package tp1_collection;
import java.util.ArrayList;
import java.util.Collections;

public class main {

	 public static void main(String args[]) {

	        ArrayList<Etudiant> listeEtudiants = new ArrayList<>();
	        Stats stats = new Stats();

	        Etudiant e1 = new Etudiant(115566, "amal");
	        Note n1 = new Note("java", 14.25f);
	        e1.addNote(n1);
	        
	        Etudiant e2 = new Etudiant(115567, "adem");
	        Note n2 = new Note("UX", 15.25f);
	        e2.addNote(n2);

	    
	        listeEtudiants.add(e1);
	        listeEtudiants.add(e2);
	        

	        System.out.println("Liste des etudiants :");
	        for (Etudiant e : listeEtudiants) {
	            System.out.println(e);
	        }

	        Collections.sort(listeEtudiants, new CompareNom());
	        System.out.println("\nTri par nom :");
	        for (Etudiant etudiant : listeEtudiants) {
	            System.out.println(etudiant);
	        }

	        Collections.sort(listeEtudiants, new CompareMatricule());
	        System.out.println("\nTri par matricule :");
	        for (Etudiant etudiant : listeEtudiants) {
	            System.out.println(etudiant);
	        }

	        System.out.println("\nMoyennes des etudiants :");
	        for (Etudiant e : listeEtudiants) {
	            System.out.println("Etudiant: " + e.getNom());
	            System.out.println("Moyenne: " + e.getValue());
	            System.out.println("Meilleure note : " + stats.meilleurNote(e));
	            System.out.println("Moins bonne note : " + stats.meilleurNote(e));
	            System.out.println();
	        }

	        System.out.println("Moyenne du groupe : " + stats.moyGroupe(listeEtudiants));

	        Etudiant meilleurEtudiant = stats.meilleurEtudiant(listeEtudiants);
	        Etudiant moinsBonEtudiant = stats.moinsbonEtudiant(listeEtudiants);

	        System.out.println("\nMeilleur etudiant : ");
	        System.out.println("Matricule : " + meilleurEtudiant.getMatricule());
	        System.out.println("Nom : " + meilleurEtudiant.getNom());
	        System.out.println("Moyenne : " + stats.moyNotes(meilleurEtudiant));

	        System.out.println("\nMoins bon etudiant : ");
	        System.out.println("Matricule : " + moinsBonEtudiant.getMatricule());
	        System.out.println("Nom : " + moinsBonEtudiant.getNom());
	        System.out.println("Moyenne : " + stats.moyNotes(moinsBonEtudiant));
	    }
}
