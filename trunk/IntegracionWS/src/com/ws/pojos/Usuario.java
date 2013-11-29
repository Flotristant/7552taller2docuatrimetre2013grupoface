	package com.ws.pojos;

import java.io.Serializable;

public class Usuario  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//TODO: consultar con seguridad y sesion si pueden pasar a Long en lugar de int, por problemas de compatibilidad 
	//(Long->int puede no funcionar)
	private Long userId;
	private Long idRol;

	private String username;
	private String password; 
	private String email;
	private String nombre;
	private String apellido;
	private String padron;
	private String fechaNac;
	private Boolean activado;
	private Boolean habilitado;
	
	
	public Usuario() {}
	
	public Usuario(int id,String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public Long getId() {
		return userId;
	}

	public void setId(Long id) {
		this.userId = id;
	}

		
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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

	public String getPadron() {
		return padron;
	}

	public void setPadron(String padron) {
		this.padron = padron;
	}

	public String getFechaNacimiento() {
		return fechaNac;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNac = fechaNacimiento;
	}

	public Boolean getActivado() {
		return activado;
	}

	public void setActivado(Boolean activado) {
		this.activado = activado;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Long getIdRol() {
		return idRol;
	}
	
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
}

