/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */

package Scenes;

import DAO.ProductDAO;
import Entities.Product;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import java.sql.SQLException;


public class NewProductController {

    public TextField productId;
    public TextField productNameId;
    public TextField descriptionId;
    public TextField priceId;
    public TextField categoryId;
    public Label endringId;

    /**
     * Metode for å hente informasjonen fra TekstFeltene i programmet og opprette en instans av informasjonen.
     * Instansen blir deretter sendt til en metode i DAO klassen som oppretter et nytt produkt i databasen.
     */
    public void createProduct(ActionEvent actionEvent) throws SQLException {
        Product product = new Product();
        ProductDAO productDAO = new ProductDAO();

        product.setProduct_id(Integer.parseInt(productId.getText()));
        product.setProduct_name(productNameId.getText());
        product.setDescription(descriptionId.getText());
        product.setPrice(Integer.parseInt(priceId.getText()));
        product.setCategory(Integer.parseInt(categoryId.getText()));

        productDAO.createNewProduct(product);
        endringId.setText("The product has been saved!");

    }


}