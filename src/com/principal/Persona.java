package com.principal;

import java.time.LocalDate;
import java.util.List;

public class Persona {

	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private LocalDate fechaNacimiento;
	private Sexo sexo;

	enum Sexo {
		HOMBRE, MUJER
	}

	public Persona(String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, Sexo sexo) {
		super();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public static List<Persona> getPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

}
