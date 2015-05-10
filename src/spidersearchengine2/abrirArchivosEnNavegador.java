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
//se importan las bibliotecas a utilizar
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class abrirArchivosEnNavegador
{
 //public static void main(String args[]) throws Exception
 
    //constructor
    public abrirArchivosEnNavegador(String p_URL) throws URISyntaxException, IOException{
 
 // Create Desktop object
        Desktop paginaWeb = Desktop.getDesktop();

 // Browse a URL, say google.com
        paginaWeb.browse(new URI(p_URL));

    }
}