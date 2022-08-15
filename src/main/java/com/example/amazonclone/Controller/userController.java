package com.example.amazonclone.Controller;

import com.example.amazonclone.model.ApiResponces;
import com.example.amazonclone.model.Product;
import com.example.amazonclone.model.User;
import com.example.amazonclone.service.productService;
import com.example.amazonclone.service.userService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
public class userController {

    private final userService userService;
    public userController(userService userService){
        this.userService=userService;
    }

    @GetMapping()
    public ResponseEntity getUser(){
        ArrayList<User> users=userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/register")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String Message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(Message,400));}
        boolean isValid=userService.addUser(user);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("user add",201));}
        return ResponseEntity.status(400).body(new ApiResponces("you can't add user that have seam id",400));
    }

    @PutMapping ("/update")
    public ResponseEntity updateUser(@RequestBody User user,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(message,400));
        }
        boolean isValid= userService.updateUser(user);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("User updated ",201));}
        return ResponseEntity.status(400).body(new ApiResponces("there is nothing to update or wrong ID User ",400));}

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestBody User user,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(message,400));
        }
        boolean isValid=userService.deleteUser(user);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("user deleted",201));}
        return ResponseEntity.status(400).body(new ApiResponces("there is nothing to delete or wrong ID user ",400));}

}
