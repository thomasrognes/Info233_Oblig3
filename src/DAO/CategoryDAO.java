package DAO;

import Entities.Address;
import Entities.Category;
import Sample.Main;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;

public class CategoryDAO {
    private Connection conn;

    public CategoryDAO() {
        this.conn = Main.conn;
    }

    //Oppretter en instans av Category gjennom ID
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
}
