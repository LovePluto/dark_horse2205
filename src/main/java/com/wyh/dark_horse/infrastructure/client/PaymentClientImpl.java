package com.wyh.dark_horse.infrastructure.client;

import com.wyh.dark_horse.infrastructure.client.feign.PaymentFeign;
import com.wyh.dark_horse.infrastructure.client.feign.PaymentRequest;
import com.wyh.dark_horse.infrastructure.exception.PaymentException;
import com.wyh.dark_horse.margin.client.PaymentClient;
import com.wyh.dark_horse.margin.model.Margin;
import com.wyh.dark_horse.margin.model.MarginResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class PaymentClientImpl implements PaymentClient {
    private final PaymentFeign paymentFeign;

    @Override
    public MarginResult payment(Margin margin) {
        try {
            return paymentFeign.payment(PaymentRequest.from(margin));
        } catch (Exception e) {
            log.error("payment feign failed!", e);
            throw new PaymentException("支付失败，如果发生扣款，三个工作日内进行退款！");
        }

    }
}
