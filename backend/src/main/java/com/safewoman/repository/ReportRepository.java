package com.safewoman.safewoman.repository;

import com.safewoman.safewoman.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByCity(String city);
    List<Report> findByState(String state);
    List<Report> findByOffenseType(String offenseType);
}
