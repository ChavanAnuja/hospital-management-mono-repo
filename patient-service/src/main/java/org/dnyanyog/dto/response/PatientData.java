package org.dnyanyog.dto.response;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class PatientData {
	private Long patientId;

	  private String patientNameEnglish;

	  private String patientNameMarathi;

	  private String mobileNumber;

	  private String gender;

	  private Date birthDate;

	  private Date firstExaminationDate;

	  private String address;

	  public String getPatientNameEnglish() {
	    return patientNameEnglish;
	  }

	  public void setPatientNameEnglish(String patientNameEnglish) {
	    this.patientNameEnglish = patientNameEnglish;
	  }

	  public String getPatientNameMarathi() {
	    return patientNameMarathi;
	  }

	  public void setPatientNameMarathi(String patientNameMarathi) {
	    this.patientNameMarathi = patientNameMarathi;
	  }

	  public String getMobileNumber() {
	    return mobileNumber;
	  }

	  public void setMobileNumber(String mobileNumber) {
	    this.mobileNumber = mobileNumber;
	  }

	  public String getGender() {
	    return gender;
	  }

	  public void setGender(String gender) {
	    this.gender = gender;
	  }

	  public Date getBirthDate() {
	    return birthDate;
	  }

	  public void setBirthDate(Date birthDate) {
	    this.birthDate = birthDate;
	  }

	  public Date getFirstExaminationDate() {
	    return firstExaminationDate;
	  }

	  public void setFirstExaminationDate(Date firstExaminationDate) {
	    this.firstExaminationDate = firstExaminationDate;
	  }

	  public String getAddress() {
	    return address;
	  }

	  public void setAddress(String address) {
	    this.address = address;
	  }

	  public Long getPatientId() {
	    return patientId;
	  }

	  public void setPatientId(Long patientId) {
	    this.patientId = patientId;
	  }
	
}
