package tp2_collections;

import java.util.Collection;

public class Main {
	 public static void main(String[] args) {
	        DossierPharmacie pharmacie = new DossierPharmacie("Ma Pharmacie");

	        pharmacie.nouveauPatient("Louay", new String[]{"Aspirine", "Vitamine C"});
	        pharmacie.nouveauPatient("Intissar", new String[]{"Paracetamol", "Ibuprofene"});
	        pharmacie.nouveauPatient("Isslem", new String[]{"Aspirine", "Antibiotique"});

	        pharmacie.affiche();

	        pharmacie.ajoutMedicament("Louay", "Antihistaminique");

	        pharmacie.affichePatient("Louay");

	        Collection<String> patientsAvecAspirine = pharmacie.affichePatientAvecMedicament("Aspirine");
	        System.out.println("Patients prenant de l'Aspirine : " + patientsAvecAspirine);

	        Collection<String> patientsAvecIbuprofene = pharmacie.affichePatientAvecMedicament("Ibuprofene");
	        System.out.println("Patients prenant de l'Ibuprofène : " + patientsAvecIbuprofene);
	    }
	
}
