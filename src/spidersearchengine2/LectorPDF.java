package spidersearchengine2;

import java.io.File;
import org.apache.tika.Tika;

public class LectorPDF {
    public String ContenidoDelArchivo = null;
    File archivoParaLeer;
//public static void main(String args[]) throws Exception {
    public LectorPDF(String p_RutaDelDocumento){
        
        try {
          archivoParaLeer=new File(p_RutaDelDocumento);
          String contenidoDelArchivo=new Tika().parseToString(archivoParaLeer);
          ContenidoDelArchivo=contenidoDelArchivo;
          ContenidoDelArchivo = ContenidoDelArchivo.replaceAll("\\b\\w{1,3}\\b\\s?", ""); //elimina palabras de 3 letras o menos
          ContenidoDelArchivo = ContenidoDelArchivo.replaceAll("[^a-zA-Z]", " "); // cambia todos los caracteres que no son letras por un espacio
          ContenidoDelArchivo = ContenidoDelArchivo.replaceAll("\\s+", " "); //cambia todos los campos en blanco por por un solo espacio
    
        }
        catch (Exception e) {
          e.printStackTrace();
        }
        //return ContenidoDelArchivo;

    } 
}


