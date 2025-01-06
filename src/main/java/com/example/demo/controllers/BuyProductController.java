package com.example.demo.controllers;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.Optional;

@Controller
public class BuyProductController {

    private final ProductService productService;

    @Autowired
    public BuyProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") Long productID, Model model) {
        // Retrieve the product from the database
        Optional<Product> productOptional = Optional.ofNullable(productService.findById(Math.toIntExact(productID)));

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            if (product.getInv() > 0) {

                product.setInv(product.getInv() - 1);
                productService.save(product); // Save the updated product

                model.addAttribute("message", "Purchase was successful!");
                return "purchaseSuccess"; // Redirect to purchase success page
            } else {

                model.addAttribute("message", "This product is out of stock.");
                return "purchaseError"; // Redirect to purchase error page
            }
        } else {
           
            model.addAttribute("message", "Product not found.");
            return "purchaseError"; // Redirect to purchase error page
        }
    }
}
