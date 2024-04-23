
import notas.EstudianteException;
import notas.Estudiante;

public class PruebaEstudiante {
	public static void main(String[] args) {
		try {
			Estudiante a1 = new Estudiante("22456784F", "Gonzalez Perez, Juan", 5.5);
			//Alumno a2 = new Alumno("33456777S", "Gonzalez Perez, Juan", 3.4);
			Estudiante a2 = new Estudiante("33456777S", "Gonzalez Perez, Juan", -3.4);
			System.out.println(a1.getNombre()+" "+a1.getCalificacion());
			System.out.println(a2.getNombre()+" "+a2.getCalificacion());
			if (a1.equals(a2)) {
				System.out.println("Estudiantes iguales");
			} else {
				System.out.println("Estudiantes distintos");
			}
		} catch (EstudianteException e) {
			System.err.println("Error: "+e.getMessage());
		}
	}
}
