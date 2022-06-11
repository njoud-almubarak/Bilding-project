package com.example.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@AllArgsConstructor @NoArgsConstructor
@Entity @Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty (message = "message is required")
    private String message;
    @NotNull(message = "rate is required")
    @Min(value = 1,message = "rate must be number between 1-5")
    @Max(value = 5, message = "rate must be number between 1-5")
    private Integer rate;

    @ManyToOne
   // @JsonIgnore
    private ServiceProvider serviceprovider;

    @ManyToOne
  //  @JsonIgnore
    private Myuser myuser;
}
