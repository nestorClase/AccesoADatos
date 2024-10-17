package Ficheros.Teoria.FicheroBinario;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Colocarte {

    static Scanner teclado = new Scanner(System.in);
    static RandomAccessFile archivo=null;

    public static void main(String[] args) throws IOException {
        int numero;
        try {
            archivo = new RandomAccessFile("datos.txt", "rw");

            System.out.println("Introduce el numero ");
        }catch (Exception e){}
    }

}
