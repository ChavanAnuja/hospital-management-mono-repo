package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.request.PatientRequest;
import org.dnyanyog.dto.response.PatientResponse;
import org.dnyanyog.entity.Patient;
import org.dnyanyog.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    
    private PatientRepo patientRepository;
    private PatientResponse patientResponse;

    @Autowired
    public PatientServiceImpl(PatientRepo patientRepository, PatientResponse patientResponse) {
        this.patientRepository = patientRepository;
        this.patientResponse = patientResponse;
    }

    @Override
    public Optional<PatientResponse> addPatientDetails(PatientRequest request) throws Exception {
        Patient patient = new Patient();
        patient.setAddress(request.getAddress());
        patient.setBirthDate(request.getBirthDate());
        patient.setFirstExaminationDate(request.getFirstExaminationDate());
        patient.setGender(request.getGender());
        patient.setMobileNumber(request.getMobileNumber());
        patient.setPatientId(request.getPatientId());  // Assuming there's a way to set this
        patient.setPatientNameEnglish(request.getPatientNameEnglish());
        patient.setPatientNameMarathi(request.getPatientNameMarathi());

        patient = patientRepository.save(patient);

        patientResponse.setStatus("Success");;
        patientResponse.setMessage("Patient Added Successfully");
        return Optional.of(patientResponse);
 
    }
    
    @Override
    public Optional<PatientResponse> getPatientDetails(Long patientId) {
        return patientRepository.findById(patientId).map(patient -> {
            PatientResponse response = new PatientResponse();
            response.setStatus("Success");
            response.setMessage("Patient found successfully");
            return response;
        });
    }
    
    public Optional<PatientResponse> deletePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    return Optional.empty();
    }
}
