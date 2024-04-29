/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.projectdemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author fatihdemir
 */
@Data
@Builder
@Entity
public class CartProduct {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartProductId;
    
    private Cart cart;
    
    private int productQuantity;
    
    private Product product;
    
    
    
}
