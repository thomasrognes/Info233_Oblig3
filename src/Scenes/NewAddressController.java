package Scenes;

import DAO.AddressDAO;
import Entities.Address;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class NewAddressController {

    public TextField addressId;
    public TextField streetNumberId;
    public TextField streetNameId;
    public TextField postalCodeId;
    public TextField postalTownId;
    public Label endringId;


    public void createAddress(ActionEvent actionEvent) throws SQLException {
        Address address = new Address();
        AddressDAO addressDAO = new AddressDAO();

        address.setAddress_id(Integer.parseInt(addressId.getText()));
        address.setStreet_number(streetNumberId.getText());
        address.setStreet_name(streetNameId.getText());
        address.setPostal_code(postalCodeId.getText());
        address.setPostal_town(postalTownId.getText());

        addressDAO.createNewAddress(address);
        endringId.setText("The address has been saved!");

    }
}
