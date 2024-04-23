
package notas;

import java.util.Objects;

/**
 * Clase para representar estudiantes, manteniendo información sobre su dni (String), 
 * su nombre (String) y la calificación obtenida en una asignatura (double). 
 *
 */
public class Estudiante {
	// Variables privadas para almacenar el dni, el nombre y la nota.
	private String dni;
	private String nombre;
	private double nota;
	
	/**
	 * Constructor para crear estudiantes, a partir de un dni y un nombre. 
	 * En ese caso, se asume que la calificación es 0. 
	 * Si la calificación es negativa se lanza una excepción EstudianteException.
	 * 
	 * @param n	Nombre del/la estudiante
	 * @param d	DNI del/la estudiante
	 * @throws EstudianteException
	 */
	public Estudiante(String d, String n) throws EstudianteException {
		this(d, n, 0);
	}
	
	/**
	 * Constructor para crear estudiantes, a patir de un dni, un nombre y una nota.
	 * Si la calificación es negativa se lanza una excepción EstudianteException.
	 * 
	 * @param n	Nombre del/la estudiante
	 * @param d	DNI del/la estudiante
	 * @param c	Calificación 
	 * @throws EstudianteException 
	*/
	public Estudiante(String d, String nm, double nt) throws EstudianteException {
		if (nt < 0) {
			throw new EstudianteException("Calificacion negativa");
		}
		dni = d;
		nombre = nm;
		nota = nt;
	}
	
	/**
	 * Método para consultar el nombre del o de la estduiante.
	 * @return	El nombre del/la estudiante
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Método para consultar el DNI del o de la estudiante.
	 * @return	El DNI del/la estudiante
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * Método para consultar la calificación del o de la estudiante
	 * @return	Calificación del/la estudiante
	 */
	public double getCalificacion() {
		return nota;
	}
	
	/**
	 * Dos estudiantes son iguales cuando tienen el mismo nombre y el mismo DNI, independientemente de
	 * mayúsculas y minúsculas.
	 */
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof Estudiante) {
			Estudiante x = (Estudiante)o;
			ok = this.nombre.equals(x.nombre)
				&& this.dni.equalsIgnoreCase(x.dni);
		}
		return ok;
	}
	
	/**
	 * El método hashCode se redefine de forma adecuada, atendiendo a la redefinición de equals.
	 */
	@Override
	public int hashCode() {
		//return nombre.hashCode() + dni.toUpperCase().hashCode();
		return Objects.hash(nombre, dni.toUpperCase());
	}
	
	/**
	 * Representación textual del alumno:
	 * 		Nombre (DNI)
	 */
	@Override
	public String toString() {
		return nombre + " (" + dni+")";
	}
}
