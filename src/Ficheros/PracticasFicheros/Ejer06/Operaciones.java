package Ficheros.PracticasFicheros.Ejer06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Operaciones {
    private double mediaNum;
    private double numMasAlto;
    private double numMasBajo;

    public Operaciones() {
        Usuario usuario = new Usuario();
        File archivo = new File(usuario.getRuta());

        try {
            media(archivo);
        }catch (IOException e){
            System.out.println("No se puede ingresar el archivo");
        }
    }

    public Operaciones(double numMasBajo, double numMasAlto, double mediaNum) {
        this.numMasBajo = numMasBajo;
        this.numMasAlto = numMasAlto;
        this.mediaNum = mediaNum;
    }

    public double getMediaNum() {
        return mediaNum;
    }

    public void setMediaNum(double mediaNum) {
        this.mediaNum = mediaNum;
    }

    public double getNumMasBajo() {
        return numMasBajo;
    }

    public void setNumMasBajo(double numMasBajo) {
        this.numMasBajo = numMasBajo;
    }

    public double getNumMasAlto() {
        return numMasAlto;
    }

    public void setNumMasAlto(double numMasAlto) {
        this.numMasAlto = numMasAlto;
    }

    public void media (File archivo) throws IOException {
        FileReader fr = new FileReader(archivo);
        ArrayList<Double> numeros = new ArrayList<>();
        double suma = 0;

        StringBuilder linea = new StringBuilder();
        int i;

        // Leer el archivo carácter por carácter
        while ((i = fr.read()) != -1) {
            char c = (char) i;
            if (c == '\n') { // Si es un salto de línea, procesar la línea
                Scanner scanner = new Scanner(linea.toString());
                while (scanner.hasNextDouble()) {
                    double numero = scanner.nextDouble();
                    numeros.add(numero);
                    suma += numero; // Sumar al total
                }
                linea.setLength(0); // Reiniciar el StringBuilder para la próxima línea
                scanner.close();
            } else {
                linea.append(c); // Agregar carácter a la línea
            }
        }

        // Procesar la última línea si no termina en salto de línea
        if (linea.length() > 0) {
            Scanner scanner = new Scanner(linea.toString());
            while (scanner.hasNextDouble()) {
                double numero = scanner.nextDouble();
                numeros.add(numero);
                suma += numero; // Sumar al total
            }
            scanner.close();
        }

        // Calcular y mostrar la media
        if (!numeros.isEmpty()) {
            double media = suma / numeros.size(); // Usar el tamaño de la lista
            System.out.println("La media es: " + media);
        } else {
            System.out.println("NFu o se encontraron números en el archivo.");
        }

        fr.close(); // Cerrar el archivo
    }
}
