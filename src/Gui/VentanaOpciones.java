/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import spidersearchengine2.SeleccionComoAbrirUrl;

public class VentanaOpciones extends JPanel {

  String arregloConElementos[] = { "https://www.google.com/?gws_rd=ssl", "One", "Two", "Three", "Four", "Five", "Six",
      "Seven", "Eight", "Nine", "Ten", "Eleven"};

  JList listaConUrls;

  public VentanaOpciones() {
    setLayout(new BorderLayout());

    listaConUrls = new JList(arregloConElementos);
    
    JScrollPane panelOpcionesScroll = new JScrollPane(listaConUrls);

    DefaultListSelectionModel m = new DefaultListSelectionModel();
    m.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    m.setLeadAnchorNotificationEnabled(false);
    
    listaConUrls.setSelectionModel(m);
    listaConUrls.addListSelectionListener(new ListSelectionListener() {
      
        public void valueChanged(ListSelectionEvent e) {
        //aqui se abren los url al dar clic
        SeleccionComoAbrirUrl escogerComoAbrirDocumento
                = new SeleccionComoAbrirUrl();
          try {
              escogerComoAbrirDocumento.abrirUrl(arregloConElementos[0]);
              
          } catch (IOException | URISyntaxException ex) {
              Logger.getLogger(VentanaOpciones.class.getName()).
                      log(Level.SEVERE, null, ex);
          }
      }
    });
    
    add(panelOpcionesScroll, BorderLayout.NORTH);
    
  }

  public void desplegar() {
    JFrame frame = new JFrame("SpiderSearch");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new VentanaOpciones());
    frame.pack();
    frame.setVisible(true);
  }
}