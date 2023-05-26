package com.frontendpos.posfrontend.service;

import com.frontendpos.posfrontend.dto.RequestOrderSaveDTO;
import com.frontendpos.posfrontend.entity.Order;

import java.util.List;

public interface OrderService {
    Order saveOrders(RequestOrderSaveDTO requestOrderSaveDTO);

    List<Order> getAllOrders();


}
