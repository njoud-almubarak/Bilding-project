package com.example.building.controller;

import com.example.building.DTO.SpDTO;
import com.example.building.Utils;
import com.example.building.model.*;
import com.example.building.service.Appointservice;
import com.example.building.service.SPservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/SP")
public class SPcontrpller {


    Logger logger= LoggerFactory.getLogger(SPcontrpller.class);
    private final SPservice sPservice;

    @GetMapping("getsp")
    public ResponseEntity getsp(){
        Account account = Utils.getAccount(SecurityContextHolder.getContext());
        logger.info("get service provider");
        return ResponseEntity.status(200).body(sPservice.getUserByEmail(account.getEmail()));}






    @PostMapping("register")
    public ResponseEntity<?> addsprovider(@RequestBody @Valid SpDTO  sp)throws IllegalAccessException{
        sPservice.addserviceprovider(sp.getAccount(),sp.getServiceProvider());
        logger.info("add new service provider");
        return ResponseEntity.status(201).body(new Api("New service provider added",201));}




    @PutMapping("edite/{spid}")
    public ResponseEntity editesp(@RequestBody @Valid ServiceProvider sp)throws IllegalAccessException{
        Account account = Utils.getAccount(SecurityContextHolder.getContext());
        ServiceProvider currentsp=sPservice.getUserByEmail(account.getEmail());
        logger.info("update service provider");
        sPservice.editesp(sp,currentsp);
        return ResponseEntity.status(200).body("service provider is updated");}

    @DeleteMapping("deletesp")
    public ResponseEntity<Api> deletesp() {

        logger.info("Delete service provider");
        Account account = Utils.getAccount(SecurityContextHolder.getContext());
        ServiceProvider sp = sPservice.getUserByEmail(account.getEmail());
        sPservice.deletesp(account,sp);
        return ResponseEntity.status(200).body(new Api("service provider deleted", 200));}


    @PostMapping("addproject/{spid}")
    public ResponseEntity<?> addproject(@RequestBody @Valid Project project, @PathVariable Integer spid)throws IllegalAccessException{
        sPservice.addproject(project,spid);
        logger.info("add new project");
        return ResponseEntity.status(200).body(new Api("New project added",200));}



    @GetMapping("getproject/{spid}")
    public ResponseEntity getprojectbyspid(@PathVariable Integer spid){

      //  sPservice.getprojectbyspid(spid);
        logger.info("get projects");
        return ResponseEntity.status(200).body( sPservice.getprojectbyspid(spid));}



    @GetMapping("getappointment/{spid}")
    public ResponseEntity getappointmentbyuserid(@PathVariable Integer spid){
        logger.info("get appointment by service provider id");
        return ResponseEntity.status(200).body(sPservice.getAppointmentbyspid(spid));}
}
