package com.wyh.dark_horse.margin.client;

import com.wyh.dark_horse.margin.model.Margin;
import com.wyh.dark_horse.margin.model.MarginResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentClientImpl implements PaymentClient {
    @Override
    public MarginResult payment(Margin margin) {
        return null;
    }
}
