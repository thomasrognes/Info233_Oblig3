/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */

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


    /**
     * Metode for å hente informasjonen fra TekstFeltene i programmet og opprette en instans av informasjonen.
     * Instansen blir deretter sendt til en metode i DAO klassen.
     *
     */
    public void editProductCategory(ActionEvent actionEvent) {
        Category category = new Category();
        CategoryDAO categoryDAO = new CategoryDAO();

        category.setCategory_id(Integer.parseInt(categoryId.getText()));
        category.setCategory_name(categoryNameId.getText());

        categoryDAO.editProductCategory(category);

        endringId.setText("Changes has been saved!");
    }

}
