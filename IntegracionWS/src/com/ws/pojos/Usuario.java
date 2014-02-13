	package com.ws.pojos;

import java.util.List;

public class Usuario  extends Pojo {

	//TODO: consultar con seguridad y sesion si pueden pasar a Long en lugar de int, por problemas de compatibilidad 
	//(Long->int puede no funcionar)
	private Long idRol;

	private String username;
	private String password; 
	private String email;
	private String nombre;
	private String apellido;
	private String padron;
	private String fechaNacimiento;
	private Boolean activado;
	private Boolean habilitado;  
	private List<Actividad> actividades;
	private List<Nota> notas;
	private List<Grupo> grupos;
	
	
	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Usuario() {}
	
	public Usuario(int id,String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
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
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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


	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Usuario DBUser = new ar.fiuba.redsocedu.datalayer.ws.Usuario();
		DBUser.setActivado(this.getActivado());
		DBUser.setHabilitado(this.getHabilitado());
		DBUser.setEmail(this.getEmail());
		DBUser.setNombre(this.getNombre());
		DBUser.setApellido(this.getApellido());
		DBUser.setUsername(this.getUsername());
		DBUser.setPassword(this.getPassword());
		DBUser.setPadron(this.getPadron());
		DBUser.setId(this.getId());
		if(actividades != null) {
			for(Actividad actividad : actividades) {
				DBUser.getActividades().add((ar.fiuba.redsocedu.datalayer.ws.Actividad)actividad.getDatabaseEntity());
			}
		}
		if(notas != null) {
			for(Nota nota : notas) {
				DBUser.getNotas().add((ar.fiuba.redsocedu.datalayer.ws.Nota)nota.getDatabaseEntity());
			}
		}
		if(grupos != null) {
			for(Grupo grupo : grupos) {
				DBUser.getGrupos().add((ar.fiuba.redsocedu.datalayer.ws.Grupo)grupo.getDatabaseEntity());
			}
		}
		//DBUser.setRolId(this.getIdRol());
		return DBUser;
	}
}

