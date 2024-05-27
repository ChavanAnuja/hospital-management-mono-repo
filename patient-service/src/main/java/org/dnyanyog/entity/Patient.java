package org.dnyanyog.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table
public class Patient {
  @Id @GeneratedValue private Long patientId;

  @Column 
  private String patientNameEnglish;

  @Column 
  private String patientNameMarathi;
  @Column 
  private String mobileNumber;
  @Column 
  private String gender;
  @Column 
  private Date birthDate;
  @Column 
  private Date firstExaminationDate;
  @Column 
  private String address;

  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

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

  
}
