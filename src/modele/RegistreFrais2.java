package modele;

import utils.ExceptionFraisExisteDeja;

import javax.swing.*;
import java.util.ArrayList;

public class RegistreFrais2 {

    public ArrayList<Frais> registreFrais2;

    public RegistreFrais2() {
        this.registreFrais2 = new ArrayList<>();
    }

    public ArrayList<Frais> getRegistreFrais2() {
        return registreFrais2;
    }

    public void setRegistreFrais2(ArrayList<Frais> registreFrais2) {
        this.registreFrais2 = registreFrais2;
    }

    public void ajouterFrais2(Frais frais) throws ExceptionFraisExisteDeja {
        if (validerDoublonFrais(frais)) {
            System.out.println("Erreur");
            throw new ExceptionFraisExisteDeja("Un frais doublon trouvé", frais);
        } else {
            JOptionPane.showMessageDialog(null, "Ajout du frais de votre employé avec succès ", "Edition", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("good Frais");
            this.registreFrais2.add(frais);
        }
    }
    public boolean validerDoublonFrais(Frais frais) {
        for (Frais tmp : registreFrais2) {
            if (tmp.equals(frais)) {
                return true;
            }
        }
        return false;
    }

    public void listerFrais() {
        for (Frais tmp : registreFrais2) {
            System.out.println(tmp);
        }
    }


    public String afficherFrais() {
        StringBuilder sb = new StringBuilder();
        for (Frais tmp: registreFrais2) {
            sb.append(tmp);
            sb.append("\n");
        }
        return sb.toString();
    }
}
