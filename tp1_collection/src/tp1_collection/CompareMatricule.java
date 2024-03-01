package tp1_collection;

import java.util.Comparator;

public class CompareMatricule implements Comparator<Etudiant>{

	@Override
	public int compare(Etudiant o1, Etudiant o2) {
		
		return Integer.compare(o1.getMatricule(), o2.getMatricule());
	}
	
}
