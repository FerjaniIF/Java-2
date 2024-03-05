package td2_collection;

public class Main {

	    public static void main(String[] args) {
	        Stock stock = new Stock();

	        Article article1 = new Article("Laptop", 1200.00);
	        Article article2 = new Article("Phone", 800.00);

	        stock.addNouvArticle(article1, 10);
	        stock.addNouvArticle(article2, 20);

	        System.out.println("Initial Stock:");
	        stock.sortStock();

	        Facture fact = new Facture(stock);

	        fact.addLigne(3, "Laptop");
	        fact.addLigne(2, "Phone");

	        System.out.println("\nStock apres facture:");
	        stock.sortStock();

	        System.out.println("\nStock Details:");
	        for (LigneFacture ligneFacture : fact.getLignes()) {
	            System.out.println("Article: " + ligneFacture.getArticle().getNom() +
	                    ", Quantity: " + ligneFacture.getQt() +
	                    ", Total: " + ligneFacture.getMontantTotal());
	        }

	        fact.removeLigne(1);

	        System.out.println("\nStock apres suppression:");
	        stock.sortStock();

	        System.out.println("\nUpdated stock Details:");
	        for (LigneFacture ligneFacture : fact.getLignes()) {
	            System.out.println("Article: " + ligneFacture.getArticle().getNom() +
	                    ", Quantity: " + ligneFacture.getQt() +
	                    ", Total: " + ligneFacture.getMontantTotal());
	        }

	        System.out.println("\nTotal Stock Amount: " + fact.getMontantTotal());
	    }
	

}
