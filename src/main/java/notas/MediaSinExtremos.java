package notas;

import java.util.List;


/**
 *  Clase que implementa la interfaz CalculoMedia, considerando la media en un rango. 
 */
public class MediaSinExtremos implements CalculoMedia {
	private double min;
	private double max;
	public MediaSinExtremos(double n, double x) {
		min = n;
		max = x;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double valor) {
		min = valor;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double valor) {
		max = valor;
	}
	@Override
	public double calcula(List<Estudiante> estudiantes) throws EstudianteException {
		int enRango = 0;
		double s = 0;
		for (Estudiante a : estudiantes) {
			if (min <= a.getCalificacion() && a.getCalificacion() <= max) {
				s += a.getCalificacion();
				++enRango;
			}
		}
		if (enRango == 0) {
			throw new EstudianteException("No hay estudiantes");
		}
		return s / enRango;
	}
}
