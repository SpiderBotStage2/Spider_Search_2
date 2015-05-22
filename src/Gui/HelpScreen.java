/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

/**
 *
 * @author osboxes
 */
public class HelpScreen extends javax.swing.JFrame {

    /**
     * Creates new form HelpScreen
     */
    public HelpScreen() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        OpMenu = new javax.swing.JMenu();
        OPBack = new javax.swing.JMenuItem();
        OPOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana de ayuda");
        setMinimumSize(new java.awt.Dimension(1121, 940));
        getContentPane().setLayout(null);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Puntos\n1. barra de busqueda: nos sirve para buscar la informacion que queramos en la base de datos creada por el spider \n\t            search.\n\n2. Boton de busqueda: se utiliza para realizar una busqueda en base al dato que hayamos buscado.\n\n3. Zona de informacion: esta zona se utiliza para desplegar la infromacion que nos proporciona la base datos con \n\t                respecto a los links que apuntan a cada coindicendia segun las busqueda pedida.\n\n4. Barra de opciones: se tienen dos puntos para la barra de informacion:\n\t          1. Opcion de Conexion: intenta una conexion con el servidor TCP/IP para enviar y recibir datos.\n\t          2. Opcion de ayuda: accede al menu de ayuda para la obtencion de informacion de como usar \n\t\t                  la aplicacion.\n\t          3. Opcion de salir: cierra el programa.\n");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 1100, 370);

        jLabel2.setText("Panel de informacion");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 210, 50);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 270, 900, 630);

        OpMenu.setText("Options");

        OPBack.setText("Devolverse");
        OPBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OPBackActionPerformed(evt);
            }
        });
        OpMenu.add(OPBack);

        OPOut.setText("Salir");
        OPOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OPOutActionPerformed(evt);
            }
        });
        OpMenu.add(OPOut);

        jMenuBar1.add(OpMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OPOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OPOutActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_OPOutActionPerformed

    private void OPBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OPBackActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_OPBackActionPerformed

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
            java.util.logging.Logger.getLogger(HelpScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HelpScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HelpScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HelpScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HelpScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OPBack;
    private javax.swing.JMenuItem OPOut;
    private javax.swing.JMenu OpMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
