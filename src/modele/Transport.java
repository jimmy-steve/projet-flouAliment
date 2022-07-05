package modele;

import java.time.LocalDate;

public class Transport extends Frais{

    public Transport() {
    }

    public Transport(Employe employe, String typeFrais, double prixFacture, LocalDate date) {
        super(employe, typeFrais, prixFacture, date);
    }

    @Override
    public Employe getEmploye() {
        return super.getEmploye();
    }

    @Override
    public void setEmploye(Employe employe) {
        super.setEmploye(employe);
    }

    @Override
    public String getTypeFrais() {
        return super.getTypeFrais();
    }

    @Override
    public void setTypeFrais(String typeFrais) {
        super.setTypeFrais(typeFrais);
    }

    @Override
    public double getPrixFacture() {
        return super.getPrixFacture();
    }

    @Override
    public void setPrixFacture(double prixFacture) {
        super.setPrixFacture(prixFacture);
    }

    @Override
    public double getRemboDispo() {
        return super.getRemboDispo();
    }

    @Override
    public void setRemboDispo(double remboDispo) {
        super.setRemboDispo(remboDispo);
    }

    @Override
    public LocalDate getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(LocalDate date) {
        super.setDate(date);
    }

    @Override
    public String toString() {
        return "Transport" + super.toString();
    }


}
