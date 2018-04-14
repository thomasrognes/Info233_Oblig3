package Scenes;

import DAO.ProductDAO;
import Entities.Product;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditProductController {
    public TextField productId;
    public TextField productNameId;
    public TextField descriptionId;
    public TextField priceId;
    public TextField categoryId;
    public Label endringId;

    public void editProduct(ActionEvent actionEvent) {
        Product product = new Product();
        ProductDAO productDAO = new ProductDAO();

        product.setProduct_id(Integer.parseInt(productId.getText()));
        product.setProduct_name(productNameId.getText());
        product.setDescription(descriptionId.getText());
        product.setPrice(Integer.parseInt(priceId.getText()));
        product.setCategory(Integer.parseInt(categoryId.getText()));

        productDAO.editProduct(product);

        endringId.setText("Changes has been saved!");
    }
}
