/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author joimar
 */
public class Led extends javax.swing.JFrame {

    PanamaHitek_Arduino ino = new PanamaHitek_Arduino();

    public Led() {
        initComponents();

        try {
            ino.arduinoRXTX("/dev/ttyUSB0", 9600, listener);
        } catch (ArduinoException ex) {
            Logger.getLogger(Led.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (ino.isMessageAvailable() == true) {
                    try {
                        Txt_temperatura.setText(ino.printMessage());
                    } catch (SerialPortException ex) {
                        Logger.getLogger(Led.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ArduinoException ex) {
                        Logger.getLogger(Led.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SerialPortException ex) {
                Logger.getLogger(Led.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ArduinoException ex) {
                Logger.getLogger(Led.class.getName()).log(Level.SEVERE, null, ex);
            }
 
            
            
        }

    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_Enceder = new javax.swing.JButton();
        Btn_apagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Txt_temperatura = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btn_Enceder.setText("Encender");
        Btn_Enceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EncederActionPerformed(evt);
            }
        });

        Btn_apagar.setText("Apagar");
        Btn_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_apagarActionPerformed(evt);
            }
        });

        jLabel1.setText("Led 1 ");

        Txt_temperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_temperaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(Btn_Enceder)
                .addGap(35, 35, 35)
                .addComponent(Btn_apagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(Txt_temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Enceder)
                    .addComponent(Btn_apagar)
                    .addComponent(jLabel1)
                    .addComponent(Txt_temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(237, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_EncederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EncederActionPerformed
        try {
            ino.sendData("1");
        } catch (Exception ex) {
            Logger.getLogger(Led.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_EncederActionPerformed

    private void Btn_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_apagarActionPerformed
        try {
            ino.sendData("0");
        } catch (Exception ex) {
            Logger.getLogger(Led.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Btn_apagarActionPerformed

    private void Txt_temperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_temperaturaActionPerformed


    }//GEN-LAST:event_Txt_temperaturaActionPerformed

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
            java.util.logging.Logger.getLogger(Led.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Led.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Led.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Led.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Led().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Enceder;
    private javax.swing.JButton Btn_apagar;
    public javax.swing.JTextField Txt_temperatura;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
