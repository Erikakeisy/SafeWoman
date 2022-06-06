package com.safewoman.safewoman.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReport;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate openingDate = LocalDate.now();

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String street;

    @Column
    private String hour;

    @Column
    private String neighborhood;

    @Column
    private String date;

    @Column
    private String offenseType;

    @Column
    private boolean alone;

    @Column
    private String offenseParticulars;

    @Column
    private String offenseLocation;

    @Column
    private boolean policeReport;

    @Column
    private boolean policeSolved;

    @Column
    private String policeReportParticulars;

    @Column
    private String suspectParticulars;

    @Column
    private String observation;

//    @ManyToOne
//    @JoinColumn(name = "id")
//    private User user;

}