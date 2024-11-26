package DAO;

import entidades.ProfesorEntidad;

import java.util.List;

public interface ProfesorDAO {

    //Crea un nuevo profesor
    public void crearProfesor(ProfesorEntidad profesor);
    //Obtiene un profesor por su ID
    public ProfesorEntidad obtenerProfesorId(String id);
    //Obtener todos los profesor
    public List<ProfesorEntidad> obtenerTodosLosProfesores();
    //Actualiza un profesor existente
    public void actualizarProfesor(ProfesorEntidad profesor);
    //Elimina un profesor por su ID
    public void eliminarProfesor(String id);
}
