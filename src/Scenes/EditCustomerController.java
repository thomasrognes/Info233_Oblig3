package Scenes;

import DAO.AddressDAO;
import DAO.CustomerDAO;
import Entities.Address;
import Entities.Customer;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditCustomerController {

    public TextField customerId;
    public TextField customerNameId;
    public TextField addressId;
    public TextField phoneNumberId;
    public TextField billingAccountId;
    public Label endringId;

    public void editCustomer(ActionEvent actionEvent) {
        Customer customer = new Customer();
        CustomerDAO customerDAO = new CustomerDAO();

        customer.setCustomer_id(Integer.parseInt(customerId.getText()));
        customer.setCustomer_name(customerNameId.getText());
        customer.setAddress(Integer.parseInt(addressId.getText()));
        customer.setPhone_number(phoneNumberId.getText());
        customer.setBilling_account(billingAccountId.getText());

        customerDAO.editCustomer(customer);

        endringId.setText("Changes has been saved!");
    }
}
