package tp1_ex2_collection;
import java.util.Scanner;

public class gestionAnnuaires {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Annuaire annuaire = new Annuaire();
        boolean condition = true;

        while (condition) {
            System.out.println("Entrez une commande (+nom, ?nom, !, bye) : ");
            String commande = scanner.next();

            switch (commande) {
                case "+":
                    String nom = scanner.next();
                    String numero = scanner.next();
                    String adresse = scanner.next();
                    annuaire.ajouterFiche(nom, numero, adresse);
                    break;

                case "?":
                    String nomRecherche = scanner.next();
                    Fiche ficheTrouvee = annuaire.rechercherFiche(nomRecherche);
                    if (ficheTrouvee != null) {
                        System.out.println(ficheTrouvee);
                    } else 
                        System.out.println("Aucune fiche trouvee pour le nom : " + nomRecherche);
                    break;

                case "!":
                    annuaire.afficherToutesLesFiches();
                    break;

                case ".":
                    System.out.println("Programme termine");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Commande non reconnue. Reessayer.");
            }
        }
    }
}
