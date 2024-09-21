import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean salir = false;
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		while (!salir) {
			System.out.println("1. Escribir un programa que diga por consola “Hola Mundo”.");
			System.out.println("2. Escribir un programa que escriba un número aleatorio entero entre 1 y 10.");
			System.out.println(
					"3. Escribir un programa que cada vez que se ejecute saque de un nombre de un compañero declase. Implementarlo con un array (o lista).");
			System.out.println("4. Hacer el mismo programa, pero usando enum.");
			System.out.println(
					"5. Escribir un programa que genere un primer número entero aleatorio y posteriormente genere20 números enteros aleatorios y vaya comparando estos 20 con el número generado en unprimer lugar. Por pantalla tendrá que salir “El primer número X es [menor | mayor | igual] queY “");
			System.out.println(
					"6. Escribir un programa para jugar a “piedra, papel, tijera” con el ordenador. El juego funcionaráde la siguiente manera: El usuario escribirá una de las tres palabras (piedra, papel o tijera) yluego el ordenador sacará una aleatoria. Tendrá que salir el mensaje de quién ha ganado.");
			System.out.println(
					"7. Escribir un programa que detecte números primos hasta 100 (usar el operador módulo %, elnúmero primo es aquel que es divisible solo por sí mismo y por 1).");
			System.out.println("8. Escribir un programa que pida dos palabras por consola y compare si son iguales.");
			System.out.println(
					"9.  Escribir un programa en java que simule el lanzamiento al aire de una moneda. Lanzar lamoneda al aire 1.000.000 de veces y sumar las veces que sale cara y las que sale cruz.");
			System.out.println(
					"10. Escribir un programa que dado un número introducido por el usuario escriba en consola la secuencia de Fibonacci (la secuencia de Fibonacci es aquella cuyo número es obtiene como lasuma de los dos anteriores: 1, 1, 2, 3, 5, 8, 13, 21, 34.....). Hacer que la secuencia sea de 10iteraciones. Por ejemplo, si el usuario introduce el número 5 la secuencia debería de ser:5, 5 , 10 , 15, 25, 40, 65, 105, 170, 275, 445, 720");
			System.out.println(
					"11. Escribir un programa que permita a un usuario introducir personas en una lista. La persona tendrá un nombre y una edad. Si el usuario no introduce ningún nombre la persona se llamará“Anónimo” y si el usuario introduce una edad negativa la persona tendrá 99 años. Llevar acabo estos controles en el constructor de la clase persona.");
			System.out.println(
					"12. Hacer el mismo programa que el anterior, pero si el usuario no introduce edad o nombre estoscampos no se inicializarán.");
			System.out.println(
					"13. Echa un vistazo a la clase Cuenta.java. Escribe un método main para experimentar con ella:• Usa la clase Cuenta como clase base y escribe dos clases derivadas llamadasCuentaCorriente y CuentaAhorro. La cuenta corriente permitirá quedarse ennegativo, la cuenta de Ahorro no.• Crear una clase Banco que será la que tenga el método main, crear dentro variasclases de tipo CuentaCorriente y de tipo CuentaAhorro e ir metiéndolas en una lista,todas con un saldo cero.• Posteriormente hay que iterar sobre esa lista y retirar dinero de ambas."
							+ "Pista: se trata de probar el polimorfismo.");
			System.out.println(
					"14.  En la empresa en la que trabajas hay cuatro tipos de empleado: Gerente, Trabajador por horasy Trabajador en nómina. Todos tienen como propiedades: Nombre, Numero de Empleado ySueldo.14.1. Al Gerente se le calcula el salario cogiendo su sueldo y sumándole unacomisión (la comisión tiene que ser una propiedad del objeto Gerente)14.2. Al trabajador en nómina se le calcula el sueldo cogiendo su sueldo y noaplicándole ninguna modificación.14.3. Al trabajador por horas se le calcula el sueldo multiplicando su sueldo por lashoras trabajadas (las horas tienen que ser una propiedad de este objeto).Se pide:• Construir la estructura de clases aprovechando la herencia y el polimorfismo.• Crear un programa que cree varios objetos de empleados, los meta en una lista y losrecorra calculando su salario.");
			System.out.println(
					"15. Crear un paquete de utilidades en el que haya una clase que tenga dos métodos estáticos deutilidades, uno que calcule el índice de grasa corporal (estatura / kgs^2). Ejemplo: 1.89 * 80^2. Y otro que calcule el área de un cuadrado.Crear otro paquete en el que hay una clase que se llame Persona con propiedades nombre,estatura y kgs y con un método que calcule el índice de grasa corporal.Crear en una clase main un objeto persona y calcular el IGC de las dos formas.");
			System.out.println("16. Salir");
			int opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1:

				System.out.println("Hola mundo");

				break;
			case 2:
				realizarEjercicio2(random);

				break;
			case 3:

				realizarEjercicio3(random);
				break;
			case 4:

				realizarEjercicio4(random);

				break;
			case 5:
				realizarEjercicio5(random);
				break;
			case 6:
				realizarEjercicio6(sc, random);
				break;
			case 7:
				realizarEjercicio7(sc);

				break;
			case 8:
				realizarEjercicio8(sc);

				break;
			case 9:
				realizarEjercicio9(sc, random);

				break;
			case 10:
				realizarEjercicio10(sc);
				break;
			case 11:
				realizarEjercicio11(sc);
						
				break;
			case 12:
				realizarEjercicio12(sc);
				break;
			case 13:

				break;
			case 14:

				break;
			case 15:

				break;

			case 16:
				System.out.println("Saliendo del programa..");
				salir = true;
				break;
			default:
				System.out.println("Introduzca una opción válida");
				break;
			}
			if (!salir) {
				System.out.println("\nPresione Enter para continuar...");
				sc.nextLine();
			}
		}
	}

	public static void realizarEjercicio12(Scanner sc) {
		String respuesta = "";
		String nombre;
		String edad;
		Boolean continuar = true;
		
		System.out.println("***LISTA DE PERSONAS***");

		List<Persona> listaPersonas = new ArrayList<Persona>();
		do {
			Persona persona = new Persona();
			
			System.out.println("Nombre:");
			nombre = sc.nextLine();
			if(!nombre.trim().isEmpty()) {
				persona.setNombre(nombre);
			}
			System.out.println("Edad:");
			edad = sc.nextLine();
			if(!edad.trim().isEmpty()) {
				persona.setEdad(Integer.parseInt(edad));
			}
			listaPersonas.add(persona);
			
			
			System.out.println("¿Imprimir lista?(S/N");
			respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("S")) {
				for (Persona p : listaPersonas) {
					System.out.println(persona.toString());
				}
			}
			System.out.println("¿Salir?(S/N");
			respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("S"))
				continuar = false;
		} while (continuar);
	}

	public static void realizarEjercicio11(Scanner sc) {
		String respuesta = "";
		String nombre;
		Integer edad;
		Boolean continuar = true;
		System.out.println("***LISTA DE PERSONAS***");

		List<Persona> listaPersonas = new ArrayList<Persona>();
		do {
			System.out.println("Nombre:");
			nombre = sc.nextLine();
			System.out.println("Edad:");
			edad = Integer.parseInt(sc.nextLine());
			listaPersonas.add(new Persona(nombre, edad));
			
			
			System.out.println("¿Imprimir lista?(S/N");
			respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("S")) {
				for (Persona persona : listaPersonas) {
					System.out.println(persona.toString());
				}
			}
			System.out.println("¿Salir?(S/N");
			respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("S"))
				continuar = false;
		} while (continuar);
	}

	public static void realizarEjercicio10(Scanner sc) {
		System.out.println("SECUENCIA DE FIBONACCI");
		System.out.println("Introduzca un número:");
		Integer numero = Integer.parseInt(sc.nextLine());
		Integer[] secuenciaFibonacci = new Integer[12];
		for (int i = 1; i < secuenciaFibonacci.length; i++) {

			if (i == 1) {
				secuenciaFibonacci[0] = numero;
				secuenciaFibonacci[i] = numero;
				continue;
			}

			secuenciaFibonacci[i] = secuenciaFibonacci[i - 1] + secuenciaFibonacci[i - 2];

		}

		for (Integer num : secuenciaFibonacci) {
			System.out.println(num + " ");
		}
	}

	public static void realizarEjercicio9(Scanner sc, Random random) {
		System.out.println("***LANZAMONEDAS***");
		boolean iniciarJuego = false;
		int lanzamientos = 0;
		int contadorCaras = 0;
		int contadorCruces = 0;
		boolean caraOCruz;
		System.out.println("¿Desea comenzar a lanzar monedas?(S/N)");
		String respuesta = sc.nextLine();
		if (respuesta.equalsIgnoreCase("s"))
			iniciarJuego = true;

		if (iniciarJuego) {
			while (lanzamientos != 1000000) {

				caraOCruz = random.nextBoolean();
				if (caraOCruz) {
					System.out.println("Salió cara");
					contadorCaras++;
				} else {
					System.out.println("Salió cruz");
					contadorCruces++;
				}

				lanzamientos++;
			}
		}
		System.out.println("Ha salido cara: " + contadorCaras + " veces.");
		System.out.println("Ha salido cruz: " + contadorCruces + " veces.");
		System.out.println("FIN");
	}

	public static void realizarEjercicio8(Scanner sc) {
		System.out.println("***COMPARADOR DE PALABRAS***");
		System.out.println("Introduce una palabra:");
		String palabraUno = sc.nextLine();
		System.out.println("Introduce otra palabra:");
		String palabraDos = sc.nextLine();
		if (palabraUno.equalsIgnoreCase(palabraDos)) {
			System.out.println("Son iguales");
		} else {
			System.out.println("NO son iguales.");
		}
	}

	public static void realizarEjercicio7(Scanner sc) {
		System.out.println("***DETECTOR DE NÚMEROS PRIMOS***");
		System.out.println("Número primo: aquel que SOLO tiene DOS divisores: el 1 y él mismo");
		System.out.println("Introduzca un número entre 2 y 100:");
		int numero = Integer.parseInt(sc.nextLine());
		boolean esPrimo = true;
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				esPrimo = false;
			}
		}

		if (esPrimo)
			System.out.println(numero + " es primo.");
		else
			System.out.println(numero + " no es primo");
	}

	public static void realizarEjercicio5(Random random) {
		int primerNumero = random.nextInt(1, 100);
		System.out.println("El PRIMER número es.." + primerNumero);
		System.out.println("Generando los otros 20..");

		for (int i = 0; i < 20; i++) {
			int numeroAleatorio = random.nextInt(1, 100);
			if (primerNumero < numeroAleatorio) {
				System.out.println("El primer número es MENOR que " + numeroAleatorio);
			} else if (primerNumero == numeroAleatorio) {
				System.out.println("El primer número es IGUAL que " + numeroAleatorio);
			} else {
				System.out.println("El primer número es MAYOR que " + numeroAleatorio);
			}
		}
	}

	public static void realizarEjercicio6(Scanner sc, Random random) {
		String eleccion;
		String[] opcionesJuego = { "piedra", "papel", "tijera" };
		do {
			System.out.println("PIEDRA, PAPEL O TIJERA [ELIGE]:");
			eleccion = sc.nextLine();

			System.out.println("El ordenador está pensando..");
			String eleccionOrdenador = opcionesJuego[random.nextInt(0, opcionesJuego.length - 1)];
			System.out.println("El ordenador ha sacado " + eleccionOrdenador);
			if (eleccion.equalsIgnoreCase(eleccionOrdenador)) {
				System.out.println("EMPATE");
			} else if (eleccion.equalsIgnoreCase("piedra") && eleccionOrdenador.equalsIgnoreCase("papel")
					|| (eleccion.equalsIgnoreCase("papel") && eleccionOrdenador.equalsIgnoreCase("tijera")
							|| (eleccion.equalsIgnoreCase("tijera") && eleccionOrdenador.equalsIgnoreCase("piedra")))) {
				System.out.println("DERROTA");
			} else if (eleccion.equalsIgnoreCase("piedra") && eleccionOrdenador.equalsIgnoreCase("tijera")
					|| (eleccion.equalsIgnoreCase("papel") && eleccionOrdenador.equalsIgnoreCase("piedra")
							|| (eleccion.equalsIgnoreCase("tijera") && eleccionOrdenador.equalsIgnoreCase("papel")))) {
				System.out.println("VICTORIA");
			}

		} while (!eleccion.equalsIgnoreCase(opcionesJuego[0]) && !eleccion.equalsIgnoreCase(opcionesJuego[1])
				&& !eleccion.equalsIgnoreCase(opcionesJuego[2]));
	}

	public static void realizarEjercicio4(Random random) {
		Companeros[] companerosClase = Companeros.values();
		System.out
				.println("El nombre generado es... " + companerosClase[random.nextInt(0, companerosClase.length - 1)]);
	}

	public static void realizarEjercicio3(Random random) {
		String[] nombresCompaneros = { "PabloVicen", "Pablo CafeSolo", "Javi", "Carlos", "Terra", "Fran", "Vero",
				"Jaime" };// length = 8
		System.out.println("Sacando el nombre de un compañero de clase de forma aleatoria..");

		System.out.println("Y el nombre es..." + nombresCompaneros[random.nextInt(0, nombresCompaneros.length - 1)]);
	}

	public static void realizarEjercicio2(Random random) {

		System.out.println("Generando número aleatorio entre 1 y 10...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println(random.nextInt(1, 11));
	}

}
