package DAO;


import Entities.Invoice;
import Sample.Main;
import Sample.Main;

import java.sql.*;

public class InvoiceDAO {
    private Connection conn;

    public InvoiceDAO() {
        this.conn = Main.conn;
    }

    //Oppretter en instans av Invoice gjennom ID
    public Invoice createInvoiceFromId(int id) throws SQLException {
        Invoice currInvoice = new Invoice();

        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM invoice WHERE invoice_id=" + id);

            if (rs.next()){
                currInvoice.setInvoice_id(rs.getInt("invoice_id"));
                currInvoice.setCustomer(rs.getInt("customer"));
                currInvoice.setDato(rs.getString("dato"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return currInvoice;
    }


    public void createNewInvoice (Invoice invoice) throws SQLException {
        String sql = "INSERT OR IGNORE INTO invoice (invoice_id, customer, dato) VALUES (?,?,?)";

        try{
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, invoice.getCustomer());
            prep.setInt(2,invoice.getInvoice_id());
            prep.setString(3, invoice.getDato());
            prep.executeUpdate();
            System.out.println("Lagt til i database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
