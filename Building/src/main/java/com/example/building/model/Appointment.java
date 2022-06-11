package com.example.building.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Entity @Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @JsonFormat(  pattern = "yyyy-MM-dd")
//    @NotEmpty(message = "date is required")
    private LocalDate date;
    //    @NotEmpty(message = "date is required")
    @JsonFormat( pattern = "HH:mm:ss")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalTime time;



    @ManyToOne
    //@JsonIgnore
    private Myuser myuser;

    @ManyToOne
    //@JsonIgnore
    private ServiceProvider serviceprovider;
}
