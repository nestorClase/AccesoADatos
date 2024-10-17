package Ficheros.FicherosXML.teoria;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class FicheroXML {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder;
        try{
            builder = factory.newDocumentBuilder();
            DOMImplementation domImpl = builder.getDOMImplementation();
            Document document = domImpl.createDocument(null, "Empleados", null);
            cargarFicheros(builder);
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }
    }
    
    public static void cargarFicheros(DocumentBuilder builder){

    }
}
