
package notas;

/**
 * Clase para representar excepciones que traten situaciones anómalas 
 * en las clases Estudiante y Asignatura.
 */
public class EstudianteException extends Exception {
	public EstudianteException() {
		super();
	}
	public EstudianteException(String s) {
		super(s);
	}
}
