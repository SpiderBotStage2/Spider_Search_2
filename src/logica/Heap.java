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
public class Heap implements Constantes{
    
    private int _tail=cero;
    private int _MaxSize=uno;
    private int _depthSize=cero;
    private String[] _arreglo= new String[_MaxSize];
    
    public void insert(String dato){
        if(_tail==_MaxSize)
            growArray();
        _arreglo[_tail]=dato;
        _tail++;
        check();
    }
    
    private void check(){
        if (_tail==_MaxSize)
            return;
        checkAux(uno);
        checkAux(dos);
    }
    
    private void checkAux(int pHijo){
        if(pHijo>= _MaxSize)
            return;
        checkAux((pHijo*dos)+uno);
        checkAux((pHijo*dos) +dos);
        if(_arreglo[pHijo]!=null && _arreglo[pHijo/dos].compareTo(_arreglo[pHijo])>cero)
            swap(pHijo);
    }
    
    private void growArray(){
        _depthSize++;
        double newMAxsize= (Math.pow(dos,_depthSize))+_MaxSize;
        String[] newArreglo= new String[(int)newMAxsize];
        System.arraycopy(_arreglo, cero, newArreglo, cero, _MaxSize);
        _MaxSize=(int)newMAxsize;
        _arreglo=newArreglo;
    }
    
    private void swap(int pHijo){
        int Ipadre= pHijo/dos;
        String hijo=_arreglo[pHijo];
        _arreglo[pHijo]=_arreglo[Ipadre];
        _arreglo[Ipadre]=hijo;
    }
    
    public void print(){
        int indice=cero;
        printAux(indice);
    }
    
    private void printAux(int pIndice){
        if(pIndice>=_MaxSize)
            return;
        printAux((pIndice*dos)+uno);
        System.out.println(_arreglo[pIndice]);
        printAux((pIndice*dos)+dos);
    }
}
