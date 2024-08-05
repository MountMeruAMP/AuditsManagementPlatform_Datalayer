package com.mountmeru.entitymanagement.service.impl;

import com.mountmeru.entitymanagement.dto.ProductDTO;
import com.mountmeru.entitymanagement.entity.Product;
import com.mountmeru.entitymanagement.mapper.ProductMapper;
import com.mountmeru.entitymanagement.repository.ProductRepository;
import com.mountmeru.entitymanagement.service.FuelStockAuditService;
import com.mountmeru.entitymanagement.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuelStockAuditServiceImpl implements FuelStockAuditService {

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

        Product product = productRepository.findByCreatedBy(loginUserId)
//        .orElseThrow(() -> new RuntimeException("User Does Not Exist"));
        .orElse(new Product());

        return Optional.ofNullable(ProductMapper.mapToDTO(product));
    }
}
