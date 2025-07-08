import java.util.ArrayList;
import java.util.List;

public class GestorCurso implements CursoRepository, EstudianteRepository {
    // declarar variable
    private List<Curso> cursos;
    private List<Estudiante> estudiantes;

    // constructor de variable
    public GestorCurso() {
        this.cursos = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }
    
    // metodos de la interfaz de curso
    @Override
    public void crearCurso(Curso curso) {
        cursos.add(curso);
        System.out.printf("Curso '%s' con código '%s' ha sido creado.%n", curso.getNombre(), curso.getCodigo());
    }
    
    @Override
    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        System.out.println("\n--- Lista de Cursos ---");
        for (Curso c : cursos) {
            System.out.printf("Código: %s, Nombre: %s, Descripción: %s%n", c.getCodigo(), c.getNombre(), c.getDescripcion());
            System.out.println("  Estudiantes registrados:");
            boolean hayEstudiantes = false;
            for (Estudiante e : estudiantes) {
                if (e.getCodigoCurso().equals(c.getCodigo())) {
                    System.out.printf("    - %s %s (%s)%n", e.getNombre(), e.getApellido(), e.getCorreo());
                    hayEstudiantes = true;
                }
            }
            if (!hayEstudiantes) {
                System.out.println("    (Ningún estudiante registrado en este curso)");
            }
        }
    }
    
    @Override
    public void registrarEstudiante(Estudiante estudiante) {
        boolean cursoEncontrado = false;
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(estudiante.getCodigoCurso())) {
                estudiantes.add(estudiante);
                System.out.printf("Estudiante '%s' registrado en el curso '%s'.%n", estudiante.getNombre(), curso.getNombre());
                cursoEncontrado = true;
                break;
            }
        }
        if (!cursoEncontrado) {
            System.out.printf("No se pudo registrar al estudiante '%s'. El curso con código '%s' no existe.%n", estudiante.getNombre(), estudiante.getCodigoCurso());
        }
    }

}