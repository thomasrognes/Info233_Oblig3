/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */

package DAO;

import Entities.Category;
import Scenes.Main;

import java.sql.*;

public class CategoryDAO {
    private Connection conn;

    public CategoryDAO()
    {
        this.conn = Main.conn;
    }

    /**
     * Metode for å opprette en kategori-instans ved å sende inn kategori ID.
     * @param id på kategorien som skal opprettes.
     * @return kategori instansen.
     * @throws SQLException dersom den ikke blir opprettet.
     */
    public Category createCategoryFromID(int id) throws SQLException{
        Category currCategory = new Category();

        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM category WHERE category_id=" + id);

            if (rs.next()){
                currCategory.setCategory_id(rs.getInt("category_id"));
                currCategory.setCategory_name(rs.getString("category_name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return currCategory;
    }


    /**
     * Metode for å opprette en ny kategori i databasen.
     * @param category som skal opprettes.
     * @throws SQLException dersom den ikke går gjennom.
     */
    public void createNewCategory (Category category) throws SQLException {
        String sql = "INSERT OR IGNORE INTO category (category_id, category_name) VALUES (?,?)";

        try{
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, category.getCategory_id());
            prep.setString(2, category.getCategory_name());

            prep.executeUpdate();
            System.out.println("Lagt til i database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metode for å endre på en kategori som allerede ligger i databasen.
     * @param category som skal endres.
     */
    public void editProductCategory(Category category) {
        String sql = "UPDATE category SET category_name=? WHERE category_id= " + category.getCategory_id();

        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, category.getCategory_name());

            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
