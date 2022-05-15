package com.wyh.dark_horse.infrastructure.db;

import com.wyh.dark_horse.infrastructure.db.entity.MarginEntity;
import com.wyh.dark_horse.infrastructure.db.jpa.MarginJpa;
import com.wyh.dark_horse.margin.model.Margin;
import com.wyh.dark_horse.margin.repository.MarginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@AllArgsConstructor
public class MarginRepositoryImpl implements MarginRepository {
    private final MarginJpa marginJpa;

    @Override
    public void save(Margin margin) {
        marginJpa.save(MarginEntity.from(margin));
    }

    @Override
    public List<Margin> getWaitingConfirmData() {
        return Collections.emptyList();
    }
}
