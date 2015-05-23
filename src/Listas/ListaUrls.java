/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 * clase creada para la base de datos para los urls que se van ingresando 
 * para ser procesados por los threads hijos del SpiderBot
 * @author osboxes <-------------------- nombre de la VM de ubuntu
 * @param <dp> generico para la clase
 */
public class ListaUrls<dp> extends ListaSdoble{
    
    private NodoLUrl _head;
    private NodoLUrl _tail;

    @Override
    public NodoLUrl getHead(){
        return _head;
    }
    
    @Override
    public NodoLUrl getTail(){
        return _tail;
    }
    
    /**
     * metodo especial para encolar a la lista de Urls que recibe la 
     * urls que se quiere y se le ingresa el nivel de profundidad.
     * @param dato la url que se ingresa 
     * @param depth nivel de profundidad.
     */
    public void enQueue(dp dato,int depth){
        if(_head==null){
            _head=_tail= new NodoLUrl(dato);
            _head.setDepth(depth);
        }
        else{
            NodoLUrl tmp1=_tail;
            tmp1.setNext(new NodoLUrl(dato));
            _tail=(NodoLUrl)tmp1.getNext();
            _tail.setDepth(depth);
        }
    }
    
    /**
     * metodo para borrar los head una vez que una Url ya se haya seleccionado
     */
    public NodoLUrl deQueue(){
        NodoLUrl tmp= _head;
        _head=(NodoLUrl)_head.getNext();
        return tmp;
    }
    
    /**
     * funcion para imprimir todo el contendio de la lista con la profundidad 
     * de cada uno de los nodos.
     */
    @Override
    public void print(){
        NodoLUrl tmp=_head;
        while (tmp!=null){
            System.out.println(tmp.getData()+" profundidad: "+ tmp.geDepth());
            tmp=(NodoLUrl)tmp.getNext();
        }
    }
    
    /**
     * metodo para ingresar urls no repetidas
     * @param dato
     * @param depth 
     */
    public void enQueue_none_repeat(dp dato, int depth){
        NodoLUrl tmp= _head;
        boolean check= false;
        while(tmp!=null&&!check){
            if(tmp.getData().equals(dato))
                check=true;
            tmp= (NodoLUrl)tmp.getNext();
        }
        if(!check){
            enQueue(dato, depth);
        }
        else
            System.out.println("urlrepetida: "+ dato);
    }
    
    /**
     * metodo de listaUrls para devolver el largo especifico.
     * @return int i
     */
    public int getLenght(){
        int i=0;
        NodoLUrl tmp= _head;
        while(tmp!=null){
            tmp=(NodoLUrl)tmp.getNext();
            i++;
        }
        return i;
    }
}
