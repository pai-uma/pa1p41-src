
package notas;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * Clase para representar asignaturas, incluyendo su nombre, una lista de estudiantes, y una lista de 
 * errores al intentar añadir estudiantes a la asignatura.
 */
public class Asignatura {
	// Variables privadas para almacenar el nombre, la lista de estudiantes y 
	// los errores de formato que se hayan podido producir.
	private String nombre;
	private List<Estudiante> estudiantes;
	private List<String> errores;
	
	/**
	 * Constructor para crear una asignatura a partir de un nombre y un array de cadenas de caracteres, 
	 * donde cada elemento es de la forma: 
	 * 		DNI;NombreEstudiante;Calificación
	 * @param n		Nombre de la asignatura
	 * @param als	Array de String con información sobre estudiantes de la asignatura
	 * @throws EstudianteException 
	 * @throws RuntimeException 
	 */
	public Asignatura(String n, String[] ests) {
		nombre = n;
		procesarEstudiantes(ests);
	}
	
	/**
	 * Método para obtener la calificación de un/a estudiante determinado/a
	 * @param al 	Estudiante
	 * @return		Calificación del estudiante en el array estudiantes
	 * @throws 		EstudianteException 
	 */
	public double getCalificacion(Estudiante e) throws EstudianteException {
		int i = estudiantes.indexOf(e);
		if (i < 0) {
			throw new EstudianteException("Estudiante " + e + " no se encuentra");
		}
		return estudiantes.get(i).getCalificacion();
	}
	
	/** 
	 * Devuelve la media aritmética de las calificaciones del estudiantado
	 * @return	Nota media de estudiantes
	 * @throws EstudianteoException 
	 */
	public double getMedia() throws EstudianteException {
		if (estudiantes.isEmpty()) {
			throw new EstudianteException("No hay estudiantes");
		}
		double suma = 0;
		for (Estudiante est : estudiantes) {
			suma += est.getCalificacion();
		}
		return suma / estudiantes.size();
	}
	
	/**
	 * Devuelve el nombre de la asignatura
	 * @return	Nombre de asignatura
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Devuelve la lista de estudiantes
	 * @return	Lista de estudiantes
	 */
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	
	/**
	 * Devuelve la lista de errores almacenada
	 * @return	Lista de información sobre errores
	 */
	public List<String> getErrores() {
		return errores;
	}
	
	/**
	 * Representación textual de una asignatura.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(80*estudiantes.size() + 80*errores.size());
		sb.append(nombre);
		sb.append(": { ");
		sb.append(estudiantes.toString());
		sb.append(", ");
		sb.append(errores.toString());
		sb.append(" }");
		return sb.toString();
	}
	
	
	private void procesarEstudiantes(String[] ests) {
		// Se inicializan las listas para almacenar estudiantes con formato correcto
		// y los errores detectados.
		errores = new ArrayList<>();
		estudiantes = new ArrayList<>();
		// Se recorre el array ests de información sobre estudiantes de la asignatura
		for (String est : ests) {
			try {
				// Se extraen los datos separados por ;
				String[] datos = est.split("\\s*[;]\\s*");
				// Si hay menos de tres datos se añade a los errores.
				if (datos.length < 3) {
					errores.add("ERROR. Faltan datos: " + est);
				} else { // Si hay datos suficientes se añade un/a estudiante
					estudiantes.add(new Estudiante(datos[0], datos[1], Double.parseDouble(datos[2])));
				}
			} catch (NumberFormatException e) {
				errores.add("ERROR. Calificacion no numerica: " + est);
			} catch (EstudianteException e) {
				errores.add("ERROR. "+ e.getMessage() +": " + est);
			}
		}
	}
	
	/**
	 * Método privado para procesar información de un array con el formato:
	 * 		<Dni>;<Apellidos, nombre>;<Calificación>
	 * Para cada elemento en el array se deberá crear, si es posible, un objeto
	 * de la clase Estudiante con el nombre, DNI y calificación proporcionadas, y 
	 * almacenarlo en el array de estudiantes. Si no fuera posible crear un 
	 * determinado estudiante, entonces deberá almacenar esta entrada en el 
	 * array de errores, precedido de un comentario que indique cual ha sido 
	 * el problema por el que no se ha podido crear el alumno.
	 * 
	 * @param ests	Array con información sobre estudiantes
	 */
	private void procesarEstudiantes_AlternativoConScanner(String[] ests) {
		// Se inicializan las listas para almacenar estudiantes con formato correcto
		// y los errores detectados.
		estudiantes = new ArrayList<>();
		errores = new ArrayList<>();
		// Se recorre el array ests de información con estudiantes
		for (String est : ests) {
			try (Scanner sc = new Scanner(est)) {
				// Se define un scanner sobre la cadena de caracteres que 
				// tiene la información sobre cada estudiante: est
				// Considerando punto decimal para el formato numérico,
				// y que los datos están separados por ;
				sc.useLocale(Locale.ENGLISH);
				sc.useDelimiter("\\s*[;]\\s*");
				String d = sc.next();
				String n = sc.next();
				double c = sc.nextDouble();
				// Con la información obtenida del scanner, añadimos el/la estudiante correspondiente.
				estudiantes.add(new Estudiante(d, n, c));
			} catch (InputMismatchException e) {
				errores.add("ERROR. Calificacion no numerica: " + est);
			} catch(NoSuchElementException e) {
				errores.add("ERROR. Faltan datos: " + est);
			} catch (EstudianteException e) {
				errores.add("ERROR. "+ e.getMessage() +": " + est);
			}
		}
	}
}
