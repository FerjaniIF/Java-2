package application;

import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddBookControlor implements Initializable {
    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfEmail;

    @FXML
    private Button addBtn;

    @FXML
    private Button exportBtn;

    @FXML
    private Button importBtn;

    @FXML
    private Button removeBtn;

    @FXML
    private Button quitBtn;

    @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, String> emailCol;

    @FXML
    private TableColumn<Person, String> firstNameCol;

    @FXML
    private TableColumn<Person, String> lastNameCol;

    private DataClass data;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
        table.setEditable(true);

        data = new DataClass();
        table.setItems(FXCollections.observableArrayList(data.getImportList()));

        addBtn.setOnAction(event -> addPerson());
        exportBtn.setOnAction(event -> exportData());
        importBtn.setOnAction(event -> importData());
        removeBtn.setOnAction(event -> remove());
        quitBtn.setOnAction(event -> quit());
    }

    public void addPerson() {
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String email = tfEmail.getText();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty()) {
        	if (isEmailAdress(email)) {
	            Person p = new Person(firstName, lastName, email);
	            table.getItems().add(p);
	
	            tfFirstName.clear();
	            tfLastName.clear();
	            tfEmail.clear();
        	}else
                showAlert(AlertType.ERROR, email + " : Email incorrect !");
        } else 
            showAlert(AlertType.WARNING, "Veuillez remplir tous les champs !");
        
    }

    public void exportData() {
        List<Person> persons = new ArrayList<>(table.getItems());
        data.setExportList(persons);
    }

    public void importData() {
        ObservableList<Person> impD = FXCollections.observableArrayList(data.getImportList());
        table.setItems(impD);
    }

    public void remove() {
        Person p = table.getSelectionModel().getSelectedItem();
        if (p != null) {
            table.getItems().remove(p);
        }
    }

    public void quit() {
        System.exit(0);
    }
    
    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static boolean isEmailAdress(String email){
    	Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$" );
    	Matcher m = p.matcher(email.toUpperCase()); 
    	return m.matches();
    }

}
