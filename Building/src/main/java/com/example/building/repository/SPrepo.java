package com.example.building.repository;

import com.example.building.model.Myuser;
import com.example.building.model.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SPrepo extends JpaRepository<ServiceProvider,Integer> {
//ServiceProvider findServiceProviderByUsername(String username);

    ServiceProvider findByAccount_Email(String email);

}
