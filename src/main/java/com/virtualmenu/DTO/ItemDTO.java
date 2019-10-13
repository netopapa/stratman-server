package com.virtualmenu.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ItemDTO {

    private Long id;

    private String name;

    private BigDecimal value;

    private CenarioDTO cenario;
}
