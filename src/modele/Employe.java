package modele;
import java.util.Objects;

/**
 * Classe Employe
 */
public class Employe {
    private String nom;
    private String prenom;
    private String type;

    /**
     * constructeur par default
     */
    public Employe() {
    }

    /**
     * constructeur surchargé
     *
     * @param nom
     * @param prenom
     * @param type
     */
    public Employe(String nom, String prenom, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    /**
     * le equals pour employe
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;
        Employe employe = (Employe) o;
        return Objects.equals(getNom().toUpperCase(), employe.getNom().toUpperCase()) && Objects.equals(getPrenom().toUpperCase(), employe.getPrenom().toUpperCase()) && Objects.equals(getType().toUpperCase(), employe.getType().toUpperCase());
    }

    /**
     * le hascodeEmploye
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getPrenom(), getType());
    }

    /**
     * Name: Tostring
     * @return
     */
    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
