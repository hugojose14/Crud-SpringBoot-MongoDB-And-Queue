package com.bolsaideas.springboot.web.app.infraestructure.jpa.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bolsaideas.springboot.web.app.domain.model.Prescription;

public interface PrescriptionRepository extends MongoRepository<Prescription,String>{
	  boolean existsByNoPrescription(String noPrescription);
}
