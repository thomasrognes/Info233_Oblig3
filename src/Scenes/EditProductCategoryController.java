package Scenes;

import DAO.CategoryDAO;
import Entities.Category;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditProductCategoryController {

    public TextField categoryId;
    public TextField categoryNameId;
    public Label endringId;


    public void editProductCategory(ActionEvent actionEvent) {
        Category category = new Category();
        CategoryDAO categoryDAO = new CategoryDAO();

        category.setCategory_id(Integer.parseInt(categoryId.getText()));
        category.setCategory_name(categoryNameId.getText());

        categoryDAO.editProductCategory(category);

        endringId.setText("Changes has been saved!");
    }

}
