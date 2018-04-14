package Scenes;

import DAO.InvoiceDAO;
import Entities.Invoice;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class NewInvoiceController {

    public TextField customerId;
    public TextField invoiceId;
    public TextField dateId;
    public TextField productId;

    public void createNewInvoice(ActionEvent actionEvent) throws SQLException {
        Invoice invoice = new Invoice();
        InvoiceDAO invoiceDAO = new InvoiceDAO();

        invoice.setCustomer(Integer.parseInt(customerId.getText()));
        invoice.setInvoice_id(Integer.parseInt(invoiceId.getText()));
        invoice.setDato(dateId.getText());

        invoiceDAO.createNewInvoice(invoice);
    }
}