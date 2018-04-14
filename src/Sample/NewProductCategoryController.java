package Sample;

import DAO.CategoryDAO;
import Entities.Category;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class NewProductCategoryController {

    public TextField categoryId;
    public TextField categoryNameId;

    public void createProductCategory(ActionEvent actionEvent) throws SQLException {
        Category category = new Category();
        CategoryDAO categoryDAO = new CategoryDAO();

        category.setCategory_id(Integer.parseInt(categoryId.getText()));
        category.setCategory_name(categoryNameId.getText());

        categoryDAO.createNewCategory(category);
    }
}