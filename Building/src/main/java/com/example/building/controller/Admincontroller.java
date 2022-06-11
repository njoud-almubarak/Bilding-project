package com.example.building.controller;

import com.example.building.DTO.AdminDTO;
import com.example.building.Utils;
import com.example.building.model.*;
import com.example.building.service.Adminservice;
import com.example.building.service.Myuserservice;
import com.example.building.service.SPservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ServiceLoader;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
public class Admincontroller {


    Logger logger= LoggerFactory.getLogger(Admincontroller.class);
    private final Adminservice adminservice;
    private final SPservice sPservice;
    private final Myuserservice myuserservice;


    @GetMapping("veiw")
    public ResponseEntity getadmin(){
        Account account = Utils.getAccount(SecurityContextHolder.getContext());
        logger.info("get admin");
        return ResponseEntity.status(200).body(adminservice.getAdminByEmail(account.getEmail()));}





    @PostMapping("register")
    public ResponseEntity<?> addadmin(@RequestBody @Valid AdminDTO admin)throws IllegalAccessException{
        adminservice.addadmin(admin.getAccount(),admin.getAdmin());
        logger.info("add new admin");
        return ResponseEntity.status(201).body(new Api("New admin added",201));}


//    @PutMapping("update")
//    public ResponseEntity editeadmin(@RequestBody @Valid Admin admin)throws IllegalAccessException{
//        Account account = Utils.getAccount(SecurityContextHolder.getContext());
//        Admin currentadmin = adminservice.getAdminByEmail(account.getEmail());
//        logger.info("edite admin");
//        return ResponseEntity.status(200).body(adminservice.editeadmin(admin,currentadmin));}
//

    @DeleteMapping("deleteadmin/{aid}")
    public ResponseEntity<Api> deleteadmin(@PathVariable Integer aid){

        adminservice.deleteadmin(aid);
        logger.info("delete admin");
        return ResponseEntity.status(200).body(new Api("admin with id "+aid+" deleted",200));}

    @DeleteMapping("deleteuser/{uid}")
    public ResponseEntity<Api> deleteuser(@PathVariable Integer uid) {
        logger.info("Delete service provider");
      //  Account account = Utils.getAccount(SecurityContextHolder.getContext());
        Myuser myuser = myuserservice.getuserbyid(uid);
        adminservice.deleteuser(myuser);
        logger.info("delete user");
        return ResponseEntity.status(200).body(new Api("User deleted", 200));}



    @DeleteMapping("deletesp/{spid}")
    public ResponseEntity<Api> deletesp(@PathVariable Integer spid) {

        logger.info("Delete service provider");
      //  Account account = Utils.getAccount(SecurityContextHolder.getContext());
        ServiceProvider sp = sPservice.getspbyid(spid);
        adminservice.deletesp(sp);
        return ResponseEntity.status(200).body(new Api("service provider deleted", 200));}



    @DeleteMapping("deletecomment/{cid}")
    public ResponseEntity<Api> deletecomment(@PathVariable Integer cid) {

        adminservice.deletecomment(cid);
        logger.info("delete comment");
        return ResponseEntity.status(200).body(new Api("comment with id " + cid + " deleted", 200));}


}
