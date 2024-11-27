package clases;

import java.util.Scanner;

public class Moto extends Vehiculo {
	private boolean tieneSidecar;

	public boolean isTieneSidecar() {
		return tieneSidecar;
	}

	public void setTieneSidecar(boolean tieneSidecar) {
		this.tieneSidecar = tieneSidecar;
	}

	public void setDatos() {
		super.setDatos();
		Scanner sc = new Scanner(System.in);
		System.out.println("Tiene sidecar?");
		tieneSidecar = sc.next().equalsIgnoreCase("si");
	}

	@Override
	public String toString() {
		return super.toString() + "tiene Sidecar=" + tieneSidecar;
	}

}
