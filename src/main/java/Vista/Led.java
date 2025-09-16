/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
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
                if (ino.isMessageAvailable()) {
                    String mensaje = ino.printMessage().trim(); // 🔹 leer solo 1 vez
                    System.out.println("Mensaje recibido: " + mensaje);

                    // Actualizar JTextField en hilo gráfico
                    SwingUtilities.invokeLater(() -> {
                        Txt_temperatura.setText(mensaje);
                    });

                    // Extraer humedad y temperatura
                    if (mensaje.contains("Temperatura:") && mensaje.contains("Humedad:")) {
                        String[] partes = mensaje.split(";");
                        String humStr = partes[0].split(":")[1].trim();
                        String tempStr = partes[1].split(":")[1].trim();

                        double humedad = Double.parseDouble(humStr);
                        double temperatura = Double.parseDouble(tempStr);

                        System.out.println("Humedad: " + humedad + " %");
                        System.out.println("Temperatura: " + temperatura + " °C");
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

        Btn_Enceder2 = new javax.swing.JButton();
        Btn_apagar2 = new javax.swing.JButton();
        Btn_Enceder = new javax.swing.JButton();
        Btn_apagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Txt_temperatura = new javax.swing.JTextField();
        Btn_encender2 = new javax.swing.JButton();
        Btn_Apagar2 = new javax.swing.JButton();
        Encender3 = new javax.swing.JButton();
        Apagar3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        Btn_Enceder2.setText("Encender");
        Btn_Enceder2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Enceder2ActionPerformed(evt);
            }
        });

        Btn_apagar2.setText("Apagar");
        Btn_apagar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_apagar2ActionPerformed(evt);
            }
        });

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

        Btn_encender2.setText("Encender");
        Btn_encender2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_encender2ActionPerformed(evt);
            }
        });

        Btn_Apagar2.setText("Apagar");
        Btn_Apagar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Apagar2ActionPerformed(evt);
            }
        });

        Encender3.setText("Enceder");
        Encender3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Encender3ActionPerformed(evt);
            }
        });

        Apagar3.setText("Apagar");
        Apagar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apagar3ActionPerformed(evt);
            }
        });

        jLabel2.setText("led2");

        jLabel3.setText("led3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_Enceder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_encender2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Encender3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Apagar3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_Apagar2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_apagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(Txt_temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_encender2)
                    .addComponent(Btn_Apagar2)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Encender3)
                    .addComponent(Apagar3)
                    .addComponent(jLabel3))
                .addContainerGap(151, Short.MAX_VALUE))
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

    private void Btn_Enceder2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Enceder2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Enceder2ActionPerformed

    private void Btn_apagar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_apagar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_apagar2ActionPerformed

    private void Btn_encender2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_encender2ActionPerformed
        try {
            ino.sendData("2");
        } catch (Exception ex) {
            Logger.getLogger(Led.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_encender2ActionPerformed

    private void Btn_Apagar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Apagar2ActionPerformed
        try {
            ino.sendData("3");
        } catch (Exception ex) {
            Logger.getLogger(Led.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_Apagar2ActionPerformed

    private void Encender3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Encender3ActionPerformed
        try {
            ino.sendData("4");
        } catch (Exception ex) {
            Logger.getLogger(Led.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Encender3ActionPerformed

    private void Apagar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apagar3ActionPerformed
        try {
            ino.sendData("5");
        } catch (Exception ex) {
            Logger.getLogger(Led.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Apagar3ActionPerformed

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
    private javax.swing.JButton Apagar3;
    private javax.swing.JButton Btn_Apagar2;
    private javax.swing.JButton Btn_Enceder;
    private javax.swing.JButton Btn_Enceder2;
    private javax.swing.JButton Btn_apagar;
    private javax.swing.JButton Btn_apagar2;
    private javax.swing.JButton Btn_encender2;
    private javax.swing.JButton Encender3;
    public javax.swing.JTextField Txt_temperatura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
