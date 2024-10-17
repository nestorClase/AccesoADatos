package Ficheros.FicherosXML.ejercicios.Ejer1;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String dni;
    private String telefono;
    private int edad;

    public Persona(){

    }

    public Persona(String nombre, String dni, String telefono, int edad){
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad +
                '}';
    }
}
