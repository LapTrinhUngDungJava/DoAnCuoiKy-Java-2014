/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demotemplate;

import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Skys
 */
public class ListLookAndFeelInfo {
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*
         *  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            * 
          javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
         
         * : Da moi truong`. Vi du: win7 thi se lay' giao dien giong win 7
         * win8 thi se lay giao dien giong win8.
         * Mac v.v...
        */
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                 System.out.println("InforName: " + info.getName() + " - ClassName: " + info.getClassName());
     
            }
        }
}
