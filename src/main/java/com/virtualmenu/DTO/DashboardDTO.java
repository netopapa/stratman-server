package com.virtualmenu.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDTO {
    private List<ItemDTO> currentItens;
    private ChartDTO currentCenario;
    private List<ChartDTO> historic;
}
