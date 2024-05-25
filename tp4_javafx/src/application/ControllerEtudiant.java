package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;

public class ControllerEtudiant {

    @FXML
    private TextField nomE;

    @FXML
    private TextField prenomE;

    @FXML
    private RadioButton sexeF;

    @FXML
    private RadioButton sexeH;

    @FXML
    private SplitMenuButton filiereE;

    @FXML
    private Button addBtn;

    @FXML
    private Button suppBtn;

    @FXML
    private Button editBtn;

    @FXML
    private TableView<Etudiant> listeE;

    @FXML
    private TableColumn<Etudiant, Integer> idCol;

    @FXML
    private TableColumn<Etudiant, String> nomCol;

    @FXML
    private TableColumn<Etudiant, String> prenomCol;

    @FXML
    private TableColumn<Etudiant, String> sexeCol;

    @FXML
    private TableColumn<Etudiant, String> filiereCol;

    // Add reference to your EtudiantM manager here

    // Initialize method
    @FXML
    private void initialize() {
        // Configure TableView columns
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        sexeCol.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        filiereCol.setCellValueFactory(new PropertyValueFactory<>("filiere"));

        refreshTableView();
    }

    @FXML
    private void handleAddE() {
        // Get data from the input fields
        String nom = nomE.getText();
        String prenom = prenomE.getText();
        String sexe = sexeF.isSelected() ? "F" : "H"; 
        String filiere = filiereE.getText();

        Etudiant etudiant = new Etudiant(nom, prenom, sexe, filiere);

        EtudiantM etudiantM = new EtudiantM();
        etudiantM.create(etudiant);

        refreshTableView();
    }

    @FXML
    private void handleDeleteE() {
        Etudiant selectedEtudiant = listeE.getSelectionModel().getSelectedItem();
        EtudiantM etudiantM = new EtudiantM();
		etudiantM.delete(selectedEtudiant);

        refreshTableView();
    }

    @FXML
    private void handleUpdateE() {
        Etudiant selectedEtudiant = listeE.getSelectionModel().getSelectedItem();

        String nom = nomE.getText();
        String prenom = prenomE.getText();
        String sexe = sexeF.isSelected() ? "F" : "H"; 
        String filiere = filiereE.getText();

        selectedEtudiant.setNom(nom);
        selectedEtudiant.setPrenom(prenom);
        selectedEtudiant.setSexe(sexe);
        selectedEtudiant.setFiliere(filiere);
        EtudiantM etudiantM = new EtudiantM();
		etudiantM.update(selectedEtudiant);

        refreshTableView();
    }

    private void refreshTableView() {
        EtudiantM etudiantM = new EtudiantM();
        List<Etudiant> etudiants = etudiantM.findAll();

        listeE.getItems().clear();

        listeE.getItems().addAll(etudiants);
    }
}
