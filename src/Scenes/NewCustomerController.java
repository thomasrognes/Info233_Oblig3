/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */

package Scenes;
import DAO.*;

import Entities.Address;
import Entities.Customer;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class NewCustomerController {

    public TextField customerId;
    public TextField customerNameId;
    public TextField addressId;
    public TextField phoneNumberId;
    public TextField billingAccountId;
    public Label endringId;



    /**
     * Metode for å hente informasjonen fra TekstFeltene i programmet og opprette en instans av informasjonen.
     * Instansen blir deretter sendt til en metode i DAO klassen som oppretter en ny kunde i databasen.
     */
    public void createCustomer(ActionEvent actionEvent) throws SQLException {
        Customer customer = new Customer();
        CustomerDAO customerDAO = new CustomerDAO();

        customer.setCustomer_id(Integer.parseInt(customerId.getText()));
        customer.setCustomer_name(customerNameId.getText());
        customer.setAddress(Integer.parseInt(addressId.getText()));
        customer.setPhone_number(phoneNumberId.getText());
        customer.setBilling_account(billingAccountId.getText());

        customerDAO.createNewCustomer(customer);
        endringId.setText("The customer has been saved!");
    }
}