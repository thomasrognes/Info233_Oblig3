package DAO;

import Entities.InvoiceItems;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InvoiceItemsDAO {
    private Connection conn;

    public InvoiceItemsDAO(Connection conn) {
        this.conn = conn;
    }


    //Oppretter en instans av InvoiceItems gjennom ID.
    public InvoiceItems createInvoiceItemFromId(int id) {
        InvoiceItems currInvoiceItem = new InvoiceItems();

        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM invoice_items WHERE invoice=" + id);

            if (rs.next()) {
                currInvoiceItem.setInvoice(rs.getInt("invoice"));
                currInvoiceItem.setProduct(rs.getInt("product"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currInvoiceItem;
    }


    public ArrayList<Integer> findProductsfromId(int id) {
        ArrayList<Integer> products = new ArrayList<Integer>();

        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT product FROM invoice_items WHERE invoice=" + id);

            while (rs.next()){
                products.add(rs.getInt("product"));
                System.out.println(rs.getInt("product"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}

