/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import static logica.Constantes.crecimientoArreglo;

/**
 * clase creada para agregarle metodos a los arboles sin tener que sobrecargar
 * de codigo las clases de arboles, este es usado mayor mente por arboles 
 * AVL.
 * @author osboxes
 */
public class MetodosPArbolesSP extends Arbol_binario{
    
    /**
     * metodo para revisar si el nodo ya existe en el arbol
     * @param pNodo dato de la clase NodoKeyword, recibe el nodo que se busca.
     * @param _root dato de la clase NodoKeyword, esta va a ser la raiz.
     * @return dato de la clase NodoKeyword y retorna un nulo si no existe y un nodo
     * valido, si existe el nodo.
     */
    public NodoKeyword exist(NodoKeyword pNodo, NodoKeyword _root){
        if (pNodo.getDato().compareTo(_root.getDato())==0)
            return _root;
        else
            return existAux(_root, pNodo);
    }
    
    /**
     * metodo para revisar si existe un nodo en el arbol, la manera implementada
     * es utilizando recursividad y realizando un recorrido en orden.
     * @param pNodo Dato de la clase NodoKeyword, el nodo con que compara.
     * @param pDato Dato de la clase NodoKeyword, el nodo al que se le compara.
     * @return retorna un null si no existe, si existe se retorna un dato no 
     * nulo.
     */
    private NodoKeyword existAux(NodoKeyword pNodo, NodoKeyword pDato){
        if (pNodo==null)
            return null;
        NodoKeyword hizq= existAux((NodoKeyword)pNodo.getHizq(), pDato);
        if (hizq!=null)
            return hizq;
        if(pNodo.getDato().compareTo(pDato.getDato())==0)
            return pNodo;
        NodoKeyword hder=existAux((NodoKeyword)pNodo.getHder(), pDato);
        if (hder!=null)
            return hder;
        else return null;
    }
    
    public String[] growArray( int pMaxSize, String[] pArreglo){
        double newMAxsize= (crecimientoArreglo)+pMaxSize;
        String[] newArreglo= new String[(int)newMAxsize];
        System.arraycopy(pArreglo, 0, newArreglo, 0, pMaxSize);
        pMaxSize=(int)newMAxsize;
        pArreglo=newArreglo;
        return pArreglo;
    }
    
     /**
     * metodo para realizar rotaciones simples a la Izquierda
     * @param pNodo recibe un dato del tipo NodoB
     * @return retorna el nodo que ahora sera la cabeza de las rotacion.
     */
    public NodoKeyword rotacionSIzq(NodoKeyword pNodo){
        NodoKeyword padre= (NodoKeyword)pNodo.getPadre();
        NodoKeyword hder= (NodoKeyword)pNodo.getHder();
        NodoKeyword maxMIn= (NodoKeyword)pNodo.getHder().getHizq();
        hder.setPadre(padre);
        hder.setHizq(pNodo);
        pNodo.setPadre(hder);
        pNodo.setHder(maxMIn);
        if(padre!=null && (NodoKeyword)padre.getHder()==pNodo)
            padre.setHder(hder);
        else if(padre!=null && (NodoKeyword)padre.getHizq()==pNodo)
            padre.setHizq(hder);
        if(maxMIn!=null)
            maxMIn.setPadre(pNodo);
        return hder;
    }
    
    /**
     * metodo para realizar rotacion simple a la Derecha
     * @param pNodo recibe un dato del tipo NodoB
     * @return retorna el nodo que ahora sera la cabeza luego de la rotacion
     */
    public NodoKeyword rotacionSDer(NodoKeyword pNodo){
        NodoKeyword padre=(NodoKeyword)pNodo.getPadre();
        NodoKeyword hizq= (NodoKeyword)pNodo.getHizq();
        NodoKeyword minMAx=(NodoKeyword)pNodo.getHizq().getHder();
        hizq.setHder(pNodo);
        hizq.setPadre(padre);
        pNodo.setPadre(hizq);
        pNodo.setHizq(minMAx);
        if(padre!=null && (NodoKeyword)padre.getHder()==pNodo)
            padre.setHder(hizq);
        else if(padre!=null && (NodoKeyword)padre.getHizq()==pNodo)
            padre.setHizq(hizq);
        if(minMAx!=null)
            minMAx.setPadre(pNodo);
        return hizq;
    }
    
    /**
     * metodo para realizar una doble rotacion hacia la derecha.
     * @param pNodo este dato pertenece a la clase NodoKeyword.
     * @return retorna el nodo que ahora es la cabeza del movimiento.
     */
    public NodoKeyword rotacionDDer(NodoKeyword pNodo){
        NodoKeyword padre= (NodoKeyword)pNodo.getPadre();
        NodoKeyword hizqG= (NodoKeyword)pNodo.getHizq().getHder().getHizq();
        NodoKeyword hderG= (NodoKeyword)pNodo.getHizq().getHder().getHder();
        NodoKeyword hizq= (NodoKeyword)pNodo.getHizq();
        NodoKeyword toHead= (NodoKeyword)pNodo.getHizq().getHder();
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
     * @param pNodo dato que pertenece a la clase NodoKeywords.
     * @return retorna el nodo que ahora es la cabeza del movimiento.
     */
    public NodoKeyword rotacionDIzq(NodoKeyword pNodo){
        NodoKeyword padre= (NodoKeyword)pNodo.getPadre();
        NodoKeyword hizqG= (NodoKeyword)pNodo.getHder().getHizq().getHizq();
        NodoKeyword hderG= (NodoKeyword)pNodo.getHder().getHizq().getHder();
        NodoKeyword hder= (NodoKeyword)pNodo.getHder();
        NodoKeyword toHead= (NodoKeyword)pNodo.getHder().getHizq();
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
     * metodo para devolver el menor de los mayores
     * @param pNodo
     * @return un nodoB
     */
    private NodoKeyword minMax(NodoKeyword pNodo){
        if(pNodo.getHizq()==null)
            return pNodo;
        else if(pNodo.getHizq().getHizq()!=null)
            return minMax((NodoKeyword)pNodo.getHizq());
        else 
            return pNodo;
    }
    
    /**
     * meotodo de borrado para cualquier arbol AVL
     * @param dato dato generico
     * @param pNodo el nodo raiz del arbol
     * @return retorna el nodo Aux convertido ahora en la raiz
     */
    public NodoKeyword delete(NodoKeyword dato, NodoKeyword pNodo){
        if(pNodo==null)
            return null;
        return deleteSP(dato, pNodo);
    }
    
    /**
     * metodo especial, recursivo, que se utiliza para eliminar un nodo en el 
     * arbol AVL.
     * @param dato dato de la clase NodoKeyword, se le ingresa el nodo a eliminar.
     * @param pNodo dato de la clase NodoKeyword, se ingresa el nodo acomparacion.
     * @return retorna la nueva raiz del arbol, por si acaso se cambia o 
     * elimina la raiz.
     */
    private NodoKeyword deleteSP(NodoKeyword dato, NodoKeyword pNodo){
        if(pNodo.getDato().equals(dato.getDato())){
            if((NodoKeyword)pNodo.getHizq()==null)
                return (NodoKeyword)pNodo.getHder();
            else if ((NodoKeyword)pNodo.getHder()==null)
                return (NodoKeyword)pNodo.getHizq();
            else{
                NodoKeyword Aux = minMax((NodoKeyword)pNodo.getHder());
                if(Aux==pNodo.getHder()){
                    Aux.setHizq(pNodo.getHizq());
                    return Aux;
                }
                NodoKeyword menor= (NodoKeyword)Aux.getHizq();
                menor.setHizq((NodoKeyword)pNodo.getHizq());
                NodoKeyword menor_hder= (NodoKeyword)menor.getHder();
                menor.setHder((NodoKeyword)pNodo.getHder());
                pNodo.setHder((NodoKeyword)menor_hder);
                if((NodoKeyword)Aux.getHizq()==menor){
                    Aux.setHizq((NodoKeyword)menor_hder);
                }
                else{
                    Aux.setHder((NodoKeyword)menor_hder);
                }
                return menor;
            }
        }
        else if(dato.LengthP()<pNodo.LengthP()){
            pNodo.setHizq(deleteSP(dato, (NodoKeyword)pNodo.getHizq()));
            return pNodo;
        }
        else{
            pNodo.setHder(deleteSP(dato, (NodoKeyword)pNodo.getHder()));
            return pNodo;
        }
    }

    
    public NodoKeyword borrar(NodoKeyword pNodo){
        if((NodoKeyword)pNodo.getHizq()==null)
            return (NodoKeyword)pNodo.getHder();
        else if ((NodoKeyword)pNodo.getHder()==null)
            return (NodoKeyword)pNodo.getHizq();
        else{
            NodoKeyword Aux = minMax((NodoKeyword)pNodo.getHder());
            if(Aux==pNodo.getHder()){
                ((NodoKeyword)pNodo.getHizq()).setPadre(Aux);
                Aux.setHizq(pNodo.getHizq());
                return Aux;
            }
            NodoKeyword menor= (NodoKeyword)Aux.getHizq();
            ((NodoKeyword)pNodo.getHizq()).setPadre(menor);
            menor.setHizq((NodoKeyword)pNodo.getHizq());
            NodoKeyword menor_hder= (NodoKeyword)menor.getHder();
            ((NodoKeyword)pNodo.getHder()).setPadre(menor);
            menor.setHder((NodoKeyword)pNodo.getHder());
            pNodo.setHder((NodoKeyword)menor_hder);
            if((NodoKeyword)Aux.getHizq()==menor){
                Aux.setHizq((NodoKeyword)menor_hder);
            }
            else{
                Aux.setHder((NodoKeyword)menor_hder);
            }
            if(menor_hder!=null)
                    menor_hder.setPadre(Aux);
            return menor;
        }
    }
    
    /**
     * metodo para arboles diferentes del binario
     * @param pNodo nodo raiz del arbol
     */
    public void print(NodoB pNodo){
        NodoB tmp=pNodo;
        printIOD(tmp);
    }
    
    /**
     * metodo recursivo que va imprimiendo en orden el contenido del arbol
     * @param tmp nodo padre
     */
    private void printIOD(NodoB tmp){
        if(tmp==null)
            return;
        printIOD(tmp.getHizq());
        System.out.println(tmp.getDato());
        printIOD(tmp.getHder());
    }
}
