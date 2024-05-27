package org.dnyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class PatientResponse {
  private String status;
  private String message;
  private PatientData data;

  
  public String getStatus() {
return status;}

public void setStatus(String status) {
this.status = status;}

public String getMessage() {
return message;}

public void setMessage(String message) {
this.message = message;}

public PatientData getData() {
    return data;
  }

  public void setData(PatientData data) {
    this.data = data;
  }
}
