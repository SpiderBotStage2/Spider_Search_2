/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package TCP_IP;

/**
 *
 * @author luis
 */
import java.net.*;
import java.io.*;

class EnviarArchivo
{
         private String nombreArchivo = "";
         
         public EnviarArchivo( String nombreArchivo )
         {
              this.nombreArchivo = nombreArchivo;
         }
       
         public void enviarArchivo( )
         {
         
          try
          {
         
            //Creamos la direccion IP de la maquina que recibira el archivo
            InetAddress direccion = InetAddress.getByName("172.26.109.144");
         
              try (// Creamos el Socket con la direccion y elpuerto de comunicacion
                      Socket socket = new Socket( direccion, 4400 )) {
                  socket.setSoTimeout( 2000 );
                  socket.setKeepAlive( true );
                  
                  // Creamos el archivo que vamos a enviar
                  File archivo = new File( nombreArchivo );
                  
                  // Obtenemos el tamaño del archivo
                  int tamañoArchivo = ( int )archivo.length();
                  
                  // Creamos el flujo de salida, este tipo de flujo nos permite
                  // hacer la escritura de diferentes tipos de datos tales como
                  // Strings, boolean, caracteres y la familia de enteros, etc.
                  DataOutputStream dos = new DataOutputStream( 
                          socket.getOutputStream() );
                  
                  System.out.println( "Enviando Archivo: "+archivo.getName() );
                  
                  // Enviamos el nombre del archivo
                  dos.writeUTF( archivo.getName() );
                  
                  // Enviamos el tamaño del archivo
                  dos.writeInt( tamañoArchivo );
                  
                  // Creamos flujo de entrada para realizar la lectura del archivo en bytes
                  FileInputStream fis = new FileInputStream( nombreArchivo );
                  BufferedOutputStream bos;
                // Creamos el flujo de salida para enviar los datos del archivo en bytes
                try (BufferedInputStream bis = new BufferedInputStream( fis )){
                    // Creamos el flujo de salida para enviar los datos del archivo en bytes
                    bos = new BufferedOutputStream( socket.getOutputStream());
                    // Creamos un array de tipo byte con el tamaño del archivo
                    byte[] buffer = new byte[ tamañoArchivo ];
                    // Leemos el archivo y lo introducimos en el array de bytes
                    bis.read( buffer );
                    // Realizamos el envio de los bytes que conforman el archivo
                    for( int i = 0; i < buffer.length; i++ )
                    {
                        bos.write( buffer[ i ] );
                    } System.out.println("Archivo Enviado: "+archivo.getName());
                    // Cerramos socket y flujos
                }
                  bos.close();
              } 
          }
          catch( Exception e )
          {
            System.out.println( e.toString() );
          }
         
         }       
         public static void main( String args[] )
         {
            EnviarArchivo ea = new EnviarArchivo(
                    "/home/luis/Escritorio/Java.pdf");
            ea.enviarArchivo();
         }
         
}