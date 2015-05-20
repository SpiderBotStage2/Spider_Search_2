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
     * metodo especial para ingresar datos en una rbol AVL
     * @param pDato dato que se ingres ay pertenece a la clase NodoUrl
     */
    public void insert(NodoUrl pDato){
        if (_root==null)
            _root=pDato;
        else
            insertAux( pDato, _root);
        if(isLeft(pDato))
            reLocate(pDato);
        check();
    }
    
    /**
     * metodo para ingresar datos en un arbol de manera recursiva.
     * @param pDato dato que se ingresa perteneciente a la clase NodoUrl.
     * @param pNodo dato padre para recursionar, pertenece a la clase 
     * NodoUrl.
     */
    private void insertAux(NodoUrl pDato, NodoUrl pNodo){
        if (pNodo.LengthP()==pDato.LengthP()){
            if(pNodo.getDato().compareTo(pDato.getDato())==0)
                pNodo=pDato;
            else if(pNodo.getDato().compareTo(pDato.getDato())<0){
                overPlaceIzq(pDato, pNodo);
            }
            else
                overPlaceDer(pDato, pNodo);
        }
        else{
            if(pNodo.LengthP()<pDato.LengthP()){   
                if(pNodo.getHizq()==null){
                    pNodo.setHizq(pDato);
                    ((NodoUrl)pNodo.getHizq()).setPadre(pNodo);
                }
                else
                    insertAux(pDato, (NodoUrl)pNodo.getHizq());
            }
            else{
                if(pNodo.getHder()==null){
                    pNodo.setHder(pDato);
                    ((NodoUrl)pNodo.getHder()).setPadre(pNodo);
                }
                else
                    insertAux(pDato,(NodoUrl)pNodo.getHder());
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
        if(minMAx!=null)
            minMAx.setPadre(pNodo);
        return hizq;
    }
    
    /**
     * metodo para realizar una doble rotacion hacia la derecha.
     * @param pNodo este dato pertenece a la clase NodoUrl.
     * @return retorna el nodo que ahora es la cabeza del movimiento.
     */
    private NodoUrl rotacionDDer(NodoUrl pNodo){
        NodoUrl padre= (NodoUrl)pNodo.getPadre();
        NodoUrl hizqG= (NodoUrl)pNodo.getHizq().getHder().getHizq();
        NodoUrl hderG= (NodoUrl)pNodo.getHizq().getHder().getHder();
        NodoUrl hizq= (NodoUrl)pNodo.getHizq();
        NodoUrl toHead= (NodoUrl)pNodo.getHizq().getHder();
        toHead.setPadre(padre);
        toHead.setHizq(hizq);
        toHead.setHder(pNodo);
        hizq.setPadre(toHead);
        hizq.setHder(hizqG);
        pNodo.setPadre(toHead);
        pNodo.setHizq(hderG);
        if(padre!=null && padre.getHder()==pNodo)
            padre.setHder(toHead);
        else if(padre!=null && padre.getHizq()==pNodo)
            padre.setHizq(toHead);
        if(hderG!=null)
            hderG.setPadre(pNodo);
        if (hizqG!=null)
            hizqG.setPadre(hizq);
        return toHead;
    }
    
    /**
     * metodo para realizar rotaciones hacia la izquierda.
     * @param pNodo dato que pertenece a la clase NodoUrl.
     * @return retorna el nodo que ahora es la cabeza del movimiento.
     */
    private NodoUrl rotacionDIzq(NodoUrl pNodo){
        NodoUrl padre= (NodoUrl)pNodo.getPadre();
        NodoUrl hizqG= (NodoUrl)pNodo.getHder().getHizq().getHizq();
        NodoUrl hderG= (NodoUrl)pNodo.getHder().getHizq().getHder();
        NodoUrl hder= (NodoUrl)pNodo.getHizq();
        NodoUrl toHead= (NodoUrl)pNodo.getHizq().getHder();
        toHead.setPadre(padre);
        toHead.setHder(hder);
        toHead.setHizq(pNodo);
        hder.setPadre(toHead);
        hder.setHizq(hderG);
        pNodo.setPadre(toHead);
        pNodo.setHder(hizqG);
        if(padre!=null && padre.getHder()==pNodo)
            padre.setHder(toHead);
        else if(padre!=null && padre.getHizq()==pNodo)
            padre.setHizq(toHead);
        if(hderG!=null)
            hderG.setPadre(hder);
        if (hizqG!=null)
            hizqG.setPadre(pNodo);
        return toHead;
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
        NodoUrl hijo = (NodoUrl)padre.getHizq();
        padre.setHder(pNodo);
        pNodo.setPadre(padre);
        pNodo.setHder(hijo);
        hijo.setPadre(pNodo);
    }
    
    /**
     * agarra el dato que se acaba de ingresar y compara si es necesario 
     * hacer recolocacion ya que el arbol se desorganiza.
     * @param pDato dato que pertenece a la clase NodoUrl y se usa para 
     * representar al que se va a mover.
     */
    private void reLocate(NodoUrl pDato){
        super.delete(pDato.getDato(),_root);
        insertAux(pDato, _root);
    }
    
    /**
     * metodo booleano para confirmar si un dato es izquierda en el arbol o no.
     * @param pDato dato que se va a confirmar y pertenece a la clase NoroUrl
     * @return retorna un booleano
     */
    public boolean isLeft(NodoUrl pDato){
        if(pDato==_root)
            return false;
        else
            return findAux(pDato, (NodoUrl)_root.getHizq());
    }

    /**
     * retorna una booleano confirmando si es izquierdo o no.
     * @param pDato dato con el que se compara.
     * @param pNodo dato padre para hacer la comparacion.
     * @return retorna un booleano.
     */
    private boolean findAux(NodoUrl pDato, NodoUrl pNodo){
        if (pNodo.getDato().compareTo(pDato.getDato())==0){
            if(pDato.LengthP()>_root.LengthP())
                return true;
            else
                return false;
        }
        else{
            if(pNodo.getDato().compareTo(pDato.getDato())>0){
                if((NodoUrl)pNodo.getHizq()==null)
                    return false;
                else
                    return findAux(pDato, (NodoUrl)pNodo.getHizq());
            }
            else{
                if((NodoUrl)pNodo.getHder()==null)
                    return false;
                else
                    return findAux(pDato, (NodoUrl)pNodo.getHder());
            }
        }
    }
}