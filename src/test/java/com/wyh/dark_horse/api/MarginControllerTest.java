package com.wyh.dark_horse.api;

import com.wyh.dark_horse.api.dto.MarginDto;
import com.wyh.dark_horse.infrastructure.client.PaymentClientImpl;
import com.wyh.dark_horse.infrastructure.client.feign.PaymentFeign;
import com.wyh.dark_horse.margin.model.MarginResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MarginControllerTest extends BaseApi {
    private PaymentFeign paymentFeign;

    @Autowired
    private PaymentClientImpl paymentClient;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        paymentFeign = Mockito.mock(PaymentFeign.class);
        ReflectionTestUtils.setField(paymentClient, "paymentFeign", paymentFeign);
    }

    @Test
    public void should_margin_successful() throws Exception {
        MarginDto dto = new MarginDto("goodId", new BigDecimal("22"));
        MarginResult marginResult = new MarginResult(true, "marginId", new BigDecimal("22"), "id", null);
        when(paymentFeign.payment(any())).thenReturn(marginResult);

        mockMvc.perform(post("/auctions/margins", dto)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void should_margin_failed() throws Exception {
        MarginDto dto = new MarginDto("goodId", new BigDecimal("22"));
        MarginResult marginResult = new MarginResult(false, "marginId", new BigDecimal("22"), "id", null);
        when(paymentFeign.payment(any())).thenReturn(marginResult);

        mockMvc.perform(post("/auctions/margins", dto)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isConflict());
    }
}
