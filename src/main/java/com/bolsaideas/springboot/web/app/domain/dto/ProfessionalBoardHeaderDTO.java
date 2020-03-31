package com.bolsaideas.springboot.web.app.domain.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ProfessionalBoardHeaderDTO {
  
  @SerializedName("junta_profesional")
  ProfessionalBoardDTO professionalBoardDTO;
}
