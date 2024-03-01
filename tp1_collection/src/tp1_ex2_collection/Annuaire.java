package tp1_ex2_collection;
import java.util.HashMap;
import java.util.Map;


public class Annuaire {
	private Map<String, Fiche> tab;

    public Annuaire() {
        this.tab = new HashMap<>();
    }

    public void ajouterFiche(String nom, String numero, String adresse) {
        Fiche fiche = new Fiche(nom, numero, adresse);
        tab.put(nom, fiche);
    }

    public Fiche rechercherFiche(String nom) {
        return tab.get(nom);
    }

    public void afficherToutesLesFiches() {
        for (Fiche fiche : tab.values()) {
            System.out.println(fiche);
        }
    }
    
    
    
}
