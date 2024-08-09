package com.mountmeru.entitymanagement.service;

import com.mountmeru.entitymanagement.dto.FuelAuditStagingDTO;
import com.mountmeru.entitymanagement.dto.FuelStockAuditPdfDTO;
import com.mountmeru.entitymanagement.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface FuelStockAuditService {

    ProductDTO createProduct(ProductDTO productDTO);
    Optional<ProductDTO> getProduct(long loginUserId);

    Optional<FuelAuditStagingDTO> createFuelStockAudit(String stationCode);

    Optional<String> generateFuelStockAuditPDF(FuelStockAuditPdfDTO pdfDTO);
    Optional<String> generatePDF(String source);

    void testPdf(String fileSource);

}
