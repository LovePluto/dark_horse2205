package com.wyh.dark_horse.margin.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.wyh.dark_horse.margin.model.MarginStatus.CONFIRM;
import static com.wyh.dark_horse.margin.model.MarginStatus.WAITING_CONFIRM;
import static org.assertj.core.api.Assertions.assertThat;

class MarginTest {

    @Test
    public void should_init_margin_successfully() {
        Margin margin = new Margin();

        margin.init();

        assertThat(margin.getId()).isNotEmpty();
        assertThat(margin.getCreatedAt()).isNotNull();
        assertThat(margin.getStatus()).isEqualTo(WAITING_CONFIRM);
    }

    @Test
    public void should_update_margin_successfully() {
        Margin margin = new Margin();
        MarginResult marginResult = MarginResult.builder()
                .result(true)
                .id("id")
                .price(new BigDecimal("11"))
                .build();

        margin.update(marginResult);

        assertThat(margin.getStatus()).isEqualTo(CONFIRM);
        assertThat(margin.getPaymentId()).isEqualTo("id");
    }
}
