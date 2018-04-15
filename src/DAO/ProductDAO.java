/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */


package DAO;

import Entities.Product;
import Sample.Main;

import java.sql.*;

public class ProductDAO {
    private Connection conn;

    public ProductDAO() {
        conn = Main.conn;
    }

    /**
     * Metode for å opprette et produkt-instans ved å sende inn produkt ID.
     * @param id på produktet som skal opprettes.
     * @return Produkt instansen.
     * @throws SQLException dersom den ikke blir opprettet.
     */
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

    /**
     * Metode for å opprette et nytt produkt i databasen.
     * @param product som skal opprettes.
     * @throws SQLException dersom den ikke går gjennom.
     */
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

    /**
     * Metode for å endre på et produkt som allerede ligger i databasen.
     * @param product som skal endres.
     */
    public void editProduct(Product product) {
    String sql = "UPDATE product SET product_name=?, description=?, price=?, category=? WHERE product_id= " + product.getProduct_id();

        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, product.getProduct_name());
            prep.setString(2, product.getDescription());
            prep.setFloat(3, product.getPrice());
            prep.setInt(4, product.getCategory());

            prep.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
         }
    }
}
