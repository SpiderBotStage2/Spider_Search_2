/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author osboxes
 */
public class MetodosPArbolesSP {
    
    public NodoUrl exist(NodoUrl pNodo, NodoUrl _root){
        if (pNodo.getDato().compareTo(_root.getDato())==0)
            return _root;
        else
            return existAux(_root, pNodo);
    }
    
    public NodoUrl existAux(NodoUrl pNodo, NodoUrl pDato){
        if (pNodo==null)
            return null;
        NodoUrl hizq= existAux((NodoUrl)pNodo.getHizq(), pDato);
        if (hizq!=null)
            return hizq;
        if(pNodo.getDato().compareTo(pDato.getDato())==0)
            return pNodo;
        NodoUrl hder=existAux((NodoUrl)pNodo.getHizq(), pDato);
        if (hder!=null)
            return hder;
        else return null;
    }
    
     /**
     * metodo para realizar rotaciones simples a la Izquierda
     * @param pNodo recibe un dato del tipo NodoB
     */
    public NodoUrl rotacionSIzq(NodoUrl pNodo){
        NodoUrl padre= (NodoUrl)pNodo.getPadre();
        NodoUrl hder= (NodoUrl)pNodo.getHder();
        NodoUrl maxMIn= (NodoUrl)pNodo.getHder().getHizq();
        hder.setPadre(padre);
        hder.setHizq(pNodo);
        pNodo.setPadre(hder);
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
    public NodoUrl rotacionSDer(NodoUrl pNodo){
        NodoUrl padre=(NodoUrl)pNodo.getPadre();
        NodoUrl hizq= (NodoUrl)pNodo.getHizq();
        NodoUrl minMAx=(NodoUrl)pNodo.getHizq().getHder();
        hizq.setHder(pNodo);
        hizq.setPadre(padre);
        pNodo.setPadre(hizq);
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
        NodoUrl hder= (NodoUrl)pNodo.getHder();
        NodoUrl toHead= (NodoUrl)pNodo.getHder().getHizq();
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
    private NodoB minMax(NodoB pNodo){
        if(pNodo.getHizq()==null)
            return pNodo;
        else if(pNodo.getHizq().getHizq()!=null)
            return minMax(pNodo.getHizq());
        else 
            return pNodo;
    }
    
    private NodoUrl deleteSP(NodoUrl dato, NodoUrl pNodo){
        if(pNodo.getDato().equals(dato.getDato())){
            if((NodoUrl)pNodo.getHizq()==null)
                return (NodoUrl)pNodo.getHder();
            else if ((NodoUrl)pNodo.getHder()==null)
                return (NodoUrl)pNodo.getHizq();
            else{
                NodoUrl Aux = (NodoUrl)minMax(pNodo.getHder());
                if(Aux==pNodo.getHder()){
                    Aux.setHizq(pNodo.getHizq());
                    return Aux;
                }
                NodoUrl menor= (NodoUrl)Aux.getHizq();
                menor.setHizq((NodoUrl)pNodo.getHizq());
                NodoUrl menor_hder= (NodoUrl)menor.getHder();
                menor.setHder((NodoUrl)pNodo.getHder());
                pNodo.setHder((NodoUrl)menor_hder);
                if((NodoUrl)Aux.getHizq()==menor)
                    Aux.setHizq((NodoUrl)menor_hder);
                else
                    Aux.setHder((NodoUrl)menor_hder);
                return menor;
            }
        }
        else if(dato.LengthP()<pNodo.LengthP()){
            pNodo.setHizq(deleteSP(dato, (NodoUrl)pNodo.getHizq()));
            return pNodo;
        }
        else{
            pNodo.setHder(deleteSP(dato, (NodoUrl)pNodo.getHder()));
            return pNodo;
        }
    }
}
