package application;

public class Person {

	private String prenom;
	private String nom;
	private String email;
	
	public Person(String prenom, String nom, String email) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public void setPrenom(String pr) {
		this.prenom = pr;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String n) {
		this.nom = n;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String e) {
		this.email = e;
	}
	
	@Override
	public String toString() {
		return prenom+" "+nom+", adresse email : "+email;
	}
}
