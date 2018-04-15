/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */


package Entities;

public class Invoice {
    private int invoice_id, customer;
    private String dato;

    public Invoice() {
        this.invoice_id = invoice_id;
        this.customer = customer;
        this.dato = dato;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}
