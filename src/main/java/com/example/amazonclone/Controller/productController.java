package com.example.amazonclone.Controller;


import com.example.amazonclone.model.ApiResponces;
import com.example.amazonclone.model.Product;
import com.example.amazonclone.service.productService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
public class productController {
    private final productService productService;
    public productController(productService productService){
        this.productService=productService;
    }

    @GetMapping()
    public ResponseEntity getProduct(){
        ArrayList<Product> products=productService.getProducts();
        return ResponseEntity.status(200).body(products);
    }

    @PostMapping("/register")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if (errors.hasErrors()){
            String Message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(Message,400));}
        boolean isValid=productService.addProduct(product);
        if (isValid){
        return ResponseEntity.status(201).body(new ApiResponces("Product add",201));}
        return ResponseEntity.status(400).body(new ApiResponces("you can't add product that have seam id or " +
                "there is no category id like you put",400));
    }

    @PutMapping ("/update")
    public ResponseEntity updateProduct(@RequestBody Product product,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(message,400));
        }
        boolean isValid=productService.updateProduct(product);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("Product updated ",201));}
        return ResponseEntity.status(400).body(new ApiResponces("there is nothing to update or wrong ID product or wrong ID category  ",400));}

@DeleteMapping("/delete")
    public ResponseEntity deleteProduct(@RequestBody Product product,Errors errors){
    if(errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponces(message,400));
    }
   boolean isValid=productService.deleteProduct(product);
   if (isValid){
    return ResponseEntity.status(201).body(new ApiResponces("Product deleted",201));}
    return ResponseEntity.status(400).body(new ApiResponces("there is nothing to delete or wrong ID product ",400));}

    @PostMapping("/buyProduct")
    private ResponseEntity buyProduct(@RequestParam String userId , String productId, String merchantId ,Errors errors){
        if (errors.hasErrors()){
            String Message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(Message,400));}
        Integer caseBuy=productService.buyProduct( userId ,  productId,  merchantId);
        switch (caseBuy){
            case -1:
                return ResponseEntity.status(400).body("there is no users or merchant ");
            case 0:
                return ResponseEntity.status(400).body("your balance is not enugh or there is no product in stock");
            case 1:
                return ResponseEntity.status(201).body("you buy the product");
            default:
                return ResponseEntity.status(500).body("Server error !");
        }
    }
}
