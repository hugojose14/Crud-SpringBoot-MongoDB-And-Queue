package com.bolsaideas.springboot.web.app.service.internal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsaideas.springboot.web.app.commons.AssemblerHugo;
import com.bolsaideas.springboot.web.app.commons.AssemblerProfessionalBoard;
import com.bolsaideas.springboot.web.app.domain.dto.HugoDto;
import com.bolsaideas.springboot.web.app.domain.dto.ProfessionalBoardDTO;
import com.bolsaideas.springboot.web.app.domain.model.Credential;
import com.bolsaideas.springboot.web.app.domain.model.Hugo;
import com.bolsaideas.springboot.web.app.events.model.EventDeviceHugo;
import com.bolsaideas.springboot.web.app.infraestructure.jpa.repositories.CredentialRepository;
import com.bolsaideas.springboot.web.app.infraestructure.jpa.repositories.HugoRepository;
import com.bolsaideas.springboot.web.app.infraestructure.jpa.repositories.PrescriptionRepository;
import com.bolsaideas.springboot.web.app.infraestructure.jpa.repositories.ProfessionalBoardRepository;
import com.bolsaideas.springboot.web.app.rest.client.service.HugoWsMipresService;
import com.bolsaideas.springboot.web.app.service.HugoService;

@Service
public class DefaultHugoServiceService implements HugoService{
	
	@Autowired
	private HugoRepository hugoRepository;
	
	@Autowired
	EventDeviceHugo eventDeviceHugo;
	
	@Autowired
	HugoWsMipresService hugoWsMipresService;
	
	@Autowired 
	CredentialRepository credentialRepository;
	
	@Autowired
	ProfessionalBoardRepository professionalBoardRepository;
	
	@Autowired
	PrescriptionRepository prescriptionRepository;
	
	private static final String TOTAL_PROFESSIONALBOARD = "Total de professional boards";
	private static final String PROFESSIONALBOARD_PENDINGS = "Total de juntas professional boards pendientes";

	
	@Override
	public void publishDeviceHugo(HugoDto hugo) {
		
		Hugo eventModelDevice = Hugo.builder().build();
		
		eventDeviceHugo.publisDeviceHugo(eventModelDevice);
	}

	@Override
	public List<HugoDto> findAll() {
		return AssemblerHugo.convertAllToDto(hugoRepository.findAll());
	}


	@Override
	public HugoDto findById(String idHugo) {
		
		if(idHugo.isEmpty()) {
			throw new RuntimeException("Registro no encontrado");
		}
		return AssemblerHugo.converDto(hugoRepository.findById(idHugo).get());
		
	}

	@Override
	public void delete(String idHugo) {
		
		if(idHugo.isEmpty()) {
			throw new RuntimeException("Registro no encontrado");
		}
		
		hugoRepository.deleteById(idHugo);
	}

	@Override
	public Hugo update(HugoDto hugo) {
		this.findById(hugo.getId());
		return hugoRepository.save(AssemblerHugo.convertToEntity(hugo));
		
	}

	@Override
	public Hugo save(HugoDto hugo) {
		 return hugoRepository.save(AssemblerHugo.convertToEntity(hugo));
	}

	@Override
	public Map<String, Integer> saveProfessionalBoard(String nit, String regimen, String noPrescription) {
		
		LocalTime localTimeNow = LocalTime.now();
	    LocalDate localDateNow = LocalDate.now();
	    
	    Map<String, Integer> totalPrescriptions = new HashMap<String, Integer>();
	    
	    if(nit.isEmpty() || regimen.isEmpty()  || noPrescription.isEmpty() ) {
	    	throw new RuntimeException("Campos no deben ser nulos");
	    }
	    
	    Credential credential = credentialRepository.findByNitAndRegimen(nit, regimen);
	    
	    if(credential == null) {
	    	throw new RuntimeException("No existe credencial registrada con el NIT y regimen");
	    }
	    
	    List<ProfessionalBoardDTO> professionalBoardDTOList = hugoWsMipresService.listJuntaProfesional(nit,credential.getToken(), noPrescription);
	    
	    if(professionalBoardDTOList.isEmpty()) {
	    	throw new RuntimeException("La preinscripcion de la junta médica no se encontró");
	    }
	    
	    int contProfessionalBoard=0, contProfessionalBoardPending=0;
	    
	    for(ProfessionalBoardDTO professionalBoardDTO: professionalBoardDTOList) {
	    	
	    	if(professionalBoardDTO.getNoPrescripcion().isEmpty()) {
	    		throw new RuntimeException("La junta medica profesional está vacía");
	    	}
	    	
	    	if(!professionalBoardDTO.getNoPrescripcion().isEmpty() || !professionalBoardDTOList.isEmpty()) {
	    		
	    		//Haciendo que ProfessionalBoard persista en la base de datos
	    		//Mapeando el objeto
	    		ProfessionalBoardDTO professionalDto= AssemblerProfessionalBoard.converDto(professionalBoardRepository.save(AssemblerProfessionalBoard.convertToEntity(professionalBoardDTO)));
	    		
	    		contProfessionalBoard++;
		    	contProfessionalBoardPending++;
	    	}	
	    }
	    
	    
	    totalPrescriptions.put(TOTAL_PROFESSIONALBOARD, contProfessionalBoard);
	    totalPrescriptions.put(PROFESSIONALBOARD_PENDINGS, contProfessionalBoardPending);
		return totalPrescriptions;
		
	}

	@Override
	public boolean existsByNoPrescription(String noPrescription) {	
		return prescriptionRepository.existsByNoPrescription(noPrescription);
	}
	
}
