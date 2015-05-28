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
import static logica.Constantes.ListaXml;
import static logica.Constantes.direccion;
import static logica.Constantes.indiceBusXml;
import static logica.Constantes.yes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author osboxes
 */
public class SendData {
    
    private ListaSdoble _datos;
    private DocumentBuilderFactory _docFactory;
    private DocumentBuilder _Builder;
    private Document _doc;
    private Element _root;
    private Element _palabra;
    private Element _Url;
    
    public SendData(ListaSdoble ls){
        this._datos=ls;
    }
    
    private void create(){
        try {
            _docFactory = DocumentBuilderFactory.newInstance();
            _Builder = _docFactory.newDocumentBuilder();
            //el principal del documento
            _doc = _Builder.newDocument();
            //raiz para agregar datos al rchivo
            _root = _doc.createElement(ListaXml);
            _doc.appendChild(_root);
            Nodo tmp=_datos.getHead();
            for(int i=0; i<_datos.getLength(); i++){
                
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,yes);
            DOMSource source = new DOMSource(_doc);
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
}
