package com.wyh.dark_horse.margin.client;

import com.wyh.dark_horse.margin.model.Margin;
import com.wyh.dark_horse.margin.model.MarginResult;

public interface PaymentClient {
    MarginResult payment(Margin margin);
}
