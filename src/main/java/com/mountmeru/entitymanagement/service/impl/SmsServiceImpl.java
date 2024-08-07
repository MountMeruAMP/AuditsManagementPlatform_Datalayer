package com.mountmeru.entitymanagement.service.impl;

import com.mountmeru.entitymanagement.service.SmsService;
import com.mountmeru.entitymanagement.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class SmsServiceImpl implements SmsService {

    public static Logger log = LoggerFactory.getLogger(SmsServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;

    @Value("")
    private String messageTemplate;

    @Override
    public String sendOtp(String phone, String otp) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> response = null;
//        StringBuilder url = new StringBuilder("https://sms.genialconsultancy.com/submitsms.jsp?");
//        String baseUrl = "http://sms.genialconsultancy.com/submitsms.jsp?";

        String message = Constants.MESSAGE_TEMPLATE;
        String user = "genial12";
        String key = "f72e846523XX";
        String senderId = "MERU";
        String accusage = "3";

        try {

            message = message.replace("<USEROTP>", otp);

            URI uri = UriComponentsBuilder.fromHttpUrl(Constants.SMS_BASE_URL)
                    .queryParam("user", user)
                    .queryParam("key", key)
                    .queryParam("mobile", phone)
//                    .queryParam("message", message)
                    .queryParam("message", message)
                    .queryParam("senderid", senderId)
                    .queryParam("accusage", accusage)
                    .build()
                    .encode()
                    .toUri();

            response = restTemplate.exchange(uri.toString(), HttpMethod.GET, null, String.class);
            // Handle response
            if (response.getStatusCode().is2xxSuccessful()) {
                log.info(response.getBody());
                return "Success";
            }else {
                return "Sms sending failed";
            }

        } catch (HttpClientErrorException e) {
            // Handle client errors (4xx)
            log.error(e.getMessage());
//            e.printStackTrace();
//            JSONObject errJs = new JSONObject(e.getResponseBodyAsString());
            throw new RuntimeException(e.getMessage());
        } catch (RestClientException e) {
            // Handle other errors
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
