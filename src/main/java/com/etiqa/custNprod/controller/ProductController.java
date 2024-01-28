package com.etiqa.custNprod.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.etiqa.custNprod.domain.Product;
import com.etiqa.custNprod.service.ProductService;
import com.etiqa.custNprod.service.dto.ProductDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/prodAPI")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping("/bookRegistration")
    @ResponseStatus(HttpStatus.CREATED)
    public void bookData(@Valid @RequestBody ProductDTO productDTO) {
        log.info("REST request to create book {}", productDTO);

        productService.bookData(productDTO);
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllBookData() {
        log.info("REST request to find all books {}");

        List<Product> books = productService.getAllBookData() ;

        return books;
    }

    @GetMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> getBookData(@Valid @PathVariable Long id) {
        log.info("REST request to find book By Id {}", id);

        Product books = productService.getBookData(id) ;

        return ResponseEntity.ok(books);
    }

    @PutMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> updateBookData(@Valid @PathVariable ProductDTO productDTO) {
        log.info("REST request to update book By Id {}", productDTO.getId());

        Product books = productService.updateBookData(productDTO) ;

        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBookData(@Valid @PathVariable Long id) {
        log.info("REST request to delete book By Id {}", id);

        productService.deleteBookData(id) ;
    }
    
    
}
