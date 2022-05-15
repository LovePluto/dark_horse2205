package com.wyh.dark_horse.api.dto;

import com.wyh.dark_horse.margin.model.Margin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarginDto {
    private String goodId;
    private BigDecimal price;

    public Margin toMargin() {
        Margin margin = new Margin();
        margin.setGoodId(goodId);
        margin.setPrice(price);
        return margin;
    }
}
