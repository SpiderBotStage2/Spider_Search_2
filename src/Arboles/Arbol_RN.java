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
public class Arbol_RN  <dp extends Comparable<dp>> extends Arbol_binario implements Constantes{
    
    private NodoB _root;

    public void insert(NodoB pNodo){
        if(_root==null){
            _root=pNodo;
            changeColor(_root);
        }
        else{
            insertAux(_root, pNodo);
        }
        check(pNodo);
    }
    
    private void insertAux(NodoB pPadre, NodoB pDato){
        if(pDato.getDato().compareTo((dp)pPadre.getDato())<0){   
            if(pPadre.getHizq()==null){
                pPadre.setHizq(pDato);
                pPadre.getHizq().setPadre(pPadre);
            }
            else
                insertAux(pPadre.getHizq(),pDato);
        }
        else if (pDato.getDato().compareTo((dp)pPadre.getDato())>0)
            if(pPadre.getHder()==null){
                pPadre.setHder(pDato);
                pPadre.getHder().setPadre(pPadre);
            }
            else
                insertAux(pPadre.getHder(),pDato);
    }
    
    private void check(NodoB pNodo){
        if(pNodo==_root)
            return;
        checkAux(pNodo, pNodo.getPadre());
    }
    
    private void checkAux(NodoB pNodo, NodoB pPadre){
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
            NodoB abuelo=pPadre.getPadre();
            NodoB tio;
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
    
     private NodoB rotacionSIzq(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB hder= pNodo.getHder();
        NodoB maxMIn= pNodo.getHder().getHizq();
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
    private NodoB rotacionSDer(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB hizq= pNodo.getHizq();
        NodoB minMAx= pNodo.getHizq().getHder();
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
    private NodoB rotacionDDer(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB hizqG= pNodo.getHizq().getHder().getHizq();
        NodoB hderG= pNodo.getHizq().getHder().getHder();
        NodoB hizq= pNodo.getHizq();
        NodoB toHead= pNodo.getHizq().getHder();
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
    private NodoB rotacionDIzq(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB hizqG= pNodo.getHder().getHizq().getHizq();
        NodoB hderG= pNodo.getHder().getHizq().getHder();
        NodoB hder= pNodo.getHder();
        NodoB toHead= pNodo.getHder().getHizq();
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
    
    private void changeColor(NodoB pNodo){
        if(pNodo.getColor()==0)
            pNodo.setColor(1);
        else
            pNodo.setColor(0);
    }
    
    @Override
    public void print() {
        super.print(_root); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        Arbol_RN Nuevo = new Arbol_RN();
        NodoB nuevo= new NodoB(6);
        NodoB nuevo1= new NodoB(7);
        NodoB nuevo2= new NodoB(8);
        NodoB nuevo3= new NodoB(9);
        NodoB nuevo4= new NodoB(10);
        Nuevo.insert(nuevo);
        Nuevo.insert(nuevo1);
        Nuevo.insert(nuevo2);
        Nuevo.insert(nuevo3);
        Nuevo.insert(nuevo4);
        Nuevo.print();
    }   
}
