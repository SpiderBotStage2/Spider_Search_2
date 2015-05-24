/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import logica.Constantes;

/**
 * clase para crear arboles rojo y negro
 * @author osboxes
 * @param <dp>
 */
public class Arbol_RN extends Arbol_binario implements Constantes{
    
    private NodoPadresUrls _root;

    public void insert(NodoPadresUrls pNodo){
        if(_root==null){
            _root=pNodo;
            changeColor(_root);
        }
        else{
            insertAux(_root, pNodo);
        }
        check(pNodo);
    }
    
    private void insertAux(NodoPadresUrls pPadre, NodoPadresUrls pDato){
        if(pDato.getDato().compareTo(pPadre.getDato())<0){   
            if((NodoPadresUrls)pPadre.getHizq()==null){
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
    
    private void check(NodoPadresUrls pNodo){
        if(pNodo==_root)
            return;
        checkAux(pNodo, pNodo.getPadre());
    }
    
    private void checkAux(NodoPadresUrls pNodo, NodoPadresUrls pPadre){
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
            NodoPadresUrls abuelo=pPadre.getPadre();
            NodoPadresUrls tio;
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
    
     private NodoPadresUrls rotacionSIzq(NodoPadresUrls pNodo){
        NodoPadresUrls padre= pNodo.getPadre();
        NodoPadresUrls hder= pNodo.getHder();
        NodoPadresUrls maxMIn= pNodo.getHder().getHizq();
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
    private NodoPadresUrls rotacionSDer(NodoPadresUrls pNodo){
        NodoPadresUrls padre= pNodo.getPadre();
        NodoPadresUrls hizq= pNodo.getHizq();
        NodoPadresUrls minMAx= pNodo.getHizq().getHder();
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
    private NodoPadresUrls rotacionDDer(NodoPadresUrls pNodo){
        NodoPadresUrls padre= pNodo.getPadre();
        NodoPadresUrls hizqG= pNodo.getHizq().getHder().getHizq();
        NodoPadresUrls hderG= pNodo.getHizq().getHder().getHder();
        NodoPadresUrls hizq= pNodo.getHizq();
        NodoPadresUrls toHead= pNodo.getHizq().getHder();
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
    private NodoPadresUrls rotacionDIzq(NodoPadresUrls pNodo){
        NodoPadresUrls padre= pNodo.getPadre();
        NodoPadresUrls hizqG= pNodo.getHder().getHizq().getHizq();
        NodoPadresUrls hderG= pNodo.getHder().getHizq().getHder();
        NodoPadresUrls hder= pNodo.getHder();
        NodoPadresUrls toHead= pNodo.getHder().getHizq();
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
    
    private void changeColor(NodoPadresUrls pNodo){
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
    private void printIOD(NodoPadresUrls tmp){
        if(tmp==null)
            return;
        printIOD(tmp.getHizq());
        System.out.println(tmp.getDato());
        printIOD(tmp.getHder());
    }
    
    
}
