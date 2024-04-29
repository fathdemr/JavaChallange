/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.projectdemo.services;

import com.example.projectdemo.dto.CartDto;
import com.example.projectdemo.models.Cart;
import com.example.projectdemo.models.Customer;
import com.example.projectdemo.repositories.CartRepository;
import com.example.projectdemo.repositories.CustomerRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;


/**
 *
 * @author fatihdemir
 */
@Service
public class CartService {
    
    private CartRepository cartRepository;
    
    private CustomerRepository customerRepository;
    
    public String EmptyCart(CartDto cartDto){
        Optional<Customer> optionalCustomer = customerRepository.findById(cartDto.getCustomerId());
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            Cart emptyCart = Cart.builder().customer(customer).build();
            cartRepository.save(emptyCart); 
            return "Cart has been created!";
        }
        else{
            return "Cart has not created";
        }
        
    }
    
    public String deleteCart(CartDto cartDto){
        Optional<Cart> optionalCart = cartRepository.findById(cartDto.getCartId());
        if(optionalCart.isPresent()){
            Cart cart = optionalCart.get();
            cartRepository.delete(cart);
            return "Cart has been deleted";
        }
        else{
            return "Cart has not found";
        }
        
    }
    
    
}
