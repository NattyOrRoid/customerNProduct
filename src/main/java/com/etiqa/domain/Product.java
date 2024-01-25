package com.etiqa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "")
@Getter
@Setter
public class Product {

    private long id;
    private String title;
    private float price;
    private int quantity;
    
}
