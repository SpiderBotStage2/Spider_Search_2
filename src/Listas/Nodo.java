/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 *
 * @author Ellioth
 * @param <dp> generic para administracion de nodos
 */
public class Nodo<dp extends Comparable<dp>> {
    /**
     * atributos de la clase padre nodo
     */
    private dp dato;
    private Nodo NextNodo;
    private Nodo prevNodo;
    
    /**
     * metodo para ingresar el dato que 
     * se va a contener en el nodo creado
     * @param pData 
     */
    public Nodo(dp pData){
        this.dato= pData;
    }
    
    /**
     * devuelve el contenido del nodo
     * @return 
     */
    public dp getData(){
        return  dato;
    }
    
    /**
     * si se le desea cambiar el dato 
     * a un nodo, se le ingresa como el 
     * parametro "dato"
     * @param dato 
     */
    public void setData(dp dato){
        this.dato=dato;
    }
    
    /**
     * devuelve el nodo siguiente de 
     * el cual estamos trabajando
     * @return 
     */
    public Nodo getNext(){
        return NextNodo;
    }
    
    /**
     * devuelve el nodo anterior del
     * cual nos entramos
     * @return 
     */
    public Nodo getPrev(){
        return prevNodo;
    }
    
    /**
     * establece como parametro de entrada
     * un nodo para colocarlo como siguiente
     * del cual nos encontramos
     * @param pNodo 
     */
    public void setNext(Nodo pNodo){
        this.NextNodo=pNodo;
    }
    
    /**
     * establece un como parametro de entrada
     * el nodo que se encuentra anterior al 
     * cual nos estamos referenciando
     * @param pNodo 
     */
    public void setPrev(Nodo pNodo){
        this.prevNodo=pNodo;
    }
}
