/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import logica.Constantes;
import Listas.ListaSdoble;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import Arboles.MetodosPArbolesSP;


public class ReadUrl extends MetodosPArbolesSP implements Constantes{
    
    private DocumentBuilder Dbuilder;
    private DocumentBuilderFactory Dfactory;
    private Document docu;
    private String[] Urls;
    private ListaSdoble SpAtri;
    
    /**
     * contructor de la clase nos inicializa las listas que se van a estar 
     * urilizando
     */
    public ReadUrl(){
        Urls = new String[crecimientoArreglo];//tamaño del arreglo
        SpAtri= new ListaSdoble();
    }
    
    /**
     * lector de archivos xml, recibe como parametro un integer que nos indica 
     * a que cosas va a leer del xml
     */
    public void readAll(){
        try{
            Dfactory = DocumentBuilderFactory.newInstance();
            Dbuilder= Dfactory.newDocumentBuilder();
            docu= Dbuilder.parse(direccion);
            docu.getDocumentElement().normalize();
            NodeList lista = docu.getElementsByTagName(ListaXml);
            Node nodoL = lista.item(0);
            if(nodoL.getNodeType()==Node.ELEMENT_NODE){
                Element elm= (Element)nodoL;
                for(int i=0; i<elm.getElementsByTagName(indiceBusXml).getLength();i++){
                    if(i==Urls.length)
                        Urls=growArray(Urls.length, Urls);
                    Urls[i]=elm.getElementsByTagName(indiceBusXml).item(i).getTextContent();

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
