/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */


package Scenes;

import DAO.*;
import Entities.*;
import Sample.Main;
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


    /**
     * Metode for å skrive ut informasjonen til fakturaen som skal vises.
     * @param id på fakturaen som skal vises.
     * @throws SQLException dersom ID ikke finnes.
     */
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

            //Går igjennom hvert produkt i productList og opprettet Labels for hvert felt.
            for (Product product : productList){

                Label name = new Label();
                name.setText(product.getProduct_name());

                Label description = new Label();
                description.setText(product.getDescription());

                Label price = new Label();
                price.setText(String.valueOf(product.getPrice()));

                // legger til prisen i totalsummen
                sum += product.getPrice();

                HBox horrisontalBox = new HBox();
                horrisontalBox.setStyle("-fx-spacing: 20");

                horrisontalBox.getChildren().add(name);
                horrisontalBox.getChildren().add(description);
                horrisontalBox.getChildren().add(price);

                name.setPrefWidth(280);
                description.setPrefWidth(150);

                salesBox.getChildren().add(horrisontalBox);
                salesBox.setStyle("-fx-spacing: 10");
            }
            totalSumID.setText(String.valueOf(sum));
        }
    }

    /**
     * Metode for å fjerne informasjonen i Vboxen.
     */
    private void resetInvoice() {
        salesBox.getChildren().clear();
    }


    /**
     * Metode for å bla i de forskjellige fakturaene.
     *
     */
    public void nextInvoice(ActionEvent actionEvent) throws SQLException {
        currentIndex++;
        resetInvoice();
        loadInvoice(currentIndex);
    }

    /**
     * Metode for å bla i de forskjellige fakturaene.
     *
     */
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