package Scenes;

import DAO.InvoiceDAO;
import Entities.Invoice;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;

public class NewInvoiceController {

    public TextField customerId;
    public TextField invoiceId;
    public DatePicker dateId;
    public Label endringId;

    public void createNewInvoice(ActionEvent actionEvent) throws SQLException {
        Invoice invoice = new Invoice();
        InvoiceDAO invoiceDAO = new InvoiceDAO();

        invoice.setCustomer(Integer.parseInt(customerId.getText()));
        invoice.setInvoice_id(Integer.parseInt(invoiceId.getText()));
        invoice.setDato(String.valueOf(dateId.getEditor().getText()));

        invoiceDAO.createNewInvoice(invoice);
        endringId.setText("The invoice has been saved!");

    }
}