package com.wyh.dark_horse.infrastructure.db.entity;

import com.wyh.dark_horse.margin.model.Margin;
import com.wyh.dark_horse.margin.model.MarginStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_margin")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MarginEntity {
    @Id
    private String id;
    private String goodId;
    private BigDecimal price;
    private String paymentId;
    private MarginStatus status;
    private LocalDateTime createdAt;

    public static MarginEntity from(Margin margin) {
        return MarginEntity.builder()
                .id(margin.getId())
                .goodId(margin.getGoodId())
                .price(margin.getPrice())
                .paymentId(margin.getPaymentId())
                .status(margin.getStatus())
                .createdAt(margin.getCreatedAt())
                .build();
    }
}
