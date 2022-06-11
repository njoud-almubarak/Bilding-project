package com.example.building.service;

import com.example.building.DTO.AdminDTO;
import com.example.building.exeption.InvalidId;
import com.example.building.model.*;
import com.example.building.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Adminservice {
    private final Adminrepo adminrepo;
    private final Myuserrepo myuserrepo;
    private final SPrepo sprepo;
    private final Commentrepo commentrepo;
    private final Accountrepo accountrepo;




    public List<Admin> getadmin(){
        return adminrepo.findAll();
    }

    public void addadmin(Account account,Admin admin){
        String hashedPassword=new BCryptPasswordEncoder().encode(account.getPassword());
        admin.setAccount(account);
        account.setPassword(hashedPassword);
        adminrepo.save(admin);}


    public void editeadminpassword(Account account,Admin admin, Integer id){
        Admin admin1=adminrepo.findById(id)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        admin1.setId(id);
//     admin1.setUsername(admin.getUsername());
//    admin1.setPassword(admin.getPassword());
//     admin1.setRole(admin1.getRole());
        String hashedPassword=new BCryptPasswordEncoder().encode(account.getPassword());
        admin1.getAccount().setPassword(hashedPassword);
        adminrepo.save(admin1);}


    public Admin getAdminByEmail(String email) {
        return adminrepo.findByAccount_Email(email);
    }

    public void deleteadmin(Integer id){

        Admin admin1=adminrepo.findById(id)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        adminrepo.deleteById(id);}

    public void deleteuser(Myuser myuser){
//accountrepo.delete(account);
myuserrepo.delete(myuser);
    }

    public void deletesp( ServiceProvider sp){

          //  accountrepo.delete(account);
            sprepo.delete(sp);
        }


    public void deletecomment(Integer cid) {
        Comment comment=commentrepo.findById(cid)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        commentrepo.delete(comment);}

}


