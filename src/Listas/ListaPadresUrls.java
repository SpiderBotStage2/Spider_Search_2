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
public class ListaPadresUrls {
    private NodoPadresUrls _head;
    private NodoPadresUrls _tail;
    private int TotalWords;
    
    public void insert(NodoPadresUrls pNodo){
        if(_head==null){
            _head=pNodo;
            _tail=_head;
        }
        else{
            NodoPadresUrls tmp1=_tail;
            tmp1.setNext(pNodo);
            _tail=_tail.getNext();
        }
            
    }
}
