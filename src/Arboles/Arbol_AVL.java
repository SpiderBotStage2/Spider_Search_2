/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import Listas.NodoLUrl;
import logica.Constantes;
/**
 * clase para crear arboles auto-valanceables
 * @author osboxes
 */
public class Arbol_AVL  extends MetodosPArbolesSP implements Constantes{
    
    private NodoKeyword _root;
    
    /**
     * metodo para retornar la raiz y realizar recorridos en el arbol.
     * @return retorna un dato de la clase NodoKeyword, este es la raiz del 
     * arbol.
     */
    public NodoKeyword getRoot(){
        return _root;
    }
    
    /**
     * metodo especial para ingresar datos en una rbol AVL
     * @param pDato dato que se ingres ay pertenece a la clase NodoKeyword
     */
    public void insert(NodoKeyword pDato){
        if (_root==null)
            _root=pDato;
        else{
            NodoKeyword ifExist= exist(pDato, _root);
            if (ifExist!=null && ifExist!=pDato)
                reLocate(ifExist, pDato);
            else
                insertAux( pDato, _root);
        }
        check();
    }
    
    /**
     * metodo para ingresar datos en un arbol de manera recursiva.
     * @param pDato dato que se ingresa perteneciente a la clase NodoKeyword.
     * @param pNodo dato padre para recursionar, pertenece a la clase 
     * NodoKeyword.
     */
    private void insertAux(NodoKeyword pDato, NodoKeyword pRaiz){
        if (pRaiz.LengthP()==pDato.LengthP()){
            if(pRaiz.getDato().compareTo(pDato.getDato())<0){
                overPlaceDer(pDato, pRaiz);
            }
            else
                overPlaceIzq(pDato, pRaiz);
        }
        else{
            if(pRaiz.LengthP()>pDato.LengthP()){   
                if(pRaiz.getHizq()==null){
                    pRaiz.setHizq(pDato);
                    ((NodoKeyword)pRaiz.getHizq()).setPadre(pRaiz);
                }
                else
                    insertAux(pDato, (NodoKeyword)pRaiz.getHizq());
            }
            else{
                if(pRaiz.getHder()==null){
                    pRaiz.setHder(pDato);
                    ((NodoKeyword)pRaiz.getHder()).setPadre(pRaiz);
                }
                else
                    insertAux(pDato,(NodoKeyword)pRaiz.getHder());
            }
        }
    }
    
     /**
     * metodo privado para poder calcular la profundidad de cada nodo
     * @param Hizq hijo izquierdo del nodo
     * @param Hder hijo derecho del nodo
     * @return retorna un dato int que se establece como profundidad del nodo
     */
    private int Heigth(NodoKeyword Hizq, NodoKeyword Hder){
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
    private double FactorEquilibrio(NodoKeyword Hizq, NodoKeyword Hder){
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
      * metodo privado para establecer y revisar la altura de los nodos
      * este mismo realiza las rotaciones.
      */
     private void check(){
         NodoKeyword tmp= _root;
         checkAux(tmp);
     }
    
    /**
     * metodo recursivo que va poniendo la profundidad, factor de equilibrio
     * y revisa si se ocupan hacer rotaciones en el arbol.
     * @param pNodo recibe un dato del tipo NodoB
     */
    private void checkAux(NodoKeyword pNodo){
        if(pNodo==null)
            return;
        checkAux((NodoKeyword)pNodo.getHizq());
        checkAux((NodoKeyword)pNodo.getHder());
        pNodo.setDepth(Heigth((NodoKeyword)pNodo.getHizq(), (NodoKeyword)pNodo.getHder()));
        pNodo.setFE(FactorEquilibrio((NodoKeyword)pNodo.getHizq(), (NodoKeyword)pNodo.getHder()));
        //System.out.println("Profundidad: "+pNodo.getDepth()+"; Factor de equilibrio: "+ pNodo.getFE());
        if(pNodo==_root){
            if(pNodo.getFE()>=2){
                if((pNodo.getFE()+pNodo.getHizq().getFE())>pNodo.getFE())
                    _root=rotacionSDer(pNodo);
                else
                   _root=rotacionDDer(pNodo);
            }
            else if(pNodo.getFE()<=-2)
                if((pNodo.getFE()+pNodo.getHder().getFE())<pNodo.getFE())
                    _root=rotacionSIzq(pNodo);
                else
                    _root=rotacionDIzq(pNodo);
        }
        else{
            if(pNodo.getFE()>=2){
                if((pNodo.getFE()+pNodo.getHizq().getFE())>pNodo.getFE())
                    rotacionSDer(pNodo);
                else
                    rotacionDDer(pNodo);
            }
            else if(pNodo.getFE()<=-2)
                if((pNodo.getFE()+pNodo.getHder().getFE())<pNodo.getFE())
                    rotacionSIzq(pNodo);
                else
                    rotacionDIzq(pNodo);
        }
    }
    
    /**
     * metodo para eliminar dato del arbol AVL.
     * @param dato recibe un String como dato para eliminar.
     */
    public void delete(String dato) {
        exist(dato);
        super.delete(dato, _root);
        check();
    }
    
    /**
     * metodo para encontrar un nodo en el arbol, utiliza el parametro de 
     * busqueda en orden.
     * @param pDato dato del tipo String, dato el cual buscaremos.
     * @return retorna un nulo si no existe el nodo, un nodo completo si existe
     * el nodo.
     */
    public NodoKeyword exist(String pDato) {
        return super.exist(new NodoKeyword(pDato, new NodoLUrl("",0)), _root);
    }
    
    /**
     * metodo para realizar una colocacion forzada en la izquierda por 
     * si una palabra tiene la misma cantidad de datos que otra.
     * @param pNodo dato que incialmente el padre de donde va ingresar
     * @param padre dato de que se va ingresar
     * ambos datos, tanto como pNodo y padre son datos que pertenecen a la 
     * clase NodoKeyword.
     */
    private void overPlaceIzq(NodoKeyword pNodo, NodoKeyword padre){
        NodoKeyword hijo = (NodoKeyword)padre.getHizq();
        padre.setHizq(pNodo);
        pNodo.setPadre(padre);
        pNodo.setHizq(hijo);
        if(hijo!=null)
            hijo.setPadre(pNodo);
    }
    
    /**
     * metodo para realizar una colocacion forzada en la derecha por 
     * si una palabra tiene la misma cantidad de datos que otra.
     * @param pNodo dato que incialmente el padre de donde va ingresar
     * @param padre dato de que se va ingresar
     * ambos datos, tanto como pNodo y padre son datos que pertenecen a la 
     * clase NodoKeyword.
     */
    private void overPlaceDer(NodoKeyword pNodo, NodoKeyword padre){
        NodoKeyword hijo = (NodoKeyword)padre.getHder();
        padre.setHder(pNodo);
        pNodo.setPadre(padre);
        pNodo.setHder(hijo);
        if(hijo!=null)
            hijo.setPadre(pNodo);
    }
    
    /**
     * agarra el dato que se acaba de ingresar y compara si es necesario 
     * hacer recolocacion ya que el arbol se desorganiza.
     * @param pDato dato que pertenece a la clase NodoKeyword y se usa para 
     * representar al que se va a mover.
     */
    private void reLocate(NodoKeyword pDato, NodoKeyword newInsert){
        _root=delete(pDato, _root);
        newInsert.SumCont(uno);
        newInsert.getListaUrls().enQueue_none_repeat(
                pDato.getListaUrls().getHead());
        insert(newInsert);
    }
    
    /**
     * metodo sobre escrito del padre para imprimir todos los nodos del arbol en
     * orden
     */
    @Override
    public void print() {
        super.print(_root); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        Arbol_AVL nuevo=new Arbol_AVL();
        NodoKeyword Nuevo=new NodoKeyword("hola", new NodoLUrl("www", 0));
        NodoKeyword Nuevo1=new NodoKeyword("hola", new NodoLUrl("www", 0));
        NodoKeyword Nuevo2=new NodoKeyword("ya", new NodoLUrl("www", 0));
        NodoKeyword Nuevo3=new NodoKeyword("casi", new NodoLUrl("www", 0));
        NodoKeyword Nuevo4=new NodoKeyword("hola", new NodoLUrl("www", 0));
        NodoKeyword Nuevo5=new NodoKeyword("hola", new NodoLUrl("www", 0));
        nuevo.insert(Nuevo);
        nuevo.insert(Nuevo1);
        nuevo.insert(Nuevo2);
        nuevo.insert(Nuevo3);
        nuevo.insert(Nuevo4);
        nuevo.insert(Nuevo5);
        nuevo.print();
    }
}