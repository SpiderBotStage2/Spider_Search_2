package logica;

import java.io.File;
import java.io.IOException;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

public class LectorPDF {
   public String ContenidoDelArchivo = null;
    File archivoParaLeer;
//public static void main(String args[]) throws Exception {
    public LectorPDF(String p_RutaDelDocumento){

        try {
          archivoParaLeer=new File(p_RutaDelDocumento);
          String contenidoDelArchivo=new Tika().parseToString(archivoParaLeer);
          contenidoDelArchivo = contenidoDelArchivo; 
          contenidoDelArchivo = contenidoDelArchivo.replaceAll("\\b\\w{1,3}\\b\\s?", " ");
          contenidoDelArchivo = contenidoDelArchivo.replaceAll("[^a-zA-Z]", " ");
          ContenidoDelArchivo = contenidoDelArchivo.replaceAll("\\s+", " ");
          
        }
        catch (IOException | TikaException e) {
        }

    } 
}


