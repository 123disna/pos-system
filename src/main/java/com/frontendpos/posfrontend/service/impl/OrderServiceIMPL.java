package com.frontendpos.posfrontend.service.impl;

import com.frontendpos.posfrontend.dto.RequestOrderSaveDTO;
import com.frontendpos.posfrontend.entity.Order;
import com.frontendpos.posfrontend.entity.OrderDetails;
import com.frontendpos.posfrontend.repo.CustomerRepo;
import com.frontendpos.posfrontend.repo.ItemRepo;
import com.frontendpos.posfrontend.repo.OrderDetailsRepo;
import com.frontendpos.posfrontend.repo.OrderRepo;
import com.frontendpos.posfrontend.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Override
    public Order saveOrders(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order=new Order(
               customerRepo.getById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()
        );
        orderRepo.save(order);
        if(orderRepo.existsById(order.getOrderId())){
             List<OrderDetails> orderDetailsList=modelMapper
                                                 .map(requestOrderSaveDTO.getOrderDetailsSaveDTOS(),new TypeToken<List<OrderDetails>>(){}.getType());

            for(int i=0;i<orderDetailsList.size();i++){
                orderDetailsList.get(i).setOrders(order);
                orderDetailsList.get(i).setItem(itemRepo.getById(requestOrderSaveDTO.getOrderDetailsSaveDTOS().get(i).getItem()));
            }

            if(orderDetailsList.size()>0)
            {
                orderDetailsRepo.saveAll(orderDetailsList);
            }

        }
        return orderRepo.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
