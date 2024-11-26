package entidades;


import java.util.Date;

public class ProfesorEntidad {

    private String codProfesor;
    private String nombreProfesor;
    private String ciudad;

    public ProfesorEntidad() {
    }

    public ProfesorEntidad(String codProfesor, String nombreProfesor, String ciudad) {
        this.codProfesor = codProfesor;
        this.nombreProfesor = nombreProfesor;
        this.ciudad = ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCodProfesor(String codProfesor) {
        this.codProfesor = codProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodProfesor() {
        return codProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    @Override
    public String toString() {
        return "ProfesorEntidad{" +
                "codProfesor='" + codProfesor + '\'' +
                ", nombreProfesor='" + nombreProfesor + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
