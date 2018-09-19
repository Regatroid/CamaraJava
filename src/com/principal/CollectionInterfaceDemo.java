package com.principal;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

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

		persona1 = new Persona("Juan", "ape1", "ape2", LocalDate.of(1991, Month.MARCH, 17), Sexo.HOMBRE, 2500.00,
				Persona.Ciudad.AGUILAS);
		persona2 = new Persona("Ainoa", "sanchez-Fortun", "Asensio", LocalDate.of(2000, Month.APRIL, 13), Sexo.MUJER,
				2500.00, Persona.Ciudad.AGUILAS);
		persona3 = new Persona("Adreu", "Buenafuente", "Torres", LocalDate.of(1983, Month.FEBRUARY, 17), Sexo.MUJER,
				2500.00, Persona.Ciudad.AGUILAS);

		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);

		/*
		 * Variante 2, no crear objetyos personas previamente
		 */

		personas.add(new Persona("Tomas", "apelli1", "apelli2", LocalDate.of(2007, Month.MARCH, 03), Sexo.HOMBRE,
				2500.00, Persona.Ciudad.AGUILAS));

		/*
		 * Variante 3, la clase persona ya contenga un conjunto de personas que no
		 * necesita crear personas, crear un elemento estatico en la clase persona que
		 * devuelva un listado de personas, para que de una forma rapida tener
		 * disponible unas cuantas personas para trabajar
		 */

		// metodo devuelve un listado de personas

		personas.add(new Persona("Tomas", "apelli1", "apelli2", LocalDate.of(2007, Month.MARCH, 03), Sexo.HOMBRE,
				2500.00, Persona.Ciudad.AGUILAS));
		personas.add(new Persona("Luisa", "Ey", "Holi", LocalDate.of(2000, Month.AUGUST, 07), Sexo.MUJER, 2500.00,
				Persona.Ciudad.AGUILAS));
		personas.add(new Persona("Felipe", "Hola", "Felipe", LocalDate.of(2001, Month.DECEMBER, 12), Sexo.HOMBRE,
				2500.00, Persona.Ciudad.AGUILAS));

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

//		while (it.hasNext()) {
//			// por ejemplo eliminar los de el sexo masculino
//			if (it.next().getSexo().equals(Persona.Sexo.HOMBRE)) {
//				it.remove();
//			}
//			// imprimir la lista resultante que solo obtendra personas del sexo mujer
//			System.out.println("Listado de personas resultante ");
//			System.out.println(personas);
//
//			// actividad
//
//		}
		Iterator<Persona> mujer;

		mujer = personas.iterator();
		int num = 0;
		Double salario = 0.00;

		while (mujer.hasNext()) {
			Persona pp = mujer.next();
			if (pp.getSexo().equals(Persona.Sexo.MUJER)) {

				salario += pp.getSalario();
				num++;
			}

		}
		double salarioPromedio = salario / num;
		System.out.println(salarioPromedio);
		
		
		
		/*
		 * Tercero. Via o metodo preferido de recorrer una colección es el primero que aperece en
		 * la documentacion es decir utilizando operaciones de agregado metodos de la clase Stream y expresiones lambda
		Solucionar el ejercicio 2 por esta via
		 * */
		Double salarioPromedioMujeres;
		/*
		 * 
		sintaxis coleccion.stream.tuberia (como filter), filter tiene que implementar la interfaz predicate
		para eso es necesario una clase, si esta funcionalidad solo se va a usar 1 vez se puede usar una clase anidada
		CLASE ANONINA (que no tiene la palabra reserva class), que se declara y se instancia en el mismo sitio
		la clase anonima implementa la funcionalidad, la creamos
		 de tipo predicate e implementa Persona. 
		compruebaSexo es un objeto que se crea de la clase anonina y se instancia en el mismo sitio que se declara
		 al usar predicate se implementa como minimo siempre el metodo test, que recibe algo (una persona en este caso)
		 comprueba en el cuerpo lo que sea necesario y devuelve true o false
		 */
		
		
		//todo esto se puede mejorar metiendolo en el filtro sin crear el objeto
//		Predicate<Persona> compruebaSexo = new Predicate<Persona>() {
//
//			@Override
//			public boolean test(Persona t) {
//				// TODO Auto-generated method stub
//				//en este caso se le pasa persona y comprueba si es mujer en el return y devuelve true
//				return (t.getSexo().equals(Persona.Sexo.MUJER));
//			}
//			
//		};
		//termina ; porque es una expresion de clase
		
		//en la ayuda cuando sale Predicate <? super Persona>, el ? es un comodin, cualquier tipo de dato, pero el super Persona, 
		//quiere decir que puede trabajar con cualquier dato pero que sea del elemento persona. Es una restricción de tipo generico
		
		
//		personas.stream()
//			.filter(compruebaSexo)
		//lo haremos sin crear el objeto y usando solo filter
		
//		personas.stream()
//			.filter(new Predicate<Persona>() {
//
//				@Override
//				public boolean test(Persona t) {
//					// TODO Auto-generated method stub
//					return (t.getSexo().equals(Persona.Sexo.MUJER));
//				}
//				
//			});
		
		/* hay una forma de reducir aun mas el codigo usando expresiones lambda en lugar de una clase anonina, para
		 * implementar el unico metodo abstracto de la interfaz funcional Predicate */
		
		//Ejemplo lambda, tenemos un metodo increment que devuelve un Integer
		
//		Integer Increment(Integer x)
//		{
//			return x++;
//		}
//		//en expresion lambda quedaria, que al ser una sola instruccion no necesita ; 
//		
//		(Integer x) -> {return x++}
//		
//		//se podria mejorar mas, si se recorre una coleccion de enteros el tipo de dato no es necesario, y si es un solo parametro 
//		//no necesita parantesis, ademas, al ser una sola instruccion (cuerpo) no hace falta las llaves { de apertura de cierre, 
//		// ademas el return no es necesario
//		
//		x ->  x++
		
		/*mejoramos la funcionalidad con expresiones lambda */
		
		salarioPromedioMujeres = personas.stream().filter(p -> p.getSexo().equals(Persona.Sexo.MUJER))
			//con eso obtenemos las mujeres y ahora cogemos el salario
			//.mapToDouble(p -> p.getSalario())
			//en aquellos casos donde la expresion lambda solamente invoque al metodo que implementa la funcionalidad
			//es mas claro y eficiente pasar el metodo por referencia, como en el caso de mapToDouble(p -> p.getSalario()) 
			.mapToDouble(Persona::getSalario) //sin parentesis porque no se invoca el metodo, sino su direcion	
			//la operacion final, el salario promedio, usamos average, no asegura que devuelva un double, para que lo devuelva usamos
			//getAsDouble
			.average().getAsDouble()
			;
		System.out.println(salarioPromedio);
		//y esto devuelve un booleano , porque filter implementa la interfaz predicated
		
		//equals compara dos cosas, da o verdadero o falso, pero a nivel interno usa el metodo test que develve un booleano.
		//el equals es porque le tienes que decir que compare
	}

	


}
