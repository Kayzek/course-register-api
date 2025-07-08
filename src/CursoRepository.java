public interface CursoRepository {
    // Contratos - principio Open / Close
    void crearCurso(Curso curso);
    void listarCursos();
}