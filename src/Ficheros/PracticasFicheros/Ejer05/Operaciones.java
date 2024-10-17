package Ficheros.PracticasFicheros.Ejer05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Operaciones {

    public Operaciones() {

        Usuario usuario = new Usuario();
        File archivo = new File(usuario.getRuta());

        try {
            System.out.println("Los numeros del archivo son");
            imprimirnumeros(archivo);
            System.out.println();
            System.out.println("Y la media es: ");
            media(archivo);
        }catch (IOException e){
            System.out.println("Error inesperado");
        }
    }

    public void imprimirnumeros (File archivo) throws IOException {
        FileReader fr = new FileReader(archivo);
        int i;

        while ((i = fr.read())!=-1){
            System.out.print((char)i);
        }
    }

    public void media (File archivo) throws IOException {
        FileReader fr = new FileReader(archivo);
        int i;
        int sumaNumeros=0;
        int contador=0;

        while ((i = fr.read()) != -1) {
            char c = (char) i;
            // Verificar si el carácter es un número (entre '0' y '9')
            if (Character.isDigit(c)) {
                int numero = Character.getNumericValue(c);  // Convertir el carácter a número
                sumaNumeros += numero;  // Sumar el número
                contador++;  // Incrementar el contador de números
            }
        }

        if (contador > 0) {
            double media = (double) sumaNumeros / contador;  // Calcular la media
            System.out.println("La media es: " + media);
        } else {
            System.out.println("No se encontraron números en el archivo.");
        }

        fr.close();  // Cerrar el archivo al final
    }



}
