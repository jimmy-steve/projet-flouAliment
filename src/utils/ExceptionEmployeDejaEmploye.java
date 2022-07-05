package utils;

import modele.Employe;

public class ExceptionEmployeDejaEmploye extends Exception{
    private Employe employe;

    public ExceptionEmployeDejaEmploye(Employe employe) {
        this.employe = employe;
    }

    public ExceptionEmployeDejaEmploye(String message, Employe employe) {
        super(message);
        this.employe = employe;
    }

    public Employe getEmploye() {
        return employe;
    }


    @Override
    public String toString() {
        return "ExceptionEmployeDejaEmploye{" +
                "employe=" + employe.toString() +
                '}';
    }
}
