/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */

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

    /**
     * Metode for å opprette en faktura-instans ved å sende inn faktura ID.
     * @param id på fakturaen som skal opprettes.
     * @return faktura instansen.
     * @throws SQLException dersom den ikke blir opprettet.
     */
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


    /**
     * Metode for å opprette en ny faktura i databasen.
     * @param invoice som skal opprettes.
     * @throws SQLException dersom den ikke går gjennom.
     */
    public void createNewInvoice (Invoice invoice) throws SQLException {
        String sql = "INSERT OR IGNORE INTO invoice (invoice_id, customer, dato) VALUES (?,?,?)";

        try{
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1,invoice.getInvoice_id());
            prep.setInt(2, invoice.getCustomer());
            prep.setString(3, invoice.getDato());

            prep.executeUpdate();
            System.out.println("Lagt til i database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metode for å endre på en kunde som allerede ligger i databasen.
     * @param invoice som skal endres.
     */
    public void editInvoice (Invoice invoice) {
        String sql = "UPDATE invoice SET invoice_id = ?, customer = ?, dato = ? WHERE invoice_id=" + invoice.getInvoice_id();

        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, invoice.getInvoice_id());
            prep.setInt(2, invoice.getCustomer());
            prep.setString(3, invoice.getDato());

            prep.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
