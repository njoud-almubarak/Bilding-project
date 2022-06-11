package com.example.building.repository;

import com.example.building.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Appointmentrepo extends JpaRepository<Appointment,Integer> {

  //  Appointment findAllAppointmentByDate(LocalDate date);
   // List<Appointment> findAppointmentByMyuserId(Integer uid);
    List<Appointment> findAppointmentsByMyuserId(Integer uid);
    List<Appointment> findAppointmentsByServiceproviderId(Integer spid);

}
