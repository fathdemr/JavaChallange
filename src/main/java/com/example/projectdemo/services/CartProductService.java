/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.projectdemo.services;

import com.example.projectdemo.dto.CartDto;
import com.example.projectdemo.repositories.CartProductRepository;
import java.util.Optional;
import com.example.projectdemo.models.CartProduct;
import org.springframework.stereotype.Service;

/**
 *
 * @author fatihdemir
 */
@Service
public class CartProductService {
    
    CartProductRepository cartProductRepository;
    
    public String addProductToCart(CartDto cartDto){
        Optional<CartProduct> optionalCartProduct = cartProductRepository.findById(cartDto.getCartId());
        if(optionalCartProduct.isPresent()){
            CartProduct cartProduct = optionalCartProduct.get();
            if(cartProduct.getProduct().getProductStock() < 0 || cartProduct.getProductQuantity() > cartProduct.getProduct().getProductStock()){
                cartProduct.setProductQuantity(cartProduct.getCartProductId()+1);
                cartProductRepository.save(cartProduct);
                return "Product has been successfully added from your cart!";
            }
        }
        return "Product cannot be less than 0 and more than the cart quantity!";
    }
    
    public String removeProductFromCart(CartDto cartDto){
        Optional<CartProduct> optionalCartProduct = cartProductRepository.findById(cartDto.getCartId());
        if(optionalCartProduct.isPresent()){
            CartProduct cartProduct = optionalCartProduct.get();
            if(cartProduct.getProduct().getProductStock() < 0 || cartProduct.getProductQuantity() > cartProduct.getProduct().getProductStock()){
                cartProduct.setProductQuantity(cartProduct.getCartProductId()-  1);
                cartProductRepository.save(cartProduct);
                return "Product has been successfully deleted from your cart!";
            }
        }
        return "Product cannot be less than 0 and more than the cart quantity!";
    }
    
    
    
    
     
}
