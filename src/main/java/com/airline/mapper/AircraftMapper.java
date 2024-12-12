package com.airline.mapper;

import com.airline.dto.AircraftDto;
import com.airline.entity.Aircraft;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AircraftMapper {
    
    public AircraftDto toDto(Aircraft aircraft) {
        return AircraftDto.builder()
            .id(aircraft.getId())
            .model(aircraft.getModel())
            .cargoCapacity(aircraft.getCargoCapacity())
            .manufactureDate(aircraft.getManufactureDate())
            .registrationNumber(aircraft.getRegistrationNumber())
            .contractNumber(aircraft.getContractNumber())
            .seatConfiguration(aircraft.getSeatConfiguration())
            .inOperation(aircraft.isInOperation())
            .build();
    }
    
    public Aircraft toEntity(AircraftDto dto) {
        return Aircraft.builder()
            .id(dto.getId())
            .model(dto.getModel())
            .cargoCapacity(dto.getCargoCapacity())
            .manufactureDate(dto.getManufactureDate())
            .registrationNumber(dto.getRegistrationNumber())
            .contractNumber(dto.getContractNumber())
            .seatConfiguration(dto.getSeatConfiguration())
            .inOperation(dto.isInOperation())
            .build();
    }
} 