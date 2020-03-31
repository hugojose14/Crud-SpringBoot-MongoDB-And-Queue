package com.bolsaideas.springboot.web.app.service;

import java.util.List;
import java.util.Map;

import com.bolsaideas.springboot.web.app.domain.dto.HugoDto;
import com.bolsaideas.springboot.web.app.domain.model.Hugo;

public interface HugoService {
		
	public List<HugoDto> findAll();
	
	public HugoDto findById(String idHugo);
	
	public void delete(String idHugo);
	
	public Hugo update(HugoDto hugo);

	public void publishDeviceHugo(HugoDto hugo);

	public Hugo save(HugoDto hugo);
	
	public Map<String,Integer> saveProfessionalBoard(String nit, String regimen,String noPrescription);
	
	boolean existsByNoPrescription(String noPrescription);

	
}
