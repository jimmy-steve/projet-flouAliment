package utils;

import modele.Employe;

/**
 * name : EmployeDejaEmployeException
 * fonction : verifier si un employe est déja présent
 */
public class EmployeDejaEmployeException extends Exception{
    private Employe employe;

    /**
     * constructeur qui prend un employe en parametre
     * @param employe
     */
    public EmployeDejaEmployeException(Employe employe) {
        this.employe = employe;
    }

    /**
     * name: EmployeDejaEmployeException
     * fonction : retounrer un message d'erreur
     * @param message
     * @param employe
     */
    public EmployeDejaEmployeException(String message, Employe employe) {
        super(message);
        this.employe = employe;
    }

    /**
     * name: GetEmploye
     * fonction : pour aller cherche le nom de l'employe trouver
     * @return
     */
    public Employe getEmploye() {
        return employe;
    }

    /**
     * name: to string
     * fonction : retourner en string
     * @return
     */
    @Override
    public String toString() {
        return "ExceptionEmployeDejaEmploye{" +
                "employe=" + employe.toString() +
                '}';
    }
}
