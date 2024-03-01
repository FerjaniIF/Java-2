package tp2_collections;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DossierPharmacie {
	private String nom;
    private HashMap<String, Patient> patients;

    public DossierPharmacie(String nom) {
        this.nom = nom;
        patients = new HashMap <String , Patient >();
    }

    void nouveauPatient(String nom, String[] ord) {
        String nomP = nom.toLowerCase();
        Patient nouveauPatient = new Patient(nomP);
        
        for (String medicament : ord) {
            nouveauPatient.ajoutMedicament(medicament);
        }

        patients.put(nomP, nouveauPatient);
    }

    public boolean ajoutMedicament(String nom, String m) {
        String nomP = nom.toLowerCase();

        Patient patient = patients.get(nomP);
        if (patient != null) {
            patient.ajoutMedicament(m);
            return true;
        } 
        else 
            return false;
        
    }

    public void affichePatient(String nom) {
        String nomP = nom.toLowerCase();

        Patient patient = patients.get(nomP);
        if (patient != null) {
            patient.affiche();
        }
        else 
            System.out.println("Patient non trouve : " + nom);
        
    }
    
    public void affiche() {
        System.out.println("Nom de la pharmacie : " + nom);
        System.out.println("Liste des patients :");
        for (Patient patient : patients.values()) {
            patient.affiche();
        }
    }

    public Collection<String> affichePatientAvecMedicament(String m) {
        Set<String> patientsAvecMedicament = new HashSet<>();

        for (Patient patient : patients.values()) {
            if (patient.contientMedicament(m)) {
                patientsAvecMedicament.add(patient.getNom());
            }
        }

        return patientsAvecMedicament;
    }
    
    

    
}

