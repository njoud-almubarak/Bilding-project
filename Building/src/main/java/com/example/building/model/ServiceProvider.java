package com.example.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Entity @Data
public class ServiceProvider  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "firstname is required")
    private String firstname;

    @NotEmpty(message = "lastname is required")
    private String lastname;

    @NotEmpty(message = "address is required")
    private String address;

    @NotEmpty(message = "phone number is required")
    @Size(min = 5,message = "phone number must be 5 or more character long")
    private String phonenumber;

    @NotEmpty(message = "aboutme is required")
    private String aboutme;

    private String snapshataccount;
    private String instegramaccount;



    //Relation classes..
    @OneToMany(mappedBy ="serviceprovider",cascade = CascadeType.ALL)
     @JsonIgnore
    private Set<Appointment> appointments;

    @OneToMany(mappedBy ="serviceprovider",cascade = CascadeType.ALL)
   @JsonIgnore
    private Set<Project> projects;


    @OneToMany(mappedBy ="serviceprovider",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Comment> comment;

    @OneToOne(cascade  = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;


}
