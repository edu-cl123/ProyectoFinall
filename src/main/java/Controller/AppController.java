package Controller;

import Model.Personaje;
import Model.Enemigo;
import Repositories.RepositoryEnemigo;
import Repositories.RepositoryPersonaje;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AppController implements IAppController {

    public RepositoryPersonaje personaje = new RepositoryPersonaje();
    public RepositoryEnemigo enemigo = new RepositoryEnemigo();
    
    public AppController() {};

    @Override
    public boolean loadPersonajeDDBB() {
        boolean resultado = false;
        File file = new File(IAppController.PersonajeDDBB);
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Lista de Personajes");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String codigo = eElement.getElementsByTagName("codigo").item(0).getTextContent();
                    String Nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
                    String vida = eElement.getElementsByTagName("vida").item(0).getTextContent();
                    String ataque = eElement.getElementsByTagName("ataque").item(0).getTextContent();
                    String defensa = eElement.getElementsByTagName("defensa").item(0).getTextContent();

                    personaje.addPersonaje(codigo, Nombre, vida, ataque, defensa);
                }
            }
            resultado=true;
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (SAXException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    @Override
    public boolean loadEnemigoDDBB() {
boolean resultado = false;
        File file = new File(IAppController.EnemigoDDBB);
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Lista de Enemigos");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String codigo = eElement.getElementsByTagName("codigo").item(0).getTextContent();
                    String Nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
                    int vida = Integer.parseInt(eElement.getElementsByTagName("vida").item(0).getTextContent());
                    int edad = Integer.parseInt(eElement.getElementsByTagName("Edad").item(0).getTextContent());
                    String ataque = eElement.getElementsByTagName("ataque").item(0).getTextContent();
                    String defensa = eElement.getElementsByTagName("defensa").item(0).getTextContent();

                    enemigo.addEnemigo(codigo, Nombre, vida, ataque, defensa);
                }
            }
            resultado=true;
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (SAXException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return resultado;    }

    @Override
    public boolean savePersonajeDDBB() {
        boolean resultado = false;

        try {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();

            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();
            //Contenedor del documento
            Element raiz = doc.createElement("ListaPersonajes");
            //Añadir personajes
            doc.appendChild(raiz);
            //Creado el XML
            Set<Personaje> ListaPersonajes = personaje.listAllPersonajeTrue();

            for (Personaje personaje : ListaPersonajes) {
                Element p = doc.createElement("Personaje");

                Element codigo = doc.createElement("Codigo");
                codigo.appendChild(doc.createTextNode(personaje.getNombre()));

                Element nombre = doc.createElement("Nombre");
                nombre.appendChild(doc.createTextNode(personaje.getNombre()));

                Element vida = doc.createElement("Vida");
                vida.appendChild(doc.createTextNode(personaje.getVida()));

                Element ataque = doc.createElement("Ataque");
                ataque.appendChild(doc.createTextNode(personaje.getAtaque()));

                Element defensa = doc.createElement("Defensa");
                ataque.appendChild(doc.createTextNode(personaje.getDefensa()));

                p.appendChild(codigo);
                p.appendChild(nombre);
                p.appendChild(vida);
                p.appendChild(ataque);
                p.appendChild(defensa);

                raiz.appendChild(p);
            }

            //Guardar el XML
            TransformerFactory tfact = TransformerFactory.newInstance();

            Transformer trans = tfact.newTransformer();
            //Opciones del archivo
            trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty("{http://xml.apache.org/xlst}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(IAppController.PersonajeDDBB));
            resultado = true;
            trans.transform(source, result);

        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (TransformerConfigurationException ex) {
            System.out.println(ex);
        } catch (TransformerException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    @Override
    public boolean saveEnemigoDDBB() {
        boolean resultado = false;

        try {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();

            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();
            //Contenedor del documento
            Element raiz = doc.createElement("ListaEnemigos");
            //Añadir personajes
            doc.appendChild(raiz);
            //Creado el XML
            Set<Enemigo> ListaEnemigos = enemigo.listAllEnemyTrue();

            for (Enemigo enemigo : ListaEnemigos) {
                Element p = doc.createElement("Personaje");

                Element codigo = doc.createElement("Codigo");
                codigo.appendChild(doc.createTextNode(enemigo.getNombre()));

                Element nombre = doc.createElement("Nombre");
                nombre.appendChild(doc.createTextNode(enemigo.getNombre()));

                Element vida = doc.createElement("Vida");
                vida.appendChild(doc.createTextNode(enemigo.getVida()));

                Element ataque = doc.createElement("Ataque");
                ataque.appendChild(doc.createTextNode(enemigo.getAtaque()));

                Element defensa = doc.createElement("Defensa");
                ataque.appendChild(doc.createTextNode(enemigo.getDefensa()));

                p.appendChild(codigo);
                p.appendChild(nombre);
                p.appendChild(vida);
                p.appendChild(ataque);
                p.appendChild(defensa);

                raiz.appendChild(p);
            }

            //Guardar el XML
            TransformerFactory tfact = TransformerFactory.newInstance();

            Transformer trans = tfact.newTransformer();
            //Opciones del archivo
            trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty("{http://xml.apache.org/xlst}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(IAppController.EnemigoDDBB));
            resultado = true;
            trans.transform(source, result);

        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (TransformerConfigurationException ex) {
            System.out.println(ex);
        } catch (TransformerException ex) {
            System.out.println(ex);
        }
        return resultado;
    }
    
        @Override
    public boolean loadAllDDBB() {
        boolean resultado = false;
        
        if(loadPersonajeDDBB()&& loadEnemigoDDBB()){
            resultado = true;
        }
        return resultado;
    }
    
        @Override
    public boolean saveAllDDBB() {
        boolean resultado = false;
        
        if(savePersonajeDDBB()&& saveEnemigoDDBB()) {
            resultado = true;
        }else{
            System.out.println("Error");
                   
        }
        return resultado;
    }

}
