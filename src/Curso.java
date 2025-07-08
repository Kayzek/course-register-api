public class Curso {
    
    // Principio de responsabilidad unica
    // variables
    private String nombre;
    private String codigo;
    private String descripcion;
    
    // constructor
    public Curso(String nombre, String codigo, String descripcion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    // getters
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

}