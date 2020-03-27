package com.bolsaideas.springboot.web.app.domain.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "hugos_migracion")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hugo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nombre;
	private String apellido;
	private Integer cedula;
	private String correo;
	
}
