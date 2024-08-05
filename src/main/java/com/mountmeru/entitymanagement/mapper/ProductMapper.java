package com.mountmeru.entitymanagement.mapper;

import com.mountmeru.entitymanagement.dto.ProductDTO;
import com.mountmeru.entitymanagement.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    @Autowired
    private static ModelMapper modelMapper;

    public static ProductDTO mapToDTO(Product product){
//        return modelMapper.map(product, ProductDTO.class);

        return new ProductDTO(
                product.getCounter(),
                product.getCreatedTS(),
                product.getUpdatedTS(),
                product.getCreatedBy(),
                product.getUpdatedBy(),
                product.getId(),
                product.getCategory(),
                product.getProductName(),
                product.getProductShortCode(),
                product.getProductUOM(),
                product.getProductPrice(),
                product.getDensityMin(),
                product.getDensityMax(),
                product.getProductLossLimit()
        );
    }

    public static Product mapToObject(ProductDTO productDTO){
//        return modelMapper.map(productDTO, Product.class);

        return new Product(
                productDTO.getCounter(),
                productDTO.getCreatedts(),
                productDTO.getUpdatedts(),
                productDTO.getCreatedby(),
                productDTO.getUpdatedby(),
                productDTO.getId(),
                productDTO.getCategory(),
                productDTO.getProductname(),
                productDTO.getProductshortcode(),
                productDTO.getProductUOM(),
                productDTO.getProductprice(),
                productDTO.getDensitymin(),
                productDTO.getDensitymax(),
                productDTO.getProductLossLimit()
        );
    }
}
