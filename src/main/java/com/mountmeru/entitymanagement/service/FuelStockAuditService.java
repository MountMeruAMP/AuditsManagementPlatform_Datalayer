package com.mountmeru.entitymanagement.service;

import com.mountmeru.entitymanagement.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface FuelStockAuditService {

    ProductDTO createProduct(ProductDTO productDTO);
    Optional<ProductDTO> getProduct(long loginUserId);


}
