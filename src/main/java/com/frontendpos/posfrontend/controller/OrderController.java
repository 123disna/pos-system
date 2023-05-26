package com.frontendpos.posfrontend.controller;
import com.frontendpos.posfrontend.dto.RequestOrderSaveDTO;
import com.frontendpos.posfrontend.service.CustomerService;
import com.frontendpos.posfrontend.service.ItemService;
import com.frontendpos.posfrontend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/orders")
    public String showOrderForm(Model model){
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("items", itemService.getAllItems());
        model.addAttribute("order", new RequestOrderSaveDTO());
        return "orders";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("order")RequestOrderSaveDTO requestOrderSaveDTO){
        orderService.saveOrders(requestOrderSaveDTO);
        return "redirect:/order_list";   //redirect eka wada naa
    }

    @GetMapping("/order_list")
    public String getAllOrder(Model model){
        model.addAttribute("order_list",orderService.getAllOrders());
        return "order_list";
    }

    @ModelAttribute("order")
    public RequestOrderSaveDTO requestOrderSaveDTO()
    {

        return new RequestOrderSaveDTO();
    }

    //meka tama super meken string date eka util.Date object ekakata convert karai.......................meka nattam wada natha
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
