package com.bolsaideas.springboot.web.app.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "prescriptions")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Prescription implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private String noPrescription;
  private String nit;
  private String regimen;
  private String token;
  private Status status;
  private LocalDate dateRequest;
  private LocalDate datePrescription;
  private LocalDate lastUpdate;
  private String jsonResult;
}

