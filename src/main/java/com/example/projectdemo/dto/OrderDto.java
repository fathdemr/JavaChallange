/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.projectdemo.dto;

import com.example.projectdemo.models.Payment;
import jakarta.persistence.Entity;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author fatihdemir
 */
@Data
@Builder
@Entity
public class OrderDto {
    
    private int paymentId;
    
    private int orderDetailId;
    
}
