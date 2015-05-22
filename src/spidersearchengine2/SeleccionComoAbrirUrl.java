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
 *
 * @author luis
 */
public class SeleccionComoAbrirUrl {
    
    public void abrirUrl(String pUrl) throws IOException, URISyntaxException{
        if (pUrl.substring(0,4).equals("http")){
            Desktop archivoDesktop = Desktop.getDesktop();
            archivoDesktop.browse(new URI(pUrl));
           
        }
        else{
            File rutaEnDiscoDelArchivo = 
                    new File ("/home/luis/Escritorio/Manual.pdf");
            Desktop.getDesktop().open(rutaEnDiscoDelArchivo);
        }
    
    }
}
