package org.dnyanyog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.sql.Date;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Appointment {

  @Column
  @Id
 // @SequenceGenerator(name = "appointment_seq", sequenceName = "appointment_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long appointmentId;

  @Column private String patientNameEnglish;

  @Column private Long patientId;

  @Column private Date examinationDate;

  @Column private String appointmentTime;

  @Column private String appointmentStatus;

  public static Appointment getInstance() {
    return new Appointment();
  }

  public String getAppointmentStatus() {
    return appointmentStatus;
  }

  public Appointment setAppointmentStatus(String appointmentStatus) {
    this.appointmentStatus = appointmentStatus;
    return this;
  }

  public long getAppointmentId() {
    return appointmentId;
  }

  public Appointment setAppointmentId(long appointmentId) {
    this.appointmentId = appointmentId;
    return this;
  }

  public String getPatientNameEnglish() {
    return patientNameEnglish;
  }

  public Appointment setPatientNameEnglish(String patientNameEnglish) {
    this.patientNameEnglish = patientNameEnglish;
    return this;
  }

  public Long getPatientId() {
    return patientId;
  }

  public Appointment setPatientId(Long patientId) {
    this.patientId = patientId;
    return this;
  }

  public Date getExaminationDate() {
    return examinationDate;
  }

  public Appointment setExaminationDate(Date examinationDate) {
    this.examinationDate = examinationDate;
    return this;
  }

  public String getAppointmentTime() {
    return appointmentTime;
  }

  public Appointment setAppointmentTime(String appointmentTime) {
    this.appointmentTime = appointmentTime;
    return this;
  }
}
