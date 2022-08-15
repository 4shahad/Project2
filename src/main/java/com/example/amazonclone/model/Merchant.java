package com.example.amazonclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @Data
public class Merchant {

    @NotEmpty(message= "You must put Merchant ID of the Merchant  !")
    @Pattern(regexp = "^[0-9a-zA-Z]{3}$",message = "you have to put ID of Merchant more than 2 character and less than 3")
    private String ID;

    @NotEmpty(message = "You have to but name of Merchant !")
    @Pattern(regexp = "^[a-zA-Z]{3}$",message = "you have to put name of Merchant more than 2 character and less than 3")
    private String Name ;
}
