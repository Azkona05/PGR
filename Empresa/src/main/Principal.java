package main;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import clases.Empleado;
import utilidades.Utilidades;

public class Principal {
	public static void main(String[] args) {

		Empleado empleado = null;
		List<Empleado> empleados = new ArrayList<>();
		Random rand = new Random();
		int opc;

		while (true) {
			mostrarMenu();
			opc = Utilidades.introduceNumero("Seleccione una opción: ");

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
				consultarModificarDatos(empleados);
				break;
			case 5:
				borrarEmpleado(empleados);
				break;
			case 6:
				listadoEdadEmpleados(empleados);
				break;
			case 7:
				listadoEdadAlIngreso(empleados);
				break;
			case 8:
				listadoAntiguedadDescendente(empleados, empleado);
				break;
			case 9:
				sorteoDiario(empleados, rand);
				break;
			case 10:
				estadisticas(empleados);
				break;
			case 11:
				System.out.println("Saliendo del programa.");
				return;
			default:
				System.out.println("Opción no válida.");
			}
		}
	}

	private static void estadisticas(List<Empleado> empleados) {
		System.out.println("1. Cumpleaños");
		System.out.println("2. Estadísticas de nombres");
		int estadisticaOpcion = Utilidades.introduceNumero("Seleccione una opción: ");

		if (estadisticaOpcion == 1) {
			int mes = Utilidades.introduceNumero("Ingrese el mes (1-12): ");
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

	private static void consultarModificarDatos(List<Empleado> empleados) {
		String dni;
		int opc;
		boolean eleccion = false;
		dni = Utilidades.introduceCadena("Introduce el DNI: ");
		for (Empleado empleado : empleados) {
			if (empleado.getDni().equalsIgnoreCase(dni)) {
				empleado.toString();
			}
			opc = Utilidades.introduceNumero("Quieres modificar algun dato del empleado introducido? (0-no, 1-si) ");
			if (opc == 1) {
				eleccion = true;
				opc = Utilidades.introduceNumero(
						"Que quieres modificar? 1- Nombre, 2- Apellido, 3- Fecha Nacimiento, 4- Fecha alta, 5- Salir");
				do {
					if (opc == 1) {
						empleado.setNombre(Utilidades.introduceCadena("Introduce nuevo nombre: "));
					} else if (opc == 2) {
						empleado.setApellido(Utilidades.introduceCadena("Introduce nuevo apellido: "));
					} else if (opc == 3) {
						empleado.setFechaNac(Utilidades.introduceFecha("Introduce nueva fecha: "));
					} else if (opc == 4) {
						empleado.setFechaAlta(Utilidades.introduceFecha("Introduce nueva fecha: "));
					} else {
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
		Empleado aux;
		if (empleados.isEmpty()) {
			System.out.println("No hay empleados.");
		}

		for (int i = 0; i < empleados.size(); i++) {
			for (int j = i + 1; j < empleados.size() + 1; j++) {
				if (empleados.get(j).getFechaNac().isBefore(empleados.get(i).getFechaNac())) {
					aux = empleados.get(j);
					empleados.set(j, empleados.get(i));
					empleados.get(j);
					empleados.set(i, empleados.get(j));
				}
			}
		}
		listadoEmpleados(empleados);
		System.out.println("El empleado mas joven es " + empleados.getFirst());
		System.out.println("El empleado con mas experiencia es " + empleados.getLast());
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
		Empleado aux;

		for (int i = 0; i < empleados.size(); i++) {
			for (int j = i + 1; j < empleados.size() + 1; j++) {
				if (empleados.get(j).getFechaAlta().isBefore(empleados.get(i).getFechaAlta())) {
					aux = empleados.get(j);
					empleados.set(j, empleados.get(i)); 
					empleados.get(j);
					empleados.set(i, empleados.get(j));
				}
			}
		}
		listadoEmpleados(empleados);
	}

	private static void borrarEmpleado(List<Empleado> empleados) {
		String dni;
		dni = Utilidades.introduceCadena("Introduce el DNI: ");
		empleados.removeIf(empleado -> empleado.getDni().equalsIgnoreCase(dni));
	}

}
