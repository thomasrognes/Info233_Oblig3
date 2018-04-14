
package Sample;

import DAO.*;
import Entities.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.*;

import javafx.scene.control.Label;

public class InvoiceController {

    public Connection conn;
    private int currentIndex = 1;


    public Label fakturaDatoID;
    public Label totalSumID;
    public Label kontaktInformasjonsID;
    public Label customerNameId;
    public Label customerId;
    public Label fakturaId;
    public Label addressId;
    public Label phoneNumberId;
    public Label billingAccountId;
    public VBox salesBox;

    public InvoiceController () {
        this.conn = Main.conn;
    }

    @FXML
    public void initialize() throws SQLException {
        loadInvoice(currentIndex);
    }


    public void loadInvoice(int id) throws SQLException {
        float sum = 0;

        InvoiceDAO invoiceDAO = new InvoiceDAO();
        Invoice inv = invoiceDAO.createInvoiceFromId(id);

        if (inv.getInvoice_id() > 0) {

            //Invoice information
            fakturaDatoID.setText(inv.getDato());
            customerId.setText(String.valueOf(inv.getCustomer()));
            fakturaId.setText(String.valueOf(inv.getInvoice_id()));

            // Customer information
            CustomerDAO customerDAO = new CustomerDAO();
            Customer customer = customerDAO.createCustomerFromId(inv.getCustomer());

            customerNameId.setText(customer.getCustomer_name());
            phoneNumberId.setText(customer.getPhone_number());
            billingAccountId.setText(customer.getBilling_account());

            // Address information
            AddressDAO addressDAO = new AddressDAO();
            Address address = addressDAO.createAddressFromId(customer.getAddress());

            addressId.setText(address.getStreet_name() + " " + address.getStreet_number() + "\n" + address.getPostal_code() + " " + address.getPostal_town());

            // Invoice items information
            InvoiceItemsDAO invoiceItemsDAO = new InvoiceItemsDAO(conn);
            ArrayList<Integer> productIds = invoiceItemsDAO.findProductsfromId(inv.getInvoice_id());
            Iterator productIT = productIds.iterator();

            // Product information
            ProductDAO productDAO = new ProductDAO();
            ArrayList<Product> productList = new ArrayList<Product>();

            while (productIT.hasNext()){
                Product createProductDao = productDAO.createProductFromId((Integer)productIT.next());
                productList.add(createProductDao);
            }

            for (Product product : productList){

                Label name = new Label();
                name.setText(product.getProduct_name());

                Label description = new Label();
                description.setText(product.getDescription());

                Label price = new Label();
                price.setText(String.valueOf(product.getPrice()));

                sum += product.getPrice();

                System.out.println(product.getPrice());
                System.out.println(product.getDescription());
                System.out.println(product.getProduct_name());

                HBox horrisontalBox = new HBox();
                horrisontalBox.setStyle("-fx-spacing: 20");

                horrisontalBox.getChildren().add(name);
                horrisontalBox.getChildren().add(description);
                horrisontalBox.getChildren().add(price);

                salesBox.getChildren().add(horrisontalBox);
                salesBox.setStyle("-fx-spacing: 10");
            }
            totalSumID.setText(String.valueOf(sum));
        }
    }

    private void resetInvoice() {
        salesBox.getChildren().clear();
    }


    public void nextInvoice(ActionEvent actionEvent) throws SQLException {
        currentIndex++;
        resetInvoice();
        loadInvoice(currentIndex);
    }

    public void previousInvoice(ActionEvent actionEvent) throws SQLException {
        if (currentIndex != 1){
            currentIndex--;
            resetInvoice();
            loadInvoice(currentIndex);
        } else {
            System.out.println("viser faktura med ID " + currentIndex);
        }
    }
}