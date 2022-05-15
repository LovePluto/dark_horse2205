package com.wyh.dark_horse.api;

import com.wyh.dark_horse.api.dto.MarginDto;
import com.wyh.dark_horse.margin.MarginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auctions/margins")
@AllArgsConstructor
public class MarginController {
    private final MarginService marginService;

    @PostMapping()
    public String marginPayment(MarginDto dto) {
        return marginService.create(dto.toMargin());
    }
}
