package com.mountmeru.entitymanagement.service.impl;

import com.mountmeru.entitymanagement.dto.ProductDTO;
import com.mountmeru.entitymanagement.entity.Product;
import com.mountmeru.entitymanagement.mapper.ProductMapper;
import com.mountmeru.entitymanagement.repository.ProductRepository;
import com.mountmeru.entitymanagement.service.FuelStockAuditService;
import com.mountmeru.entitymanagement.utils.CommonUtility;
import com.mountmeru.entitymanagement.utils.DateUtils;
import com.mountmeru.entitymanagement.utils.PdfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
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

    @Override
    public Optional<String> generatePDF( String source) {
        File htmlSource = new File(source);
//        File pdfDest = new File("pdfFilePath");

        // Creating the pdf
//        try {
//            // Convert HTML String to PDF File
//            String filename = new Date().getTime()+"_fuel_stock_audit.pdf";
//
//            float width = 1190;
//            float height = 1684;
//            PdfUtils.generatePDFfromHtml(Files.readString(Paths.get(htmlSource.getPath())), filename, width, height);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            log.info("pdf generation done.");
//        }
        return Optional.of("Success");
    }
}
