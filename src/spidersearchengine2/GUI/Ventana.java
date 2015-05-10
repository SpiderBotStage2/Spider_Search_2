/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spidersearchengine2.GUI;

import java.awt.Image;
import javax.swing.*;
import java.awt.Toolkit;
import spidersearchengine2.Constantes;

/**
 *
 * @author luis 
 */
public class Ventana extends JFrame{
    
    private Image imagenIconoVentana;
    private ImageIcon fondoParaLabel;
    private JLabel labelFondo;
    private JButton botonBuscar;
    private JTextField espacioParaEscribir;

    public Ventana(){
        
        
        setResizable(false);
        setVisible(true);
        setSize(Constantes.largoVentana, 
                Constantes.anchoVentana);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setTitle("Spider Search Engine");
        
        imagenIconoVentana = Toolkit.getDefaultToolkit().getImage(getClass()
                .getResource(Constantes.rutaImagenIconoVentana));
        
        setIconImage(imagenIconoVentana);
        
        fondoParaLabel = new ImageIcon(getClass().
                getResource(Constantes.rutaImagenFondo));
        labelFondo = new JLabel(fondoParaLabel);
        labelFondo.setBounds(Constantes.cero, Constantes.cero, 
                Constantes.labelFondoLargo, Constantes.labelFondoAncho);
        labelFondo.setBounds(Constantes.cero, Constantes.cero, 
                fondoParaLabel.getIconWidth(), fondoParaLabel.getIconHeight());
        
        espacioParaEscribir = new JTextField();//se instancia un campo de texto
        espacioParaEscribir.setBounds(Constantes.jTextFieldBusquedaPosX,
                Constantes.jTextFieldBusquedaPosY,
                Constantes.jTextFieldBusquedaLargo,
                Constantes.jTextFieldBusquedaAncho);/*se definen las dimensiones
                        del campo de texto*/
        
        botonBuscar = new JButton();//se instancia un boton
        botonBuscar.setText("Buscar");//etiqueta del boton
        botonBuscar.setBounds(Constantes.botonBuscarPosX,
                Constantes.botonBuscarPosY,Constantes.botonBuscarLargo,
                Constantes.botonBuscarAncho);
        
        add(espacioParaEscribir);
        add(botonBuscar);
        add(labelFondo);
        
        
        
    }
    
}
