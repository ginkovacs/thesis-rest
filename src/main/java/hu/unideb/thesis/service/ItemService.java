package hu.unideb.thesis.service;

import hu.unideb.thesis.models.Customer;
import hu.unideb.thesis.models.Item;
import hu.unideb.thesis.repository.CustomerRepository;
import hu.unideb.thesis.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;

    public void addItem(String name, Integer price, Integer customerId) {

        Customer customer = customerRepository.getOne(customerId);

        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setCustomer(customer);

        itemRepository.save(item);
    }

    public void deleteItem(Integer itemId) {
        itemRepository.deleteById(itemId);
    }

    public void updateItem(Integer itemId, Item itemChanged) {
        Item item = itemRepository.getOne(itemId);

        if (itemChanged.getName() != null) {
            item.setName(itemChanged.getName());
        }

        if (itemChanged.getPrice() != null) {
            item.setPrice(itemChanged.getPrice());
        }

        itemRepository.save(item);
    }

    public Item findItem(Integer itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("No item found"));
    }

    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }
}
