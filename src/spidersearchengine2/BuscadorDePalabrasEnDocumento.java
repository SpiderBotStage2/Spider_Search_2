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


public class BuscadorDePalabrasEnDocumento {

public BuscadorDePalabrasEnDocumento(String p_RutaDelArchivo, 
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
    System.out.println("Times found at--"+contadorVecesQueApareceLaPalabra);
    System.out.println("Word found at--"+numeroDeLinea);
}
}