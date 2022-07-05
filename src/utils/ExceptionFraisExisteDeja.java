package utils;

import modele.Frais;

public class ExceptionFraisExisteDeja extends Exception{
    private Frais frais;

    public ExceptionFraisExisteDeja(Frais frais) {
        this.frais = frais;
    }

    public ExceptionFraisExisteDeja(String message, Frais frais) {
        super(message);
        this.frais = frais;
    }

    public Frais getFrais() {
        return frais;
    }

    @Override
    public String toString() {
        return "ExceptionFraisExisteDeja{" +
                "frais=" + frais +
                '}';
    }
}
