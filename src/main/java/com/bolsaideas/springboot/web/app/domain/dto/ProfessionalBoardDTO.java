package com.bolsaideas.springboot.web.app.domain.dto;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@JsonSerializableSchema(id = "prescripcion_novedades")
public class ProfessionalBoardDTO {
  
  @SerializedName("NoPrescripcion")
  private String noPrescripcion;
  
  @SerializedName("FPrescripcion")
  private String fPrescripcion;
  
  @SerializedName("TipoTecnologia")
  private String tipoTecnologia;
  
  @SerializedName("Consecutivo")
  private int consecutivo;

  @SerializedName("EstJM")
  private String estJM;
  
  @SerializedName("CodEntProc")
  private String codEntProc;
  
  @SerializedName("Observaciones")
  private String observaciones;
  
  @SerializedName("JustificacionTecnica")
  private String justificacionTecnica;
  
  @SerializedName("Modalidad")
  private String modalidad;
  
  @SerializedName("NoActa")
  private String noActa;
  
  @SerializedName("FechaActa")
  private String fechaActa;
  
  @SerializedName("FProceso")
  private String fProceso;
  
  @SerializedName("TipoIDPaciente")
  private String tipoIDPaciente;
  
  @SerializedName("NroIDPaciente")
  private String nroIDPaciente;
  
  @SerializedName("CodEntJM")
  private String codEntJM;
  
}
