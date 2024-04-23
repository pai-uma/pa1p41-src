
import notas.*;

public class PruebaAsignatura {
	public static void main(String[] args) {
		try {
			String[] datos = {
				"12455666F;Lopez Perez, Pedro;6.7",
				"33678999D;Merlo Gomez, Isabel;5.8",
				"23555875G;Martinez Herrera, Lucia;9.1"
			};
			Asignatura poo = new Asignatura("POO", datos);
			System.out.println("Media de calificaciones: " + poo.getMedia());
			for (Estudiante a : poo.getEstudiantes()) {
				System.out.println(a.getDni());
			}
			//Alumno x = new Alumno("12455666F", "Lopez Perez, Pedro");
			Estudiante x = new Estudiante("12455666F", "Lopez Lopez, Pedro");
			System.out.println("Calificacion estudiante: " + poo.getCalificacion(x));
		} catch (EstudianteException e) {
			System.err.println("Error: "+e.getMessage());
		}
	}
}
