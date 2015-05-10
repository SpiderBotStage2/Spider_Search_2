/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 * clase para nodos de cualquier tipo de arbol
 * @author osboxes
 * @param <dp>
 */
public class NodoB <dp extends Comparable<dp>>{
    
    private dp _dato;
    private NodoB _Hizq;
    private NodoB _Hder;
    private NodoB padre;
    private double _FE;
    private int _depth;
    private int color;
    
    public NodoB(dp dato){
        this._dato=dato;
    }
    
    /**
     * metodo para obtener la informacion interna del nodo
     * @return un dato generico
     */
    public dp getDato(){
        return _dato;
    }
    
    /**
     * metodo para establecer el factor de equilibrio de un nodo
     * metodo especifico para los arboles AVL
     * @param fe recibe un dato tipo entero
     */
    public void setFE(double fe){
        this._FE=fe;
    }
    
    /**
     * metodo para establecer la profundida del nodo, se utilizan unicamente
     * en arboles AVL
     * @param depth 
     */
    public void setDepth(int depth){
        this._depth=depth;
    }
    
    /**
     * metodo para establecer el padre de un nodo, se emplea en el arbol Splay
     * @param padre padre es de la clase NodoB
     */
    public void setPadre(NodoB padre){
        this.padre=padre;
    }
    
    /**
     * establece el hijo izquierdo de este nodo 
     * @param hizq recibe un dato tipo NodoB
     */
    public void setHizq(NodoB hizq){
        this._Hizq=hizq;
    }
    
    /**
     * establece el hijo derecho del nodo 
     * @param hder recibe un dato tipo NodoB
     */
    public void setHder(NodoB hder){
        this._Hder=hder;
    }
    
    /**
     * metodo para establecer el color del nodo de un arbol rojo y negro
     * @param color 1 para rojo y 0 para negro
     */
    public void setColor(int color){
        this.color=color;
    }
    
    /**
     * metodo para retornar el color de una nodo
     * @return retorna un int, 1 para rjo y 0 para negro. 
     */
    public int getColor(){
        return color;
    }
    
    /**
     * metodo que devuelve el factor de equilibrio del nodo, usado 
     * unicamente con arboles AVL
     * @return retorna un dato tipo int
     */
    public double getFE(){
        return _FE;
    }
    
    /**
     * metodo devolver la profundida de los nodos, se utiliza especificamente
     * para arboles AVL
     * @return retorna un dato tipo int
     */
    public int getDepth(){
        return _depth;
    }
    
    /**
     * metodo que devuelve el padre de los nodos de un arbol
     * @return NodoB
     */
    public NodoB getPadre(){
        return padre;
    }
    
    /**
     * retorna el hijo izquierdo del nodo
     * @return retorna un dato tipo NodoB
     */
    public NodoB getHizq(){
        return _Hizq;
    }
    
    /**
     * retorna el hijo derecho del nodo
     * @return retorna un dato tipo NodoB
     */
    public NodoB getHder(){
        return _Hder;
    }
}
