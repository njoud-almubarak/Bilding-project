package com.example.building.controller;

import com.example.building.model.Admin;
import com.example.building.model.Api;
import com.example.building.model.Appointment;
import com.example.building.model.Project;
import com.example.building.service.Appointservice;
import com.example.building.service.Projectservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/project")
public class Projectcontroller {


    Logger logger= LoggerFactory.getLogger(Projectcontroller.class);
    private final Projectservice projectservice;


    @GetMapping("getall")
    public ResponseEntity getproject(){
        logger.info("get all project");
        return ResponseEntity.status(200).body(projectservice.getproject());}






    @PutMapping("edite/{pid}")
    public ResponseEntity editeproject(@RequestBody @Valid Project project, @PathVariable Integer pid){

        projectservice.editeproject(project,pid);
        logger.info("edite project");
        return ResponseEntity.status(200).body(new Api("project "+pid+" updated",200));}





    @DeleteMapping("delete/{pid}")
    public ResponseEntity<Api> deleteproject(@PathVariable Integer pid)throws IllegalAccessException{

        projectservice.deleteproject(pid);
        logger.info("delete project");
        return ResponseEntity.status(200).body(new Api("project with id "+pid+" deleted",200));
    }


}
