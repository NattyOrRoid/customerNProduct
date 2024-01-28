package com.etiqa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.etiqa.domain.Product;
import com.etiqa.helper.ExceptionHandler;
import com.etiqa.repository.ProductRepository;
import com.etiqa.service.dto.ProductDTO;

@Service
public class ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public void bookData(ProductDTO productDTO) {

        Optional<Product> existBookTitle = productRepository.findOneByTitle(productDTO.getTitle());

        if (existBookTitle.isPresent()) {
            Optional<Product> existBookAuthor = productRepository.findOneByAuthor(productDTO.getTitle());

            if (existBookAuthor.isPresent()) {
                throw new ExceptionHandler("Book with the same author already exist");
            }
        }

        Product book = new Product();
        book.setTitle(productDTO.getTitle());
        book.setAuthor(productDTO.getAuthor());
        book.setPrice(productDTO.getPrice());
        book.setQuantity(productDTO.getQuantity());
    }

    public Product updateBookData(ProductDTO productDTO) {
        Product book = productRepository.findById(productDTO.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No product found with id " + productDTO.getId()));

        log.info("Current book data {}", book);

        book.setTitle(productDTO.getTitle());
        // book.setAuthor(productDTO);
        book.setPrice(productDTO.getPrice());
        book.setQuantity(productDTO.getQuantity());

        return book;
    }

    @Transactional(readOnly = true)
    public List<Product> getAllBookData(){
        List<Product> books = new ArrayList<Product>();
        
        books = productRepository.findAll();

        if(books.isEmpty()){
            throw new NullPointerException("There's no book data.");
        }

        return books;
    }

    @Transactional(readOnly = true)
    public Product getBookData(Long id){
        Product book = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No book found with id " + id));

        return book;
    }

    public void deleteBookData(Long id){
        productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No book found with id " + id));
    }
    
}
