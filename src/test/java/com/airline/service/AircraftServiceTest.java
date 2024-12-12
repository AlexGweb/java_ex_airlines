package com.airline.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.time.LocalDate;
import com.airline.domain.Aircraft;
import com.airline.repository.AircraftRepository;

@ExtendWith(MockitoExtension.class)
class AircraftServiceTest {
    @Mock
    private AircraftRepository aircraftRepository;
    
    @InjectMocks
    private AircraftService aircraftService;
    
    @Test
    void addAircraft_ShouldSetInOperationAndSave() {
        // Given
        Aircraft aircraft = Aircraft.builder()
            .model("Boeing 737")
            .cargoCapacity(20000)
            .manufactureDate(LocalDate.now().minusYears(1))
            .registrationNumber("ABC123")
            .contractNumber("CNT001")
            .build();
            
        when(aircraftRepository.save(any(Aircraft.class)))
            .thenReturn(aircraft);
            
        // When
        Aircraft saved = aircraftService.addAircraft(aircraft);
        
        // Then
        assertTrue(saved.isInOperation());
        verify(aircraftRepository).save(aircraft);
    }
} 