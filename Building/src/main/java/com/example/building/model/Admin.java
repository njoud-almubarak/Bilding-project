package com.example.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@AllArgsConstructor @NoArgsConstructor
 @Data @Entity
public class Admin {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;




//Relation classes..
 @OneToOne(cascade  = CascadeType.ALL)
 @MapsId
 @JoinColumn(name = "account_id")
 @JsonIgnore
 private Account account;


}



