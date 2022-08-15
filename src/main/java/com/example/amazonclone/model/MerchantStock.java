package com.example.amazonclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @Data
public class MerchantStock {

    @NotEmpty(message= "You must put ID of the MerchantStock  !")
    @Pattern(regexp = "^[0-9a-zA-Z]{3}$",message = "you have to put ID of MerchantStock more than 2 character and less than 3")
    private String ID;

    @NotEmpty(message= "You must put productId of the MerchantStock  !")
    @Pattern(regexp = "^[0-9a-zA-Z]{3}$",message = "you have to put ID of product  more than 2 character and less than 3")
    private String productId;

    @NotEmpty(message= "You must put merchantId of the MerchantStock  !")
    @Pattern(regexp = "^[0-9a-zA-Z]{3}$",message = "you have to put ID of Merchant more than 2 character and less than 3")
    private String merchantId;

    @NotEmpty(message= "You must put Stock of the MerchantStock  !")
    @Range(min = 11,message ="Your stock must be more than 10 at the start !")
    private int Stock;
}
