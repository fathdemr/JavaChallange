/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.projectdemo.repositories;

import com.example.projectdemo.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fatihdemir
 */
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
    
}
