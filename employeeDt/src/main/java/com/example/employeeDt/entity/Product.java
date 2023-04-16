package com.example.employeeDt.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;


@Entity
@Getter
@Setter
@ToString
public class Product extends BaseModel {


    private String name;
    private String qty;


    private String price;

    private String brand;

}
