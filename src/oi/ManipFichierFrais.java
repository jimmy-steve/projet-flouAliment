package oi;

import modele.*;
import modele.Frais;
import modele.RegistreFrais;
import utils.FraisExisteDejaException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ManipFichierFrais {

    /**
     * name: lecture
     * @param fichier
     * @param listingFrais
     */
    public static void lecture(String fichier, RegistreFrais listingFrais) {

        File file = new File(fichier);

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String ligne;
            while ((ligne = br.readLine()) != null) {

                Hebergement frais = parserLigne(ligne);

                    listingFrais.ajouterFrais(frais);

            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FraisExisteDejaException e) {
            e.printStackTrace();
        }
    }

    /**
     * name: parserLigner
     * @param ligne
     * @return un string ligne
     */
    private static Hebergement parserLigne(String ligne) {

        String[] tokens = ligne.split(";");
        String nom = tokens[0];
        String prenom = tokens[1];//-------------------------------on dirait sa bloque ici------- Index 1 out of bounds for length 1
        String type = tokens[2];
        String typeFrais = tokens[3];
        double prixFacture = Double.parseDouble(tokens[4]);
        LocalDate date = LocalDate.parse(tokens[5], DateTimeFormatter.ISO_DATE);

        Employe emp = new Employe();
        emp.setNom(nom);
        emp.setPrenom(prenom);
        emp.setType(type);

        Hebergement test = new Hebergement(emp, typeFrais, prixFacture, date);


        return test;
    }

    /**
     * name: ecriture
     * fonction: permett l'écriture et de persister les donnée dans un fichier
     * @param fichier
     * @param listingFrais
     *
     */
    public static void ecriture(String fichier, RegistreFrais listingFrais) throws IOException {
        File file = new File(fichier);
        FileWriter fw = null;
        BufferedWriter bw = null;

            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            for (Frais Frais : listingFrais.getRegistreFrais2()) {

                String ligne = formerLigne(Frais);
                bw.write(ligne);
                bw.newLine();
            }
            bw.close();

    }

    /**
     * name: formerLigne
     *
     * @param frais
     * @return un frais avec l"'employe et ses frais
     */
    public static String formerLigne(Frais frais) {
        return frais.getEmploye().getNom() + ";" + frais.getEmploye().getPrenom() + ";" + frais.getEmploye().getType() + ";" + frais.getTypeFrais() + ";" + frais.getPrixFacture() + ";" + frais.getRemboDispo() + ";" + frais.getDate() + "\n";
    }

}
