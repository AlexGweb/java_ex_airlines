package com.airline.service.integration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountingService {
    private final RestTemplate restTemplate;
    
    @Value("${accounting.service.url}")
    private String accountingServiceUrl;
    
    @Async
    public void sendFlightFinancialReport(FinancialReport report) {
        try {
            restTemplate.postForEntity(
                accountingServiceUrl + "/financial-reports",
                report,
                Void.class
            );
            log.info("Financial report sent to accounting service: {}", report);
        } catch (Exception ex) {
            log.error("Failed to send financial report: {}", ex.getMessage());
            throw new IntegrationException("Accounting service communication failed", ex);
        }
    }
} 