package DAO;

import entidades.AlumnoEntidad;

import java.util.List;

public interface AlumnoDAO {
    //Crea un nuevo alumno
    public void crearAlumno(AlumnoEntidad alumno);
    //Obtiene un alumno por su ID
    public AlumnoEntidad obtenerAlumnoPorId(String id);
    //Obtener todos los alumnos
    public List<AlumnoEntidad> obtenerTodosLosAlumnos();
    //Actualiza un alumno existente
    public void actualizarAlumno(AlumnoEntidad alumno);
    //Elimina un alumno por su ID
    public void eliminarAlumno(String id);
}
