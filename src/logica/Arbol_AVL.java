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
public class Arbol_AVL <dp extends Comparable<dp>> extends MetodosPArbolesSP{
    
    private NodoUrl _root;
          
    /**
     * metodo especial para ingresar datos en una rbol AVL
     * @param pDato dato que se ingres ay pertenece a la clase NodoUrl
     */
    public void insert(NodoUrl pDato){
        if (_root==null)
            _root=pDato;
        else{
            NodoUrl ifExist= super.exist(pDato, _root);
            if (ifExist!=null)
                if(pDato.LengthP()>_root.LengthP() && isLeft(ifExist, (NodoUrl)_root.getHizq()))
                    reLocate(ifExist, pDato);
            else
                insertAux( pDato, _root);
        }
        check();
    }
    
    /**
     * metodo para ingresar datos en un arbol de manera recursiva.
     * @param pDato dato que se ingresa perteneciente a la clase NodoUrl.
     * @param pNodo dato padre para recursionar, pertenece a la clase 
     * NodoUrl.
     */
    private void insertAux(NodoUrl pDato, NodoUrl pRaiz){
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
                    ((NodoUrl)pRaiz.getHizq()).setPadre(pRaiz);
                }
                else
                    insertAux(pDato, (NodoUrl)pRaiz.getHizq());
            }
            else{
                if(pRaiz.getHder()==null){
                    pRaiz.setHder(pDato);
                    ((NodoUrl)pRaiz.getHder()).setPadre(pRaiz);
                }
                else
                    insertAux(pDato,(NodoUrl)pRaiz.getHder());
            }
        }
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
    private double FactorEquilibrio(NodoUrl Hizq, NodoUrl Hder){
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
     * metodo para realizar una colocacion forzada en la izquierda por 
     * si una palabra tiene la misma cantidad de datos que otra.
     * @param pNodo dato que incialmente el padre de donde va ingresar
     * @param padre dato de que se va ingresar
     * ambos datos, tanto como pNodo y padre son datos que pertenecen a la 
     * clase NodoUrl.
     */
    private void overPlaceIzq(NodoUrl pNodo, NodoUrl padre){
        NodoUrl hijo = (NodoUrl)padre.getHizq();
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
     * clase NodoUrl.
     */
    private void overPlaceDer(NodoUrl pNodo, NodoUrl padre){
        NodoUrl hijo = (NodoUrl)padre.getHder();
        padre.setHder(pNodo);
        pNodo.setPadre(padre);
        pNodo.setHder(hijo);
        if(hijo!=null)
            hijo.setPadre(pNodo);
    }
    
    /**
     * agarra el dato que se acaba de ingresar y compara si es necesario 
     * hacer recolocacion ya que el arbol se desorganiza.
     * @param pDato dato que pertenece a la clase NodoUrl y se usa para 
     * representar al que se va a mover.
     */
    private void reLocate(NodoUrl pDato, NodoUrl newInsert){
        
    }
    
    private boolean isLeft(NodoUrl pDato, NodoUrl pPadre){
        if(pDato==pPadre)
            return true;
        else if (pDato.LengthP()<pPadre.LengthP()){
            if(pPadre.getHizq()!=null)
                return isLeft(pDato, (NodoUrl)pPadre.getHizq());
            else
                return false;
        }
        else{
            if(pPadre.getHder()!=null)
                return isLeft(pDato, (NodoUrl)pPadre.getHder());
            else
                return false;
        }
    }
    
    public static void main(String[] args) {
        Arbol_AVL Nuevo= new Arbol_AVL();
        NodoUrl nuevo= new NodoUrl("A",3);
        NodoUrl nuevo1= new NodoUrl("B",8);
        NodoUrl nuevo2= new NodoUrl("D",7);
        NodoUrl nuevo3= new NodoUrl("C",1);
        NodoUrl nuevo4= new NodoUrl("F",3);
        NodoUrl nuevo5= new NodoUrl("A",9);
        Nuevo.insert(nuevo);
        Nuevo.insert(nuevo1);
        Nuevo.insert(nuevo2);
        Nuevo.insert(nuevo3);
        Nuevo.insert(nuevo4);
        //Nuevo.print();
        Nuevo.insert(nuevo4);
        Nuevo.insert(nuevo5);        
    }
}