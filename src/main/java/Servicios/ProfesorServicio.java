package Servicios;

import DAO.ModulosDAOImplementacion;
import DAO.ProfesorDAOImplementacion;
import DTO.ProfesorDTO;
import entidades.ProfesorEntidad;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class ProfesorServicio {

    private static ProfesorServicio instancia;
    private ProfesorDAOImplementacion profesorDAOImplementacion;
    private ModulosDAOImplementacion modulosDAOImplementacion;

    private ProfesorServicio(DataSource dataSource){
        this.profesorDAOImplementacion = profesorDAOImplementacion.getInstancia(dataSource);
        this.modulosDAOImplementacion = modulosDAOImplementacion.getInstancia(dataSource);
    }

    public static ProfesorServicio getInstancia(DataSource dataSource) {
        if (instancia == null) {
            instancia = new ProfesorServicio(dataSource);
        }
        return instancia;
    }

    public ProfesorDTO crearProfesor(ProfesorDTO profesorDTO){
        ProfesorEntidad profesorEntidad = new ProfesorEntidad();
        profesorEntidad.setCodProfesor(profesorDTO.getIdProfesor());
        profesorEntidad.setNombreProfesor(profesorDTO.getNombreProfesor());
        profesorEntidad.setCiudad(profesorDTO.getCiudad());
        profesorDAOImplementacion.crearProfesor(profesorEntidad);
        return profesorDTO;
    }

    public ProfesorDTO obtenerProfesorPorId(String id){
        ProfesorEntidad profesorEntidad = profesorDAOImplementacion.obtenerProfesorId(id);
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setIdProfesor(profesorEntidad.getCodProfesor());
        profesorDTO.setNombreProfesor(profesorEntidad.getNombreProfesor());
        profesorDTO.setCiudad(profesorEntidad.getCiudad());
        return profesorDTO;
    }

    public List<ProfesorDTO> obtenerTodosLosProfesores(){
        List<ProfesorEntidad> profesoresEntidad = profesorDAOImplementacion.obtenerTodosLosProfesores();
        List<ProfesorDTO> profesoresDTO = new ArrayList<>();
        for (ProfesorEntidad profesorEntidad : profesoresEntidad) {
            ProfesorDTO profesorDTO = new ProfesorDTO();
            profesorDTO.setIdProfesor(profesorEntidad.getCodProfesor());
            profesorDTO.setNombreProfesor(profesorEntidad.getNombreProfesor());
            profesorDTO.setCiudad(profesorEntidad.getCiudad());
            profesoresDTO.add(profesorDTO);
        }
        return profesoresDTO;
    }

    public boolean actualizarProfesor(String id, ProfesorDTO profesorDTO){
        try{
            ProfesorEntidad profesorEntidad = profesorDAOImplementacion.obtenerProfesorId(id);
            profesorEntidad.setNombreProfesor(profesorDTO.getNombreProfesor());
            profesorEntidad.setCiudad(profesorDTO.getCiudad());
            profesorDAOImplementacion.actualizarProfesor(profesorEntidad);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean eliminarProfesor(String id){
        try{
            profesorDAOImplementacion.eliminarProfesor(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public ProfesorDTO obetenermodulos(String idProfesor){
        ProfesorEntidad profesorEntidad = profesorDAOImplementacion.obtenerProfesorId(idProfesor);
        ArrayList<String> modulos = modulosDAOImplementacion.obtenerModulosPorIdProfesor(profesorEntidad.getCodProfesor());
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setIdProfesor(profesorEntidad.getCodProfesor());
        profesorDTO.setNombreProfesor(profesorEntidad.getNombreProfesor());
        profesorDTO.setCiudad(profesorEntidad.getCiudad());
        profesorDTO.setModulos(modulos);
        return profesorDTO;
    }

    private ProfesorEntidad mapearDTOAEntidad(ProfesorDTO profesorDTO){
        ProfesorEntidad profesorEntidad = new ProfesorEntidad();
        profesorEntidad.setCodProfesor(profesorDTO.getIdProfesor());
        profesorEntidad.setNombreProfesor(profesorDTO.getNombreProfesor());
        profesorEntidad.setCiudad(profesorDTO.getCiudad());
        return profesorEntidad;
    }

    private ProfesorDTO mapearEntidadADTO(ProfesorEntidad profesorEntidad){
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setIdProfesor(profesorEntidad.getCodProfesor());
        profesorDTO.setNombreProfesor(profesorEntidad.getNombreProfesor());
        profesorDTO.setCiudad(profesorEntidad.getCiudad());
        return profesorDTO;
    }

}
