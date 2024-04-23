package notas;

import java.util.List;

/**
 * Clase que implementa la interfaz CalculoMedia, considerando la media armónica.
 */
public class MediaArmonica implements CalculoMedia {
	@Override
	public double calcula(List<Estudiante> estudiantes) throws EstudianteException {
		int mayor0 = 0;
		double suma = 0;
		for (Estudiante est : estudiantes) {
			if (est.getCalificacion() > 0) {
				suma += 1 / est.getCalificacion();
				++mayor0;
			}
		}
		if (mayor0 == 0) {
			throw new EstudianteException("No hay estudiantes");
		}
		return mayor0 / suma;
	}
}
