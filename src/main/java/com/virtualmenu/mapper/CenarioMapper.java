package com.virtualmenu.mapper;

import com.virtualmenu.DTO.CenarioDTO;
import com.virtualmenu.model.Cenario;

import java.time.ZoneOffset;
import java.util.Date;

public class CenarioMapper implements GenericMapper<Cenario, CenarioDTO> {

    @Override
    public CenarioDTO convertToDTO(Cenario entity) {
        return CenarioDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .dateReference(entity.getDateReference().atStartOfDay(ZoneOffset.systemDefault()).toInstant().toEpochMilli())
                .balance(entity.getBalance())
                .build();
    }

    @Override
    public Cenario convertToEntity(CenarioDTO dto) {
        return Cenario.builder()
                .id(dto.getId())
                .name(dto.getName())
                .balance(dto.getBalance())
                .dateReference(new Date(dto.getDateReference()).toInstant().atZone(ZoneOffset.systemDefault()).toLocalDate())
                .build();
    }
}
