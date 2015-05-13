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
     * contructor que recibe un pData que seria lo que se quiere ingresar
     * en este caso la palabra; recibe un Url padre que nos indica de que 
     * url proviene esa palabra.
     * @param pData
     * @param Urlpadre 
     */
    public NodoUrl(dp pData, String Urlpadre) {
        super(pData);
        this.Urlpadre= new ListaSdoble();
        this.countPpage= new ListaSdoble();
        this.Urlpadre.enQueue(Urlpadre);
        this.countPpage.enQueue(1);
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
     * metodo para ingresar un nuevo padre a la keyword.
     * @param Urlpadre dato de entra del Url padre
     */
    public void setUrlsPadre(String Urlpadre){
        indiceCt.setNext(new Nodo(0));
        indiceCt= indiceCt.getNext();
        this.Urlpadre.enQueue(Urlpadre);
        upCount();
    }
    
    /**
     * obtiene los padres urls del nodo
     * @return Urlpadre;
     */
    public ListaSdoble getUrlsPadres(){
        return Urlpadre;
    }
    
    /**
     * 
     * @return devuleve la lista de la cantidad de veces que se encontro 
     * la palabra por url.
     */
    public ListaSdoble getCont(){
        return countPpage;
    }
    
    /**
     * metodo para aumentar la cuenta de la cantidad de veces que 
     * se encontro la palabra en la pagina indicada.
     */
    public void upCount(){
        indiceCt.setData((int)indiceCt.getData()+1);
    }
    
    /**
     * establece de forma manual la cantidad de veces que se encontro la 
     * palabra
     * @param i 
     */
    public void setCount(int i){
        indiceCt.setData(i);
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
    
    /**
     * metodo pra imprimir el ocntenido del nodo, en este caso imprime
     * los padres del nodo y su cantidad de veces aparecida.
     */
    public void printPadre(){
        Nodo tmp1= Urlpadre.getHead();
        Nodo tmp2= countPpage.getHead();
        while(tmp1!=null || tmp2!=null){
            System.out.println(tmp1.getData()+"..Cantidades de veces Encontrada la palabra: "+tmp2.getData());
            tmp1= tmp1.getNext();
            tmp2= tmp2.getNext();
        }
    }
}
