package utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Utilidades {

	public static String introduceCadena(String mensaje) {
		String cadena = null;
		Scanner sc = new Scanner(System.in);

		System.out.println(mensaje);
		try {
			cadena = sc.next();
		} catch (NoSuchElementException e) {
			System.out.println("Error al introducir la cadena. ");
		}
		return cadena;
	}

	public static int introduceNumero(String mensaje) {
		int numero = 0;
		String cadena = null;
		boolean correcto = true;
		do {
			cadena = introduceCadena(cadena);
			System.out.println(mensaje);
			try {
				numero = Integer.parseInt(cadena);
			} catch (NumberFormatException e) {
				System.out.println("Esto no es un numero entero. ");
				correcto = false;
			}
		} while (!correcto);
		return numero;
	}

	public static LocalDate introduceFecha(String mensaje) {
		DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = null;
		String cadena = null;
		boolean correcto = true;

		do {
			cadena = introduceCadena(cadena);
			System.out.println(mensaje);
			try {
				fecha = LocalDate.parse(cadena, formate);
			} catch (DateTimeParseException e) {
				System.out.println("Fecha incorrecta. ");
				correcto = false;
			}
		} while (!correcto);

		return fecha;
	}

	public static float introducirNumeroConDecimales(String mensaje) {
		float numero = 0;
		String cadena = null;
		boolean correcto = true;

		do {
			cadena = introduceCadena(cadena);
			System.out.println(mensaje);
			try {
				numero = Float.parseFloat(cadena);
			} catch (NumberFormatException e) {
				System.out.println("Numero incorrecta. ");
				correcto = false;
			}
		} while (!correcto);
		
		return 0;
	}
}
