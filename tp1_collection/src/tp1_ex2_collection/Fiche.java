package tp1_ex2_collection;

public class Fiche {
	private String nom;
	private String adr;
	private String num;
	
	public Fiche(String nom, String num, String adr) {
        this.nom = nom;
        this.num = num;
        this.adr = adr;
    }
	
	public String getNom() {
		return nom;
	}
	
	public String getNum() {
		return num;
	}
	
	public String getAdr() {
		return adr;
	}
	
	public void setNom(String  nom) {
		this.nom = nom;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public void setAdr(String adr) {
		this.adr = adr;
	}
	
	 @Override
	 public String toString() {
	    return "Nom: " + nom + ", Numero: " + num + ", Adresse: " + adr;
	 }
	
}
