/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminarasterisco;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Rene
 */
public class Ventana_Pricipal extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Pricipal
     */
    public Ventana_Pricipal() {
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

        PTodo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        T = new javax.swing.JTextArea();
        B = new javax.swing.JButton();
        B2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PTodo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        T.setColumns(20);
        T.setRows(5);
        jScrollPane1.setViewportView(T);

        PTodo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 530, 360));

        B.setText("Eliminar *");
        B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActionPerformed(evt);
            }
        });
        PTodo.add(B, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, -1, -1));

        B2.setText("htm + -*");
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });
        PTodo.add(B2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PTodo, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PTodo, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActionPerformed
        LinkedList<String> l = new LinkedList<>();
        Scanner s = new Scanner(T.getText());
        while (s.hasNextLine()) {
            String a = s.nextLine();
//            System.out.println("a="+a);
            if (!a.isEmpty()) {
                for (int i = 0; i < a.length(); i++) {
                    char c = a.charAt(i);
                    if (c == ' ') {
                        continue;
                    }
                    if (c == '*') {
                        a = a.substring(i + 1);
//                        System.out.println("a 2="+a);
                    }
                }
                l.add(a);
            }
            //   a = (!a.isEmpty() && a.charAt(0) == '*') ? a.substring(1) : a;

        }
        T.setText("");
        String A[] = l.toArray(new String[0]);
//        System.out.println(Arrays.toString(A));
        for (int i = 0; i < 10; i++) {
            T.append(A[i] + "\n");
        }
    }//GEN-LAST:event_BActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed

        String H1[] = {"<html>", "<head>", "</head>", "<body>"}, H2[] = {"</body>", "</html>"};
        LinkedList<String> l = new LinkedList<>();
        Scanner s = new Scanner(T.getText());
        while (s.hasNextLine()) {
            String a = s.nextLine();
//            System.out.println("a="+a);
            if (!a.isEmpty()) {
                for (int i = 0; i < a.length(); i++) {
                    char c = a.charAt(i);
                    if (c == ' ') {
                        continue;
                    }
                    if (c == '*') {
                        a = a.substring(i + 1);
//                        System.out.println("a 2="+a);
                    }
                }
                l.add(a);
            }
            //   a = (!a.isEmpty() && a.charAt(0) == '*') ? a.substring(1) : a;

        }
        T.setText("");
        add(H1);
        add(l.toArray(new String[0]));
        add(H2);
    }//GEN-LAST:event_B2ActionPerformed

    private void add(String A[]) {
        for (int i = 0; i < A.length; i++) {
            T.append(A[i] + "\n");
        }
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
            java.util.logging.Logger.getLogger(Ventana_Pricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Pricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Pricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Pricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Pricipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B;
    private javax.swing.JButton B2;
    private javax.swing.JPanel PTodo;
    private javax.swing.JTextArea T;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
