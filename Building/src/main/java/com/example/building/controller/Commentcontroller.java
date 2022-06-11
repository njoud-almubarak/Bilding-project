package com.example.building.controller;

import com.example.building.model.Api;
import com.example.building.model.Appointment;
import com.example.building.model.Comment;
import com.example.building.service.Appointservice;
import com.example.building.service.Commentservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/comment")
public class Commentcontroller {


    Logger logger= LoggerFactory.getLogger(Commentcontroller.class);
    private final Commentservice commentservice;


//    @GetMapping("getall")
//    public ResponseEntity getcomment(){
//        logger.info("get all comment");
//        return ResponseEntity.status(200).body(commentservice.getcomment());}
//



//    @PostMapping("add")
//    public ResponseEntity<?> addcomment(@RequestBody @Valid Comment comment)throws IllegalAccessException{
//
//        commentservice.addcomment(comment);
//        logger.info("add new comment");
//        return ResponseEntity.status(200).body(new Api("New comment added",200));}

//    @DeleteMapping("delete/{cid}")
//    public ResponseEntity<?> deletecomment(@PathVariable Integer cid){
//        commentservice.deletecomment(cid);
//        logger.info("delete comment");
//        return ResponseEntity.status(200).body(new Api(" comment deleted",200));

   // }




}
