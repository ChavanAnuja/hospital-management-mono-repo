package org.dnyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class DataByPatientIdResponse {

  private int status;
  private String message;
  private DataByPatientId data;

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

  public DataByPatientId getData() {
    return data;
  }

  public void setData(DataByPatientId data) {
    this.data = data;
  }
  
 
}
