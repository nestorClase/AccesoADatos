package Ficheros.PracticasFicheros.Ejer04;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Contador {
    private int numCaracteres;
    private int numPalabras;
    private int numLineas;

    public Contador() {
        Usuario usuario = new Usuario();
        File archivo = new File(usuario.getRuta());
        try {
            caracteres(archivo);
            palabras(archivo);
            lineas(archivo);
        } catch (IOException e) {
            System.out.println("No se puede acceder al archivo");
        }

    }

    public Contador(int numCaracteres, int numPalabras, int numLineas) {
        this.numCaracteres = numCaracteres;
        this.numPalabras = numPalabras;
        this.numLineas = numLineas;
    }

    public int getNumCaracteres() {
        return numCaracteres;
    }

    public void setNumCaracteres(int numCaracteres) {
        this.numCaracteres = numCaracteres;
    }

    public int getNumPalabras() {
        return numPalabras;
    }

    public void setNumPalabras(int numPalabras) {
        this.numPalabras = numPalabras;
    }

    public int getNumLineas() {
        return numLineas;
    }

    public void setNumLineas(int numLineas) {
        this.numLineas = numLineas;
    }

    public void caracteres(File archivo) throws IOException {
        try (FileReader fr = new FileReader(archivo)) {
            int i;
            while ((i = fr.read()) != -1) {
                if ((char) i != ' ' && (char) i != '\n' && (char) i != '\r' && (char) i != '\t') {
                    numCaracteres++;
                }
            }
        }
    }

    public void palabras (File archivo) throws IOException {
        FileReader fr = new FileReader(archivo);
        int i;

        while((i = fr.read()) != -1){
            if((char)i==' '||(char)i=='\n'){
                numPalabras++;
            }
        }
        numPalabras++;
    }

    public void lineas (File archivo) throws IOException {
        FileReader fr = new FileReader(archivo);
        int i;
        while((i = fr.read()) != -1){
            if((char)i=='\n'){
                numLineas++;
            }
        }
        numLineas++;
    }

    @Override
    public String toString() {
        return "Contador{" +
                "numCaracteres=" + numCaracteres +
                ", numPalabras=" + numPalabras +
                ", numLineas=" + numLineas +
                '}';
    }
}
