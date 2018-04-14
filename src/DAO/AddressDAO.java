package DAO;

import Entities.Address;
import Entities.Customer;
import Sample.Main;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class AddressDAO {

    private Connection conn;

    public AddressDAO(){
        this.conn = Main.conn;
    }

    //Oppretter en instans av Address gjennom ID
    public Address createAddressFromId(int id) throws SQLException{
        Address currAddress = new Address();

        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM address WHERE address_id=" + id);

            if (rs.next()){
                currAddress.setAddress_id(rs.getInt("address_id"));
                currAddress.setStreet_number(rs.getString("street_number"));
                currAddress.setStreet_name(rs.getString("street_name"));
                currAddress.setPostal_code(rs.getString("postal_code"));
                currAddress.setPostal_town(rs.getString("postal_town"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return currAddress;
    }

    // Oppretter en ny kunde
    public void createNewAddress (Address address) throws SQLException {
        String sql = "INSERT OR IGNORE INTO address (address_id, street_number, street_name, postal_code, postal_town) VALUES (?,?,?,?,?)";

        try{
            PreparedStatement prep = conn.prepareStatement(sql);

            prep.setInt(1, address.getAddress_id());
            prep.setString(2, address.getStreet_number());
            prep.setString(3, address.getStreet_name());
            prep.setString(4, address.getPostal_code());
            prep.setString(5, address.getPostal_town());

            prep.executeUpdate();
            System.out.println("Lagt til i database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
