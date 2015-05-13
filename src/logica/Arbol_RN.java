/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 * clase para crear arboles rojo y negro
 * @author osboxes
 * @param <dp>
 */
public class Arbol_RN  <dp extends Comparable<dp>> extends Arbol_binario{
    
    private NodoB _root;

    @Override
    public void insert(Comparable dato) {
        _root=super.insert(dato, _root);
        check();
    }
    
    private void check(){
        if (_root.getColor()==1)
            changeColor(_root);
        checkAux(_root);
    }
    
    private void checkAux(NodoB pNodo){
        
    }
    
    private void changeColor(NodoB pNodo){
        if(pNodo.getColor()==1)
            pNodo.setColor(2);
        else
            pNodo.setColor(1);
    }
}
