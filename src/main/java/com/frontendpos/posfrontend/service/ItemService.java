package com.frontendpos.posfrontend.service;

import com.frontendpos.posfrontend.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getAllItems();

    Item addItem(Item item);

    Item getItemById(int id);

    Item updateItem(Item existItem);

    void deleteItem(int id);

    double getSellingPriceByName(String name);
}
