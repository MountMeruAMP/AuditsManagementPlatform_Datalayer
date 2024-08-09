package com.mountmeru.entitymanagement.service.impl;

import com.itextpdf.kernel.geom.PageSize;
import com.mountmeru.entitymanagement.dto.*;
import com.mountmeru.entitymanagement.entity.Product;
import com.mountmeru.entitymanagement.exceptions.ResourceNotFoundException;
import com.mountmeru.entitymanagement.mapper.ProductMapper;
import com.mountmeru.entitymanagement.repository.ProductRepository;
import com.mountmeru.entitymanagement.service.ClustersService;
import com.mountmeru.entitymanagement.service.FuelStockAuditService;
import com.mountmeru.entitymanagement.service.StationsService;
import com.mountmeru.entitymanagement.service.UsersService;
import com.mountmeru.entitymanagement.utils.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class FuelStockAuditServiceImpl implements FuelStockAuditService {

    Logger log = LoggerFactory.getLogger(FuelStockAuditServiceImpl.class);
    @Autowired
    DateUtils oDateUtils;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private UsersService oUsersService;

    @Autowired
    private StationsService oStationsService;

    @Autowired
    private ClustersService oClustersService;

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
    public Optional<FuelAuditStagingDTO> createFuelStockAudit(String stationCode) {
        FuelStockAuditPdfDTO pdfDTO = new FuelStockAuditPdfDTO();
        pdfDTO.setFileSource("C:/Users/Arind/Documents/Workspace/Anavadya Office/InfiniValue/fuel_audit_stock_v2.html");

        StationsDTO stationsDTO = oStationsService.getStationsById(stationCode);
        if (stationsDTO == null)
            throw new ResourceNotFoundException("No Station found");

        pdfDTO.setStationCode(stationCode);
        pdfDTO.setStationName(stationsDTO.getStationname());
        pdfDTO.setStationType(stationsDTO.getStationtype());

        ClustersDTO cluster = oClustersService.getClusterById(stationsDTO.getClusterid());
        if (null == cluster) {
            throw new ResourceNotFoundException("No cluster found");
        }

        UsersDTO userCM = oUsersService.getUsersByUserId(NumberUtils.toLong(cluster.getManagerid()));
        UsersDTO userSM = oUsersService.getUsersByUserId(NumberUtils.toLong(stationsDTO.getManager_id()));

        pdfDTO.setCmName(userCM.getFirstname() + " " + userCM.getLastname());
        pdfDTO.setSmName(userSM.getFirstname() + " " + userSM.getLastname());

        Optional<String> source = generateFuelStockAuditPDF(pdfDTO);

        source.ifPresent(this::generatePDF);

        return Optional.empty();
    }

    @Override
    public Optional<String> generateFuelStockAuditPDF(FuelStockAuditPdfDTO pdfDTO) {

        try {
            // Read the HTML file
            String htmlContent = HtmlFileProcessor.readHtmlFile(pdfDTO.getFileSource());

            // Prepare the placeholders to replace
            Map<String, String> placeholders = new HashMap<>();
            placeholders.put("<STATION_NAME>", pdfDTO.getStationName());
            placeholders.put("<STATION_TYPE>", pdfDTO.getStationType());
            placeholders.put("<SM_NAME>", pdfDTO.getSmName());
            placeholders.put("<CM_NAME>", pdfDTO.getCmName());
            placeholders.put("<STATION_CODE>", pdfDTO.getStationCode());
            placeholders.put("<REGION>", pdfDTO.getRegion());
            placeholders.put("<RH_NAME>", pdfDTO.getRhName());
            placeholders.put("<AUDITOR_NAME>", pdfDTO.getAuditorName());
            placeholders.put("<DATE_OF_AUDIT>", pdfDTO.getDateOfAudit());
            placeholders.put("<DATE_OF_LAST_AUDIT>", pdfDTO.getDateOfLastAudit());
            placeholders.put("<START_TIME_OF_AUDIT>", pdfDTO.getStartTime());
            placeholders.put("<END_TIME_OF_AUDIT>", "2024-08-09");

            // Replace the placeholders
            String modifiedHtmlContent = HtmlFileProcessor.replacePlaceholders(htmlContent, placeholders);

            // (Optional) Write the modified content back to a file
//            HtmlFileProcessor.writeHtmlFile(pdfDTO.getFileSource(), modifiedHtmlContent);

            // Use the modified HTML content as needed
//            System.out.println(modifiedHtmlContent);
            return Optional.ofNullable(modifiedHtmlContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            log.info("pdf generation done.");
        }
    }

    @Override
    public Optional<String> generatePDF(String source) {
//        File htmlSource = new File(source);
//         Creating the pdf
        try {
            // Convert HTML String to PDF File
            String filename = Constants.TEMP_DIR + new Date().getTime()+"_fuel_stock_audit.pdf";

//            PdfUtils.generatePDFfromHtml(Files.readString(Paths.get(htmlSource.getPath())), filename, new PageSize(PageSize.A4));
            PdfUtils.generatePDFfromHtml(source, filename, new PageSize(PageSize.A4));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            log.info("pdf generation done.");
        }
        return Optional.of("Success");
    }

    @Override
    public void testPdf(String fileSource) {

        try {
            File htmlSource = new File(fileSource);
            generatePDF(Files.readString(Paths.get(htmlSource.getPath())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
