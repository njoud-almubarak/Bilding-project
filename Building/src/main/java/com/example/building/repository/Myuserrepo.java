package com.example.building.repository;

import com.example.building.model.Myuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Myuserrepo extends JpaRepository<Myuser,Integer> {
Myuser findMyuserByUsername(String username);

Myuser findByAccount_Email(String email);

}
