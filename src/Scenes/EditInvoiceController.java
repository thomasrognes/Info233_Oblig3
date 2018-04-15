package Scenes;

import DAO.InvoiceDAO;
import Entities.Invoice;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditInvoiceController {

    public TextField invoiceId;
    public TextField customerId;
    public DatePicker datoId;
    public Label endringId;


    public void editInvoice(ActionEvent actionEvent) {
        Invoice invoice = new Invoice();
        InvoiceDAO invoiceDAO = new InvoiceDAO();

        invoice.setInvoice_id(Integer.parseInt(invoiceId.getText()));
        invoice.setCustomer(Integer.parseInt(customerId.getText()));
        invoice.setDato(String.valueOf(datoId.getEditor().getText()));

        invoiceDAO.editInvoice(invoice);
        endringId.setText("Changes has been saved!");

    }
}
