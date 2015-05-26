/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xml;

import Listas.ListaSdoble;
import Listas.Nodo;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import logica.Constantes;

/**
 * clase para hacer el xml que contiene las palabras puestas en la 
 * lista de Url, y se utiliza para enviarla al spider engine
 * @author osboxes <-------------nombre de maquina virtual de ubuntu, 
 * create by ellioth>
 */
public class CrearXml implements Constantes{
    private DocumentBuilderFactory docFactory;
    private DocumentBuilder Builder;
    private Document doc;
    private Element root;
    private Element Url;
    
    /**
     * se le ingresa una lista de urls, crea un archivo xml en la carpeta donde
     * se encuentra el archivo.
     * @param pUrl lista con los url para que los threats coman desde ahi.
     */
    public CrearXml( ListaSdoble pUrl){
        try {
            docFactory = DocumentBuilderFactory.newInstance();
            Builder = docFactory.newDocumentBuilder();
            //el principal del documento
            doc = Builder.newDocument();
            //raiz para agregar datos al rchivo
            root = doc.createElement(ListaXml);
            doc.appendChild(root);
            Nodo tmp= pUrl.getHead();
            for(int i=0; i<pUrl.getLength(); i++){
                this.Url = doc.createElement(indiceBusXml);
                this.Url.appendChild(doc.createTextNode((String)tmp.getData()));
                root.appendChild(this.Url);
                tmp= tmp.getNext();
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,yes);
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(direccion));
            
            //opcion para imprimir en consola
            //StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
              pce.printStackTrace();
        } catch (TransformerException tfe) {
              tfe.printStackTrace();
        }
    }
    
    /**
     * metodos de prueba
    public static void main(String[] args) {
        ListaSdoble nuevo= new ListaSdoble();
        nuevo.enQueue("www.google.com");
        nuevo.enQueue("www.wikipedia.com");
        nuevo.enQueue("C:/home/user/Library");
        nuevo.enQueue("www.stackoverflow.com");
        CrearXml nuevo2= new CrearXml(nuevo);
    }*/
}
