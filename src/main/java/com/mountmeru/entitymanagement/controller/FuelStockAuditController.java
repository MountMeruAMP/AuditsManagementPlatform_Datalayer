package com.mountmeru.entitymanagement.controller;

import com.mountmeru.entitymanagement.dto.EmailDTO;
import com.mountmeru.entitymanagement.dto.ProductDTO;
import com.mountmeru.entitymanagement.jsonresponses.common.ResponseErrorVo;
import com.mountmeru.entitymanagement.jsonresponses.common.ResponseVO;
import com.mountmeru.entitymanagement.jsonresponses.common.ResponseVOBuilder;
import com.mountmeru.entitymanagement.service.FuelStockAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/audit/fuelstock")
public class FuelStockAuditController {

    @Autowired
    private FuelStockAuditService oFuelStockAuditService;

    @GetMapping(value = "/test")
    public ResponseEntity<String> testDetails(@RequestHeader long loginUserId){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        return new ResponseEntity<>(String.valueOf(loginUserId), headers, HttpStatus.OK);
    }

    @PostMapping(value = "/createproduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseVO<ProductDTO>> createProductDetails(@RequestHeader long loginUserId, @RequestBody ProductDTO productDTO){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        productDTO.setCreatedby(loginUserId);

        ProductDTO resDTO = oFuelStockAuditService.createProduct(productDTO);
        ResponseEntity<ResponseVO<ProductDTO>> response;
        if (resDTO.getCounter() != 0) {
            response = new ResponseEntity<>(new ResponseVOBuilder<ProductDTO>()
                    .addData(productDTO)
                    .build(), headers, HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>(new ResponseVOBuilder<ProductDTO>()
                    .error(new ResponseErrorVo("400", "Product not created!"))
                    .build(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping(value = "/getproduct")
    public ResponseEntity<ResponseVO<ProductDTO>> getProductDetails(@RequestHeader long loginUserId){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Optional<ProductDTO> productDTO = oFuelStockAuditService.getProduct(loginUserId);
//        ResponseVO<ProductDTO> res;
        ResponseEntity<ResponseVO<ProductDTO>> response;
        if (productDTO.isPresent()) {
            response = new ResponseEntity<>(new ResponseVOBuilder<ProductDTO>()
                    .addData(productDTO.get(), "201", "Successful")
                    .build(), headers, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(new ResponseVOBuilder<ProductDTO>()
                    .error(new ResponseErrorVo("404", "Product not found!"))
                    .build(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @PostMapping(value = "/createfuelstockaudit", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createForFuelStockAudit(@RequestBody Map<String, String> req) {

        oFuelStockAuditService.createFuelStockAudit(req.get("stationCode"));

        return "Successful";
    }

    @PostMapping(value = "/generatepdf", produces = MediaType.APPLICATION_JSON_VALUE)
    public String generatePdfForFuelStockAudit(@RequestBody Map<String, String> req) {


        oFuelStockAuditService.testPdf(req.get("fileName"));

        return "Successful";
    }
}
