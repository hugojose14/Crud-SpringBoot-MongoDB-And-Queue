package com.bolsaideas.springboot.web.app.infraestructure.jpa.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.bolsaideas.springboot.web.app.domain.model.Hugo;

@Repository
public interface HugoRepository extends MongoRepository<Hugo, String>{


}
