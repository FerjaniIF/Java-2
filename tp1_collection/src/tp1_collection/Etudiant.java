package tp1_collection;
import java.util.ArrayList;

public class Etudiant implements Statisticable, Comparable<Etudiant> {
	private int matricule;
	private String nom;
	public ArrayList<Note> listeNotes;
	
	public Etudiant(int matricule, String nom) {
		this.matricule = matricule;
		this.nom = nom;
		this.listeNotes = new ArrayList<>();
	}
	
	public int getMatricule() {
		return matricule;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public int setMatricule(int matricule) {
		return this.matricule = matricule;
	}
	
	public String setNom(String nom) {
		return this.nom = nom;
	}
	
	
	public void addNote(Note n) {
		this.listeNotes.add(n);
	}
	
	@Override
	public int compareTo(Etudiant e) {
		if(this.getValue() == e.getValue()) {
			return 0;
		}
		else if (this.getValue() > e.getValue()) {
			return 1;
		}
		else
			return -1;
	}

	@Override
	public float getValue() {
		float somme=0;
		for (Note i : listeNotes) {
			somme+=i.getNote();
		}
	    return somme/listeNotes.size();
	
	}
	
	@Override
	public String toString() {
		return " : Matricule : " + matricule + ", nom : " + nom + ", notes = " + listeNotes ;
	}

}
