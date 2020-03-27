package com.bolsaideas.springboot.web.app.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsaideas.springboot.web.app.domain.model.Hugo;
import com.bolsaideas.springboot.web.app.service.HugoService;

@RestController
@RequestMapping("api/hugo")
public class HugoController {

	@Autowired
	HugoService hugoService;
	
	@PostMapping("/agregar")
	public String saveHugo(@RequestBody Hugo hugo) {
		
		hugoService.save(hugo);
		hugoService.publishDeviceHugo(hugo);
	
		return "Guardo y envió a la cola";
	}
	
	@GetMapping
	public List<Hugo> getHugos(){
		return hugoService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Hugo> getHugo(@PathVariable String id) {
		return hugoService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteHugo(@PathVariable String id) {
		 hugoService.delete(id);
	}
	
	@PutMapping("/{id}")
	public Hugo updateHugo(Hugo hugo) {
		return hugoService.update(hugo);
	}	
}
