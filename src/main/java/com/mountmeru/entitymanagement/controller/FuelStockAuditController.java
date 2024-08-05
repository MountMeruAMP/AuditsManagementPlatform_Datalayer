package com.mountmeru.entitymanagement.controller;

import com.mountmeru.entitymanagement.dto.ProductDTO;
import com.mountmeru.entitymanagement.jsonresponses.DashboardResponse;
import com.mountmeru.entitymanagement.service.FuelStockAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ProductDTO> createProductDetails(@RequestHeader long loginUserId, @RequestBody ProductDTO productDTO){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        productDTO.setCreatedby(loginUserId);
        return new ResponseEntity<>(oFuelStockAuditService.createProduct(productDTO), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/getproduct")
    public ResponseEntity<ProductDTO> getProductDetails(@RequestHeader long loginUserId){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        return new ResponseEntity<>(oFuelStockAuditService.getProduct(loginUserId).get(), headers, HttpStatus.OK);
    }
}
