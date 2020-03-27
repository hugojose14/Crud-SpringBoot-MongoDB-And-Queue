package com.bolsaideas.springboot.web.app.service;

import java.util.List;
import java.util.Optional;

import com.bolsaideas.springboot.web.app.domain.model.Hugo;

public interface HugoService {
	
	public Hugo save(Hugo hugo);
	
	public List<Hugo> findAll();
	
	public Optional<Hugo> findById(String idHugo);
	
	public void delete(String idHugo);
	
	public Hugo update(Hugo hugo);

	void publishDeviceHugo(Hugo hugo);
	
}
