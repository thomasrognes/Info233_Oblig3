package Sample;


import Entities.Invoice;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.awt.event.ActionEvent;
import java.io.IOException;



public class SampleController {

    // Åpner Faktura vincuet.
    public void openInvoiceScene(javafx.event.ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Sample/InvoiceScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Faktura");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Faktura kan ikke vises");
        }
    }

    // Åpner vinduet som gir deg muligheten til å opprette en ny kunde.
    public void openNewCustomerScene(javafx.event.ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Sample/NewCustomerScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("New Customer");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }

    // Åpner vinduet som gir deg muligheten til å opprette en ny kunde.
    public void openNewAddressScene(javafx.event.ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Sample/NewAddressScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("New Address");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }

    // Åpner vinduet som gir deg muligheten til å opprette en ny produkt kategori.
    public void openNewProductCategoryScene(javafx.event.ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Sample/NewProductCategoryScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("New Product Category");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }

    // Åpner vinduet som gir deg muligheten til å opprette et nytt produkt.
    public void openNewProductScene(javafx.event.ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Sample/NewProductScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("New Product");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }

    // Åpner vinduet som gir deg muligheten til å opprette en ny faktura.
    public void openNewInvoiceScene(javafx.event.ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Sample/NewInvoiceScene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("New Invoice");
            stage.setScene(new Scene(root, 550, 600));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error opening the window");
        }
    }
}


