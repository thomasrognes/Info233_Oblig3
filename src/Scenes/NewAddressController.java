/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */

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

    /**
     * Metode for å hente informasjonen fra TekstFeltene i programmet og opprette en instans av informasjonen.
     * Instansen blir deretter sendt til en metode i DAO klassen som oppretter en ny adresse i databasen.
     */
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
