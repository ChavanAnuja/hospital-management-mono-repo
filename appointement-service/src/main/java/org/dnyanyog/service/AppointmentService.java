package org.dnyanyog.service;


import org.dnyanyog.dto.request.AppointmentRequest;
import org.dnyanyog.dto.request.UpdateAppointmentRequest;
import org.dnyanyog.dto.response.AppointmentResponse;
import org.dnyanyog.dto.response.DataByPatientId;
import org.dnyanyog.dto.response.UpdateAppointmentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface AppointmentService {
	
	  ResponseEntity<AppointmentResponse> addAppointment(AppointmentRequest request);
	
	  AppointmentResponse deleteAppointment(Long patientId);

  ResponseEntity<DataByPatientId> getDataByPatientId(long patientId);

ResponseEntity<DataByPatientId> updateDataByPatientId(long patientId,UpdateAppointmentRequest updatedData);

ResponseEntity<UpdateAppointmentResponse> updateAppointment(long patientId,UpdateAppointmentRequest request);

}
