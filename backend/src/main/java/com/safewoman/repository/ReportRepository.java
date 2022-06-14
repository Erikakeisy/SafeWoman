package com.safewoman.repository;

import com.safewoman.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByCity(String city);
    List<Report> findByState(String state);
    List<Report> findByOffenseType(String offenseType);
}
