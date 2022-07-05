package main;

import modele.*;
import oi.ManipFichier;
import ui.FenMenu;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //---------------------------------------------------------------création registre employe
        RegistreEmploye listing = new RegistreEmploye();
        //---------------------------------------------------------------Creer listing Frais
        RegistreFrais listingFrais = new RegistreFrais();


        try {
            ManipFichier.lecture("src/data/dataIn.txt", listing);
        } catch (FileNotFoundException e1) {//-------------on peut récupérer l'erreur si le fichier est introuvable
            JOptionPane.showMessageDialog(null, "Fichier en entrée introuvable !!", "Erreur I/O", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fichier introuvable !!", "Erreur I/O", JOptionPane.ERROR_MESSAGE);
        }catch (ArrayIndexOutOfBoundsException e2){
            JOptionPane.showMessageDialog(null, "Fichier Vide !!", "Erreur I/O", JOptionPane.ERROR_MESSAGE);
        }


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
            java.util.logging.Logger.getLogger(FenMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenMenu(listing, listingFrais).setVisible(true);

            }
        });
    }


}
