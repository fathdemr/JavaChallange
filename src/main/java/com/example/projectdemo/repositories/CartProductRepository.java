/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.projectdemo.repositories;

import com.example.projectdemo.models.CartProduct;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fatihdemir
 */
public interface CartProductRepository extends JpaRepository<CartProduct, Integer>{
    @Query("select cp from CartProduct cp join cp.cart c where c.cartId = :cartId")
    List<CartProduct> findByCartId(int cartId);
}
