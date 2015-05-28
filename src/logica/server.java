/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import static logica.Constantes.crecimientoArreglo;
/**
 *
 * @author osboxes
 */
public class server{
    private ServerSocket _servidor;
    private Socket _socket;
    private boolean _listening;
    private int _ID;
    private int _puerto;
    private serverThread[] _hilos= new serverThread[5];

    public server() throws IOException{
        _listening=true;
        _ID=0;
        _puerto=5005;
        try{
            _servidor = new ServerSocket(_puerto);
            System.out.println("esperando cliente");
            while (_listening){
                _socket= _servidor.accept();
                System.out.print("socket de cliente"+ _ID +" :" +_socket);
                if (_ID==_hilos.length)
                    growArray(_ID, _hilos);
                _hilos[_ID]=new serverThread(_socket,_ID);
                _hilos[_ID].start();
                _ID++;
            }
        }catch(IOException e){
                System.out.println(e.getMessage());
        }	
    }
    
    public serverThread[] growArray( int pMaxSize, serverThread[] pArreglo){
        double newMAxsize= (crecimientoArreglo)+pMaxSize;
        serverThread[] newArreglo= new serverThread[(int)newMAxsize];
        System.arraycopy(pArreglo, 0, newArreglo, 0, pMaxSize);
        pMaxSize=(int)newMAxsize;
        pArreglo=newArreglo;
        return pArreglo;
    }
}
