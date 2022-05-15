package com.wyh.dark_horse.infrastructure.client;

import com.wyh.dark_horse.infrastructure.client.feign.PaymentFeign;
import com.wyh.dark_horse.infrastructure.client.feign.PaymentRequest;
import com.wyh.dark_horse.margin.client.PaymentClient;
import com.wyh.dark_horse.margin.model.Margin;
import com.wyh.dark_horse.margin.model.MarginResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentClientImpl implements PaymentClient {
    private final PaymentFeign paymentFeign;

    @Override
    public MarginResult payment(Margin margin) {
        return paymentFeign.payment(PaymentRequest.from(margin));

    }
}
