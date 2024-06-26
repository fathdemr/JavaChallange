/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.projectdemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


/**
 *
 * @author fatihdemir
 */
@Entity
@Data
public class Product {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    
    private String productName;
   
    private double productPrice;
    
    private int productStock;
}
