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
public class Heap {
    
    private static final int _root=0;
    private int _tail=_root;
    private int _MaxSize=1;
    private static final double _growP=2;
    private int _depthSize=0;
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
        checkAux((_root*2)+1);
        checkAux((_root*2)+2);
    }
    
    private void checkAux(int pHijo){
        if(pHijo>= _MaxSize)
            return;
        checkAux((pHijo*2)+1);
        checkAux((pHijo*2) +2);
        if(_arreglo[pHijo]!=null && _arreglo[pHijo/2].compareTo(_arreglo[pHijo])>0)
            swap(pHijo);
    }
    
    private void growArray(){
        _depthSize++;
        double newMAxsize= (Math.pow(_growP,_depthSize))+_MaxSize;
        String[] newArreglo= new String[(int)newMAxsize];
        System.arraycopy(_arreglo, 0, newArreglo, 0, _MaxSize);
        _MaxSize=(int)newMAxsize;
        _arreglo=newArreglo;
    }
    
    private void swap(int pHijo){
        int Ipadre= pHijo/2;
        String hijo=_arreglo[pHijo];
        _arreglo[pHijo]=_arreglo[Ipadre];
        _arreglo[Ipadre]=hijo;
    }
    
    public void print(){
        int indice=_root;
        printAux(indice);
    }
    
    private void printAux(int pIndice){
        if(pIndice>=_MaxSize)
            return;
        printAux((pIndice*2)+1);
        System.out.println(_arreglo[pIndice]);
        printAux((pIndice*2)+2);
    }
}
