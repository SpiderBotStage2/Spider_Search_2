/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import Listas.ListaSdoble;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ReadSpiderBotAttr {
    
    private File path;
    private DocumentBuilder Dbuilder;
    private DocumentBuilderFactory Dfactory;
    private Document docu;
    private String[] Urls;
    private ListaSdoble SpAtri;
    private int tail;
    
    /**
     * contructor de la clase
     * nos inicializa las listas
     * que se van a estar urilizando
     */
    public ReadSpiderBotAttr(){
        Urls = new String[2];//tamaño del arreglo
        SpAtri= new ListaSdoble();
    }
    /**
     * lector de archivos xml, recibe 
     * como parametro un integer que nos indica 
     * a que cosas va a leer del xml
     * @param diferencial 
     */
    public void readAll(int diferencial){
        try{
            //path=new File("\\Xmls\\WebPages.xml");
            Dfactory = DocumentBuilderFactory.newInstance();
            Dbuilder= Dfactory.newDocumentBuilder();
            docu= Dbuilder.parse("web_pages.xml");
            docu.getDocumentElement().normalize();
            if(diferencial==1){
                NodeList lista = docu.getElementsByTagName("targets");
                Node nodoL = lista.item(0);
                if(nodoL.getNodeType()==Node.ELEMENT_NODE){
                    Element elm= (Element)nodoL;
                    for(int i=0; i<elm.getElementsByTagName("url").getLength();i++){
                        Urls[i]=elm.getElementsByTagName("url").item(0).getTextContent();
                        tail++;
                        
                    }
                }
            }
            else{
                NodeList lista = docu.getElementsByTagName("spider");
                Node nodoL = lista.item(0);
                if(nodoL.getNodeType()==Node.ELEMENT_NODE){
                    Element elm= (Element)nodoL;
                    SpAtri.enQueue(Integer.parseInt(elm.getElementsByTagName("maxthreads").item(0).getTextContent()));
                    SpAtri.enQueue(Integer.parseInt(elm.getElementsByTagName("recursivity").item(0).getTextContent()));
                    SpAtri.enQueue(Integer.parseInt(elm.getElementsByTagName("reindex").item(0).getTextContent()));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * metodo que retorna una lista de atributos del spiderbot puestos en el xml
     * 
     * @return 
     */
    public ListaSdoble getSpAtri(){
        return this.SpAtri;
    }
    
    /**
     * retorna la lista de los urls targets en el xml
     * @return 
     */
    /*public ListaUrls getUrls(){
        return this.Urls; hay q cambiarlo
    }*/
}
