/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xml;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gustavo
 */
public class SacarLinksDeSitiosWeb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        String html = new GetHTML().getHTML("http://es.wikipedia.org/wiki/Canis_lupus_familiaris");
                //URL urltext = new URL("http://es.wikipedia.org/wiki/Canis_lupus_familiaris");
                // NOTE: Use ArticleExtractor unless DefaultExtractor gives better results for you
                //String textextracion = ArticleExtractor.INSTANCE.getText(urltext);           
                //System.out.println(textextracion);
                Pattern p = Pattern.compile("href=\"(.*?)\"");
                Matcher m = p.matcher(html);
                String url = null;
                while (m.find()){
                    url = m.group(1);
                    System.out.println(m.group(1));
                    // TODO code application logic here
    }
    
}
}
