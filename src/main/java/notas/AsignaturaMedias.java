package notas;


/**
 * La clase AsignaturaMedias representa asignaturas, extendiendo la clase Asignatura
 * con la posibilidad de calcular distintas medias de las calificaciones del estudiantado.
 * 
 */
public class AsignaturaMedias extends Asignatura {

	/**
	 * Constructor para crear asignaturas a partir de su nombre y de un array de estudiantes.
	 * @param n		Nombre de la asignatura
	 * @param ests	Array con estudiantes
	 */
	public AsignaturaMedias(String n, String[] ests) {
		super(n, ests);
	}
	
	/**
	 * Redefinición del método getMedia(), utilizando la implementación de la clase MediaAritmetica
	 */
	@Override
	public double getMedia() throws EstudianteException {
		return this.getMedia(new MediaAritmetica());
	}
	
	/**
	 * Obtiene la media de las calificaciones, según se establece en el objeto que se pasa como argumento.
	 * 
	 * @param calc		Objeto con el método de cálculo de la media
	 * @return			Media de las calificaciones
	 * @throws EstudianteException
	 */
	public double getMedia(CalculoMedia calc) throws EstudianteException {
		return calc.calcula(getEstudiantes());
	}

}
