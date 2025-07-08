public class Estudiante {
    private String nombre;
    private String apellido;
    private String correo;
    private String codigoCurso;

    public Estudiante(String nombre, String apellido, String correo, String codigoCurso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.codigoCurso = codigoCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }
}