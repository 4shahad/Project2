package com.example.amazonclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@AllArgsConstructor @Data
public class Category {

    @NotEmpty(message= "You must put category ID of the Product  !")
    @Pattern(regexp = "^[0-9a-zA-Z]{3}$",message = "you have to put ID of category more than 2 character and less than 3")
    private String ID;

    @NotEmpty(message = "You have to but name of Product !")
    @Pattern(regexp = "^[a-zA-Z]{3}$",message = "you have to put name of category more than 2 character and less than 3")
    private String Name ;
}
