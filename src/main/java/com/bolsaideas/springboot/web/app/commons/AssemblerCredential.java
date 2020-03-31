package com.bolsaideas.springboot.web.app.commons;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.bolsaideas.springboot.web.app.domain.dto.CredentialsDto;
import com.bolsaideas.springboot.web.app.domain.model.Credential;


public class AssemblerCredential {
	
	public static Credential convertToEntity(CredentialsDto credentialDto) {
		
		Credential credential = new Credential();	
		BeanUtils.copyProperties(credentialDto, credential);
		return credential;
	}
	
	public static List<Credential> convertAllEntity(List<CredentialsDto> credentialDTOList){
		if(credentialDTOList.isEmpty()) {
			throw new RuntimeException("La Lista no puede estar vacia");
		}
		
		List<Credential> credentialsList = new ArrayList<Credential>();
		credentialDTOList.forEach(input -> {
			credentialsList.add(convertToEntity(input));
		});
		
		return credentialsList;
		
	}
	
	public static CredentialsDto convertDto(Credential credential) {
		CredentialsDto credentialsDto = new CredentialsDto();
		BeanUtils.copyProperties(credential, credentialsDto);
		return credentialsDto;
	}
	
	
	public static List<Credential> convertAllDto(List<Credential> credentialList){
		if(credentialList.isEmpty()) {
			throw new RuntimeException("La Lista no puede estar vacia");
		}
		
		List<CredentialsDto> credentialsList = new ArrayList<CredentialsDto>();
		credentialList.forEach(input -> {
			credentialsList.add(convertDto(input));
		});
		
		return credentialList;
		
	}
	
	
	

}
