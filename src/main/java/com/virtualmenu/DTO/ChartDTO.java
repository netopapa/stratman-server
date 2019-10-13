package com.virtualmenu.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChartDTO {
    private String name;
    private Long dateReference;
    private List<String> labels;
    private List<BigDecimal> series;
}
