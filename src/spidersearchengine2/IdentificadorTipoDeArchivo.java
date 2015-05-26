
package spidersearchengine2;

import java.net.*;

/**
 * Clase que identifica el MIME type de una url
 * @author luis
 */
public class IdentificadorTipoDeArchivo{
  /**
   * Metodo que verifica el MIME type y lo retorna
   * @param pArchivoUrl String: direccion donde se encuentra el archivo al que 
   * se le quiere verificar el MIME type
   * @return String: MIME type del archivo
   * @throws java.io.IOException
   * @throws MalformedURLException 
   */
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
    