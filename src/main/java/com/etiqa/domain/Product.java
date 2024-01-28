package com.etiqa.domain;

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
    @Column(name = "Book Title")
    private String title;
    @Column(name = "Book Auhtor")
    private String author;
    @Column(name = "Book Price")
    private float price;
    @Column(name = "Book Quantity")
    private int quantity;
    
}
