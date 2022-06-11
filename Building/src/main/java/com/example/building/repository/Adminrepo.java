package com.example.building.repository;

import com.example.building.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Adminrepo extends JpaRepository<Admin,Integer> {
Admin findByAccount_Email(String email);
  //  Admin findAdminByUsername(String username);
}
