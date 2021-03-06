package com.bolsaideas.springboot.web.app.domain.dto;
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
public class HugoDto {

	private String id;
	private String nombre;
	private String apellido;
	private Integer cedula;
	private String correo;
}
