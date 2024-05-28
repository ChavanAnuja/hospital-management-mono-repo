package org.dnyanyog.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Entity
@Table
public class Appointment {

  @Column
  @Id
  @SequenceGenerator(name = "appointment_seq", sequenceName = "appointment_seq", allocationSize = 1)
  private long AppointmentId;

  @Column private String patientNameEnglish;

  @Column private Long patientId;

  @Column private Date examinationDate;

  @Column private String appointmentTime;

  @Column private String appointmentStatus;

  public String getAppointmentStatus() {
    return appointmentStatus;
  }

  public void setAppointmentStatus(String appointmentStatus) {
    this.appointmentStatus = appointmentStatus;
  }

  public long getAppointmentId() {
    return AppointmentId;
  }

  public void setAppointmentId(long appointmentId) {
    AppointmentId = appointmentId;
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
