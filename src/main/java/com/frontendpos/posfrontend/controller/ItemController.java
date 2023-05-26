package com.frontendpos.posfrontend.controller;

import com.frontendpos.posfrontend.entity.Item;
import com.frontendpos.posfrontend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {
    @Autowired
    private ItemService service;

    @GetMapping("/items")
    public String listItems(Model model){
        model.addAttribute("items",service.getAllItems());
        return "items";
    }
    @GetMapping("/items/new")
    public String createItem(Model model){
        Item item=new Item();
        model.addAttribute("item",item);
        return "create_item";
    }
    @PostMapping("/items")
    public String saveAllItem(@ModelAttribute("item")Item item){
        service.addItem(item);
        return "redirect:/items";
    }

   @GetMapping("/items/edit/{id}")
    public String editItemForm(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("item",service.getItemById(id));
        return "edit_item";
    }

    @PostMapping("/items/{id}")
    public String updateItem(@PathVariable int id,
                                @ModelAttribute("item")Item item,
                                Model model){
        Item existItem=service.getItemById(id);
        existItem.setItemName(item.getItemName());
        existItem.setMeasuringUnit(item.getMeasuringUnit());
        existItem.setBalanceQty(item.getBalanceQty());
        existItem.setSupplierPrice(item.getSupplierPrice());
        existItem.setSellingPrice(item.getSellingPrice());

        service.updateItem(existItem);
        return "redirect:/items";
    }

    @GetMapping("/items/{id}")
    public String deleteItem(@PathVariable int id){
        service.deleteItem(id);
        return "redirect:/items";
    }

    @GetMapping("/items/getPrice/{name}")
    public String getSellingPriceByName(@PathVariable(value = "name") String name,Model model){
        double sellingPrice=service.getSellingPriceByName(name);
        return "redirect:/items";
    }
}
