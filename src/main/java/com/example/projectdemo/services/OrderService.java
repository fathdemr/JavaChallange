/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.projectdemo.services;

import com.example.projectdemo.dto.OrderDto;
import com.example.projectdemo.models.Order;
import com.example.projectdemo.models.Payment;
import com.example.projectdemo.repositories.OrderRepository;
import com.example.projectdemo.repositories.PaymentRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author fatihdemir
 */
@Service
public class OrderService {
    
    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;
    
    public String placeOrder(OrderDto orderDto){
        Optional<Payment> optionalPayment = paymentRepository.findById(orderDto.getPaymentId());
        if(optionalPayment.isPresent()){
            Payment payment = optionalPayment.get();
            Order placeOrder = Order.builder().payment(payment).orderConfirmation(true).orderDate(new Date()).build();
            orderRepository.save(placeOrder);
            return "Order has been successfully added!";
        }
        return "Order has not been successfully added!";
    }
    
}
