/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 *
 * @author osboxes
 */
public class NodoPadresUrls{
    
    private int _cantTotal;
    private String _dato;
    private NodoPadresUrls _next;
    
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
    
    public NodoPadresUrls getNext(){
        return this._next;
    }
    
    public String getDato(){
        return this._dato;
    }
}
