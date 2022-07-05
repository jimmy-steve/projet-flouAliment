package utils;

import modele.Employe;
import modele.Frais;
import modele.RegistreFrais;

import javax.swing.*;

public class Utilitaire {

    /**
     *  Calcule le remboursement pour les frais d'hébergement en fonction de l'employé, son type, le mois. Return Le montant illigible au remboursement.
     * @param emp
     * @param listingFrais
     * @param frais
     * @return double
     */
    public static double calculRemboursementMaxHebergement(Employe emp, RegistreFrais listingFrais, Frais frais) {
        double montantRembourse = 0;
        double montantUtilisePrealable = 0;
        double remboDispoTotalHergement = 0;

        switch (emp.getType()) {
            case "junior":
                remboDispoTotalHergement = 1200;

                montantUtilisePrealable = calculerMontantUtiliseMois(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotalHergement, emp, frais);

                break;
            case "senior":
                remboDispoTotalHergement = 1600;

                montantUtilisePrealable = calculerMontantUtiliseMois(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotalHergement, emp, frais);
                break;
            case "super":
                remboDispoTotalHergement = 3000;

                montantUtilisePrealable = calculerMontantUtiliseMois(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotalHergement, emp, frais);

                break;
        }
        return montantRembourse;
    }

    /**
     *  Calcule le remboursement  pour les frais de restauration en fonction de l'employé, son type, le mois. Return Le montant illigible au remboursement.
     * @param emp
     * @param listingFrais
     * @param frais
     * @return double
     */
    public static double calculRemboursementMaxRestaurant(Employe emp, RegistreFrais listingFrais, Frais frais) {
        double montantRembourse = 0;
        double montantUtilisePrealable = 0;
        double remboDispoTotalRestaurant;

        switch (emp.getType()) {
            case "junior":
                remboDispoTotalRestaurant = 25;

                montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotalRestaurant, emp, frais);

                break;
            case "senior":
                remboDispoTotalRestaurant = 40;

                montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotalRestaurant, emp, frais);
                break;


            case "super":
                remboDispoTotalRestaurant = 60;

                montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotalRestaurant, emp, frais);
                break;
        }
        return montantRembourse;
    }


    /**
     *  Calcule le remboursement  pour les frais de transport en fonction de l'employé, son type, le mois et le jour. Return Le montant illigible au remboursement.
     * @param emp
     * @param listingFrais
     * @param frais
     * @return double
     */
    public static double calculRemboursementMaxTransport(Employe emp, RegistreFrais listingFrais, Frais frais) {
        double montantRembourse = 0;
        double montantUtilisePrealable = 0;
        double remboDispoTotalTransport;

        switch (emp.getType()) {
            case "junior":
                remboDispoTotalTransport = 50;

                montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotalTransport, emp, frais);


                break;
            case "senior":
                remboDispoTotalTransport = 80;

                montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotalTransport, emp, frais);

                break;
            case "super":
                remboDispoTotalTransport = 150;

                montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotalTransport, emp, frais);

                break;
        }
        return montantRembourse;
    }

    /**
     *Calcule le remboursement  pour les frais de transport en fonction de l'employé, son type, le mois, le jour.
     * @param emp
     * @param listingFrais
     * @param frais
     * @return en double Le montant illigible au remboursement.
     */
    public static double calculRemboursementMaxTransportAvion(Employe emp, RegistreFrais listingFrais, Frais frais) {
        double montantRembourse = 0;
        double montantUtilisePrealable = 0;
        double remboDispoTotalTransport = 2000;

        if (emp.getType().equalsIgnoreCase(("super"))){
            montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais,montantUtilisePrealable,emp);
            montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotalTransport, emp, frais);
        }

        return montantRembourse;
    }


    /**
     * Le montant utilié au préalable par l'employé dans l'espace temps de un mois
     * @param listingFrais
     * @param frais
     * @param montantUtilisePrealable
     * @param emp
     * @return double
     */
    private static double calculerMontantUtiliseMois(RegistreFrais listingFrais, Frais frais, double montantUtilisePrealable, Employe emp) {
        for (Frais tmp : listingFrais.getRegistreFrais2()) {
            if (frais.getDate().getYear() == tmp.getDate().getYear()
                    && frais.getDate().getMonth() == tmp.getDate().getMonth()
                    && frais.getTypeFrais().equalsIgnoreCase(tmp.getTypeFrais())) {
                montantUtilisePrealable += tmp.getPrixFacture();
            }
        }
        return montantUtilisePrealable;
    }

    /**
     * Le montant utilié au préalable par l'employé dans l'espace temps de un jour.
     * @param listingFrais
     * @param frais
     * @param montantUtilisePrealable
     * @param emp
     * @return double
     */
    private static double calculerMontantUtiliseJour(RegistreFrais listingFrais, Frais frais, double montantUtilisePrealable, Employe emp) {
        for (Frais tmp : listingFrais.getRegistreFrais2()) {
            if (frais.getDate().getYear() == tmp.getDate().getYear()
                    && frais.getDate().getMonth() == tmp.getDate().getMonth()
                    && frais.getDate().getDayOfMonth() == tmp.getDate().getDayOfMonth()
                    && frais.getTypeFrais().equalsIgnoreCase(tmp.getTypeFrais())) {
                montantUtilisePrealable += tmp.getPrixFacture();
            }
        }
        return montantUtilisePrealable;
    }

    /**
     *  Calcule le montant à remboursé selon le type d'employé et renvoie un message pour avertir le comptable du montant à rembourser
     * @param montantUtilisePrealable
     * @param remboDispoTotal
     * @param emp
     * @param frais
     * @return double
     *
     */
    private static double caculerMontantRembourse(double montantUtilisePrealable, double remboDispoTotal, Employe emp, Frais frais) {
        double montantRembourse = 0;
        if (montantUtilisePrealable > remboDispoTotal) {
            alertDepassementRemboursement(emp, montantRembourse);
            return 0;
        } else if ((montantUtilisePrealable + frais.getPrixFacture()) > remboDispoTotal) {
            montantRembourse = remboDispoTotal - montantUtilisePrealable;
            alertDepassementRemboursement(emp, montantRembourse);
            return montantRembourse;
        } else
            return frais.getPrixFacture();
    }

    /**
     * Afficher message d'avertissement
     *
     * @param emp
     * @param montantRembourse
     */
    private static void alertDepassementRemboursement(Employe emp, double montantRembourse) {
        JOptionPane.showMessageDialog(null, "Remboursement disponible dépassé.\n Voici le montant auquel " + emp.getPrenom() + " " + emp.getNom() + " aura droit: " + montantRembourse,
                "Saisie de valeurs",
                JOptionPane.ERROR_MESSAGE);
    }

}