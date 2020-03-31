package com.bolsaideas.springboot.web.app.infraestructure.jpa.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bolsaideas.springboot.web.app.domain.model.ProfessionalBoard;

public interface ProfessionalBoardRepository extends MongoRepository<ProfessionalBoard, String>{

	
	
}
