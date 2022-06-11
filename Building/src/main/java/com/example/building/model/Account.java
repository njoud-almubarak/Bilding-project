package com.example.building.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
 @Data @Entity
public class Account implements UserDetails {

@Id
@Column(nullable = false)
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;


 @NotEmpty(message = "email is required")
 @Email
 @Column(unique = true)
 private String email;


 @NotEmpty(message = "password is required")
 @Size(min = 5,message = "password must be 5 or more character long")
 private String password;


 @NotEmpty (message = "role is required")
 @Pattern(regexp = "ADMIN|USER|Architect|Interiordesigner|contractor|supervisor",message = "role must be ADMIN USER or Architect or Interiordesigner or contractor or supervisor")
 private String role;

 @Override
 public Collection<? extends GrantedAuthority> getAuthorities() {
  return List.of(new SimpleGrantedAuthority(this.role));}


 @Override
 public String getPassword() {
  return this.password;}


 @Override
 public String getUsername() {
  return this.email;}


 @Override
 public boolean isAccountNonExpired() {
  return true;}


 @Override
 public boolean isAccountNonLocked() {
  return true;}


 @Override
 public boolean isCredentialsNonExpired() {
  return true;}


 @Override
 public boolean isEnabled() {
  return true;}

}
