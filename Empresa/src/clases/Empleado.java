package clases;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

import utilidades.Utilidades;

public class Empleado implements Comparable<Empleado> {
	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNac;
	private LocalDate fechaAlta;
	private int numSorteo;

	public Empleado(String nombre, String apellido, String dni, LocalDate fechaNac, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNac = fechaNac;
		this.fechaAlta = fechaAlta;
		this.numSorteo = new Random().nextInt(100) + 1;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int calcularEdad() {
		return Period.between(fechaNac, LocalDate.now()).getYears();
	}

	public int calcularAntiguedad() {
		return Period.between(fechaAlta, LocalDate.now()).getYears();
	}

	@Override
	public String toString() {
		DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("Nombre: %s, Apellido: %s, DNI: %s, Fecha Nac: %s, Fecha Alta: %s, Número Sorteo: %d",
				nombre, apellido, dni, fechaNac.format(formate), fechaAlta.format(formate), numSorteo);
	}

	public void getDatos() {
	
		nombre = Utilidades.introduceCadena("Nombre: ");;
		apellido = Utilidades.introduceCadena("Apellido: ");;
		dni= Utilidades.introduceCadena("DNI: ");
		fechaNac = Utilidades.introduceFecha("Fecha de Nacimiento (dd/MM/yyyy): ");
		fechaAlta = Utilidades.introduceFecha("Fecha de Alta (dd/MM/yyyy): ");
	}

	@Override
	public int compareTo(Empleado otroEmpleado) {

		return this.apellido.compareTo(otroEmpleado.getApellido());
	}
}
