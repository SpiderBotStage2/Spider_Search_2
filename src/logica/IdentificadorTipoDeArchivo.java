
package logica;

import java.net.*;

public class IdentificadorTipoDeArchivo{
  public static String getTipoDeArchivo(String pArchivoUrl)
    throws java.io.IOException, MalformedURLException
  {
    String tipoDeArchivo = null;
    URL direccionDelArchivo = new URL(pArchivoUrl);
    URLConnection coneccionConUrl = null;
    coneccionConUrl = direccionDelArchivo.openConnection();
    tipoDeArchivo = coneccionConUrl.getContentType();
    return tipoDeArchivo;
  }

  
}
    