package tp1_collection;
import java.util.ArrayList;
import java.util.Collections;

 public class Stats {

    public Note meilleurNote(Etudiant e) {
    	return Collections.max(e.listeNotes);
    }
    
    public Note moinsNote(Etudiant e) {
    	return Collections.min(e.listeNotes);
    }
    
    static public float moyNotes(Etudiant e) {
    	return e.getValue();
    }
    
    public Etudiant meilleurMoy(ArrayList<Etudiant> e) {
    	return Collections.max(e);
    }
    
    public Etudiant MoinsMoy(ArrayList<Etudiant> e) {
    	return Collections.min(e);
    }
    
 
    
    public float moyGroupe(ArrayList<Etudiant> es) {	  
    	float sum = 0;
    		for (Etudiant e : es) {
    			sum += moyNotes(e);
    		}
    		return sum / es.size();
    }

    public Etudiant meilleurEtudiant(ArrayList<Etudiant> es) {  
		    return (Collections.max(es));
	}

	public Etudiant moinsbonEtudiant(ArrayList<Etudiant> es) {  
	    return (Collections.min(es));
	}
}
