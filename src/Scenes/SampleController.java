/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */

package Scenes;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;



public class SampleController {

    /**
     * Metode som åpner vinduet som viser en faktura.
     */
    public void openInvoiceScene(javafx.event.ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Scenes/InvoiceScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Faktura");
            stage.setScene(new Scene(root, 750, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Faktura kan ikke vises");
        }
    }

    /**
     * Metode som åpner vinduet der man kan opprette en ny kunde.
     */
    public void openNewCustomerScene(javafx.event.ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Scenes/NewCustomerScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("New Customer");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }

    /**
     * Metode som åpner vinduet der man kan opprette en ny adresse.
     */
    public void openNewAddressScene(javafx.event.ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Scenes/NewAddressScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("New Address");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }

    /**
     * Metode som åpner vinduet der man kan opprette en ny produkt-kategori.
     */
    public void openNewProductCategoryScene(javafx.event.ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Scenes/NewProductCategoryScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("New Product Category");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }

    /**
     * Metode som åpner vinduet der man kan opprette et nytt produkt.
     */
    public void openNewProductScene(javafx.event.ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Scenes/NewProductScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("New Product");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }

    /**
     * Metode som åpner vinduet der man kan opprette en ny faktura.
     */
    public void openNewInvoiceScene(javafx.event.ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Scenes/NewInvoiceScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("New Invoice");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }


    /**
     * Metode som åpner vinduet der man kan endre på en kunde.
     */
    public void openEditCustomerScene(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Scenes/EditCustomerScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Edit Customer");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }


    /**
     * Metode som åpner vinduet der man kan endre på en adresse.
     */
    public void openEditAddressScene(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Scenes/EditAddressScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Edit Address");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }

    /**
     * Metode som åpner vinduet der man kan endre på et produkt.
     */
    public void openEditProductScene(ActionEvent actionEvent) {
        Parent root;
        try {
        root = FXMLLoader.load(getClass().getResource("/Scenes/EditProductScene.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Edit Product");
        stage.setScene(new Scene(root, 550, 600));
        stage.show();
        } catch (IOException e){
        e.printStackTrace();
        System.out.println("Error opening the window");
        }
    }

    /**
     * Metode som åpner vinduet der man kan endre på en produkt-kategori
     */
    public void openEditProductCategoryScene(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Scenes/EditProductCategoryScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Edit product category");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }


    /**
     * Metode som åpner vinduet der man kan endre på en faktura.
     */
    public void openEditInvoiceScene(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Scenes/EditInvoiceScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Edit Invoice");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }
}


