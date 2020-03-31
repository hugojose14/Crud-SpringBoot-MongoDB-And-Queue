package com.bolsaideas.springboot.web.app.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientWsMipres {

	@Value("${mipres.default.juntaMedicaUrl}")
	private String juntaMedicaUrl;
	
	private RestTemplate restTemplate;
	
	private String url;
	
	@Autowired
	public ClientWsMipres(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	 public ResponseEntity<String> obtainProfessionalBoardService(String nit, String token, String noPrescription){
		    url = String.format("%s/%s/%s/%s", juntaMedicaUrl, nit, token.trim(),noPrescription);
		    ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
		    return result;
		  }
}
