package com.example.building.service;

import com.example.building.exeption.InvalidId;
import com.example.building.model.*;
import com.example.building.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Myuserservice {
    private final Myuserrepo myuserrepo;
    private final Commentrepo commentrepo;
    private final SPservice spservice;
private final SPrepo sprepo;
private final Accountrepo accountrepo;
private final Appointmentrepo appointmentrepo;



//    public List<Myuser> getuser(){ return myuserrepo.findAll(); }

    public Myuser getuserbyid(Integer id){
        Myuser myuser1=myuserrepo.findById(id)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        return myuser1;}

    public void adduser(Account account,Myuser myuser){
        String hashedPassword=new BCryptPasswordEncoder().encode(account.getPassword());
        account.setPassword(hashedPassword);
        myuser.setAccount(account);
        myuserrepo.save(myuser);}



    public Myuser editeuser(Myuser myuser,Myuser newuser){
       newuser.setUsername(myuser.getUsername());
       newuser.setPhonenumber(myuser.getPhonenumber());
       return myuserrepo.save(newuser);

    }



    public void deleteuser(Account account, Myuser myuser) {
       accountrepo.delete(account);
        myuserrepo.delete(myuser);
    }



    //get rate of service provider by service provider id..
//  to calculate rate i use this algorithm: (Total number of star / total number of persons who review * 5 ) * 5
    public double getrate(Integer spid){
        double total=0.0;
        Integer counter=1;
        List<Comment> comment=commentrepo.findAllByServiceproviderId(spid);
        for(int i=0;i<comment.size()-1;i++){
            Comment currentcomment=comment.get(i);
            double rate=currentcomment.getRate();
            total+=rate;
            counter++;}

        double rate1=((total/(counter*5))*5);
        return rate1;}
   public Myuser getUserByEmail(String email) {
       return myuserrepo.findByAccount_Email(email);
   }

    public void addcommentbyuser(Integer uid,Integer spid,Comment comment){
        Myuser myuser = getuserbyid(uid);
        ServiceProvider sp=spservice.getspbyid(spid);
        comment.setMyuser(myuser);
        comment.setServiceprovider(sp);
        commentrepo.save(comment);}



    public List<Comment> getcomment(Integer spid) {
        List<Comment> comment=commentrepo.findAllByServiceproviderId(spid);
        return comment;}


    public void addappointment(Appointment appoint,Integer uid,Integer spid){

        ServiceProvider sp=spservice.getspbyid(spid);
        Myuser myuser= getuserbyid(uid);
        appoint.setServiceprovider(sp);
        appoint.setMyuser(myuser);
        appointmentrepo.save(appoint);}




    public List<Appointment> getAppointmentbyuserid(Integer uid){
    getuserbyid(uid);
      return appointmentrepo.findAppointmentsByMyuserId(uid);
    }



}


