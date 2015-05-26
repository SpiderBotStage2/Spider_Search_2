/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 * clase de lista que sive como padre para todas las otras otras clases
 * que hagan listas o sirvan como bases de datos.
 *
 * @author osboxes <------asi se llama la maquina virtual en ubuntu
 * @param <dp>
 */
public class ListaSdoble <dp extends Comparable<dp>>{
    
    private Nodo _head;
    private Nodo _tail;
    
    /**
     * encola en una lista doble simple los nodos que se ocupen 
     * @param dato 
     */
    public void enQueue(dp dato){
        if (_head==null){
            _head=_tail=new Nodo(dato);
        }
        else{
            Nodo tmp1=_tail;
            tmp1.setNext( new Nodo(dato));
            _tail=(Nodo)tmp1.getNext();
            _tail.setPrev(tmp1);
        }
    }
    
    /**
     * devuelve la cabeza de la lista o el primer nodo que se ingreso
     * @return 
     */
    public Nodo getHead(){
        return _head;
    }
    
    /**
     * devuelve la cola de la lista o el ulrimo nodo ingresado
     * @return 
     */
    public Nodo getTail(){
        return _tail;
    }
    
    /**
     * recive un dato y va buscando en toda lista si existe un nodo 
     * que contenga tal valor, de encontrarlo lo elimina, si no lo encuentra
     * alerta un null.
     * @param dato 
     */
    public void deQueue(dp dato){
        Nodo tmp=_head;
        Nodo tmp2=tmp;
        while(tmp!=null|| !tmp.getData().equals(dato)){
            tmp2=tmp;
            tmp=tmp.getNext();
        }
        if(tmp==null)
            return;
        else if(tmp==tmp2 && tmp.getData().equals(dato))
            _head=(Nodo)_head.getData();
        else{
            if(tmp2.getData().equals(dato))
                tmp2.setNext(tmp.getNext());
            else
                return;
        }
    }
    
    /**
     * metodo para devolver la cantidad numerica de datos encontrados 
     * en la lista 
     * @return i;
     */
    public int getLength(){
        Nodo tmp=_head;
        int i =0;
        while(tmp!=null){
            i++;
            tmp= tmp.getNext();
        }
        return i;
    }
    
    public void print(){
        Nodo tmp=_head;
        while(tmp!=null){
            System.out.println(tmp.getData());
            tmp=tmp.getNext();
        }
    }
    /**
     * hace casi lo mismo que el metodo de borrado pero no lo elimina, solo
     * devuelve el valor del nodo.
     * @param dato
     * @return 
     */
    public dp find(dp dato){
        Nodo tmp =_head;
        while(tmp!=null||tmp.getData().equals(dato)){
            tmp=tmp.getNext();
        }
        return (dp)tmp.getData();
    }
}
