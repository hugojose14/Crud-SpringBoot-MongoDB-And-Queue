package com.bolsaideas.springboot.web.app.rest.client.service.internal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bolsaideas.springboot.web.app.domain.dto.ProfessionalBoardDTO;
import com.bolsaideas.springboot.web.app.domain.dto.ProfessionalBoardHeaderDTO;
import com.bolsaideas.springboot.web.app.rest.client.ClientWsMipres;
import com.bolsaideas.springboot.web.app.rest.client.service.HugoWsMipresService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class DefaultClientWsMipresService implements HugoWsMipresService {

	@Autowired
	ClientWsMipres clientWsMipres;

	JsonParser jsonParser;
	GsonBuilder gsonBuilder;
	Gson gson;

	private static final Integer RESPONSE_CODE_MIPRES_OK = 200;

	@PostConstruct
	public void postConstruct() {
		jsonParser = new JsonParser();
		gsonBuilder = new GsonBuilder();
		gson = gsonBuilder.create();
	}

	@Override
	  public List<ProfessionalBoardDTO> listJuntaProfesional(String nit, String token,String noPrescription) {

	    if (nit == null || noPrescription == null) {
	      throw new RuntimeException("Campos no deben Ser Nulos");
	    }

	    ResponseEntity<String> result = clientWsMipres.obtainProfessionalBoardService(nit, token, noPrescription);

	    if (result == null) {
	      throw new RuntimeException("Junta Medica no encontrada");
	    }
	    List<ProfessionalBoardDTO> juntaMedicaDTOList = null;
	    if (result.getStatusCodeValue() == RESPONSE_CODE_MIPRES_OK) {
	      juntaMedicaDTOList = new ArrayList<>();
	      JsonArray jsonArrayPescriptions = jsonParser.parse(result.getBody()).getAsJsonArray();

	      for (JsonElement elementoProfessionalBoardJson : jsonArrayPescriptions) {
	        JsonObject objProfessionalBoard = elementoProfessionalBoardJson.getAsJsonObject();
	        ProfessionalBoardHeaderDTO professionalBoardHeaderDTO =
	            gson.fromJson(objProfessionalBoard, ProfessionalBoardHeaderDTO.class);
	        juntaMedicaDTOList.add(professionalBoardHeaderDTO.getProfessionalBoardDTO());
	      }
	    }
	    return juntaMedicaDTOList;
	  }

}
