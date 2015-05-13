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
    
    private int _root=0;
    private int _tail=_root;
    private int _MaxSize=0;
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
        checkAux(_root*2);
        checkAux((_root*2)+1);
    }
    
    private void checkAux(int pHijo){
        if(_arreglo[pHijo]==null)
            return;
        checkAux(pHijo*2);
        checkAux((pHijo*2) +1);
        if(_arreglo[pHijo/2].compareTo(_arreglo[pHijo])>0)
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
        if(_arreglo[pIndice]==null)
            return;
        printAux(pIndice*2);
        System.out.println(_arreglo[pIndice]);
        printAux((pIndice*2)+1);
    }
    
    public static void main(String[] args) {
        Heap nuevo= new Heap();
        nuevo.insert("1");
        nuevo.insert("5");
        nuevo.insert("10");
        nuevo.insert("2");
        nuevo.print();
    }
}
