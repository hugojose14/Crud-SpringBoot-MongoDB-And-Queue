package com.bolsaideas.springboot.web.app.interfaces;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolsaideas.springboot.web.app.domain.dto.HugoDto;
import com.bolsaideas.springboot.web.app.domain.model.Hugo;
import com.bolsaideas.springboot.web.app.service.HugoService;

@RestController
@RequestMapping("api/hugo")
public class HugoController {

	@Autowired
	HugoService hugoService;
	
	 private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


	@PostMapping("/agregar")
	public String saveHugo(@RequestBody HugoDto hugo) {

		hugoService.save(hugo);
		hugoService.publishDeviceHugo(hugo);

		return "Guardo y envió a la cola";
	}

	@GetMapping
	public List<HugoDto> getHugos() {
		return hugoService.findAll();
	}

	@GetMapping("/{id}")
	public HugoDto getHugo(@PathVariable String id) {
		return hugoService.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteHugo(@PathVariable String id) {
		hugoService.delete(id);
	}

	@PutMapping("/{id}")
	public Hugo updateHugo(HugoDto hugo) {
		return hugoService.update(hugo);
	}

	@GetMapping("/{nit}/{regimen}/{noPrescription}")
	public ResponseEntity<String> getJuntaProfesional(@PathVariable("nit") String nit,
			@PathVariable("regimen") String regimen, @PathVariable("noPrescription") String noPrescription)
			throws Exception {
		
        LOGGER.severe("El compi funciona");

//		if (hugoService.existsByNoPrescription(noPrescription)) {
//		} else {
//	        LOGGER.severe("El compi no funciona");//jajaaj la mamada lol xd
//			return new ResponseEntity<String>("Prescripcion no existe", HttpStatus.OK);
//		}
		hugoService.saveProfessionalBoard(nit, regimen, noPrescription);

		return new ResponseEntity<String>("Junta profesional guardada en la base de datos", HttpStatus.OK);

	}

}
