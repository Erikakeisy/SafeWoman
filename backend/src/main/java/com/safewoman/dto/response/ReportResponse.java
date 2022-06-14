package com.safewoman.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponse {

    private Long idReport;

    private LocalDate openingDate = LocalDate.now();

    private String city;

    private String state;

    private String street;

    private String hour;

    private String neighborhood;

    private String date;

    private String offenseType;

    private boolean alone;

    private String offenseParticulars;

    private String offenseLocation;

    private boolean policeReport;

    private boolean policeSolved;

    private String policeReportParticulars;

    private String suspectParticulars;

    private String observation;
//
//    private User user;
}
