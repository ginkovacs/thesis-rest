package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    private List<Customer> customers = new ArrayList<>();

    public CustomerRepository() {

        Customer customer = new Customer();

        customer.setFirstName("ab");
        customer.setLastName("cd");
        customers.add(customer);

        customer.setFirstName("ef");
        customer.setLastName("gh");
        customers.add(customer);
    }

    public List<Customer> findAll() {

        return customers;
    }

    public void add(String firstName, String lastName) {

        Customer customer = new Customer();

        customer.setFirstName(firstName);
        customer.setLastName(lastName);

        customers.add(customer);
    }

}
