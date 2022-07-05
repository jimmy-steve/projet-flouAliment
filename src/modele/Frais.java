package modele;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Frais {
    private Employe employe;
    private String typeFrais;
    private double prixFacture;
    private double remboDispo;
    private LocalDate date;

    public Frais() {
    }

    public Frais(Employe employe, String typeFrais, double prixFacture, LocalDate date) {
        this.employe = employe;
        this.typeFrais = typeFrais;
        this.prixFacture = prixFacture;
        this.date = date;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public String getTypeFrais() {
        return typeFrais;
    }

    public void setTypeFrais(String typeFrais) {
        this.typeFrais = typeFrais;
    }

    public double getPrixFacture() {
        return prixFacture;
    }

    public void setPrixFacture(double prixFacture) {
        this.prixFacture = prixFacture;
    }

    public double getRemboDispo() {
        return remboDispo;
    }

    public void setRemboDispo(double remboDispo) {
        this.remboDispo = remboDispo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Frais)) return false;
        Frais frais = (Frais) o;
        return Double.compare(frais.getPrixFacture(), getPrixFacture()) == 0 && Double.compare(frais.getRemboDispo(), getRemboDispo()) == 0 && Objects.equals(getEmploye(), frais.getEmploye()) && Objects.equals(getTypeFrais(), frais.getTypeFrais()) && Objects.equals(getDate(), frais.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmploye(), getTypeFrais(), getPrixFacture(), getRemboDispo(), getDate());
    }

    @Override
    public String toString() {
        return "{" +
                "employe=" + employe +
                ", typeFrais='" + typeFrais + '\'' +
                ", prixFacture=" + prixFacture +
                ", remboDispo=" + remboDispo +
                ", date=" + date +
                '}';
    }


}
