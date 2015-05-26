/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spidersearchengine2;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *Clase que abre un archivo en el navegador o en el lector de documentos  
 * @author luis
 */
public class SeleccionComoAbrirUrl {
    /**
     * Metodo que verifica si el archivo es un documento en internet o si se 
     * encuentra en una carpeta y abre dicho archivo
     * @param pUrl String: direccion donde se encuentra el documento
     * @throws IOException
     * @throws URISyntaxException 
     */
    public void abrirUrl(String pUrl) throws IOException, URISyntaxException{
        if (pUrl.substring(0,4).equals("http")){
            Desktop archivoDesktop = Desktop.getDesktop();
            archivoDesktop.browse(new URI(pUrl));
           
        }
        else{
            File rutaEnDiscoDelArchivo = new File (pUrl);
            Desktop.getDesktop().open(rutaEnDiscoDelArchivo);
        }
    
    }
}
