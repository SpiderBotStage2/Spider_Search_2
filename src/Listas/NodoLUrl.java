/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;


import static logica.Constantes.Rojo;


/**
 * clase para hacer los nodos que se extraen del indice creado por el spiderbot,
 * esta clase se utiliza para crear la lista de parte de este mismo indice y 
 * tambien para crear arboles rojo y negros que luego de que los threads
 * terminen con la lista de parte del spiderbot
 * @author Ellioth
 */
public class NodoLUrl {

    private int _profundida;
    private int _cantTotal;
    private String _dato;
    private NodoLUrl _next;
    private NodoLUrl _hder;
    private NodoLUrl _hizq;
    private NodoLUrl _padre;
    private int _color=Rojo;
    
    /**
     * contructor recibe un dato del tipo string
     * @param url 
     * @param depth 
     */
    public NodoLUrl(String url, int depth){
        this._dato=url;
        this._profundida=depth;
    }
    
    /**
     * metodo para establecer la cantidad total de palabras que tiene el archivo
     * @param cantT dato entero, es la cantidad que le queremos ingresar.
     */
    public void setCantT(int cantT){
        this._cantTotal=cantT;
    }
    
    /**
     * metodo para establecer el nodo siguiente, este solo se utiliza para hacer
     * listas.
     * @param next dato de 
     */
    public void setNext(NodoLUrl next){
        this._next=next;
    }
    
    /**
     * metodo para establecer el hijo derecho de este mismo nodo, metodo pensado
     * para utilizarce unicamente con el arbol rojo y negro.
     * @param hder dato de la clase NodoLUrl, este sera el hijo derecho del nodo
     */
    public void setHder(NodoLUrl hder){
        this._hder=hder;
    }
    
    /**
     * metodo para establecer el hijo izquierdo del nodo, metodo pensado para 
     * emplearse unicamente con el arbol rojo y negro.
     * @param hizq dato de la clase NodoUrl, este sera el hijo izquierdo del 
     * nodo en cuestion.
     */
    public void setHizq(NodoLUrl hizq){
        this._hizq=hizq;
    }
    
    /**
     * metodo para establecer el padre del nodo, se utiliza solo para la arboles
     * rojo y negros.
     * @param padre dato de la clase NodoUrl, este sera el padre del nodo.
     */
    public void setPadre(NodoLUrl padre){
        this._padre=padre;
    }
    
    /**
     * metodo que establece el color del nodo, solo se emplea en la creacion de 
     * arboles rojo y negros.
     * @param color dato entero, representa el color del nodo, Cero para Rojo y
     * Uno para Negro.
     */
    public void setColor(int color){
        this._color=color;
    }
    
    /**
     * metodo para obtener el dato del nodo, se utliza para cuando se tiene que 
     * realizar compraciones o establecimiento de datos.
     * @return retorna un String ya que este nodo solo contiene direcciones 
     * en formato de string.
     */
    public String getDato(){
        return this._dato;
    }
    
    /**
     * metodo que retorna el hijo derecho del nodo,este metodo esta pensado para
     * utilizar solo con arboles rojo y negros.
     * @return retorna un dato de la clase NodoLUrl que este es el hijo derecho
     * del nodo.
     */
    public NodoLUrl getHder(){
        return _hder;
    }
    
    /**
     * metodo para retornar el hijo izquierdo del nodo, este metodo solo se 
     * utiliza en arboles rojo y negros.
     * @return retorna un dato de la clase NodoLUrl, este es el hijo izquierdo 
     * del nodo.
     */
    public NodoLUrl getHizq(){
        return _hizq;
    }
    
    /**
     * metodo para retornar el padre del nodo, se utiliza solo en arboles rojo y
     * negros.
     * @return retorna un dato de la clase NodoLUrl, este es el padre del nodo. 
     */
    public NodoLUrl getPadre(){
        return _padre;
    }
    
    /**
     * metodo para obtener el nodo siguiente al nodo que estamos haciendo, 
     * este metodo solo se emplea en la creacion de la lista del indice.
     * @return retorna el nodo siguiente al nodo que estamos creando, pertenece
     * a la clase NodoLUrl.
     */
    public NodoLUrl getNext(){
        return this._next;
    }
    
    /**
     * metodo para obtener el color del nodo, este se emplea solo para los 
     * arboles rojo y negro.
     * @return si devuelve un cero es por que el nodo es Ŕojo y si es un uno es 
     * por que el nodo es Negro.
     */
    public int getColor(){
        return _color;
    }
    
    /**
     * devuelve el valor de la profundidad del url
     * @return profundidad
     */
    public int geDepth(){
        return _profundida;
    }
}
