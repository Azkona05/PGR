package clases;

import java.util.Scanner;

public class Coche extends Vehiculo {
	private Integer numPuertas;

	public Integer getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(Integer numPuertas) {
		this.numPuertas = numPuertas;
	}

	public void setDatos() {
		Scanner sc = new Scanner(System.in);
		super.setDatos();
		System.out.println("Introduce el numero de puertas: ");
		numPuertas = sc.nextInt();
	}

	@Override
	public String toString() {
		return super.toString() + " \n numPuertas=" + numPuertas;
	}
}
