package com.airline.service.integration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class MaintenanceService {
    private final RestTemplate restTemplate;
    
    @Value("${maintenance.service.url}")
    private String maintenanceServiceUrl;
    
    public void sendFlightReport(FlightReport report) {
        try {
            restTemplate.postForEntity(
                maintenanceServiceUrl + "/reports",
                report,
                Void.class
            );
            log.info("Flight report sent to maintenance service: {}", report);
        } catch (Exception ex) {
            log.error("Failed to send flight report: {}", ex.getMessage());
            throw new IntegrationException("Maintenance service communication failed", ex);
        }
    }
} 