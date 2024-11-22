package Servicios;

import DAO.AlumnoDAOImplementacion;
import DTO.AlumnoDTO;
import entidades.AlumnoEntidad;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AlumnoServicio {

    private static AlumnoServicio instancia;
    private AlumnoDAOImplementacion alumnoDAOImplementacion;

    private AlumnoServicio(DataSource dataSource) {
        this.alumnoDAOImplementacion = alumnoDAOImplementacion.getInstancia(dataSource);
    }

    public static AlumnoServicio getInstancia(DataSource dataSource) {
        if (instancia == null) {
            instancia = new AlumnoServicio(dataSource);
        }
        return instancia;
    }

    //Crear nuevo alumno
    public AlumnoDTO crearAlumno(AlumnoDTO alumnoDTO) {

        AlumnoEntidad alumnoEntidad = new AlumnoEntidad();
        alumnoEntidad.setCodAlumno(alumnoDTO.getIdAlumno());
        alumnoEntidad.setNombreAlumno(alumnoDTO.getNombreAlumno());
        alumnoEntidad.setApellidoAlumno(alumnoDTO.getApellidosAlumno());
        alumnoEntidad.setFechaNacimiento(convertirEdadAFecha(alumnoDTO.getEdad()));
        alumnoEntidad.setGrupo(alumnoDTO.getGrupo());
        alumnoDAOImplementacion.crearAlumno(alumnoEntidad);
        return alumnoDTO;
    }

    public AlumnoDTO obtenerAlumnoPorId(String id) {
            AlumnoEntidad alumnoEntidad = alumnoDAOImplementacion.obtenerAlumnoPorId(id);
            AlumnoDTO alumnoDTO = new AlumnoDTO();
            alumnoDTO.setIdAlumno(alumnoEntidad.getCodAlumno());
            alumnoDTO.setNombreAlumno(alumnoEntidad.getNombreAlumno());
            alumnoDTO.setApellidosAlumno(alumnoEntidad.getApellidoAlumno());
            alumnoDTO.setEdad(calcularEdad(alumnoEntidad.getFechaNacimiento()));
            alumnoDTO.setGrupo(alumnoEntidad.getGrupo());
            return alumnoDTO;
    }

    public List<AlumnoDTO> obtenerTodosLosAlumnos() {
        List<AlumnoEntidad> alumnosEntidad = alumnoDAOImplementacion.obtenerTodosLosAlumnos();
        List<AlumnoDTO> alumnosDTO = new ArrayList<>();
        for (AlumnoEntidad alumnoEntidad : alumnosEntidad) {
            AlumnoDTO alumnoDTO = new AlumnoDTO();
            alumnoDTO.setIdAlumno(alumnoEntidad.getCodAlumno());
            alumnoDTO.setNombreAlumno(alumnoEntidad.getNombreAlumno());
            alumnoDTO.setApellidosAlumno(alumnoEntidad.getApellidoAlumno());
            alumnoDTO.setEdad(calcularEdad(alumnoEntidad.getFechaNacimiento()));
            alumnoDTO.setGrupo(alumnoEntidad.getGrupo());
            alumnosDTO.add(alumnoDTO);
        }
        return alumnosDTO;
    }

    public boolean actualizarAlumno(String id, AlumnoDTO alumnoDTO){
        try {
            AlumnoEntidad alumnoEntidad = alumnoDAOImplementacion.obtenerAlumnoPorId(id);
            alumnoEntidad.setApellidoAlumno(alumnoDTO.getApellidosAlumno());
            alumnoEntidad.setNombreAlumno(alumnoDTO.getNombreAlumno());
            alumnoEntidad.setFechaNacimiento(alumnoEntidad.getFechaNacimiento());
            alumnoEntidad.setGrupo(alumnoDTO.getGrupo());
            alumnoEntidad.setCodAlumno(alumnoDTO.getIdAlumno());
            alumnoDAOImplementacion.actualizarAlumno(alumnoEntidad);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean eliminarAlumno(String id){
        try {
            alumnoDAOImplementacion.eliminarAlumno(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private AlumnoEntidad mapearDTOAEntidad(AlumnoDTO alumnoDTO) {
        AlumnoEntidad alumnoEntidad = new AlumnoEntidad();
        alumnoEntidad.setCodAlumno(alumnoDTO.getIdAlumno());
        alumnoEntidad.setNombreAlumno(alumnoDTO.getNombreAlumno());
        alumnoEntidad.setApellidoAlumno(alumnoDTO.getApellidosAlumno());
        alumnoEntidad.setFechaNacimiento(convertirEdadAFecha(alumnoDTO.getEdad()));
        alumnoEntidad.setGrupo(alumnoDTO.getGrupo());
        return alumnoEntidad;
    }

    private AlumnoDTO mapearEntidadADTO(AlumnoEntidad alumnoEntidad) {
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setIdAlumno(alumnoEntidad.getCodAlumno());
        alumnoDTO.setNombreAlumno(alumnoEntidad.getNombreAlumno());
        alumnoDTO.setApellidosAlumno(alumnoEntidad.getApellidoAlumno());
        alumnoDTO.setEdad(calcularEdad(alumnoEntidad.getFechaNacimiento()));
        alumnoDTO.setGrupo(alumnoEntidad.getGrupo());
        return alumnoDTO;
    }

    //Metodo calcular edad a partir de la fecha de nacimiento
    private int calcularEdad(Date fechaNacimiento) {
        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(fechaNacimiento);
        Calendar fechaActual = Calendar.getInstance();
        int edad = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        if (fechaActual.get(Calendar.MONTH) < fechaNac.get(Calendar.MONTH)) {
            edad--;
        } else if (fechaActual.get(Calendar.MONTH) == fechaNac.get(Calendar.MONTH) &&
                fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNac.get(Calendar.DAY_OF_MONTH)) {
            edad--;
        }
        return edad;
    }

    private Date convertirEdadAFecha(int edad) {
        Calendar fechaNac = Calendar.getInstance();
        fechaNac.add(Calendar.YEAR, -edad);
        return fechaNac.getTime();
    }
}
