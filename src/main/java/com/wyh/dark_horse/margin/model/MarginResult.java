package com.wyh.dark_horse.margin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MarginResult {
    private Boolean result;
    private String marginId;
    private BigDecimal price;
    private String id;
    private String errorMessage;
}
