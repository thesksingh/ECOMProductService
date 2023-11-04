package com.scaler.EcomProductService.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PRODUCT")
public class Product extends BaseModel {
    private String title;
    private double price;
    private String description;
    private String image;
    @ManyToOne
    private Category category;

}


/*
    Product - Category : M : 1
    1         1
    M         1
    M         1
 */