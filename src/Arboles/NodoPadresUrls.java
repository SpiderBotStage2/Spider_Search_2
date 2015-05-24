/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import logica.Constantes;
/**
 *
 * @author osboxes
 */
public class NodoPadresUrls implements Constantes{
    
    private int _cantTotal;
    private String _dato;
    private NodoPadresUrls _next;
    private NodoPadresUrls _hder;
    private NodoPadresUrls _hizq;
    private NodoPadresUrls _padre;
    private int _color=Rojo;
    
    public NodoPadresUrls(String url){
        this._dato=url;
    }
    
    public void setDato(String dato){
        this._dato=dato;
    }
    
    public void setCantT(int cantT){
        this._cantTotal=cantT;
    }
    
    public void setNext(NodoPadresUrls next){
        this._next=next;
    }
    
    public void setHder(NodoPadresUrls hder){
        this._hder=hder;
    }
    
    public void setHizq(NodoPadresUrls hizq){
        this._hizq=hizq;
    }
    
    public void setPadre(NodoPadresUrls padre){
        this._padre=padre;
    }
    
    public void setColor(int color){
        this._color=color;
    }
    
    public String getDato(){
        return this._dato;
    }
    
    public NodoPadresUrls getHder(){
        return _hder;
    }
    
    public NodoPadresUrls getHizq(){
        return _hizq;
    }
    
    public NodoPadresUrls getPadre(){
        return _padre;
    }
    
    public NodoPadresUrls getNext(){
        return this._next;
    }
    
    public int getColor(){
        return _color;
    }
}
