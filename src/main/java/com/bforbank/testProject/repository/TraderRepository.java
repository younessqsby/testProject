package com.bforbank.testProject.repository;

import com.bforbank.testProject.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraderRepository extends JpaRepository<Trader, Integer> {
}
