package com.desafio01.bootcampdevsuperior.services;

import com.desafio01.bootcampdevsuperior.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double discountTot = order.getBasic() * (order.getDiscount() / 100);
        return (order.getBasic() - discountTot) + shippingService.shipment(order);

    }

}
