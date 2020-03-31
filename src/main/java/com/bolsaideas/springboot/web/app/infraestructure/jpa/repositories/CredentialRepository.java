package com.bolsaideas.springboot.web.app.infraestructure.jpa.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bolsaideas.springboot.web.app.domain.model.Credential;

public interface CredentialRepository extends MongoRepository<Credential, String> {
	
	Credential findByNitAndRegimen(String nit, String regimen);

}
