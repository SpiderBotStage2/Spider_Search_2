/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author osboxes
 * @param <dp>
 */
public class NodoUrl <dp extends Comparable<dp>> extends NodoB{
    
    private ListaSdoble Urlpadre;
    private ListaSdoble countPpage;
    private Nodo indiceCt;
    
    /**
     * contructor que recibe la palabra, el url o direccion en disco del archivo
     * y la cantidad de veces de aparicion de la palabra
     * @param pData dato String que recibe la palabra que se va a ingresar
     * @param cantAp la cantidad total de veces que aparecio la palabra en 
     * ese archivo.
     * */
    public NodoUrl(String pData, int cantAp) {
        super(pData);
        this.countPpage= new ListaSdoble();
        this.countPpage.enQueue(cantAp);
        indiceCt= this.countPpage.getHead();
    }

    @Override
    public NodoB getPadre() {
        return super.getPadre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable getDato() {
        return super.getDato(); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public NodoB getHizq() {
        return super.getHizq(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodoB getHder() {
        return super.getHder(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getFE() {
        return super.getFE(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDepth() {
        return super.getDepth(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setPadre(NodoB padre) {
        super.setPadre(padre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHizq(NodoB hizq) {
        super.setHizq(hizq); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHder(NodoB hder) {
        super.setHder(hder); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFE(double fe) {
        super.setFE(fe); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDepth(int depth) {
        super.setDepth(depth); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * retorna la cantidad de padres que existen en un nodo
     * @return 
     */
    public int LengthP(){
        Nodo tmp= Urlpadre.getHead();
        int i=0;
        while(tmp!=null){
            i++;
            tmp=tmp.getNext();
        }
        return i;
    }
}
