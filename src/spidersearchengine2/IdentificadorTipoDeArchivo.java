
package spidersearchengine2;

import java.net.*;

public class IdentificadorTipoDeArchivo{
  public static String getTipoDeArchivo(String p_archivoUrl)
    throws java.io.IOException, MalformedURLException
  {
    String tipoDeArchivo = null;
    URL direccionDelArchivo = new URL(p_archivoUrl);
    URLConnection coneccionConUrl = null;
    coneccionConUrl = direccionDelArchivo.openConnection();
    tipoDeArchivo = coneccionConUrl.getContentType();
    return tipoDeArchivo;
  }

  /*public static void main(String args[]) throws Exception {
    System.out.println(IdentificadorTipoDeArchivo.getTipoDeArchivo("file://http://www.uacj.mx/CSB/BIVIR/Documents/Acervos/libros/Importancia_de_la_lectura.pdf"));
   
  }*/
}
