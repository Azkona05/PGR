package clases;

import java.time.LocalDate;
import java.util.Scanner;

public class Empleado {

	private final String nombreEmpresa = "Electrica S.A.";
	private String dniEmpleado;
	private String nombreEmpleado;
	private int mesEntrada;
	private int anioEntrada;
	private float porcentajeIncrementoSueldo;
	private int sueldoBase;

	// Constructors
	public Empleado(int sueldoBase) {
		this.sueldoBase = 1000;
	}

	// Getters and Setters

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public String getDniEmpleado() {
		return dniEmpleado;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public int getMesEntrada() {
		return mesEntrada;
	}

	public void setMesEntrada(int mesEntrada) {
		this.mesEntrada = mesEntrada;
	}

	public int getAnioEntrada() {
		return anioEntrada;
	}

	public void setAnioEntrada(int anioEntrada) {
		this.anioEntrada = anioEntrada;
	}

	public float getPorcentajeIncrementoSueldo() {
		return porcentajeIncrementoSueldo;
	}

	public void setPorcentajeIncrementoSueldo(float porcentajeIncrementoSueldo) {
		this.porcentajeIncrementoSueldo = porcentajeIncrementoSueldo;
	}

	public int getSueldoBase() {
		return sueldoBase;
	}

	// Methods

	public void setDatos(String dniEmpleado) {
		Scanner sc = new Scanner(System.in);
		this.setDniEmpleado(dniEmpleado);
		System.out.println("Introduce el nombre del empleado: ");
		nombreEmpleado=sc.next();
		System.out.println("Introduce el mes de entrada del empleado: ");
		mesEntrada=sc.nextInt();
		System.out.println("Introduce el incremento del sueldo que que le quieras asignar al empleado: ");
		porcentajeIncrementoSueldo = sc.nextFloat();
	}
	
	public float sueldoFinalEmpleado() {
		float sueldoFinalEmpleado;
		Scanner sc = new Scanner(System.in);
		sueldoFinalEmpleado = sueldoBase + ((porcentajeIncrementoSueldo * 100) / 100);
		if (LocalDate.now().getYear() - anioEntrada == 6) {
			if (LocalDate.now().getMonthValue() <= mesEntrada) {
				sueldoFinalEmpleado += 100;
			} else if (LocalDate.now().getYear() - anioEntrada > 6) {
				sueldoFinalEmpleado += 100;
			}
		}
		return sueldoFinalEmpleado;
	}
	
	public int aniosEmpresa() {
		return LocalDate.now().getYear() - anioEntrada;
	}
	
	
}
