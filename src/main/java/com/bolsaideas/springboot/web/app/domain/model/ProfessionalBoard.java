package com.bolsaideas.springboot.web.app.domain.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "hugos_migracion")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProfessionalBoard implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  private String id;

  private String noPrescripcion;

  private String fPrescripcion;
  
  private String tipoTecnologia;

  private int consecutivo;

  private String estJM;

  private String codEntProc;

  private String observaciones;

  private String justificacionTecnica;

  private String modalidad;

  private String noActa;

  private String fechaActa;

  private String fProceso;

  private String tipoIDPaciente;

  private String nroIDPaciente;

  private String codEntJM;
  
}
