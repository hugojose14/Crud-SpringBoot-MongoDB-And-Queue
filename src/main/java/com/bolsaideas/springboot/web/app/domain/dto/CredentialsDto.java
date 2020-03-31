package com.bolsaideas.springboot.web.app.domain.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CredentialsDto {
	
	private String id;
    private String nit;
    private String regimen;
    private String token;
    private LocalDate tokenDate;
    private String user;
	
}
