package com.wyh.dark_horse.margin;

import com.wyh.dark_horse.margin.client.PaymentClient;
import com.wyh.dark_horse.margin.model.Margin;
import com.wyh.dark_horse.margin.model.MarginResult;
import com.wyh.dark_horse.margin.repository.MarginRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MarginServiceTest {
    @InjectMocks
    private MarginService marginService;

    @Mock
    private MarginRepository marginRepository;

    @Mock
    private PaymentClient paymentClient;

    @Test
    public void should_margin_successful() {
        MarginResult marginResult = new MarginResult();
        marginResult.setResult(true);
        when(paymentClient.payment(any())).thenReturn(marginResult);

        String result = marginService.create(new Margin());

        assertThat(result).isNotEmpty();
        verify(marginRepository, times(2)).save(any());
    }

    @Test
    public void should_margin_failed() {
        MarginResult marginResult = new MarginResult();
        marginResult.setResult(false);
        when(paymentClient.payment(any())).thenReturn(marginResult);

        assertThatThrownBy(() -> marginService.create(new Margin()))
                .hasMessage("账户余额不足，请确认账户是否有足够余额缴纳保证金！");
    }
}
