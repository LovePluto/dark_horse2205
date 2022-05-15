package com.wyh.dark_horse.infrastructure.db;

import com.wyh.dark_horse.infrastructure.db.entity.MarginEntity;
import com.wyh.dark_horse.infrastructure.db.jpa.MarginJpa;
import com.wyh.dark_horse.margin.model.Margin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.wyh.dark_horse.margin.model.MarginStatus.CONFIRM;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MarginRepositoryImplTest {

    @Autowired
    private MarginRepositoryImpl marginRepository;

    @Autowired
    private MarginJpa marginJpa;

    @Test
    void should_save_margin_successful() {
        Margin margin = new Margin("id", "goodId", new BigDecimal("22"),
                "paymentId", CONFIRM, LocalDateTime.now());

        marginRepository.save(margin);

        MarginEntity result = marginJpa.findById("id").get();
        assertThat(result.getGoodId()).isEqualTo("goodId");
        assertThat(result.getPaymentId()).isEqualTo("paymentId");
        assertThat(result.getPrice()).isEqualTo(new BigDecimal("22.00"));
        assertThat(result.getStatus()).isEqualTo(CONFIRM);
    }
}
