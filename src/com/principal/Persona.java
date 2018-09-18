package com.principal;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.principal.Persona.Sexo;

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

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido="
				+ segundoApellido + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + "]";
	}

	public static List<Persona> getPersonas() {
		List<Persona> personas;
		
		personas = new ArrayList<>();

		personas.add(new Persona("Tomas", "apelli1", "apelli2", LocalDate.of(2007, Month.MARCH, 03), Sexo.HOMBRE));
		personas.add(new Persona("Luisa", "Ey", "Holi", LocalDate.of(2000, Month.AUGUST, 07), Sexo.MUJER));
		personas.add(new Persona("Felipe", "Hola", "Felipe", LocalDate.of(2001, Month.DECEMBER, 12), Sexo.HOMBRE));

		return personas;
	}
}
