package com.wyh.dark_horse.infrastructure.db.jpa;

import com.wyh.dark_horse.infrastructure.db.entity.MarginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarginJpa extends JpaRepository<MarginEntity, String> {
}
