package com.example.building.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Entity @Data
public class Myuser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "username is required")
    private String username;


    @NotEmpty(message = "phone number is required")
    @Size(min = 5,message = "phone number must be 5 or more character long")
    private String phonenumber;


//Relation classes..
    @OneToOne(cascade  = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;


    @OneToMany(mappedBy ="myuser",cascade = CascadeType.ALL)
   @JsonIgnore
    private Set<Appointment> appointments;


    @OneToMany(mappedBy ="myuser",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Comment> comments;


}
