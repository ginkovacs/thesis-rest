package hu.unideb.thesis.models;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
