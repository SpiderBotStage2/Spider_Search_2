/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import Listas.NodoLUrl;
import logica.Constantes;

/**
 * clase para crear arboles rojo y negro
 * @author osboxes
 */
public class Arbol_RN extends Arbol_binario implements Constantes{
    
    private NodoLUrl _root;

    /**
     * metodo para retornar la raiz y realizar recorridos en el arbol.
     * @return retorna un dato de la clase NodoKeyword, este es la raiz del 
     * arbol.
     */
    public NodoLUrl getroot() {
        return _root;
    }
    
    /**
     * metodo para insertar datos en el arbol.
     * @param pNodo recibe un dato de la clase NodoLUrl, este sera el Url o
     * direccion que termina de procesar el Thread.
     */
    public void insert(NodoLUrl pNodo){
        if(_root==null){
            _root=pNodo;
            changeColor(_root);
        }
        else{
            insertAux(_root, pNodo);
        }
        check(pNodo);
    }
    
    /**
     * metodo recursivo para ingresar en el arbol
     * @param pPadre dato de la clase NodoLUrl, este es la raiz inicialmente, 
     * y sera a donde se aderir el nodo.
     * @param pDato dato de la clase NodoLUrl, es el nodo que queremos ingresar.
     */
    private void insertAux(NodoLUrl pPadre, NodoLUrl pDato){
        if(pDato.getDato().compareTo(pPadre.getDato())<0){   
            if((NodoLUrl)pPadre.getHizq()==null){
                pPadre.setHizq(pDato);
                pPadre.getHizq().setPadre(pPadre);
            }
            else
                insertAux(pPadre.getHizq(),pDato);
        }
        else if (pDato.getDato().compareTo(pPadre.getDato())>0)
            if(pPadre.getHder()==null){
                pPadre.setHder(pDato);
                pPadre.getHder().setPadre(pPadre);
            }
            else
                insertAux(pPadre.getHder(),pDato);
    }
    
    /**
     * metodo para revisar que el arbol cumpla con los requerimientos 
     * necesarios.
     * @param pNodo dato de la clase NodoLUrl, recibe el nodo que acabamos de 
     * ingresar.
     */
    private void check(NodoLUrl pNodo){
        if(pNodo==_root)
            return;
        checkAux(pNodo, pNodo.getPadre());
    }
    
    /**
     * metodo recursivo par air revisando el arbol desde abajo hacia arriba.
     * @param pNodo dato de la clase NodoLUrl, el nodo el cual acabamos de 
     * ingresar.
     * @param pPadre dato de la clase NodoLUrl, el padre nodo que acabamos de 
     * ingresar.
     */
    private void checkAux(NodoLUrl pNodo, NodoLUrl pPadre){
        if (pPadre==null){
            if(pNodo.getColor()==Rojo)
                changeColor(pNodo);
            _root=pNodo;
            return;
        }
        else if (pPadre.getPadre()==null){
            return;
        }
        else{
            NodoLUrl abuelo=pPadre.getPadre();
            NodoLUrl tio;
            if(abuelo.getHizq()==pPadre){
                tio=abuelo.getHder();
                if (pPadre.getColor()==Negro)
                    return;
                else if(tio==null){
                    if(pNodo==pPadre.getHizq()){
                        changeColor(pPadre);changeColor(abuelo);
                        abuelo=rotacionSDer(abuelo);
                        checkAux(abuelo, abuelo.getPadre());
                        return;
                    }else{
                        changeColor(pNodo);changeColor(abuelo);
                        abuelo=rotacionDDer(abuelo);
                        checkAux(abuelo, abuelo.getPadre());
                        return;
                    }
                }
                else if(tio.getColor()==Rojo){
                    changeColor(pPadre);changeColor(tio);changeColor(abuelo);
                    checkAux(abuelo, abuelo.getPadre());
                    return;
                }
                else if (tio.getColor()==Negro){
                    changeColor(abuelo);changeColor(pPadre);
                    abuelo=rotacionSDer(abuelo);
                    checkAux(pPadre, pPadre.getPadre());
                    return;
                }
            }else{
                tio=abuelo.getHizq();
                if (pPadre.getColor()==Negro)
                    return;
                else if(tio==null){
                    if(pNodo==pPadre.getHder()){
                        changeColor(pPadre);changeColor(abuelo);
                        abuelo=rotacionSIzq(abuelo);
                        checkAux(abuelo, abuelo.getPadre());
                        return;
                    }else{
                        changeColor(pNodo);changeColor(abuelo);
                        abuelo=rotacionDIzq(abuelo);
                        checkAux(abuelo, abuelo.getPadre());
                        return;
                    }
                }
                else if(tio.getColor()==Rojo){
                    changeColor(pPadre);changeColor(tio);changeColor(abuelo);
                    checkAux(abuelo, abuelo.getPadre());
                    return;
                }
                else if (tio.getColor()==Negro){
                    changeColor(abuelo);changeColor(pPadre);
                    abuelo=rotacionSIzq(abuelo);
                    checkAux(pPadre, pPadre.getPadre());
                    return;
                }
            }
        }
    }
    
    /**
     * metodo para realizar una rotacion simple hacia la izquierda contra un
     * nodo conflictivo.
     * @param pNodo dato de la clase NodoLUrl, es el nodo que vamos a rotar.
     * @return retorna la cabeza del resultado de la rotacion.
     */
    private NodoLUrl rotacionSIzq(NodoLUrl pNodo){
        NodoLUrl padre= pNodo.getPadre();
        NodoLUrl hder= pNodo.getHder();
        NodoLUrl maxMIn= pNodo.getHder().getHizq();
        hder.setPadre(padre);
        hder.setHizq(pNodo);
        pNodo.setPadre(hder);
        pNodo.setHder(maxMIn);
        if(padre!=null && padre.getHder()==pNodo)
            padre.setHder(hder);
        else if(padre!=null && padre.getHizq()==pNodo)
            padre.setHizq(hder);
        if(maxMIn!=null)
            maxMIn.setPadre(pNodo);
        return hder;
    }
    
    /**
     * metodo para realizar rotacion simple a la Derecha
     * @param pNodo recibe un dato del tipo NodoB
     */
    private NodoLUrl rotacionSDer(NodoLUrl pNodo){
        NodoLUrl padre= pNodo.getPadre();
        NodoLUrl hizq= pNodo.getHizq();
        NodoLUrl minMAx= pNodo.getHizq().getHder();
        hizq.setHder(pNodo);
        hizq.setPadre(padre);
        pNodo.setPadre(hizq);
        pNodo.setHizq(minMAx);
        if(padre!=null && padre.getHder()==pNodo)
            padre.setHder(hizq);
        else if(padre!=null && padre.getHizq()==pNodo)
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
    private NodoLUrl rotacionDDer(NodoLUrl pNodo){
        NodoLUrl padre= pNodo.getPadre();
        NodoLUrl hizqG= pNodo.getHizq().getHder().getHizq();
        NodoLUrl hderG= pNodo.getHizq().getHder().getHder();
        NodoLUrl hizq= pNodo.getHizq();
        NodoLUrl toHead= pNodo.getHizq().getHder();
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
    private NodoLUrl rotacionDIzq(NodoLUrl pNodo){
        NodoLUrl padre= pNodo.getPadre();
        NodoLUrl hizqG= pNodo.getHder().getHizq().getHizq();
        NodoLUrl hderG= pNodo.getHder().getHizq().getHder();
        NodoLUrl hder= pNodo.getHder();
        NodoLUrl toHead= pNodo.getHder().getHizq();
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
     * metodo para intercambiar el color del nodo
     * @param pNodo dato de la clase NodoLUrl, es el nodo al cual queremos 
     * intercambiarle el color.
     */
    private void changeColor(NodoLUrl pNodo){
        if(pNodo.getColor()==0)
            pNodo.setColor(1);
        else
            pNodo.setColor(0);
    }
    
    /**
     * metodo para imprimir nodos desde el arbol rojo y negro
     */
    public void print(){
        printIOD(_root);
    }
    
    /**
     * metodo recursivo que va imprimiendo en orden el contenido del arbol
     * @param tmp nodo padre
     */
    private void printIOD(NodoLUrl tmp){
        if(tmp==null)
            return;
        printIOD(tmp.getHizq());
        System.out.println(tmp.getDato());
        printIOD(tmp.getHder());
    }
    
    
}
