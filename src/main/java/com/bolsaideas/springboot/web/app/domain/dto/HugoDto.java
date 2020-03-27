package com.bolsaideas.springboot.web.app.domain.dto;

public class HugoDto {

	private String id;
	private String nombre;
	private String apellido;
	private Integer cedula;
	private String correo;
	
	public HugoDto() {
		// TODO Auto-generated constructor stub
	}
	
	public HugoDto(String id, String nombre, String apellido, Integer cedula, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.correo = correo;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getCedula() {
		return cedula;
	}
	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
