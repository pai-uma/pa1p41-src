package notas;

import java.util.List;

/**
 * Interfaz que define un método para calcular la media de las calificaciones 
 * de una lista de estudiantes. 
 */
public interface CalculoMedia {
	double calcula(List<Estudiante> alumnos) throws EstudianteException ;
}
