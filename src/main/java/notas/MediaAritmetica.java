package notas;

import java.util.List;

/**
 * Clase que implementa la interfaz CalculoMedia, considerando la media aritmética.
 */
public class MediaAritmetica implements CalculoMedia {
	@Override
	public double calcula(List<Estudiante> estudiantes) throws EstudianteException {
		if (estudiantes.isEmpty()) {
			throw new EstudianteException("No hay estudiantes");
		}
		double suma = 0;
		for (Estudiante est : estudiantes) {
			suma += est.getCalificacion();
		}
		return suma / estudiantes.size();
	}
}
