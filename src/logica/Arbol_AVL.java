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
    
    private NodoUrl _root;
    
    /**
     * metodo especial para ingresar nodos en un arbol AVL.
     * @param pNodo dato de la clase NodoUrl.
     */
    public void insert(NodoUrl pNodo) {
        int lastCantP=insertAux(pNodo, _root);
        check();
        if(isLeft(pNodo,lastCantP)!=false && (pNodo.LengthP()>_root.LengthP())){
            outSide(pNodo);
        }
    }
    
    public int insertAux(NodoUrl pNodoToIn, NodoUrl pNodo){
        int lastCantP;
        if(pNodoToIn.LengthP()<pNodo.LengthP()){   
            if((NodoUrl)pNodo.getHizq()==null){
                pNodo.setHizq(pNodoToIn);
                ((NodoUrl)pNodo.getHizq()).setPadre(pNodo);
            }
            else
                insertAux(pNodoToIn,(NodoUrl)pNodo.getHizq());
            lastCantP=0;
        }
        else if (pNodoToIn.LengthP()>pNodo.LengthP()){
            if((NodoUrl)pNodo.getHder()==null){
                pNodo.setHder(pNodoToIn);
                ((NodoUrl)pNodo.getHder()).setPadre(pNodo);
            }
            else
                insertAux(pNodoToIn,(NodoUrl)pNodo.getHder());
            lastCantP=0;
        }
        
        else{
            if(pNodoToIn.getDato().compareTo(pNodo)==0){
                lastCantP=pNodoToIn.LengthP();
                pNodo=pNodoToIn;
            }
            
            else if(pNodoToIn.LengthP()<pNodo.LengthP()){   
                if((NodoUrl)pNodo.getHizq()==null){
                    pNodo.setHizq(pNodoToIn);
                    ((NodoUrl)pNodo.getHizq()).setPadre(pNodo);
                }
                else
                    insertAux(pNodoToIn,(NodoUrl)pNodo.getHizq());
                lastCantP=0;
            }
            
            else if (pNodoToIn.LengthP()>pNodo.LengthP()){
                if((NodoUrl)pNodo.getHder()==null){
                    pNodo.setHder(pNodoToIn);
                    ((NodoUrl)pNodo.getHder()).setPadre(pNodo);
                }
                else
                    insertAux(pNodoToIn,(NodoUrl)pNodo.getHder());
                lastCantP=0;
            }
            lastCantP=0;
        }
        return lastCantP;
    }
    
    /**
     * metodo privado especial que permite devolver nodos conectados al arbol.
     * @param pDato recibe un dato generico, que sea igual a los datos 
     * que se ingresado con anterioridad al arbol.
     * @return retorna un null si no existe el dato; en caso de que exista
     * devolvera un nodo que contiene las conexiones y referencias con 
     * respecto al arbol.
     */
    private boolean isLeft(NodoUrl pNodo, int lastCantP){
        if (_root==pNodo)
            return false;
        else
            return FindAux((NodoUrl)_root.getHizq(),pNodo,lastCantP);
    }
    
    /**
     * metodo privado recursivo que busca el dato que estamos buscando
     * @param pNodo recibe inicialmente la raiz.
     * @param pDato recibe un dato generico, que sea igual a los datos 
     * que se ingresado con anterioridad al arbol.
     * @return retorna el nodo que haya sido igual.
     */
    private boolean FindAux(NodoUrl pNodo, NodoUrl pNodoToSearch, int lastCantP){
        if(pNodo==pNodoToSearch)
            return true;
        if(true){//pNodo.LengthP()){
            if((NodoUrl)pNodo.getHder()==null)
                return false;
            else
                return FindAux((NodoUrl)pNodo.getHder(), pNodoToSearch, lastCantP);
        }
        if(pNodo.getDato().compareTo(pNodoToSearch.getDato())>0){
            if((NodoUrl)pNodo.getHizq()==null)
                return false;
            else 
                return FindAux((NodoUrl)pNodo.getHizq(), pNodoToSearch, lastCantP);
        }
        return false;
    }
    
    /**
     * metodo privado para poder calcular la profundidad de cada nodo
     * @param Hizq hijo izquierdo del nodo
     * @param Hder hijo derecho del nodo
     * @return retorna un dato int que se establece como profundidad del nodo
     */
    private int Heigth(NodoUrl Hizq, NodoUrl Hder){
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
     * metodo para realizar rotaciones simples a la Izquierda
     * @param pNodo recibe un dato del tipo NodoB
     */
    private NodoUrl rotacionSIzq(NodoUrl pNodo){
        NodoUrl padre= (NodoUrl)pNodo.getPadre();
        NodoUrl hder= (NodoUrl)pNodo.getHder();
        NodoUrl maxMIn= (NodoUrl)pNodo.getHder().getHizq();
        hder.setPadre(padre);
        hder.setHizq(pNodo);
        pNodo.setHder(maxMIn);
        if(padre!=null && (NodoUrl)padre.getHder()==pNodo)
            padre.setHder(hder);
        else if(padre!=null && (NodoUrl)padre.getHizq()==pNodo)
            padre.setHizq(hder);
        if(maxMIn!=null)
            maxMIn.setPadre(pNodo);
        return hder;
    }
    
    /**
     * metodo para realizar rotacion simple a la Derecha
     * @param pNodo recibe un dato del tipo NodoB
     */
    private NodoUrl rotacionSDer(NodoUrl pNodo){
        NodoUrl padre=(NodoUrl)pNodo.getPadre();
        NodoUrl hizq= (NodoUrl)pNodo.getHizq();
        NodoUrl minMAx=(NodoUrl)pNodo.getHizq().getHder();
        hizq.setHder(pNodo);
        hizq.setPadre(padre);
        pNodo.setHizq(minMAx);
        if(padre!=null && (NodoUrl)padre.getHder()==pNodo)
            padre.setHder(hizq);
        else if(padre!=null && (NodoUrl)padre.getHizq()==pNodo)
            padre.setHizq(hizq);
        if (minMAx!=null)
            minMAx.setPadre(pNodo);
        return hizq;
    }
    
    /**
     * metodo privado para establecer y revisar la altura de los nodos
     * este mismo realiza las rotaciones.
     */
    private void check(){
        NodoUrl tmp= _root;
        checkAux(tmp);
    }
    
    /**
     * metodo recursivo que va poniendo la profundidad, factor de equilibrio
     * y revisa si se ocupan hacer rotaciones en el arbol.
     * @param pNodo recibe un dato del tipo NodoB
     */
    private void checkAux(NodoUrl pNodo){
        if(pNodo==null)
            return;
        checkAux((NodoUrl)pNodo.getHizq());
        checkAux((NodoUrl)pNodo.getHder());
        pNodo.setDepth(Heigth((NodoUrl)pNodo.getHizq(), (NodoUrl)pNodo.getHder()));
        pNodo.setFE(FactorEquilibrio((NodoUrl)pNodo.getHizq(), (NodoUrl)pNodo.getHder()));
        //System.out.println("Profundidad: "+pNodo.getDepth()+"; Factor de equilibrio: "+ pNodo.getFE());
        if(pNodo==_root){
            if(pNodo.getFE()>1)
                _root=rotacionSDer(pNodo);
            else if(pNodo.getFE()<-1)
                _root=rotacionSIzq(pNodo);
        }
        else{
            if(pNodo.getFE()>1)
                rotacionSDer(pNodo);
            else if(pNodo.getFE()<-1)
                rotacionSIzq(pNodo);
        }
    }
    
    
    private void outSide(NodoUrl pNodo){
        if(true){}
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
