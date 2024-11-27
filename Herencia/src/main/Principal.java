package main;

import clases.Coche;
import clases.Moto;
import clases.Vehiculo;

public class Principal {

	public static void main(String[] args) {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setDatos();
		System.out.println("Los datos que has intoducido son: \n" + vehiculo);

		//Coche coche = new Coche();
		//coche.setDatos();
		vehiculo = new Coche();
		vehiculo.setDatos();
		System.out.println("Los datos que has intoducido del coche son: \n" + vehiculo);
		
		vehiculo = new Moto();
		vehiculo.setDatos();
		System.out.println("Los datos que has intoducido de la moto son: \n" + vehiculo);
		
	}
}
