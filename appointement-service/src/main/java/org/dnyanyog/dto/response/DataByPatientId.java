package org.dnyanyog.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;
import org.springframework.stereotype.Component;

@Component
public class DataByPatientId {

  private Long appointmentId;

  @NotNull(message = "Patientname should not be Null")
  @NotBlank(message = "Patientname should not be Blank")
  private String patientNameEnglish;

  private Long patientId;

  @NotNull(message = "ExaminationDate should not be Null")
  private Date examinationDate;

  @NotNull(message = "Time should not be Null")
  private String appointmentTime;

  private String appointmentStatus;
  private int status;
  private String message;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
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

  public String getAppointmentStatus() {
    return appointmentStatus;
  }

  public void setAppointmentStatus(String appointmentStatus) {
    this.appointmentStatus = appointmentStatus;
  }
}
