package DAO;

import Entities.Product;
import Sample.Main;

import java.sql.*;

public class ProductDAO {
    private Connection conn;

    public ProductDAO() {
        conn = Main.conn;
    }

    // Oppretter en instans av Product gjennom ID
    public Product createProductFromId(int id) throws SQLException {
        Product currProduct = new Product();

        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM product WHERE product_id=" + id);

            if (rs.next()){
                currProduct.setProduct_id(rs.getInt("product_id"));
                currProduct.setProduct_name(rs.getString("product_name"));
                currProduct.setDescription(rs.getString("description"));
                currProduct.setPrice(rs.getFloat("price"));
                currProduct.setCategory(rs.getInt("category"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currProduct;
    }

    public void createNewProduct (Product product) throws SQLException {
        String sql = "INSERT OR IGNORE INTO product (product_id, product_name, description, price, category) VALUES (?,?,?,?,?)";

        try{
            PreparedStatement prep = conn.prepareStatement(sql);

            prep.setInt(1, product.getProduct_id());
            prep.setString(2, product.getProduct_name());
            prep.setString(3, product.getDescription());
            prep.setFloat(4, product.getPrice());
            prep.setInt(5, product.getCategory());

            prep.executeUpdate();
            System.out.println("Lagt til i database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
