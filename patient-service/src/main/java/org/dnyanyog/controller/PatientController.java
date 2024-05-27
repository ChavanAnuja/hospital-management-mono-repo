package org.dnyanyog.controller;

import org.dnyanyog.dto.request.PatientRequest;
import org.dnyanyog.dto.response.PatientResponse;
import org.dnyanyog.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PatientController {

  private final PatientService patientService;

  @Autowired
  public PatientController(PatientService patientService) {
    this.patientService = patientService;
  }

  @PostMapping("/api/v1/patient/add")
  public Optional<PatientResponse> addPatient(@RequestBody PatientRequest request)
      throws Exception {
    return patientService.addPatientDetails(request);
  }

  @GetMapping("/api/v1/patient/{patientId}")
  public Optional<PatientResponse> getPatient(@PathVariable Long patientId) {
    return patientService.getPatientDetails(patientId);
  }
  
  @DeleteMapping("/api/v1/patient/{patientId}")
  public void deletePatient(@PathVariable Long patientId) {
      patientService.deletePatient(patientId);
  }
}
