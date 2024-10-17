package Ficheros.FicherosXML.ejercicios.Ejer1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CreacionFicheroXml {
    private ArrayList<Persona> personas = new ArrayList();

    public CreacionFicheroXml() {
        leerArchivo();
        crearArchivoXml();
    }

    public CreacionFicheroXml(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public void leerArchivo(){
        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
        try (FileInputStream fis = new FileInputStream("D:\\Clase\\Acceso a datos\\Proyectos\\Ficheros\\src\\FicherosXML\\ejercicios\\Ejer1\\FichPersona.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Leer los objetos del archivo
            Persona persona;
            while (true) {
                try {
                    persona = (Persona) ois.readObject(); // Leer un objeto Cliente
                    listaPersonas.add(persona); // Añadir a la lista
                } catch (IOException | ClassNotFoundException e) {
                    break; // Fin del archivo
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        setPersonas(listaPersonas);
    }

    public void crearArchivoXml(){
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            //Crear documento XML
            Document document = documentBuilder.newDocument();

            //Crear nodo raiz y colgarlo del documento
            Element rootElement = document.createElement("Personas");
            document.appendChild(rootElement);

            for(int i = 0;i < personas.size();i++){
                //Crear elemento persona y colgarlo de personas
                Element persona = document.createElement("Persona");
                rootElement.appendChild(persona);

                //Crear cada uno de los elementos de Personas
                Element elementoNombre = document.createElement("Nombre");
                persona.appendChild(elementoNombre);
                Text nombre = document.createTextNode(personas.get(i).getNombre());
                persona.appendChild(nombre);

                Element elementoDni = document.createElement("DNI");
                persona.appendChild(elementoDni);
                Text dni = document.createTextNode(personas.get(i).getDni());
                persona.appendChild(dni);

                Element elementoTelefono = document.createElement("Telefono");
                persona.appendChild(elementoTelefono);
                Text telefono = document.createTextNode(personas.get(i).getTelefono());
                persona.appendChild(telefono);

                Element elementoEdad = document.createElement("Edad");
                persona.appendChild(elementoEdad);
                Text edad =document.createTextNode(String.valueOf(personas.get(i).getEdad()));
                persona.appendChild(edad);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);

            StreamResult result = new StreamResult(new File("D:\\Clase\\Acceso a datos\\Proyectos\\Ficheros\\src\\FicherosXML\\ejercicios\\Ejer1\\Personas.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource,result);

        } catch (ParserConfigurationException e) {
            System.out.println("No se puede crear el archivo");
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
