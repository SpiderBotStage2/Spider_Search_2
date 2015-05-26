/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import Listas.ListaUrls;
import Listas.NodoLUrl;
/**
 *
 * @author osboxes
 */
public class NodoKeyword  extends NodoB{
    
    private int _countPpage;
    private ListaUrls listaUrls;

    
    /**
     * contructor que recibe la palabra, el url o direccion en disco del archivo
     * y la direccion de donde se encontro.
     * @param pData dato String que recibe la palabra que se va a ingresar
     * @param pUrl dato de la clase NodoLUrl, es la direccion en disco o en web
     * donde se encontro la palabra
     * */
    public NodoKeyword(String pData, NodoLUrl pUrl) {
        super(pData);
        this._countPpage=1;
        this.listaUrls=new ListaUrls();
        this.listaUrls.enQueue(pUrl);
    }

    /**
     * devuelve la cantidad de veces que se a encontrado la palabra.
     * @return retorna un dato tipo entero y es la contidad de veces que se 
     * ha encontrado por total.
     */
    public int getCont(){
        return _countPpage;
    }
    
    /**
     * metodo sobre escrito, retorna al padre del nodo.
     * @return retorna un dato de la clase NodoKeyword
     */
    @Override
    public NodoB getPadre() {
        return super.getPadre(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metodo para obtener el dato interno del nodo.
     * @return retorna cualquier tipo de dato, ya sea el que segun le ingresamos
     */
    @Override
    public Comparable getDato() {
        return super.getDato(); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * metodo para obtener el hijo izquierdo del nodo
     * @return retorna un dato de la clase NodoKeyWord
     */
     @Override
    public NodoB getHizq() {
        return super.getHizq(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metodo obtener el hijo derecho del nodo.
     * @return retorna un dato de la clase NodoKeyWord.
     */
    @Override
    public NodoB getHder() {
        return super.getHder(); //To change body of generated methods, choose Tools | Templates.
    }

    /***
     * metodo para obtener el factor de equilibrio del nodo.
     * @return retorna un dato tipo double.
     */
    @Override
    public double getFE() {
        return super.getFE(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metodo para devolver la profundidad del nodo
     * @return retorna un dato tipo entero.
     */
    @Override
    public int getDepth() {
        return super.getDepth(); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * metodo para sumar la cantidad querida a la cantidad de veces aparecida 
     * la palabra.
     * @param cant dato del tipo entero. 
     */
    public void SumCont(int cant){
        this._countPpage+=cant;
    }
    
    /**
     * metodo para establecer el padre del nodo
     * @param padre dato de la clase NodoLUrl
     */
    @Override
    public void setPadre(NodoB padre) {
        super.setPadre(padre); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metodo para establecer el hijo izquierdo del nodo.
     * @param hizq dato de la clase NodoKeyword.
     */
    @Override
    public void setHizq(NodoB hizq) {
        super.setHizq(hizq); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metodo para establecer el hijo drecho del nodo.
     * @param hder dato de la clase NodoKeyword.
     */
    @Override
    public void setHder(NodoB hder) {
        super.setHder(hder); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metodo para establecer el factor de equilibrio del nodo.
     * @param fe dato tipo doble
     */
    @Override
    public void setFE(double fe) {
        super.setFE(fe); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metodo para devolver la profundidad de los nodos.
     * @param depth dato tipo entero.
     */
    @Override
    public void setDepth(int depth) {
        super.setDepth(depth); 
    }
    
    /**
     * metodo para insertar un nuevo padre url en donde se a encontrado el nodo
     * @param pNodo dato del tipo NodoLUrl.
     */
    public void insertUrl(NodoLUrl pNodo){
        this.listaUrls.enQueue_none_repeat(pNodo);
    }
    
    /**
     * metodo para obtener la lista de padres urls
     * @return retorna un dato del tipo ListaUrls.
     */
    public ListaUrls getListaUrls(){
        return this.listaUrls;
    }
    
    /**
     * retorna la cantidad de apariciones de la palabra contenida en el nodo
     * @return 
     */
    public int LengthP(){
        return _countPpage;
    }
}
