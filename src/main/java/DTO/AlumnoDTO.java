package DTO;

import java.io.Serializable;

public class AlumnoDTO implements Serializable {

    private String idAlumno;
    private String nombreAlumno;
    private String apellidosAlumno;
    private int edad;
    private char grupo;

    public AlumnoDTO(String idAlumno, String nombreAlumno, String apellidosAlumno, int edad, char grupo) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidosAlumno = apellidosAlumno;
        this.edad = edad;
        this.grupo = grupo;
    }

    public AlumnoDTO() {
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellidosAlumno() {
        return apellidosAlumno;
    }

    public void setApellidosAlumno(String apellidosAlumno) {
        this.apellidosAlumno = apellidosAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "AlumnoDTO{" +
                "idAlumno='" + idAlumno + '\'' +
                ", nombreAlumno='" + nombreAlumno + '\'' +
                ", apellidosAlumno='" + apellidosAlumno + '\'' +
                ", edad=" + edad +
                ", grupo=" + grupo +
                '}';
    }
}
