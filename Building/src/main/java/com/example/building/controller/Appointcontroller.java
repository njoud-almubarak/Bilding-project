package com.example.building.controller;

import com.example.building.Utils;
import com.example.building.model.*;
import com.example.building.service.Appointservice;
import com.example.building.service.Myuserservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/appointment")
public class Appointcontroller {


//    Logger logger= LoggerFactory.getLogger(Appointcontroller.class);
//    private final Appointservice appointservice;
//private final Myuserservice myuserservice;
//
//    @GetMapping("getall")
//    public ResponseEntity getappointment(){
//        logger.info("get all appointment");
//        return ResponseEntity.status(200).body(appointservice.getAppointment());}
//@PostMapping("addapointment/{spid}")
//    public ResponseEntity<Api> addAppointment(@PathVariable Integer spid,@RequestBody @Valid Appointment appointment){
//        Account account = Utils.getAccount(SecurityContextHolder.getContext());
//        Myuser myuser = myuserservice.getUserByEmail(account.getEmail());
//        appointservice.addapointment(myuser.getId(),spid,appointment);
//        return ResponseEntity.status(201).body(new Api(" Appointment  added",201));
//
//    }





  /*  @PutMapping("edite/{aid}")
    public ResponseEntity editeappointment(@RequestBody @Valid Appointment appointment, Errors errors, @PathVariable Integer aid){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(message,400));}

        appointservice.editeappointment(appointment,aid);
        logger.info("edite appointment");
        return ResponseEntity.status(200).body(new Api("appointment "+appointment.getId()+" updated",200));}*/




   /* @DeleteMapping("delete/{aid}")
    public ResponseEntity<Api> deleteappointment(@PathVariable Integer aid){

        appointservice.deleteappointment(aid);
        logger.info("delete appointment");
        return ResponseEntity.status(200).body(new Api("appointment with id "+aid+" deleted",200));}*/





   /* @DeleteMapping("deletebydate/{date}")
    public ResponseEntity<Api> deleteappointmentbydate(@PathVariable LocalDate date){

        appointservice.deleteappointmentbydate(date);
        logger.info("delete appointment");
        return ResponseEntity.status(200).body(new Api("appointment in  "+date+" deleted",200));}*/





}
