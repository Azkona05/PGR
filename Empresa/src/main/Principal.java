package main;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import clases.Empleado;

public class Principal {
	public static void main(String[] args) {

		Empleado empleado = null;
		List<Empleado> empleados = new ArrayList<>();
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		int opc;

		while (true) {
			mostrarMenu();
			System.out.print("Seleccione una opción: ");
			opc = scanner.nextInt();

			switch (opc) {
			case 1:
				introducirDatosEmpleado(empleados, empleado);
				break;
			case 2:
				listadoEmpleados(empleados);
				break;
			case 3:
				listadoEmpleadosPorApellido(empleados, empleado);
				break;
			case 4:
				consultarModificarDatos(empleados, scanner);
				break;
			case 5:
				borrarEmpleado(empleados, scanner);
				break;
			case 6:
				listadoEdadEmpleados(empleados);
				break;
			case 7:
				listadoEdadAlIngreso(empleados);
				break;
			case 8:
				listadoAntiguedadDescendente(empleados);
				break;
			case 9:
				sorteoDiario(empleados, rand);
				break;
			case 10:
				estadisticas(scanner, empleados);
				break;
			case 11:
				System.out.println("Saliendo del programa.");
				scanner.close();
				return;
			default:
				System.out.println("Opción no válida.");
			}
		}
	}

	private static void estadisticas(Scanner scanner, List<Empleado> empleados) {
		System.out.println("1. Cumpleaños");
		System.out.println("2. Estadísticas de nombres");
		System.out.print("Seleccione una opción: ");
		int estadisticaOpcion = scanner.nextInt();
		scanner.next();

		if (estadisticaOpcion == 1) {
			System.out.print("Ingrese el mes (1-12): ");
			int mes = scanner.nextInt();
			estadisticasCumpleanios(mes, empleados);
		} else if (estadisticaOpcion == 2) {
			estadisticasNombres(empleados);
		} else {
			System.out.println("Opción no válida.");
		}

	}

	private static void introducirDatosEmpleado(List<Empleado> empleados, Empleado empleado) {
		empleado.getDatos();
		empleados.add(empleado);
	}

	private static void mostrarMenu() {
		System.out.println("1. Introducir empleado");
		System.out.println("2. Listado de empleados");
		System.out.println("3. Listado de empleados ordenados por apellido");
		System.out.println("4. Consultar/Modificar datos del empleado a partir del DNI");
		System.out.println("5. Borrado de empleado a partir de DNI");
		System.out.println("6. Listado de la edad de los empleados indicando el más joven y el más mayor");
		System.out.println("7. Listado de la edad de los empleados en el momento en el que entraron a la empresa");
		System.out.println("8. Listado ordenado en descendente de la antigüedad de los empleados");
		System.out.println("9. Sorteo diario");
		System.out.println("10. Estadísticas");
		System.out.println("11. Salir");

	}

	private static void consultarModificarDatos(List<Empleado> empleados, Scanner scanner) {
		String dni;
		int opc;
		boolean eleccion = false;
		System.out.println("Introduce el DNI: ");
		dni = scanner.next();
		for (Empleado empleado : empleados) {
			if (empleado.getDni().equalsIgnoreCase(dni)) {
				empleado.toString();
			}
			System.out.println("Quieres modificar algun dato del empleado introducido? (0-no, 1-si) ");
			opc = scanner.nextInt();
			if (opc == 1) {
				eleccion = true;
				System.out.println("Que quieres modificar? 1- Nombre, 2- Apellido, 3- Fecha Nacimiento, 4- Fecha alta, 5- Salir");
				opc = scanner.nextInt();
				do {
					if (opc == 1) {
						System.out.println("Introduce nuevo nombre: ");
						empleado.setNombre(scanner.next());
					} else if (opc == 2) {
						System.out.println("Introduce nuevo apellido: ");
						empleado.setApellido(scanner.next());
					} else if (opc == 3) {
						System.out.println("Introduce nueva fecha: ");
						empleado.setFechaNac(null);
					} else if (opc ==4){
						System.out.println("Introduce nueva fecha: ");
						empleado.setFechaAlta(null);
					}else {
						System.out.println("Gracias, saliendo...");
					}
				} while (opc < 5);
			} else {
				System.out.println("Okay");
			}

		}
	}

	private static void listadoEmpleadosPorApellido(List<Empleado> empleados, Empleado empleado) {
		Collections.sort(empleados);
		listadoEmpleados(empleados);
	}

	private static void listadoEdadEmpleados(List<Empleado> empleados) {
		if (empleados.isEmpty()) {
			System.out.println("No hay empleados.");
		}

		int mayor = Integer.MIN_VALUE;
		int menor = Integer.MAX_VALUE;

		for (Empleado empleado : empleados) {
			int edad = empleado.calcularEdad();
			if (edad > mayor)
				mayor = edad;
			if (edad < menor)
				menor = edad;
		}

		System.out.println("Empleado más joven: " + menor);
		System.out.println("Empleado más mayor: " + mayor);
	}

	private static void listadoEdadAlIngreso(List<Empleado> empleados) {
		for (Empleado empleado : empleados) {
			System.out.println("Empleado: " + empleado.getNombre() + " " + empleado.getApellido()
					+ ", Edad al ingreso: " + empleado.calcularEdad());
		}

	}

	private static void listadoEmpleados(List<Empleado> empleados) {
		for (Empleado empleado : empleados) {
			System.out.println(empleado);
		}
	}

	private static void estadisticasNombres(List<Empleado> empleados) {

	}

	private static void estadisticasCumpleanios(int mes, List<Empleado> empleados) {
		DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd/MM");
		List<Empleado> cumpleanieros = new ArrayList<>();
		for (Empleado empleado : empleados) {
			if (empleado.getFechaNac().getMonthValue() == mes) {
				cumpleanieros.add(empleado);
			}
		}
		// cumpleanieros.sort(Comparator.comparing(Empleado::getFechaNac));
		for (Empleado empleado : cumpleanieros) {
			System.out.println(
					empleado.getNombre() + " " + empleado.getApellido() + " " + empleado.getFechaNac().format(formate));
		}
	}

	private static void sorteoDiario(List<Empleado> empleados, Random rand) {
		if (empleados.isEmpty()) {
			System.out.println("No hay empleados para el sorteo.");
		}
		int ganadorIndex = rand.nextInt(empleados.size());
		Empleado ganador = empleados.get(ganadorIndex);
		System.out.println("El ganador del sorteo es: " + ganador.getNombre() + " " + ganador.getApellido());

	}

	private static void listadoAntiguedadDescendente(List<Empleado> empleados, Empleado empleado) {
      // empleados.sort(empleado.getFechaAlta()).reversed();
		for(int i = 1; i<empleados.size(); i++){
			for(int j= empleados.size()-1; j>=i; j-- ){
				if (empleados.get(j).getFechaAlta().isBefore(empleados.get(i).getFechaAlta())){
					aux = empleados[j-1];
					empleados[j-1] = empleados[j];
					empleados[j] = aux;			
				}
			}
		}	
		listadoEmpleados(empleados);
	}

	private static void borrarEmpleado(List<Empleado> empleados, Scanner scanner) {
		String dni;
		System.out.println("Introduce el DNI: ");
		dni = scanner.next();
		empleados.removeIf(empleado -> empleado.getDni().equalsIgnoreCase(dni));
	}
}
