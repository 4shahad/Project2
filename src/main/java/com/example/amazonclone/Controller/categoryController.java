package com.example.amazonclone.Controller;

import com.example.amazonclone.model.ApiResponces;
import com.example.amazonclone.model.Category;
import com.example.amazonclone.model.Product;
import com.example.amazonclone.service.categoryService;
import com.example.amazonclone.service.productService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
public class categoryController {
    private final categoryService categoryService;
    public categoryController(categoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping()
    public ResponseEntity getCategory(){
        ArrayList<Category> categories=categoryService.getCategory();
        return ResponseEntity.status(200).body(categories);
    }

    @PostMapping("/register")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if (errors.hasErrors()){
            String Message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(Message,400));}
        boolean isValid=categoryService.addCategory(category);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("Category is add",201));}
        return ResponseEntity.status(400).body(new ApiResponces("you can't add Category that have seam id",400));
    }

    @PutMapping ("/update")
    public ResponseEntity updateCategory(@RequestBody Category category,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(message,400));
        }
        boolean isValid=categoryService.updateCategory(category);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("Category updated ",201));}
        return ResponseEntity.status(400).body(new ApiResponces("there is nothing to update or wrong ID of category ",400));}

    @DeleteMapping("/delete")
    public ResponseEntity deleteCategory(@RequestBody Category category,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(message,400));
        }
        boolean isValid=categoryService.deleteCategory(category);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("Category deleted",201));}
        return ResponseEntity.status(400).body(new ApiResponces("there is nothing to delete or wrong ID category ",400));}

}
