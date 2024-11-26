package DTO;

import Servicios.ProfesorServicio;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfesorDTO implements Serializable {

    private String idProfesor;
    private String nombreProfesor;
    private String ciudad;
    private ArrayList<String> modulos;

    public ProfesorDTO() {
    }

    public ProfesorDTO(String idProfesor, String nombreProfesor, String ciudad) {
        this.idProfesor = idProfesor;
        this.nombreProfesor = nombreProfesor;
        this.ciudad = ciudad;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<String> getModulos() {
        return modulos;
    }

    public void setModulos(ArrayList<String> modulos) {
        this.modulos = modulos;
    }

    @Override
    public String toString() {
        return "ProfesorDTO{" +
                "idProfesor='" + idProfesor + '\'' +
                ", nombreProfesor='" + nombreProfesor + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", modulos=" + modulos +
                '}';
    }
}
