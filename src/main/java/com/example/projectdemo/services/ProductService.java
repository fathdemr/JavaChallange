/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.projectdemo.services;

import com.example.projectdemo.models.Product;
import com.example.projectdemo.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author fatihdemir
 */
@Service
public class ProductService {
    
    ProductRepository productRepository;
    
  
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    
    public void getProduct(Product product){
        productRepository.save(product);
    }  
    
    
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
    
   public Optional<Product> getProductById(int id){
       return productRepository.findById(id);
   }     
}
