package com.wyh.dark_horse.api;

import com.wyh.dark_horse.api.dto.MarginDto;
import com.wyh.dark_horse.infrastructure.client.feign.PaymentFeign;
import com.wyh.dark_horse.margin.model.MarginResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MarginControllerTest {
    @MockBean
    private PaymentFeign paymentFeign;

    @Autowired
    private MockMvc mockMvc;

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
