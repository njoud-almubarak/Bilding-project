package com.example.building.service;

import com.example.building.exeption.InvalidId;
import com.example.building.model.Admin;
import com.example.building.model.Appointment;
import com.example.building.model.Myuser;
import com.example.building.model.ServiceProvider;
import com.example.building.repository.Appointmentrepo;
import com.example.building.repository.Myuserrepo;
import com.example.building.repository.SPrepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Appointservice {
    private final Appointmentrepo appointmentrepo;
private final Myuserrepo myuserrepo;
private final SPrepo sPrepo;



public List<Appointment> getAppointment(){
        return appointmentrepo.findAll();
    }


//    public void editeappointment(Appointment appointment,Integer id){
//        Appointment appointment1=appointmentrepo.findById(id)
//                .orElseThrow(
//                        ()->new InvalidId("Invalid id"));
//        appointment1.setId(id);
//        appointment.setDate(appointment.getDate());
//        appointment1.setTime(appointment.getTime());
//        appointmentrepo.save(appointment1);
//
//
//    }

    public void deleteappointment(Integer aid){

        Appointment appointment=appointmentrepo.findById(aid)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        appointmentrepo.deleteById(aid);}

   /* public void deleteappointmentbydate(LocalDate date) {
        Appointment appointment=appointmentrepo.findAllAppointmentByDate(date)
                .orElseThrow(
                        ()->new IvalidDate("Invalid date"));

        appointmentrepo.delete(appointment);

    }*/
}
