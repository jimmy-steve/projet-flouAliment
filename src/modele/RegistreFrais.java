package modele;

import utils.FraisExisteDejaException;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Name: RegistreFrais
 * fonction: s'occupe de la liste des frais
 *
 */

public class RegistreFrais {

    public ArrayList<Frais> registreFrais2;


    public RegistreFrais() {
        this.registreFrais2 = new ArrayList<>();
    }

    public ArrayList<Frais> getRegistreFrais2() {
        return registreFrais2;
    }

    public void setRegistreFrais2(ArrayList<Frais> registreFrais2) {
        this.registreFrais2 = registreFrais2;
    }

    /**
     * Vérifie si le frais est dans la liste et ajoute le frais s'il n'est pas déjà présent
     * @param frais
     * @throws FraisExisteDejaException
     */
    public void ajouterFrais(Frais frais) throws FraisExisteDejaException {
        if (validerDoublonFrais(frais)) {
            System.out.println("Erreur");
            throw new FraisExisteDejaException("Un frais doublon trouvé", frais);
        } else {
            JOptionPane.showMessageDialog(null, "Ajout du frais de votre employé avec succès ", "Edition", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("good Frais");
            this.registreFrais2.add(frais);
            System.out.println(frais);
        }
    }

    /**
     * Vérifie s'il ce frais et déjà dans la liste
     * @param frais
     * @return
     */
    public boolean validerDoublonFrais(Frais frais) {
        for (Frais tmp : registreFrais2) {
            if (tmp.equals(frais)) {
                return true;
            }
        }
        return false;
    }


    /**
     * affiche tous les frais de la listeFrais
     */
    public void listerFrais() {
        for (Frais tmp : registreFrais2) {
            System.out.println(tmp);
        }
    }

    /**
     * Retourne un String contenant tous les frais de la listeFrais
     * @return String
     */
    public String afficherFrais() {
        StringBuilder sb = new StringBuilder();
        for (Frais tmp: registreFrais2) {
            sb.append(tmp);
            sb.append("\n");
        }
        return sb.toString();
    }
}
