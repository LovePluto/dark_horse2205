package com.wyh.dark_horse.margin;

import com.wyh.dark_horse.infrastructure.exception.MarginException;
import com.wyh.dark_horse.margin.client.PaymentClient;
import com.wyh.dark_horse.margin.model.Margin;
import com.wyh.dark_horse.margin.model.MarginResult;
import com.wyh.dark_horse.margin.repository.MarginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MarginService {

    private final MarginRepository marginRepository;
    private final PaymentClient paymentClient;

    public String create(Margin margin) {
        margin.init();
        marginRepository.save(margin);
        MarginResult result = paymentClient.payment(margin);
        margin.update(result);
        marginRepository.save(margin);
        if (!result.getResult()) {
            throw new MarginException("账户余额不足，请确认账户是否有足够余额缴纳保证金！");
        }
        return margin.getId();
    }
}
