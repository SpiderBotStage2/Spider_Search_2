/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//cambios es informacion minimos
package Gui;

import logica.ListaSdoble;
import logica.Nodo;



/**
 *
 * @author osboxes
 */
public class ventana extends javax.swing.JFrame {

    /**
     * Creates new form ventana
     */
    
    private ListaSdoble palabras;
    private HelpScreen ayuda;
    
    
    public ventana() {
        ayuda= new HelpScreen();
        palabras= new ListaSdoble();
   
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchInput = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        OPMenu = new javax.swing.JMenu();
        OPConnect = new javax.swing.JMenuItem();
        OPHelp = new javax.swing.JMenu();
        OPOut = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spider search");
        setMinimumSize(new java.awt.Dimension(950, 680));
        getContentPane().setLayout(null);

        SearchInput.setToolTipText("Ingrese el lo que desee buscar");
        getContentPane().add(SearchInput);
        SearchInput.setBounds(210, 50, 450, 27);

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(700, 50, 140, 29);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Instituto Tecnologico de Costa Rica\nCE-1103\nSem1-2015\nProyecto Programado 2\nSpider Search Stage 2\nDesarrollado por :\n\tGustavo Martinez / 2014098445\n\tLuis Martínez / 2013029940\n\tEllioth Ramirez /2014057732\n");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 120, 810, 380);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 150, 120);

        OPMenu.setText("Options");

        OPConnect.setText("Conectar con servidor");
        OPConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OPConnectActionPerformed(evt);
            }
        });
        OPMenu.add(OPConnect);

        OPHelp.setText("Ayuda");
        OPHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OPHelpActionPerformed(evt);
            }
        });
        OPMenu.add(OPHelp);

        OPOut.setText("Salir");
        OPOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OPOutActionPerformed(evt);
            }
        });
        OPMenu.add(OPOut);

        jMenuBar1.add(OPMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OPOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OPOutActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_OPOutActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        getTexto();
        search();
        setInfo();
        VentanaOpciones listaDeOpciones;
        listaDeOpciones = new VentanaOpciones();
        listaDeOpciones.desplegar();
        
        
        
        dispose();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void OPHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OPHelpActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ayuda.setVisible(true);
    }//GEN-LAST:event_OPHelpActionPerformed

    private void OPConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OPConnectActionPerformed
        // TODO add your handling code here:
        //connect.setVisible(true);
    }//GEN-LAST:event_OPConnectActionPerformed

    private void setInfo(){
        
    }
    
    private void search() {
        Nodo tmp=palabras.getHead();
        while(tmp!=null){
            //SendM.sendMsj((String)tmp.getData());
            tmp=tmp.getNext();
        }
    }
    
    private void getTexto(){
        String contenedor="";
        StringBuilder constructorS= new StringBuilder();
        int y=1;
        for(int x=0; x<=SearchInput.getText().length();x++){
            if(x==SearchInput.getText().length()){
                contenedor=constructorS.toString();
                palabras.enQueue(contenedor);
                break;
            }
            else if(SearchInput.getText().substring(x,y).equals(" ")){
                contenedor=constructorS.toString();
                palabras.enQueue(contenedor);
                y++;
                constructorS.delete(0, constructorS.length());
            }
            else{
                constructorS.append(SearchInput.getText().substring(x,y));
                y++;
            }
        }
        palabras.print();
        constructorS.delete(0, constructorS.length());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }
//
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OPConnect;
    private javax.swing.JMenu OPHelp;
    private javax.swing.JMenu OPMenu;
    private javax.swing.JMenu OPOut;
    private javax.swing.JTextField SearchInput;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
