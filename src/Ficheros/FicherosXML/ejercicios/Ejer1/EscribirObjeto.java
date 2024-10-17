package Ficheros.FicherosXML.ejercicios.Ejer1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class EscribirObjeto {
    public EscribirObjeto(File archivo) {
        Persona cliente0 = new Persona("Juan", "71779959H","645312407",22);
        Persona cliente1 = new Persona("Pedro", "75886657J","765389547",28);
        Persona cliente2 = new Persona("Manuel", "48992247F","698574289",55);
        Persona cliente3 = new Persona("Iara", "125566387H","687352807",80);

        try (FileOutputStream fos = new FileOutputStream(archivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(cliente0);
            oos.writeObject(cliente1);
            oos.writeObject(cliente2);
            oos.writeObject(cliente3);
            System.out.println("Objetos escritos en el fichero.");

        } catch (IOException e) {
            System.out.println("No se pudo escribir el objeto.");
        }
    }
}