package com.example.building.repository;


import com.example.building.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Accountrepo extends JpaRepository<Account,Integer> {

    Optional<Account> findByEmail(String email);
}
