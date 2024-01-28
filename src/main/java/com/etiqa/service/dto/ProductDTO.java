package com.etiqa.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private long id;
    private String title;
    private String author;
    private float price;
    private int quantity;
}
