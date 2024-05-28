package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.request.AppointmentRequest;
import org.dnyanyog.dto.request.UpdateAppointmentRequest;
import org.dnyanyog.dto.response.AppointmentData;
import org.dnyanyog.dto.response.AppointmentResponse;
import org.dnyanyog.dto.response.DataByPatientId;
import org.dnyanyog.dto.response.DataByPatientIdResponse;
import org.dnyanyog.dto.response.UpdateAppointmentData;
import org.dnyanyog.dto.response.UpdateAppointmentResponse;
import org.dnyanyog.entity.Appointment;
import org.dnyanyog.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	
	@Autowired
	private AppointmentResponse appointmentResponse;
	
	@Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepo, AppointmentResponse appointmentResponse) {
        this.appointmentRepo = appointmentRepo;
        this.appointmentResponse = appointmentResponse;
    }
	
	public ResponseEntity<AppointmentResponse> addAppointment(AppointmentRequest request)
	{
		appointmentResponse = new AppointmentResponse();
		appointmentResponse.setData(new AppointmentData());
		Appointment appointment = new Appointment();
		
		if(appointmentRepo.existsByexaminationDateAndAppointmentTime(request.getExaminationDate(), request.getAppointmentTime()))
		{
			appointmentResponse.setStatus(HttpStatus.CONFLICT.value());
			appointmentResponse.setMessage("Appointment with this date and time already exists.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(appointmentResponse);
		}
		
		appointment.setExaminationDate(request.getExaminationDate());

	
		appointment.setAppointmentTime(request.getAppointmentTime());
		appointment.setPatientId(request.getPatientId());
		appointment.setPatientNameEnglish(request.getPatientNameEnglish());
		appointment.setAppointmentId(request.getAppointmentId());
		appointment.setExaminationDate(request.getExaminationDate());

		appointment = appointmentRepo.save(appointment);
		
		appointmentResponse.setStatus(HttpStatus.CREATED.value());
		appointmentResponse.setMessage("Appointment Created Successfully");
		appointmentResponse.getData().setExaminationDate(appointment.getExaminationDate());
		appointmentResponse.getData().setAppointmentId(appointment.getAppointmentId());
		appointmentResponse.getData().setAppointmentTime(appointment.getAppointmentTime());
		appointmentResponse.getData().setPatientId(appointment.getPatientId());
		appointmentResponse.getData().setPatientNameEnglish(appointment.getPatientNameEnglish());

		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentResponse);

			
	}
	
	public AppointmentResponse deleteAppointment(Long patientId) {
		Optional<Appointment> existingAppointment = appointmentRepo.findByPatientId(patientId);

		AppointmentResponse appointmentResponse = new AppointmentResponse();

		if (existingAppointment.isPresent()) {
			Appointment deleteAppointment =(existingAppointment.get());
			deleteAppointment.setAppointmentStatus("Inactive");
			appointmentRepo.save(deleteAppointment);

			appointmentResponse.setStatus(HttpStatus.OK.value());
			appointmentResponse.setMessage("Appointment Status is INACTIVE");
		} else {
			appointmentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			appointmentResponse.setMessage("Appointments is Not Found");
		}

		return appointmentResponse;
	}
    

	
	@Override
	public ResponseEntity<DataByPatientId> getDataByPatientId(long patientId) {
	    Optional<Appointment> appointmentOpt = appointmentRepo.findByPatientId(patientId);

	    DataByPatientId response = new DataByPatientId();
	    if (appointmentOpt.isEmpty()) {
	        response.setStatus(HttpStatus.NOT_FOUND.value());
	        response.setMessage("Appointment not found");
	        return ResponseEntity.status(HttpStatus.OK).body(response);
	    }

	    Appointment appointment = appointmentOpt.get();
	    response.setStatus(HttpStatus.OK.value());
	    response.setMessage("Appointment found");

	    response.setExaminationDate(appointment.getExaminationDate());
	    response.setAppointmentId(appointment.getAppointmentId());
	    response.setAppointmentStatus(appointment.getAppointmentStatus());
	    response.setAppointmentTime(appointment.getAppointmentTime());
	    response.setPatientId(appointment.getPatientId());
	    response.setPatientNameEnglish(appointment.getPatientNameEnglish());

	    return ResponseEntity.status(HttpStatus.OK).body(response);
	}

  @Override
  public ResponseEntity<DataByPatientId> updateDataByPatientId(
      long patientId, UpdateAppointmentRequest updatedData) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResponseEntity<UpdateAppointmentResponse> updateAppointment(
      long patientId, UpdateAppointmentRequest request) {
    // TODO Auto-generated method stub
    return null;
  }
	
	
	/*@Override
	public ResponseEntity<UpdateAppointmentResponse> updateAppointment(long patientId, UpdateAppointmentRequest request) {
	    Optional<Appointment> optionalAppointment = appointmentRepo.findByPatientId(patientId);

	    UpdateAppointmentResponse appointmentResponse = new UpdateAppointmentResponse();
	    if (optionalAppointment.isEmpty()) {
	        appointmentResponse.setStatus(HttpStatus.NOT_FOUND.value());
	        appointmentResponse.setMessage("Appointment not found");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(appointmentResponse);
	    } else {
	        Appointment appointment = optionalAppointment.get();

	        // Updating appointment fields with the request data
	        appointment.setAppointmentStatus(request.getAppointmentStatus());
	        appointment.setAppointmentTime(request.getAppointmentTime());
	        appointment.setExaminationDate(request.getExaminationDate());
	        appointment.setPatientNameEnglish(request.getPatientNameEnglish());

	        // Save the updated appointment
	        appointmentRepo.save(appointment);

	        // Setting the response data
	        appointmentResponse.setStatus(HttpStatus.OK.value());
	        appointmentResponse.setMessage("Appointment updated successfully");
	        appointmentResponse.getData().setExaminationDate(appointment.getExaminationDate());
	        appointmentResponse.getData().setAppointmentId(appointment.getAppointmentId());
	        appointmentResponse.getData().setAppointmentStatus(appointment.getAppointmentStatus());
	        appointmentResponse.getData().setAppointmentTime(appointment.getAppointmentTime());
	        appointmentResponse.getData().setPatientId(appointment.getPatientId());
	        appointmentResponse.getData().setPatientNameEnglish(appointment.getPatientNameEnglish());
	        appointmentResponse.getData().setAppointmentStatus(appointment.getAppointmentStatus());

	        return ResponseEntity.status(HttpStatus.OK).body(appointmentResponse);
	    }
	}
	*/

	
//	public ResponseEntity<UpdateAppointmentResponse> updateAppointment(UpdateAppointmentRequest updateRequest) {
//
//		Optional<Appointment> appointment = appointmentRepo.findByPatientId(updateRequest.getPatientId());
//
//		if (appointment == null) {
//			UpdateAppointmentResponse response = new UpdateAppointmentResponse();
//			// response.setResponseCode(HttpStatus.NOT_FOUND.);
//			response.setStatus(HttpStatus.NOT_FOUND.value());
//			response.setMessage("Appointment not found");
//
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//		}
//		
//		appointment.setAppointmentTime(updateRequest.getAppointmentTime());
//		appointment.setAppointmentDate(updateRequest.getAppointmentDate());
//		appointment.setAppointmentStatus(updateRequest.getAppointmentStatus());
//		appointmentRepo.saveAllAndFlush(appointment);
//
//		UpdateAppointmentResponse response = new UpdateAppointmentResponse();
//		response.setResponseCode(HttpStatus.OK.value());
//		response.setResponseMessage("Appointment record updated successfully");
//
//		response.setData(new UpdateAppointmentData());
//
//		response.getData().setAppointmentDate(appointment.getAppointmentDate());
//		response.getData().setAppointmentId(appointment.getAppointmentId());
//		response.getData().setAppointmentStatus(appointment.getAppointmentStatus());
//		response.getData().setAppointmentTime(appointment.getAppointmentTime());
//		response.getData().setPatientId(appointment.getPatientId());
//		response.getData().setPatientName(appointment.getPatientName());
//		response.getData().setAppointmentStatus(appointment.getAppointmentStatus());
//		response.getData().setName(appointment.getName());
//
//		
//		return ResponseEntity.status(HttpStatus.OK).body(response);
//	}
}
