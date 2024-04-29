/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.projectdemo.controllers;


import com.example.projectdemo.dto.ProductDto;
import com.example.projectdemo.models.Product;
import com.example.projectdemo.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author fatihdemir
 */
@Controller
public class HomeController {
    
    ProductService productService;
    
    @GetMapping("/Products")
    public String products(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
    
    @GetMapping("/Products/add")
    public String productAdd(Model model){
        model.addAttribute("productDto", new ProductDto());
        return "productsAdd";
    }
    
    @PostMapping("Products/add")
    public String productAddPost(@ModelAttribute("productDto") ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        productService.getProduct(product);
        return "redirect:/Products/add";
    }
    
    @GetMapping("/Products/delete{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return "redirect:/Products/delete";
    }
    
    @GetMapping("/Products/update{id}")
    public String updateProduct(@PathVariable int id, Model model){
        Product product = productService.getProductById(id).get();
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setProductPrice(product.getProductPrice());
        model.addAttribute("productDto", productDto);
        return "productsAdd";
    }
}
