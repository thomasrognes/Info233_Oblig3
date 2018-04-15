/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */

package DAO;

import Entities.Customer;
import Sample.Main;

import java.sql.*;

public class CustomerDAO {

    private Connection conn;

    public CustomerDAO() {
        this.conn = Main.conn;
    }

    /**
     * Metode for å opprette en kunde-instans ved å sende inn kunde ID.
     * @param id på kunden som skal opprettes.
     * @return Adresse instansen.
     * @throws SQLException dersom den ikke blir opprettet.
     */    public Customer createCustomerFromId(int id) throws SQLException{
        Customer currCustomer = new Customer();

        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM customer WHERE customer_id=" + id);

            if (rs.next()){
                currCustomer.setCustomer_id(rs.getInt("customer_id"));
                currCustomer.setCustomer_name(rs.getString("customer_name"));
                currCustomer.setAddress(rs.getInt("address"));
                currCustomer.setPhone_number(rs.getString("phone_number"));
                currCustomer.setBilling_account(rs.getString("billing_account"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currCustomer;
    }

    /**
     * Metode for å opprette en ny kunde i databasen.
     * @param customer som skal opprettes.
     * @throws SQLException dersom den ikke går gjennom.
     */
    public void createNewCustomer (Customer customer) throws SQLException {
        String sql = "INSERT OR IGNORE INTO customer (customer_id, customer_name, address, phone_number, billing_account) VALUES (?,?,?,?,?)";

        try{
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, customer.getCustomer_id());
            prep.setString(2, customer.getCustomer_name());
            prep.setInt(3, customer.getAddress());
            prep.setString(4, customer.getPhone_number());
            prep.setString(5, customer.getBilling_account());
            prep.executeUpdate();
            System.out.println("Lagt til i database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metode for å endre på en kunde som allerede ligger i databasen.
     * @param customer som skal endres.
     */
    public void editCustomer(Customer customer)  {
        String sql = "UPDATE customer SET customer_name=?, address=?, phone_number=?, billing_account=? WHERE customer_id= " + customer.getCustomer_id();

        try{
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, customer.getCustomer_name());
            prep.setInt(2, customer.getAddress());
            prep.setString(3, customer.getPhone_number());
            prep.setString(4, customer.getBilling_account());

            prep.executeUpdate();
            System.out.println("Endret.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
