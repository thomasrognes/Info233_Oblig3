package Sample;
import DAO.*;

import Entities.Address;
import Entities.Customer;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class NewCustomerController {

    public TextField customerId;
    public TextField customerNameId;
    public TextField addressId;
    public TextField phoneNumberId;
    public TextField billingAccountId;



    // Oppretter en ny Customer enhet fra TextField i javafx.
    public void createCustomer(ActionEvent actionEvent) throws SQLException {
        Customer customer = new Customer();
        CustomerDAO customerDAO = new CustomerDAO();

        customer.setCustomer_id(Integer.parseInt(customerId.getText()));
        customer.setCustomer_name(customerNameId.getText());
        customer.setAddress(Integer.parseInt(addressId.getText()));
        customer.setPhone_number(phoneNumberId.getText());
        customer.setBilling_account(billingAccountId.getText());

        customerDAO.createNewCustomer(customer);
    }
}