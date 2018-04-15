/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */

package Scenes;

import DAO.CategoryDAO;
import Entities.Category;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class NewProductCategoryController {

    public TextField categoryId;
    public TextField categoryNameId;
    public Label endringId;

    /**
     * Metode for å hente informasjonen fra TekstFeltene i programmet og opprette en instans av informasjonen.
     * Instansen blir deretter sendt til en metode i DAO klassen som oppretter en ny produkt-kategori i databasen.
     */
    public void createProductCategory(ActionEvent actionEvent) throws SQLException {
        Category category = new Category();
        CategoryDAO categoryDAO = new CategoryDAO();

        category.setCategory_id(Integer.parseInt(categoryId.getText()));
        category.setCategory_name(categoryNameId.getText());

        categoryDAO.createNewCategory(category);
        endringId.setText("The category has been saved!");

    }
}