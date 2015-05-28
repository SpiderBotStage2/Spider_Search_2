/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author osboxes
 */
public class serverThread extends Thread{
    
    private DataInputStream _InputData;
    private DataOutputStream _OutputData;
    private String _MessageIn;
    private Socket _socket;
    private int _ID;
    private boolean _bandera=true;
    private String _nombreDeArchivo;
    
    public serverThread(Socket socket ,int ID){
        this._socket= socket;
        this._ID=ID;
        this._nombreDeArchivo="info"+ String.valueOf(_ID)+".xml";
        try{
            _InputData= new DataInputStream(socket.getInputStream());
            _OutputData= new DataOutputStream(socket.getOutputStream());
        }catch(IOException e){
            System.out.println(e);
        }
    }

    /**
     * metodo que realiza una desconexion con el cliente que se haya 
     * inicializado.
     */
    public void desconectar(){
        try{
            _socket.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    /**
     * metodo thread que inicializa una vez que se recibe y acepta 
     * a un cliente.
     */
    @Override
    public void run(){
        System.out.println("entro en el run");
        while(_bandera){
            try{
                _MessageIn=_InputData.readUTF();
                if (_MessageIn.equals("out")){
                    desconectar();
                    _bandera=false;
                }
                else {
                    String[] mensajes= _MessageIn.split(",");
                    try{
                        
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }

            }catch(IOException e){
                    System.out.println("Player id: "+_ID+e.getMessage());
                    _bandera=false;

            }
        }
    }
    
    /**
     * metodo para enviar un mensaje al cliente con el cual se este 
     * interactuando. 
     */
    public void enviarDato(){
        try{
            _socket.setSoTimeout( 2000 );
            _socket.setKeepAlive( true );
            File archivo = new File(_nombreDeArchivo);
            int tamañoArchivo = ( int )archivo.length();
            // Enviamos el nombre del archivo
            _OutputData.writeUTF( archivo.getName() );

            // Enviamos el tamaño del archivo
            _OutputData.writeInt( tamañoArchivo );

            // Creamos flujo de entrada para realizar la lectura del archivo en bytes
            FileInputStream fis = new FileInputStream( _nombreDeArchivo );
            BufferedOutputStream bos;
            // Creamos el flujo de salida para enviar los datos del archivo en bytes
            try (BufferedInputStream bis = new BufferedInputStream( fis )){
                // Creamos el flujo de salida para enviar los datos del archivo en bytes
                bos = new BufferedOutputStream( _socket.getOutputStream());
                // Creamos un array de tipo byte con el tamaño del archivo
                byte[] buffer = new byte[ tamañoArchivo ];
                // Leemos el archivo y lo introducimos en el array de bytes
                bis.read( buffer );
                // Realizamos el envio de los bytes que conforman el archivo
                for( int i = 0; i < buffer.length; i++ )
                {
                    bos.write( buffer[ i ] );
                } 
                System.out.println("Archivo Enviado: "+archivo.getName());
                // Cerramos socket y flujos
                }
            bos.close();
            } 
        catch(Exception e){
            
        }
        
    }
}
