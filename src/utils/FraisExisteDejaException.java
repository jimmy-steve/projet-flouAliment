package utils;

import modele.Frais;

public class FraisExisteDejaException extends Exception{
    private Frais frais;

    public FraisExisteDejaException(Frais frais) {
        this.frais = frais;
    }

    public FraisExisteDejaException(String message, Frais frais) {
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
