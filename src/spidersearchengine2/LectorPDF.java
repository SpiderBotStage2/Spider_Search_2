package spidersearchengine2;

import java.io.File;
import org.apache.tika.Tika;

public class LectorPDF {
    File archivoParaLeer;
//public static void main(String args[]) throws Exception {
    public LectorPDF(String p_RutaDelDocumento){

        try {
          archivoParaLeer=new File(p_RutaDelDocumento);
          String contenidoDelArchivo=new Tika().parseToString(archivoParaLeer);
          System.out.println(contenidoDelArchivo);
        }
        catch (Exception e) {
          e.printStackTrace();
        }

    } 
}


