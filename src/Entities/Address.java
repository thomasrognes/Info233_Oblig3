package Entities;

public class Address {
    private int address_id;
    private String street_name, postal_town, street_number, postal_code;


    public Address() {
        this.address_id = address_id;
        this.street_name = street_name;
        this.postal_town = postal_town;
        this.street_number = street_number;
        this.postal_code = postal_code;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getPostal_town() {
        return postal_town;
    }

    public void setPostal_town(String postal_town) {
        this.postal_town = postal_town;
    }
}
