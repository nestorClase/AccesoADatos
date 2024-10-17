package Ficheros.PracticasFicheros.Ejer06;

import java.util.Scanner;

public class Usuario {
    private String ruta;

    public Usuario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca la ruta del archivo");
        this.ruta = sc.nextLine();
    }

    public String getRuta() {return ruta;}
}
