package com.mountmeru.entitymanagement.service.impl;

import com.mountmeru.entitymanagement.dto.ProductDTO;
import com.mountmeru.entitymanagement.entity.Product;
import com.mountmeru.entitymanagement.mapper.ProductMapper;
import com.mountmeru.entitymanagement.repository.ProductRepository;
import com.mountmeru.entitymanagement.service.FuelStockAuditService;
import com.mountmeru.entitymanagement.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuelStockAuditServiceImpl implements FuelStockAuditService {

    Logger log = LoggerFactory.getLogger(FuelStockAuditServiceImpl.class);
    @Autowired
    DateUtils oDateUtils;

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {

        Product product = ProductMapper.mapToObject(productDTO);
        product.setCreatedTS(oDateUtils.getCurrentTimeStamp());

        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToDTO(savedProduct);
    }

    @Override
    public Optional<ProductDTO> getProduct(long loginUserId) {
        log.info("Product searching for user: {}", loginUserId);
        Optional<Product> product = productRepository.findByCreatedBy(loginUserId);

        product.ifPresent(p -> {
            // Perform some side-effects if needed, e.g., logging
            log.info("Product found for user: {}", loginUserId);
        });

        return product.map(ProductMapper::mapToDTO);
    }
}
