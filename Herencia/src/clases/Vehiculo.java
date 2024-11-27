package clases;

import java.util.Scanner;

public class Vehiculo {
	private String matricula;
	private int caballos;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public void setDatos() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce matricula: ");
		matricula = sc.next();
		System.out.println("Introduce los caballos del vehiculo: ");
		caballos = sc.nextInt();
	}

	@Override
	public String toString() {
		return "Matricula=" + matricula + "\n Caballos=" + caballos;
	}

}
