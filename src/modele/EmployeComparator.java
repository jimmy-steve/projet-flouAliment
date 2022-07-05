package modele;

import java.util.Comparator;

/**
 * name: Employe Comparator
 * fonction: comparer 2 objet employe
 */
public class EmployeComparator implements Comparator<Employe> {
    /**
     * name: compare
     * fonction: prend 2 objet employe en parametre et les compare sur leur nom
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Employe o1, Employe o2) {
        return (o1.getNom().compareTo(o2.getNom() ));
    }
}
