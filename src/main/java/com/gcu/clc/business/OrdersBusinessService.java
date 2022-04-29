package com.gcu.clc.business;

import com.gcu.clc.data.OrdersDataService;
import com.gcu.clc.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersBusinessService {

    @Autowired
    private OrdersDataService ordersDataService;

    public boolean addOrder(OrderModel orderModel){
        return ordersDataService.create(orderModel);
    }

    public List<OrderModel> getAll() {
        return ordersDataService.getAll();
    }

    public OrderModel getById(Integer orderId){
        return ordersDataService.getById(orderId);
    }

    public boolean updateAddress(OrderModel orderModel){
        return ordersDataService.update(orderModel);
    }

    public boolean deleteAddress(OrderModel orderModel){
        return ordersDataService.delete(orderModel);
    }
}
