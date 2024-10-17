package Ficheros.FicherosAleatorios;

public class Trabajadores {
    private String apellido;
    private int departamento;
    private double salario;
    private int id;

    public Trabajadores( int id, String apellido, int departamento, double salario) {
        char [] apellidos=new char[10];
        for(int i = 0; i<apellido.length(); i++){
            apellidos[i]=apellido.charAt(i);
        }
        this.apellido=apellidos.toString();
        this.departamento = departamento;
        this.salario = salario;
        this.id = id;
    }

    public Trabajadores() {
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
