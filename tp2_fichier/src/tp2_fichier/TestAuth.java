package tp2_fichier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestAuth {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\fichiers\\in.txt"));
        String ligne;

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Entrer Login: ");
        String loginSaisi = sc.nextLine();

        System.out.print("Entrer Mot de passe : ");
        String passwordSaisi = sc.nextLine();

        while ((ligne = br.readLine()) != null) {
            String[] parts = ligne.split(" ");
            if (parts.length == 2) {
                String login = parts[0];
                String password = parts[1];
                
                if (login.equals(loginSaisi) && password.equals(passwordSaisi)) {
                    System.out.println("Authentification réussite");
                    return;
                }
            }
        }
        System.out.println("PB Authentification");
        
        br.close();
        sc.close();
    }
}
