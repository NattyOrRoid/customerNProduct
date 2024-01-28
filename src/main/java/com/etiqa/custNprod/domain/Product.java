package com.etiqa.custNprod.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Product")
@Getter
@Setter
public class Product {
    @Id
    private long id;
    @Column(name = "book_title", length = 100)
    private String title;
    @Column(name = "book_author", length = 100)
    private String author;
    @Column(name = "book_price")
    private float price;
    @Column(name = "book_quantity")
    private int quantity;
    
}
