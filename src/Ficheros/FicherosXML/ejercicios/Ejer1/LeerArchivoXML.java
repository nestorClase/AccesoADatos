package Ficheros.FicherosXML.ejercicios.Ejer1;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;

public class LeerArchivoXML {
    public LeerArchivoXML() throws ParserConfigurationException {
        leerXml();
    }
    public static void leerXml() throws ParserConfigurationException {
        try{
            File fichero=new File("D:\\Clase\\Acceso a datos\\Proyectos\\Ficheros\\src\\FicherosXML\\ejercicios\\Ejer1\\Personas.xml");

            DocumentBuilderFactory fabrica=DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor=fabrica.newDocumentBuilder();
            Document documento=constructor.parse(fichero);
            documento.getDocumentElement().normalize();

            TransformerFactory cambioFabrica=TransformerFactory.newInstance();
            Transformer cambiar=cambioFabrica.newTransformer();
            DOMSource buscar=new DOMSource(documento);

            StreamResult consola=new StreamResult(System.out);
            cambiar.transform(buscar,consola);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void leerXmlSAX () {
        try {
            //Instanciamos la factoria y el tranformador
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bNombre = false;
                boolean bDni = false;
                boolean bTelefono = false;
                boolean bEdad = false;

                public void startElement(String uri, String LocalName, String qName, Attributes attributes) throws SAXException {}
            };


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
