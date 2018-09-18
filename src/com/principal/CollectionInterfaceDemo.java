package com.principal;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.principal.Persona.Sexo;

public class CollectionInterfaceDemo {

	public static void main(String[] args) {
		// Crear una coleccion
		// una lista nunca puede ser de datos primitivos
		List<String> nombres;
		nombres = new ArrayList<>();

		// agregar elementos a la coleccion
		nombres.add("Juan");
		nombres.add("Juan Manuel");
		nombres.add("Rafael");
		nombres.add("Luis");

		// crear una coleccion a partir de un array, por ejemlo el array de string qe
		// recibe el metodo main (args)
		List<String> argumentos;
		argumentos = Arrays.asList(args);

		// argumentos.add("prueba1");

		// crear una coleccion de objetos, por ejemplo una lista de personas
		// 1º creamos la clase persona, con sus atributos su getter, setter y su
		// constructor
		// creando las variables y clic derecho source generate...

		List<Persona> personas;
		personas = new ArrayList<>();

		/*
		 * rellenar la lista de personas Variante 1, crear los objetos persona y
		 * agregarlos a la coleccion
		 */
		Persona persona1;
		Persona persona2;
		Persona persona3;

		persona1 = new Persona("Juan", "ape1", "ape2", LocalDate.of(1991, Month.MARCH, 17), Sexo.HOMBRE);
		persona2 = new Persona("Ainoa", "sanchez-Fortun", "Asensio", LocalDate.of(2000, Month.APRIL, 13), Sexo.MUJER);
		persona3 = new Persona("Adreu", "Buenafuente", "Torres", LocalDate.of(1983, Month.FEBRUARY, 17), Sexo.MUJER);

		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);

		/*
		 * Variante 2, no crear objetyos personas previamente
		 */

		personas.add(new Persona("Tomas", "apelli1", "apelli2", LocalDate.of(2007, Month.MARCH, 03), Sexo.HOMBRE));

		/*
		 * Variante 3, la clase persona ya contenga un conjunto de personas que no
		 * necesita crear personas, crear un elemento estatico en la clase persona que
		 * devuelva un listado de personas, para que de una forma rapida tener
		 * disponible unas cuantas personas para trabajar
		 */

		// metodo devuelve un listado de personas

			personas.add(new Persona("Tomas", "apelli1", "apelli2", LocalDate.of(2007, Month.MARCH, 03), Sexo.HOMBRE));
			personas.add(new Persona("Luisa", "Ey", "Holi", LocalDate.of(2000, Month.AUGUST, 07), Sexo.MUJER));
			personas.add(new Persona("Felipe", "Hola", "Felipe", LocalDate.of(2001, Month.DECEMBER, 12), Sexo.HOMBRE));

			personas = Persona.getPersonas();

		/*
		 * Recorrer una coleccion (), usaremos 3 formas pero la unica que permite
		 * eliminar elementos de la coleccion mientras se recorre es usando iteradores
		 */

		// Primero, bucle foreach

		// recorrer la coleccion de argumentos y recorrer la coleccion de personas
		for (String s : nombres) {
			System.out.println(s);
		}
		System.out.println("LISTADO DE ARGUMENTOS QUE SE PASAN " + "COMO PARAMENTROS AL METODO MAIN");

		// recorrer la coleccion de argumentos
		for (String argumento : argumentos) {
			System.out.println(argumento);
		}
		// recorrer la coleccion personas
		for (Persona p : personas) {
			System.out.println(p);
		}

		// si queremos imprimir el objeto completo hay que sobrescribir el metodo
		// toString()
		// si queremos mostrar solo partes del objeto persona como nombre, apellidos...
		// ejemplo: mostrar de cada persona el nombre y sus apellidos concatenados
		for (Persona p : personas) {
			System.out.println(p.getNombre() + " " + p.getPrimerApellido() + " " + p.getSegundoApellido());
		}

		// SEGUNDO utilizando un iterador
		// es la unica forma de eliminar un elemento de la coleccion a medida que la
		// recorremos

		// recorrer la coleccion de personas
		Iterator<Persona> it;
		it = personas.iterator();

		while (it.hasNext()) {
			// por ejemplo eliminar los de el sexo masculino
			if (it.next().getSexo().equals(Persona.Sexo.HOMBRE)) {
				it.remove();
			}
			// imprimir la lista resultante que solo obtendra personas del sexo mujer
			System.out.println("Listado de personas resultante ");
			System.out.println(personas);
		}
	}
}
