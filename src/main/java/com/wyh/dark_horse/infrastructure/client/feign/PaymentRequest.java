package com.wyh.dark_horse.infrastructure.client.feign;

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
public class PaymentRequest {
    private String id;
    private String goodId;
    private BigDecimal price;

    public static PaymentRequest from(Margin margin) {
        return new PaymentRequest(margin.getId(), margin.getGoodId(), margin.getPrice());
    }
}
