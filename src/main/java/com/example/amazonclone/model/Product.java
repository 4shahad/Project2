package com.example.amazonclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @Data
public class Product {

    @NotEmpty(message= "You must put ID of the Product  !")
    @Pattern(regexp = "^[0-9a-zA-Z]{3}$",message = "you have to put ID of product more than 2 character and less than 3")
    private String ID;

    @NotEmpty(message = "You have to but name of Product !")
    @Pattern(regexp = "^[a-zA-Z]{3}$",message = "you have to put name of product more than 2 character and less than 3")
    private String Name ;

    @NotNull(message = " You have to put price of the product !")
    @Range(min=0,message = "The price must be positive ! ")
    private double Price ;

    @NotNull(message = " You have to put categoryID of the product !")
    @Pattern(regexp = "^[0-9a-zA-Z]{3}$",message = "you have to put categoryID of product more than 2 character and less than 3")
    private String categoryID;
}
