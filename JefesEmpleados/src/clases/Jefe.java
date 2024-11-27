package clases;

import java.util.Scanner;

public class Jefe extends Empleado {

	private String jefeDepartamento;
	private int plus;
	// Constructors
	public Jefe(int sueldoBase) {
		super(sueldoBase);
		this.plus = 250;
	}
	// Getters and Setters
	
	public String getJefeDepartamento() {
		return jefeDepartamento;
	}

	public void setJefeDepartamento(String jefeDepartamento) {
		this.jefeDepartamento = jefeDepartamento;
	}

	// Methods
	public void setDatos(String dniEmpleado) {
		Scanner sc = new Scanner(System.in);
		super.setDatos(dniEmpleado);
		System.out.println("Introduce el nombre del departamento del que es Jefe el empleado: ");
		setJefeDepartamento(sc.next());
	}
	public float sueldoFinalJefe() {
		return super.sueldoFinalEmpleado() + 250;
	}

}
