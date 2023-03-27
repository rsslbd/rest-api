package com.home.project.entity;

import com.home.project.urlConstants.BaseModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Product extends BaseModel {
    private String name;
    private String email;
    private String price;
    private String quantity;

}
