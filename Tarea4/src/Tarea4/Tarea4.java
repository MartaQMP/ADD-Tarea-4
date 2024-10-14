package Tarea4;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Marta
 */

public class Tarea4 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// Solicitar la ruta y nombre del archivo
		System.out.println("Introduce la dirección del archivo: ");
		String ruta = sc.nextLine();

		try {
			FileOutputStream fos = new FileOutputStream(ruta);
			DataOutputStream dos = new DataOutputStream(fos);

			for (int i = 0; i < 5; i++) {
				int nia = pedirNia();
				String nombre = pedirNombre();
				String apellidos = pedirApellidos();
				char genero = pedirGenero();
				Date fecha = pedirFecNac();
				String ciclo = pedirCiclo();
				String curso = pedirCurso();
				String grupo = pedirGrupo();
				Alumno alumno = new Alumno(nia, nombre, apellidos, ciclo, curso, grupo, genero, fecha);
				System.out.println(alumno);

				// Escribir datos
				dos.writeInt(alumno.getNia());
				dos.writeUTF(alumno.getNombre());
				dos.writeUTF(alumno.getApellidos());
				dos.writeChar(alumno.getGenero());
				dos.writeUTF(sdf.format(alumno.getFecNac()));
				dos.writeUTF(alumno.getCiclo());
				dos.writeUTF(alumno.getCurso());
				dos.writeUTF(alumno.getGrupo());
				
			}
			
			dos.close(); 

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

	// Pedir datos
	
	/**
	 * 
	 * @return NIA
	 */
	private static int pedirNia() {
		int nia = 0;
		try {
			System.out.println("Introduce el NIA:");
			nia = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error: Debes introducir un número entero.");
			sc.next();
		}
		return nia;
	}
	
	/**
	 * 
	 * @return nombre
	 */
	private static String pedirNombre() {
		sc.nextLine();
		System.out.println("Dime el nombre");
		return sc.nextLine();
	}
	
	/**
	 * 
	 * @return apellidos
	 */
	private static String pedirApellidos() {
		System.out.println("Dime los apellidos");
		return sc.nextLine();
	}
	
	/**
	 * 
	 * @return genero
	 */
	private static char pedirGenero() {
		System.out.println("Dime el genero. M o H");
		String palabra = sc.next();
		while (!palabra.equalsIgnoreCase("M") && !palabra.equalsIgnoreCase("H")) {
			System.out.println("Genero no valido. Introduce M o H:");
			palabra = sc.next();
		}
		char g = palabra.charAt(0);
		return g;
	}
	
	/**
	 * 
	 * @return fecha nacimiento
	 */
	private static Date pedirFecNac() {
		sc.nextLine();
		Date fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);

		boolean fechaValida = false;

		do {
			System.out.println("Introduce tu fecha de nacimiento (dd/mm/aaaa)");
			String f = sc.nextLine();

			try {
				fecha = sdf.parse(f);
				fechaValida = true;
			} catch (ParseException e) {
				System.out
						.println("Fecha no válida, por favor, introduce una fecha en el formato correcto (dd/mm/aaaa)");
			}
		} while (!fechaValida);

		return fecha;
	}
	
	/**
	 * 
	 * @return ciclo
	 */
	private static String pedirCiclo() {
		System.out.println("Dime el ciclo");
		return sc.next();
	}
	
	/**
	 * 
	 * @return curso
	 */
	private static String pedirCurso() {
		System.out.println("Dime el curso");
		return sc.next();
	}
	
	/**
	 * 
	 * @return grupo
	 */
	private static String pedirGrupo() {
		System.out.println("Dime el grupo");
		return sc.next();
	}

}
