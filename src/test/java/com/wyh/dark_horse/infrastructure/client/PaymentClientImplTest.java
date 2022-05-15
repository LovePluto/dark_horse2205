package com.wyh.dark_horse.infrastructure.client;

import com.wyh.dark_horse.infrastructure.client.feign.PaymentFeign;
import com.wyh.dark_horse.margin.model.Margin;
import com.wyh.dark_horse.margin.model.MarginResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentClientImplTest {

    @InjectMocks
    private PaymentClientImpl paymentClient;

    @Mock
    private PaymentFeign paymentFeign;

    @Test
    void should_payment_successful() {
        MarginResult request = new MarginResult();
        request.setId("id");
        when(paymentFeign.payment(any())).thenReturn(request);

        MarginResult result = paymentClient.payment(new Margin());

        assertThat(result.getId()).isEqualTo("id");
    }

    @Test
    void should_payment_failed() {
        when(paymentFeign.payment(any())).thenThrow(new RuntimeException());

        assertThatThrownBy(() -> paymentClient.payment(new Margin()))
                .hasMessage("支付失败，如果发生扣款，三个工作日内进行退款！");


    }
}
