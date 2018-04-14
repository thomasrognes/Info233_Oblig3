package Entities;

public class Customer {
    private int customer_id, address;
    private String customer_name, phone_number, billing_account;

    public Customer() {
        this.customer_id = customer_id;
        this.address = address;
        this.customer_name = customer_name;
        this.phone_number = phone_number;
        this.billing_account = billing_account;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBilling_account() {
        return billing_account;
    }

    public void setBilling_account(String billing_account) {
        this.billing_account = billing_account;
    }
}
