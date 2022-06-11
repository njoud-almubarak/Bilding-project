package com.example.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor @NoArgsConstructor
@Entity @Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "title is required")
    private String title;
    @NotEmpty(message = "description is required")
    private String description;
    private String image;


    @ManyToOne
    @JsonIgnore
    private ServiceProvider serviceprovider;
}
