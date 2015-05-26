/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spidersearchengine2;

/**
 *
 * @author luis
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que se encarga de buscar una palabra especifica en un documento
 * Cuenta la cantidad de veces que aparece en el mismo
 * @author luis
 */

public class BuscadorDePalabrasEnDocumento {
      
    
    /**
     * constructor de la clase
     * @param p_RutaDelArchivo String: URL donde se ubica el documento  
     * @param p_PalabraABuscar String: palabra que se quiere buscar en el 
     * documento
     */
    public void BuscarPalabrasEnDocumento(String p_RutaDelArchivo, 
            String p_PalabraABuscar)
    {
        double contadorVecesQueApareceLaPalabra = 0;  
        double countBuffer=0;
        double contadorDeLinea=0;
        String numeroDeLinea = "";
        String rutaDeArchivo = p_RutaDelArchivo;
        BufferedReader br;
        String palabraABuscarEnElDocumento = p_PalabraABuscar;
        String linea = "";

        try {
            br = new BufferedReader(new FileReader(rutaDeArchivo));
            try {
                while((linea = br.readLine()) != null)
                {
                    contadorDeLinea++;
                    //System.out.println(line);
                    String[] words = linea.split(" ");

                    for (String word : words) {
                      if (word.equals(palabraABuscarEnElDocumento)) {
                        contadorVecesQueApareceLaPalabra++;
                        countBuffer++;
                      }
                    }

                    if(countBuffer > 0)
                    {
                        countBuffer = 0;
                        numeroDeLinea += contadorDeLinea + ",";
                    }
                }
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Veces encontrada:--"
                +contadorVecesQueApareceLaPalabra);
        
    }
    /**
     * Metodo para tomar las veces que aparece una palabra en un documento
     * @return Int: cantidad de veces que aparece una palabre en un documento
     */
    /*public int getCantidadDeVeces(){
        return contadorVecesQueApareceLaPalabra;
    }*/
   public static void main(String args[]) {
        BuscadorDePalabrasEnDocumento buscar = new BuscadorDePalabrasEnDocumento();
        buscar.BuscarPalabrasEnDocumento("/home/luis/Escritorio/Java.pdf", "programa");
        
    }
    }