package com.safewoman.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequest {

    @NotNull(message = "The field city name is required")
    private String city;

    @NotNull(message = "The field state is required")
    private String state;

    @NotNull(message = "The field street is required")
    private String street;

    @NotNull(message = "The field hour is required")
    private String hour;

    @NotNull(message = "The field neighbourhood is required")
    private String neighborhood;

    @NotNull(message = "The field date is required")
    private String date;

    @NotNull(message = "The field offenseType is required")
    private String offenseType;

    @NotNull(message = "The field alone is required")
    private boolean alone;

    @NotNull(message = "The field offenseParticulars is required")
    private String offenseParticulars;

    @NotNull(message = "The field offenseLocation is required")
    private String offenseLocation;

    @NotNull(message = "The field policeReport is required")
    private boolean policeReport;

    @NotNull(message = "The field policeSolved is required")
    private boolean policeSolved;

    @NotNull(message = "The field policeReportParticulars is required")
    private String policeReportParticulars;

    @NotNull(message = "The field suspectParticulars is required")
    private String suspectParticulars;

    @NotNull(message = "The field observation is required")
    private String observation;

    private Long userId;

}

