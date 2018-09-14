package hu.unideb.thesis.service;

import hu.unideb.thesis.models.Customer;
import hu.unideb.thesis.repository.CustomerRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CustomerService {

    @Autowired //autowired van az objectum előtt, akkor a spring által használt bean lesz a változó értéke
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {

        return customerRepository.findAll();
    }

    public void add(String firstName, String lastName) {

        Assert.hasLength(firstName, "Missing firstName.");
        Assert.hasLength(lastName, "Missing firstName.");

        if(firstName.length()>50) {
            throw new RuntimeException("firstName too long");
        }
        if(lastName.length()>50) {
            throw new RuntimeException("lastName too long");
        }

        Customer customer = new Customer(firstName, lastName);
        customerRepository.save(customer);

    }

    public void deleteCust(Integer id) {customerRepository.deleteById(id);}

}
