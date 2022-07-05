package modele;

import java.util.Comparator;

public class FraisComparator implements Comparator<Frais> {
    @Override
    public int compare(Frais o1, Frais o2) { return (o1.getEmploye().getNom().compareTo(o2.getEmploye().getNom()));
    }
}
