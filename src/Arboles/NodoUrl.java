/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import Listas.ListaUrls;
/**
 *
 * @author osboxes
 */
public class NodoUrl  extends NodoB{
    
    private int countPpage;
    private ListaUrls listaUrlsPadres;
    
    /**
     * contructor que recibe la palabra, el url o direccion en disco del archivo
     * y la cantidad de veces de aparicion de la palabra
     * @param pData dato String que recibe la palabra que se va a ingresar
     * @param cantAp la cantidad total de veces que aparecio la palabra en 
     * ese archivo.
     * */
    public NodoUrl(String pData, int cantAp) {
        super(pData);
        this.countPpage=cantAp;
        this.listaUrlsPadres=new ListaUrls();
    }

    @Override
    public NodoB getPadre() {
        return super.getPadre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable getDato() {
        return super.getDato(); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public NodoB getHizq() {
        return super.getHizq(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodoB getHder() {
        return super.getHder(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getFE() {
        return super.getFE(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDepth() {
        return super.getDepth(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void SumCont(int cant){
        this.countPpage+=cant;
    }
    
    @Override
    public void setPadre(NodoB padre) {
        super.setPadre(padre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHizq(NodoB hizq) {
        super.setHizq(hizq); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHder(NodoB hder) {
        super.setHder(hder); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFE(double fe) {
        super.setFE(fe); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDepth(int depth) {
        super.setDepth(depth); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setListaPadresUrls(ListaUrls lista){
        this.listaUrlsPadres=lista;
    }
    
    public ListaUrls getListaPadresUrls(){
        return this.listaUrlsPadres;
    }
    /**
     * retorna la cantidad de apariciones de la palabra contenida en el nodo
     * @return 
     */
    public int LengthP(){
        return countPpage;
    }
}
