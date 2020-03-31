package com.bolsaideas.springboot.web.app.rest.client.service;

import java.util.List;

import com.bolsaideas.springboot.web.app.domain.dto.ProfessionalBoardDTO;

public interface HugoWsMipresService {
	
	List<ProfessionalBoardDTO> listJuntaProfesional(String nit, String token,String noPrescription);
}
