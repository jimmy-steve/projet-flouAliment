package oi;

import modele.Employe;
import modele.RegistreEmploye;
import utils.EmployeDejaEmployeException;

import javax.swing.*;
import java.io.*;

/**
 * name: ManiFichier
 * fonction: permettre l'entrer de donnée
 */
public class ManipFichier {
    public static void lecture(String fichier, RegistreEmploye listing) throws FileNotFoundException, IOException {

        File file = new File(fichier);

        FileReader fr = null;
        BufferedReader br = null;

            fr = new FileReader(file);
            br = new BufferedReader(fr);
            //lecture
            String ligne;
            while ((ligne = br.readLine()) != null) {
                //Transformer une ligne en objet de type employe
                Employe employe = parserLigne(ligne);
                //ajouter dans le registre
                try {
                    listing.ajouterEmploye(employe);
                } catch (EmployeDejaEmployeException e) {//----------on récupere l'erreur d'un employer déja présent
                    JOptionPane.showMessageDialog(null, e.getEmploye().toString(), "Erreur AJout", JOptionPane.ERROR_MESSAGE);
                }
            }
           br.close();

    }

    /**
     * name: parsrLigne
     * fonction: permettre d,aller saisi chaque chaine pour créer un employé
     * @param ligne
     * @return un objet employe (nom,prenom,type)
     */
    private static Employe parserLigne(String ligne) {
        String[] tokens = ligne.split(";");
        String nom = (tokens[0]);
        String prenom = (tokens[1]);
        String type = (tokens[2]);

        return new Employe(nom, prenom, type);
    }

    /**
     * name: ecriture
     * fonction écrire le registre d'employe dans un fichier
     * @param fichier
     * @param listing
     */
    public static void ecriture(String fichier, RegistreEmploye listing) throws IOException {
        File file = new File(fichier);
        FileWriter fw = null;
        BufferedWriter bw = null;
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            for (Employe employe : listing.getRegistre()) {  //pour tout les employé dans la liste et on transforme un employé en string
                String ligne = formerLigne(employe);//serialisation
                bw.write(ligne);
                bw.newLine();
            }
            bw.close();
    }

    /**
     * name: formerLigne
     * focntion: sert a former une ligne qui est un employe
     * @param employe
     * @return
     */
    public static String formerLigne(Employe employe) {
        return employe.getNom() + ";" + employe.getPrenom() + ";" + employe.getType();
    }
}
