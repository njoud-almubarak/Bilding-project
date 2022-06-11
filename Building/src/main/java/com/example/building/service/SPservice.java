package com.example.building.service;

import com.example.building.DTO.SpDTO;
import com.example.building.exeption.InvalidId;
import com.example.building.model.*;
import com.example.building.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SPservice {

    private final SPrepo sPrepo;
    private final Commentrepo commentrepo;
    private final Projectrepo projectrepo;
    private final Appointmentrepo appointmentrepo;

private final Accountrepo accountrepo;

//methode to veiw all service provider..
//    public List<ServiceProvider> getserviceprovider(){
//        return sPrepo.findAll();
//    }

    public ServiceProvider getDoctorById(Integer spid) {
        ServiceProvider sp1=sPrepo.findById(spid)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        return sp1;}





    //add new service provider ..
    public void addserviceprovider(Account account, ServiceProvider sp){
        String hashedPassword=new BCryptPasswordEncoder().encode(account.getPassword());
        sp.setAccount(account);
        account.setPassword(hashedPassword);
        sPrepo.save(sp);
    }



    //update service provider by his id..
    public void editesp(ServiceProvider sp, ServiceProvider newsp) {
       newsp.setSnapshataccount(sp.getSnapshataccount());
       newsp.setInstegramaccount(sp.getInstegramaccount());
       newsp.setPhonenumber(sp.getPhonenumber());
       newsp.setAddress(sp.getAddress());
       newsp.setAboutme(sp.getAboutme());
       newsp.setLastname(sp.getLastname());
       newsp.setFirstname(sp.getFirstname());
       sPrepo.save(newsp);}




//get service provider details by his id..
    public ServiceProvider getspbyid(Integer spid) {
        ServiceProvider sp=sPrepo.findById(spid)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
      return sp;}




//get rate of service provider by service provider id..
//  to calculate rate i use this algorithm: (Total number of star / total number of persons who review * 5 ) * 5
//    public double getrate(Integer spid){
//        Integer total=0;
//        Integer counter=0;
//      List<Comment> comment=commentrepo.findAllByServiceproviderId(spid);
//        for(int i=0;i<comment.size()-1;i++){
//            Comment currentcomment=comment.get(i);
//            Integer rate=currentcomment.getRate();
//             total=total+rate;
//             counter++;}
//        double rate1=((total/(counter*5))*5);
//        return rate1;}

    public void deletesp(Account account, ServiceProvider sp){

        accountrepo.delete(account);
        sPrepo.delete(sp);
    }



//add project to service provider..
    public void addproject(Project project, Integer spid){
      ServiceProvider sp=  getspbyid(spid);
      //  sp.getProject().add(project);
        project.setServiceprovider(sp);
        projectrepo.save(project);
    }



//get project by service provider id..
    public List <Project> getprojectbyspid(Integer spid) {
        getspbyid(spid);
     return    projectrepo.findProjectByServiceproviderId(spid);}



    //get appointment by service provider id..
    public List<Appointment> getAppointmentbyspid(Integer spid){
     getspbyid(spid);
        return appointmentrepo.findAppointmentsByServiceproviderId(spid);}


    //methode to get serviceprovider by email..
   public ServiceProvider getUserByEmail(String email) {
       return sPrepo.findByAccount_Email(email);
   }


}

