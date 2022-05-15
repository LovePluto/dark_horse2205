package com.wyh.dark_horse.margin.repository;

import com.wyh.dark_horse.margin.model.Margin;

import java.util.List;

public interface MarginRepository {
    void save(Margin margin);

    List<Margin> getWaitingConfirmData();
}
