package com.example.building.controller;

import com.example.building.DTO.UserDTO;
import com.example.building.Utils;
import com.example.building.model.*;
import com.example.building.service.Myuserservice;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/myuser")
public class Myusercontroller {


    Logger logger= LoggerFactory.getLogger(Myusercontroller.class);
    private final Myuserservice myuserservice;

    @GetMapping("getuser")
    public ResponseEntity getuser(){
        Account account = Utils.getAccount(SecurityContextHolder.getContext());
        return ResponseEntity.status(200).body(myuserservice.getUserByEmail(account.getEmail()));}




    @PostMapping("register")
    public ResponseEntity<Api> addUser(@RequestBody @Valid UserDTO user)throws IllegalAccessException{
        myuserservice.adduser(user.getAccount(),user.getMyuser());
        logger.info("add new user");
        return ResponseEntity.status(201).body(new Api("New User added",201));}


    @PutMapping("edite")
    public ResponseEntity editeUser(@RequestBody @Valid Myuser user )throws IllegalAccessException{
        Account account = Utils.getAccount(SecurityContextHolder.getContext());
        Myuser newuser=myuserservice.getUserByEmail(account.getEmail());
        myuserservice.editeuser(user,newuser);
        logger.info("update  user");
        return ResponseEntity.status(200).body("user is updated");
    }


    @DeleteMapping("/deleteuser")
    public ResponseEntity deleteuser(){
        logger.info("delete user");
        Account account = Utils.getAccount(SecurityContextHolder.getContext());
        Myuser myuser = myuserservice.getUserByEmail(account.getEmail());
        myuserservice.deleteuser(account,myuser);
        return ResponseEntity.status(200).body("The user deleted");

    }


@PostMapping("addcomment/{uid}/{spid}")
    public ResponseEntity addcomment(@RequestBody @Valid Comment comment,@PathVariable Integer uid,@PathVariable Integer spid)throws IllegalAccessException{
    myuserservice.addcommentbyuser(uid,spid,comment);
    logger.info("add new comment");
    return ResponseEntity.status(200).body(new Api("New account added",200));}


    @GetMapping("getcomment/{spid}")
    public ResponseEntity getcomment(@PathVariable Integer spid){
        logger.info("get comment");
        return ResponseEntity.status(200).body(myuserservice.getcomment(spid));}


    @PostMapping("addappointment/{uid}/{spid}")
    public ResponseEntity addappointment(@RequestBody @Valid Appointment appointment, @PathVariable Integer uid,@PathVariable Integer spid)throws IllegalAccessException{
        myuserservice.addappointment(appointment,uid,spid);
        logger.info("add new appointment");
        return ResponseEntity.status(200).body(new Api("New appointment added",200));}


    @GetMapping("getappointment/{uid}")
    public ResponseEntity getappointmentbyuserid(@PathVariable Integer uid){
        logger.info("get appointment by user id");
        return ResponseEntity.status(200).body(myuserservice.getAppointmentbyuserid(uid));}



    @GetMapping("getrate/{spid}")
    public ResponseEntity getrate(@PathVariable Integer spid){
        logger.info("get service provider rate");
        return ResponseEntity.status(200).body(myuserservice.getrate(spid));}
}





