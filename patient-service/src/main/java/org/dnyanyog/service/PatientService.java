package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.request.PatientRequest;
import org.dnyanyog.dto.response.PatientResponse;

public interface PatientService {

  public Optional<PatientResponse> addPatientDetails(PatientRequest request) throws Exception;
  Optional<PatientResponse> getPatientDetails(Long patientId);
  Optional<PatientResponse> deletePatient(Long patientId);
  
}
