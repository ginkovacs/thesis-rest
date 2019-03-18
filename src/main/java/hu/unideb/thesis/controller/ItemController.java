package hu.unideb.thesis.controller;

import hu.unideb.thesis.models.Item;
import hu.unideb.thesis.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("addItem")
    public ResponseEntity<Void> addItem(@RequestParam String name,
                                        @RequestParam Integer price,
                                        @RequestParam Integer customerId) {

        itemService.addItem(name, price, customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("deleteItem")
    public ResponseEntity<Void> deleteItem(@RequestParam Integer id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("updateItem")
    public ResponseEntity<Void> updateItem(@RequestParam Integer id,
                                           @RequestParam Item item) {

        itemService.updateItem(id, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("findItem")
    public ResponseEntity<Item> findItem(@RequestParam Integer id) {
        return new ResponseEntity<>(itemService.findItem(id), HttpStatus.OK);
    }

    @GetMapping("findAllItem")
    public ResponseEntity<List<Item>> findAllItem() {
        return new ResponseEntity<>(itemService.findAllItem(), HttpStatus.OK);
    }
}
