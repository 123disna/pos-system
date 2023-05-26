package com.frontendpos.posfrontend.service.impl;

import com.frontendpos.posfrontend.entity.Item;
import com.frontendpos.posfrontend.repo.ItemRepo;
import com.frontendpos.posfrontend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @Override
    public Item addItem(Item item) {
       return itemRepo.save(item);
    }

    @Override
    public Item getItemById(int id) {
        return itemRepo.findById(id).get();
    }

    @Override
    public Item updateItem(Item existItem) {
        return itemRepo.save(existItem);
    }

    @Override
    public void deleteItem(int id) {
        itemRepo.deleteById(id);
    }

    @Override
    public double getSellingPriceByName(String name) {
        Item item=itemRepo.findByItemNameEquals(name);
        return item.getSellingPrice();
    }


}
