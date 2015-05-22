/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

import Listas.Nodo;

/**
 * esta clase nos sirve para ir haciendo los nodos que estaran 
 * en la lista para los urls a analizar.
 * 
 * @author Ellioth
 */
public class NodoLUrl <dp> extends Nodo {

    private dp profundida;
    
    /**
     * establece en un nodo el urls para hacer las busquedas con el 
     * spiderbot.
     * @param pData 
     */
    public NodoLUrl(dp pData) {
        super(pData);
    }
    
    @Override
    public Object getData() {
        return super.getData(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNext(Nodo pNodo) {
        super.setNext(pNodo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nodo getNext() {
        return super.getNext(); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * devuelve el valor de la profundidad del url
     * @return profundidad
     */
    public dp geDepth(){
        return profundida;
    }
    
    /**
     * ingresa el valor de la profundiad perteneciente a la url que se asigna 
     * en este nodo.
     * @param depth 
     */
    public void setDepth(dp depth){
        profundida=depth;
    }
}
