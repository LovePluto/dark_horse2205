package com.wyh.dark_horse.margin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Margin {
    private String id;
    private String goodId;
    private BigDecimal price;
    private String paymentId;
    private MarginStatus status;
    private LocalDateTime createdAt;

    public void init() {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.createdAt = LocalDateTime.now();
        status = MarginStatus.WAITING_CONFIRM;
    }

    public void update(MarginResult result) {
        this.status = MarginStatus.CONFIRM;
        this.paymentId = result.getId();
    }
}
