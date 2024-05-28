package org.dnyanyog.repo;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.dnyanyog.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AppointmentRepository extends JpaRepository<Appointment, Long>  {
	
	// boolean appointmentExistByDateAndTime(Date examinationDate,String appointmentTime);

	 boolean existsByexaminationDateAndAppointmentTime(Date examinationDate,String appointmentTime);

  Optional<Appointment> findByPatientId(Long patientId);
  
}

