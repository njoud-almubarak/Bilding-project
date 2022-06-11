package com.example.building.service;

import com.example.building.repository.Accountrepo;
import com.example.building.repository.Adminrepo;
import com.example.building.repository.Myuserrepo;
import com.example.building.repository.SPrepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Accountservice implements UserDetailsService {

    private final Accountrepo accountrepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountrepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("invalid email"));}


    }

