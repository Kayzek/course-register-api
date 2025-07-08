import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
    Scanner scanner = new Scanner(System.in);
    GestorCurso gestor = new GestorCurso();
    boolean running = true;

    while (running) {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Crear Curso");
        System.out.println("2. Registrar Estudiante");
        System.out.println("3. Listar Cursos");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    System.out.println("\n--- Creando Nuevo Curso ---");
                    System.out.print("Ingrese el nombre del curso: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el código del curso: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Ingrese la descripción del curso: ");
                    String descripcion = scanner.nextLine();
                    // capitalizar
                    if (nombre != null || codigo != null || descripcion != null) {
                        nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
                        codigo = codigo.substring(0, 1).toUpperCase() + codigo.substring(1);
                        descripcion = descripcion.substring(0, 1).toUpperCase() + descripcion.substring(1);
                    }
                    Curso nuevoCurso = new Curso(nombre, codigo, descripcion);
                    gestor.crearCurso(nuevoCurso);
                    break;
                
                case 2:
                    System.out.println("\n--- Registrando Nuevo Estudiante ---");
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombreEstudiante = scanner.nextLine();
                    System.out.print("Ingrese el apellido del estudiante: ");
                    String apellidoEstudiante = scanner.nextLine();
                    System.out.print("Ingrese el correo del estudiante: ");
                    String correoEstudiante = scanner.nextLine();
                    System.out.print("Ingrese el código del curso del estudiante: ");
                    String codigoCursoEstudiante = scanner.nextLine();
                    // capitalizar
                    if (nombreEstudiante != null || apellidoEstudiante != null || correoEstudiante != null || codigoCursoEstudiante != null) {
                        nombreEstudiante = nombreEstudiante.substring(0, 1).toUpperCase() + nombreEstudiante.substring(1);
                        apellidoEstudiante = apellidoEstudiante.substring(0, 1).toUpperCase() + apellidoEstudiante.substring(1);
                        correoEstudiante = correoEstudiante.substring(0, 1).toUpperCase() + correoEstudiante.substring(1);
                        codigoCursoEstudiante = codigoCursoEstudiante.substring(0, 1).toUpperCase() + codigoCursoEstudiante.substring(1);
                    }
                    
                    Estudiante nuevoEstudiante = new Estudiante(nombreEstudiante,apellidoEstudiante,correoEstudiante,
                    codigoCursoEstudiante);
                    gestor.registrarEstudiante(nuevoEstudiante);
                    break;    
                case 3:
                    System.out.println("\n--- Listando Cursos ---");
                    gestor.listarCursos();
                    break;
                case 4:
                    running = false;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            } 
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido.");
            scanner.nextLine(); // Limpiar entrada inválida
        }
    }
    }
}