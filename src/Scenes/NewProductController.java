package Scenes;

import DAO.ProductDAO;
import Entities.Product;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.sql.SQLException;


public class NewProductController {

    public TextField productId;
    public TextField productNameId;
    public TextField descriptionId;
    public TextField priceId;
    public TextField categoryId;

    // Oppretter et nytt produkt i databasen.
    public void createProduct(ActionEvent actionEvent) throws SQLException {
        Product product = new Product();
        ProductDAO productDAO = new ProductDAO();

        product.setProduct_id(Integer.parseInt(productId.getText()));
        product.setProduct_name(productNameId.getText());
        product.setDescription(descriptionId.getText());
        product.setPrice(Integer.parseInt(priceId.getText()));
        product.setCategory(Integer.parseInt(categoryId.getText()));

        productDAO.createNewProduct(product);

    }
}