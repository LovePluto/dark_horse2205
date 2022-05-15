package com.wyh.dark_horse.infrastructure.client.feign;

import com.wyh.dark_horse.margin.model.MarginResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "payment", url = "${payment.url}")
public interface PaymentFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/payment")
    MarginResult payment(PaymentRequest request);
}
