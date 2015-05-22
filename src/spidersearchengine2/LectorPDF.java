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
          ContenidoDelArchivo = contenidoDelArchivo; 
          ContenidoDelArchivo = ContenidoDelArchivo.replaceAll("\\b\\w{1,3}\\b\\s?", "");
          ContenidoDelArchivo = ContenidoDelArchivo.replaceAll("[^a-zA-Z]", "");
          ContenidoDelArchivo = ContenidoDelArchivo.replaceAll("\\s+", "");
          
        }
        catch (Exception e) {
          e.printStackTrace();
        }

    } 
}


