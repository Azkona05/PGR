package main;

import java.util.ArrayList;
import clases.Empleado;
import clases.Jefe;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		ArrayList<Empleado> empleados = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		int opc;
		do {
			mostrarMenu();
			System.out.println("¿Que quieres hacer?");
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				introducirDatosEmpleados(empleados, sc);
				break;
			case 2:
				visualizarTodosLosDatos(empleados, sc);
				break;
			case 3:
				visualizarTodosLosJefes(empleados, sc);
				break;
			case 4:
				visualizarJefesDptoConcreto(empleados, sc);
				break;
			case 5:
				introducirNombreYDniYvisualizarAniosEmpresa(empleados, sc);
				break;
			case 6:
				introducirSalario(empleados, sc);
				break;
			case 7:
				introducirNumeroAnios(empleados, sc);
				break;
			case 8:
				DarBajaEmpleado(empleados, sc);
				break;
			case 9:
				estadisticaOrdenadaAlfabeticamente(empleados, sc);
				break;
			case 10:
				System.out.println("Saliendo....");
				break;
			default:
				System.out.println("ERROR! Elige una opcion correcta.");
				break;
			}
		} while (opc != 10);

	}

	private static void introducirDatosEmpleados(ArrayList<Empleado> empleados, Scanner sc) {
		String dniEmpleado, nombreEmpleado, jefeDepartamento;
		int mesEntrada, añoEntrada;
		float porcentajeIncrementoSueldo;

		for (Empleado emp : empleados) {
			if (emp.getDniEmpleado().equals(dniEmpleado)) {
				System.out.println("Error: El empleado ya existe.");
			}
		}
		if (jefeDepartamento != null) {
			empleados.add(new Jefe(añoEntrada).setDatos(dniEmpleado));
		} else {
			empleados.add(new Empleado().setDatos(dniEmpleado));
		}

	}

	private static void visualizarTodosLosDatos(ArrayList<Empleado> empleados, Scanner sc) {
		for (Empleado emp : empleados) {
			System.out.printf("DNI: %s, Nombre: %s, Sueldo Final: %.2f%n", emp.getDniEmpleado(),
					emp.getNombreEmpleado(), emp.sueldoFinalEmpleado());
		}

	}

	private static void visualizarTodosLosJefes(ArrayList<Empleado> empleados, Scanner sc) {
		for (Empleado emp : empleados) {
			if (emp instanceof Jefe) {
				Jefe jefe = (Jefe) emp;
				System.out.printf("DNI: %s, Nombre: %s, Departamento: %s, Sueldo Final: %.2f%n", jefe.getDniEmpleado(),
						jefe.getNombreEmpleado(), jefe.getJefeDepartamento(), jefe.sueldoFinalJefe());
			}
		}

	}

	private static void visualizarJefesDptoConcreto(ArrayList<Empleado> empleados, Scanner sc) {
		boolean hayJefes = false;
		for (Empleado emp : empleados) {
			if (emp instanceof Jefe && ((Jefe) emp).getJefeDepartamento().equals(jefeDepartamento)) {
				if (!hayJefes) {
					System.out.printf("Jefe/s del departamento %s:%n", getJefeDepartamento());
					hayJefes = true;
				}
				System.out.printf("Nombre: %s, DNI: %s%n", emp.getNombreEmpleado(), emp.getDniEmpleado());
			}
		}
		if (!hayJefes) {
			System.out.printf("No hay jefes en el departamento %s.%n", jefeDepartamento);
		}

	}

	private static void introducirNombreYDniYvisualizarAniosEmpresa(ArrayList<Empleado> empleados, Scanner sc) {
		boolean encontrado = false;
		String nombreEmpleado;
		System.out.println("Introduce el nombre del empleado: ");
		nombreEmpleado = sc.next();
		for (Empleado emp : empleados) {
			if (emp.getNombreEmpleado().toLowerCase().contains(nombreEmpleado.toLowerCase())) {
				String esJefe = emp instanceof Jefe ? "Sí" : "No";
				System.out.printf("DNI: %s, Años en la empresa: %d, Jefe: %s%n", emp.getDniEmpleado(),
						emp.aniosEmpresa(), esJefe);
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("No se encontró ningún empleado.");
		}

	}

	private static void introducirSalario(ArrayList<Empleado> empleados, Scanner sc) {
		 boolean encontrado = false;
		 float sueldo;
			System.out.println("Introduce el año: ");
			sueldo = sc.nextInt();
	        for (Empleado emp : empleados) {
	            if (Jefe.sueldoFinalJefe() >= sueldo) {
	                String esJefe = emp instanceof Jefe ? "Sí" : "No";
	                System.out.printf("DNI: %s, Nombre: %s, Sueldo Final: %.2f, Jefe: %s%n", emp.getDniEmpleado(), emp.getNombreEmpleado(), emp.sueldoFinalJefe(), esJefe);
	                encontrado = true;
	            }
	        }
	        if (!encontrado) {
	            System.out.println("No se encontraron empleados con ese sueldo.");
	        }

	}

	private static void introducirNumeroAnios(ArrayList<Empleado> empleados, Scanner sc) {
		boolean encontrado = false;
		int anios;
		System.out.println("Introduce el año: ");
		anios = sc.nextInt();
        for (Empleado emp : empleados) {
            if (emp instanceof Jefe && emp.aniosEmpresa() >= anios) {
                System.out.printf("DNI: %s, Nombre: %s, Años en la empresa: %d%n", emp.getDniEmpleado(), emp.getNombreEmpleado(), emp.aniosEmpresa());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron jefes con esos años en la empresa.");
        }

	}

	private static void DarBajaEmpleado(ArrayList<Empleado> empleados, Scanner sc) {
		String dniEmpleado;
		System.out.println("Introduce el DNI del empleado");
		dniEmpleado = sc.next();
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getDniEmpleado().equals(dniEmpleado)) {
				empleados.remove(i);
				System.out.println("Empleado dado de baja.");
				return;
			}
		}
		System.out.println("Error: El empleado no existe.");

	}

	private static void estadisticaOrdenadaAlfabeticamente(ArrayList<Empleado> empleados, Scanner sc) {
		// TODO Auto-generated method stub

	}

	private static void mostrarMenu() {
		System.out.println("***MENU***");
		System.out.println(
				"1. Introducir datos de empleade/s y/o jefe/s comprobando que no existan ya (a partir de su DNI). ");
		System.out.println(
				"2. Visualizar todos los datos (con sueldo final) de todos los empleados (los jefes son empleados)");
		System.out.println("3. Visualizar los jefes ");
		System.out.println("4. Visualizar los jefes de un departamento concreto.");
		System.out.println(
				"5. Introducir nombre o al menos un grupo de caracteres del nombre y dni y visulizar los años que lleva en la empresa sindicando si es jefe o no.");
		System.out.println(
				"6. Introducir un salario y mostrar aquellos empleados cuyo salario final es igual o superior.");
		System.out.println("7. Introducir numero de años y mostrar jefes que lleven en la empresa esos o más años");
		System.out.println("8. Dar de baja a un empleade/jefe a partir de su DNI.");
		System.out.println(
				"9. Estadística ordenada alfabéticamente por departamento de los diferentes departamentos que tienen jefe/s indicando: departamento y nº jefe/s.");
		System.out.println("10. Salir ");

	}
}
