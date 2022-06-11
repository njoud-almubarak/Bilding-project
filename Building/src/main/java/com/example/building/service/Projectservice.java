package com.example.building.service;

import com.example.building.exeption.InvalidId;
import com.example.building.model.Admin;
import com.example.building.model.Appointment;
import com.example.building.model.Project;
import com.example.building.repository.Appointmentrepo;
import com.example.building.repository.Projectrepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Projectservice {
    private final Projectrepo projectrepo;




    public List<Project> getproject(){
        return projectrepo.findAll();
    }


    /*public List<Project> getprojectbyspid(Integer spid){ return projectrepo.findAll(); }*/


    //add project by service provider id..
   /* public void addproject(Project project,Integer spid){
        projectrepo.save(project);}*/


    //update  project by project id..
    public void editeproject(Project project, Integer pid){
        Project project1=projectrepo.findById(pid)
                .orElseThrow(
                        ()->new InvalidId("Invalid project id"));
        project1.setId(pid);
        project1.setTitle(project.getTitle());
        project1.setDescription(project.getDescription());
        project1.setImage(project.getImage());
        projectrepo.save(project1);}


    //delete project by project id..
    public void deleteproject(Integer pid){

        Project project=projectrepo.findById(pid)
                .orElseThrow(
                        ()->new InvalidId("Invalid project id"));
        projectrepo.deleteById(pid);}

}
