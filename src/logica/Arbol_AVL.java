/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 * clase para crear arboles auto-valanceables
 * @author osboxes
 * @param <dp>
 */
public class Arbol_AVL <dp extends Comparable<dp>> extends Arbol_binario{
    
    private NodoB _root;
    
    /**
     * metodo sobre escrito de la clase padre para ingresar nodos en 
     * un arbol AVL.
     * @param dato dato generico
     */
    @Override
    public void insert(Comparable dato) {
        _root=super.insert(dato, _root);
        check();
    }
    
    /**
     * metodo privado para poder calcular la profundidad de cada nodo
     * @param Hizq hijo izquierdo del nodo
     * @param Hder hijo derecho del nodo
     * @return retorna un dato int que se establece como profundidad del nodo
     */
    private int Heigth(NodoB Hizq, NodoB Hder){
        if(Hizq!=null&&Hder!=null)
            return Math.max(Hizq.getDepth(),Hder.getDepth())+1;
        else if(Hizq!=null)
            return Hizq.getDepth()+1;
        else if(Hder!=null)
            return Hder.getDepth()+1;
        else
            return 0;
    }
    
    /**
     * metodo para calcular el factor de equilibrio de un nodo
     * @param Hizq
     * @param Hder
     * @return retrona un dato tipo int, si se retorna un dato con valor
     * de cero es que se encuentra equilibrado
     */
    private double FactorEquilibrio(NodoB Hizq, NodoB Hder){
        if(Hizq!=null&&Hder!=null)
            return Hizq.getDepth()-Hder.getDepth();
        else if(Hizq!=null)
            return Hizq.getDepth()+1;
        else if(Hder!=null)
            return -Hder.getDepth()-1;
        else
            return 0;
    }
    
    /**
     * metodo para realizar rotaciones simples a la Derecha 
     * @param pNodo recibe un dato del tipo NodoB
     */
    private NodoB rotacionSDer(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB hder= pNodo.getHder();
        NodoB maxMIn= pNodo.getHder().getHizq();
        hder.setPadre(padre);
        hder.setHizq(pNodo);
        pNodo.setHder(maxMIn);
        if(padre!=null && padre.getHder()==pNodo)
            padre.setHder(hder);
        else if(padre!=null && padre.getHizq()==pNodo)
            padre.setHizq(hder);
        maxMIn.setPadre(pNodo);
        return hder;
    }
    
    /**
     * metodo para realizar rotacion simple a la Izquierda
     * @param pNodo recibe un dato del tipo NodoB
     */
    private NodoB rotacionSIzq(NodoB pNodo){
        NodoB padre=pNodo.getPadre();
        NodoB hizq= pNodo.getHizq();
        NodoB minMAx=pNodo.getHizq().getHder();
        hizq.setHder(pNodo);
        hizq.setPadre(padre);
        pNodo.setHizq(minMAx);
        if(padre!=null && padre.getHder()==pNodo)
            padre.setHder(hizq);
        else if(padre!=null && padre.getHizq()==pNodo)
            padre.setHizq(hizq);
        return hizq;
    }
    
    /**
     * metodo privado para establecer y revisar la altura de los nodos
     * este mismo realiza las rotaciones.
     */
    private void check(){
        NodoB tmp= _root;
        checkAux(tmp);
    }
    
    /**
     * metodo recursivo que va poniendo la profundidad, factor de equilibrio
     * y revisa si se ocupan hacer rotaciones en el arbol.
     * @param pNodo recibe un dato del tipo NodoB
     */
    private void checkAux(NodoB pNodo){
        if(pNodo==null)
            return;
        checkAux(pNodo.getHizq());
        checkAux(pNodo.getHder());
        pNodo.setDepth(Heigth(pNodo.getHizq(), pNodo.getHder()));
        pNodo.setFE(FactorEquilibrio(pNodo.getHizq(), pNodo.getHder()));
        //System.out.println("Profundidad: "+pNodo.getDepth()+"; Factor de equilibrio: "+ pNodo.getFE());
        if(pNodo==_root){
            if(pNodo.getFE()>1)
                _root=rotacionSIzq(pNodo);
            else if(pNodo.getFE()<-1)
                _root=rotacionSDer(pNodo);
        }
        else{
            if(pNodo.getFE()>1)
                rotacionSIzq(pNodo);
            else if(pNodo.getFE()<-1)
                rotacionSDer(pNodo);
        }
    }
    
    /**
     * metodo sobreescrito para imprimir en preorden los nodos de un arbol
     */
    @Override
    public void print(){
        super.print(_root);
    }
    
     /* pruebas unitarias del arbol AVL
    public static void main(String[] args) {
        Arbol_AVL nuevo = new Arbol_AVL();
        nuevo.insert(10);
        nuevo.insert(5);
        nuevo.insert(15);
        nuevo.insert(13);
        nuevo.insert(20);
        nuevo.insert(19);
        nuevo.insert(22);
        nuevo.print();
    }*/
}
