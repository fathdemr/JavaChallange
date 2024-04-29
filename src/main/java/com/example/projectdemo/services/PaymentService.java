/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.projectdemo.services;

import com.example.projectdemo.dto.PaymentDto;
import com.example.projectdemo.models.Customer;
import com.example.projectdemo.models.Payment;
import com.example.projectdemo.repositories.CustomerRepository;
import com.example.projectdemo.repositories.PaymentRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author fatihdemir
 */
@Service
public class PaymentService {
    
    private PaymentRepository paymentRepository;
    private CustomerRepository customerRepository;
    
    public String addPayment(PaymentDto paymentDto){
        Optional<Customer> optionalCustomer = customerRepository.findById(paymentDto.getCustomerId());
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            Payment payment = Payment.builder().customer(customer).build();
            paymentRepository.save(payment);
            return "Payment has been successfully added!";
        }
        return "Payment has not been successfully added!";
    }
            
    
}
