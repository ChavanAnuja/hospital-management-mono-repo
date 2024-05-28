package org.dnyanyog.dto.response;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class AppointmentData {

  private Long appointmentId;

  private String patientNameEnglish;

  private Long patientId;

  private Date examinationDate;

  private String appointmentTime;

  private String appointmentStatus;

  public String getAppointmentStatus() {
    return appointmentStatus;
  }

  public void setAppointmentStatus(String appointmentStatus) {
    this.appointmentStatus = appointmentStatus;
  }

  public Long getAppointmentId() {
    return appointmentId;
  }

  public void setAppointmentId(Long appointmentId) {
    this.appointmentId = appointmentId;
  }

  public String getPatientNameEnglish() {
    return patientNameEnglish;
  }

  public void setPatientNameEnglish(String patientNameEnglish) {
    this.patientNameEnglish = patientNameEnglish;
  }

  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

  public Date getExaminationDate() {
    return examinationDate;
  }

  public void setExaminationDate(Date examinationDate) {
    this.examinationDate = examinationDate;
  }

  public String getAppointmentTime() {
    return appointmentTime;
  }

  public void setAppointmentTime(String appointmentTime) {
    this.appointmentTime = appointmentTime;
  }
}
