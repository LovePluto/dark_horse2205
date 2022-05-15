package com.wyh.dark_horse.api;

import com.wyh.dark_horse.margin.MarginService;
import com.wyh.dark_horse.margin.model.Margin;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@AllArgsConstructor
public class ScheduleController {
    private final MarginService marginService;

    @GetMapping("/auctions/margins/waiting-confirms")
    public List<Margin> getMargin() {
        return marginService.getWaitingConfirmData();
    }
}
