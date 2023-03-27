package com.home.project.controller;


import com.home.project.dto.ResponseMessage;
import com.home.project.entity.PostCategory;
import com.home.project.entity.PostEntity;
import com.home.project.entity.Product;
import com.home.project.repository.PostRepository;
import com.home.project.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {


    @Autowired
    ProductRepo productRepo;

    @GetMapping("/product")
    List<Product> all() {
        return productRepo.findAll();
    }

    @GetMapping("/product/{id}")
    Product allByStatus(@PathVariable Long id) {

        Product pro = new Product();

        return productRepo.findById(id).get();
    }
    // end::get-aggregate-root[]


//    @PostMapping("/product/save")
    @PostMapping("/product")
    Product newPost(@RequestBody Product product) {
        return productRepo.save(product);
    }

//    @PutMapping("/product/save")
    @PutMapping("/product")
    Product replaceEmployee(@RequestBody Product product) {

        return productRepo.findById(product.getId())
                .map(post -> {
//                    BeanUtils.copyProperties(postEntity,post);
                    post.setName(product.getName());
                    post.setPrice(product.getPrice());
                    post.setEmail(product.getEmail());
                    post.setQuantity(product.getQuantity());
                    return productRepo.save(post);
                })
                .orElseGet(() -> {
                    product.setId(product.getId());
                    return productRepo.save(product);
                });
    }

//    @DeleteMapping("/product/delete/{id}")
    @DeleteMapping("/product/{id}")
    ResponseEntity<ResponseMessage> deleteEmployee(@PathVariable Long id) {
        productRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Success Delete"));
    }
}
