/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.etudiant;

import METIER.Service;
import MODEL.Classe;
import MODEL.Etudiant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Djiby DIOP
 */
public class ViewClassesController implements Initializable {
    
     private Service METIER;
    ObservableList <Classe> obClasses;
    ObservableList <Etudiant> obEtudiants;
    
    @FXML
    private Button handleCreerClasse;

    @FXML
    private TextField textLibelle;
    @FXML
    private TextField textNbreEtudiant;  
    
    
    @FXML
    private TableView<Classe> tblvClasse;
    @FXML
    private TableColumn<Classe, String> tblcId;
    @FXML
    private TableColumn<Classe, String> tblcLibelle;
    @FXML
    private TableColumn<Classe, String> tblcNbreEtudiant;
    @FXML
    
    
    private TableView<Etudiant> tblvEtudiant;
    @FXML
    private TableColumn<Etudiant,String> tblcEtuId;
    @FXML
    private TableColumn<Etudiant,String> tblcNomPrenom;
    @FXML
    private TableColumn<Etudiant,String> tblcTuteur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        METIER=new Service();
        obClasses=FXCollections.observableArrayList(METIER.listerClasse());
        
        loadTable();
    }
        
    private void loadTable(){
            tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
            tblcNbreEtudiant.setCellValueFactory(new PropertyValueFactory<>("nbre"));        
            tblvClasse.setItems(obClasses);
    }    

    @FXML
    private void handleCreerClasse(ActionEvent event) {
        String libelle=textLibelle.getText();
        int nbre=Integer.parseInt(textNbreEtudiant.getText());
        Classe cl=new Classe(libelle,nbre);
        if (METIER.creerClasse(cl)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Classe ajoutée avec succès");
            alert.setTitle("Information");
            alert.show();
            obClasses.add(cl);
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur d'insertion");
            alert.setTitle("Erreur");
            alert.show();   
        }
    }

    @FXML
    private void handleShowEtudiant(MouseEvent event) {
         Classe classeSelected=tblvClasse.getSelectionModel().getSelectedItem();
        obEtudiants=FXCollections.observableArrayList(METIER.listerEtudiantParClasse(classeSelected));
        
         tblcEtuId.setCellValueFactory(new PropertyValueFactory<>("id"));
         tblcNomPrenom.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
         tblcTuteur.setCellValueFactory(new PropertyValueFactory<>("tuteur"));         
         tblvEtudiant.setItems(obEtudiants);
    }                  
    
}
