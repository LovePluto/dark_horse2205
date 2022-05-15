package com.wyh.dark_horse.infrastructure.db.jpa;

import com.wyh.dark_horse.infrastructure.db.entity.MarginEntity;
import com.wyh.dark_horse.margin.model.MarginStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarginJpa extends JpaRepository<MarginEntity, String> {

    List<MarginEntity> findAllByStatus(MarginStatus status);
}
