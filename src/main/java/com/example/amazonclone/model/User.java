package com.example.amazonclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class User {
    @NotEmpty(message = "You have to put ID for the User!")
    @Pattern(regexp = "^[0-9a-zA-Z]{3}$",message = "you have to put ID of user more than 2 character and less than 3")
    private String ID;

    @NotEmpty(message = "You have to put UserName for the User!")
    @Pattern(regexp = "/^[a-zA-Z]{5}$/",message="you have to put user name more than 4 latter")
    private String Name ;

    @NotEmpty(message = "You have to put Password for the User!")
    @Pattern(regexp = "^(?=.*(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{6}$)",
            message = "user passWord not valid  !")
    private String PassWord;

    @NotEmpty(message = "You have to put Email for the User!")
    @Email(message = "You have to put valid Email for the User!")
    private String Email;

    @NotEmpty(message = "You have to put Role for the User!")
    @Pattern(regexp = "(admin|user)",
            message = "Role must be in admin or user only")
    private String Role;
    @Positive(message="you have to put curect number ")
    @NotNull(message="you must put your balance ")
    private int balance ;
}
