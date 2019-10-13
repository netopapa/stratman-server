package com.virtualmenu.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart extends BaseModel {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private RestaurantTable table;

    @Column(nullable = false)
    private Boolean closed;

    @Column(nullable = false)
    private Boolean payd;

    @Column(nullable = false)
    private BigDecimal total;
}
