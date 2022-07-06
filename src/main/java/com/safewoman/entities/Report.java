package com.safewoman.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "tb_reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "report_id")
    private Long reportId;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate openingDate = LocalDate.now();

    private String city;

    private String state;

    private String street;

    private String hour;

    private String neighborhood;

    private String date;

    private String offenseType;

    private String alone;

    @Column
    private String offenseLocation;

    @Column
    private String policeReport;

    @Column
    private String policeSolved;

    @Column
    private String suspectParticulars;

    @Column
    private String observation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}