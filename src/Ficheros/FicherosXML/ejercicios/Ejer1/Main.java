package Ficheros.FicherosXML.ejercicios.Ejer1;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("D:\\Clase\\Acceso a datos\\Proyectos\\Ficheros" +
                "\\src\\FicherosXML\\ejercicios\\Ejer1\\FichPersona.dat");

        EscribirObjeto escribirObjeto = new EscribirObjeto(archivo);
        CreacionFicheroXml creacionFicheroXml = new CreacionFicheroXml();
        try {
            LeerArchivoXML leerArchivoXML;
            System.out.println(leerArchivoXML = new LeerArchivoXML());
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
