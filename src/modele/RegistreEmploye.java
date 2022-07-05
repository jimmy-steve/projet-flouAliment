package modele;

import utils.EmployeDejaEmployeException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Name: RegistreEmploye
 * fonction: s'occupe de la liste des employe
 */
public class RegistreEmploye {
    private TreeSet<Employe> registre;

    /**
     * name : constructeur par défault
     * avec son comparator en parametre
     */
    public RegistreEmploye() {
        this.registre = new TreeSet<>(new EmployeComparator());
    }

    /**
     * name: getRegistre
     * fonction: pour avoir acces au registre
     *
     * @return le registre
     */
    public TreeSet<Employe> getRegistre() {
        return registre;
    }

    /**
     * name: setRegistre
     * fonction: pour setter le registre
     *
     * @param registre
     */
    public void setRegistre(TreeSet<Employe> registre) {
        this.registre = registre;
    }

    /**
     * name: ajouterEmploye
     * fonction: permet d'ajouter les employe dans la liste
     *
     * @param employe
     * @throws EmployeDejaEmployeException
     */
    public void ajouterEmploye(Employe employe) throws EmployeDejaEmployeException {

        if (validerEmp(employe)) {//----------------------------il faut vérifier si il existe déja dans la liste
            System.out.println("Erreur");
            throw new EmployeDejaEmployeException("Un employé doublon trouvé ", employe);
        } else {
            JOptionPane.showMessageDialog(null, "Ajout d'un employé avec succès",
                    "Edition", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Good");
            this.registre.add(employe);

        }

    }

    /**
     * name: validerEmp
     * fonction: permet de valider un employe
     * @param employe
     * @return  un boolean
     */
    private boolean validerEmp(Employe employe) {
        for (Employe temp : registre
        ) {
            if (temp.equals(employe)) {
                return true;
            }
        }
        return false;
    }

    /**
     * name: lister Employe
     * fonction: permet de lister en string la liste d'employe
     */
    public void listerEmployes() {
        for (Employe tmp : registre
        ) {
            System.out.println(tmp);
        }
    }

    /**
     * name: afficherEmploye
     * fonction: permet d"afficher les employe avec un stringbuilder
     * @return un string
     */
    public String afficherEmploye() {
        StringBuilder sb = new StringBuilder();
        for (Employe tmp : registre) {
            sb.append(tmp);
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * name: rechercherEmploye
     *
     * @param motCle
     * @return
     */
    public ArrayList<Employe> rechercherEmploye(String motCle) {
        ArrayList<Employe> trouve = new ArrayList<>();

        for (Employe tmp : registre
        ) {
            if (tmp.getNom().equals(motCle)) {
                trouve.add(tmp);
            }
        }
        return trouve;
    }

    /**
     * name: supprimer un employe
     * @param emp
     */
    public void supprimerEmploye(Employe emp) {
        registre.remove(emp);
    }


}
