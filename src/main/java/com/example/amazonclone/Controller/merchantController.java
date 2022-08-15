package com.example.amazonclone.Controller;

import com.example.amazonclone.model.ApiResponces;
import com.example.amazonclone.model.Category;
import com.example.amazonclone.model.Merchant;
import com.example.amazonclone.service.categoryService;
import com.example.amazonclone.service.merchantService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
public class merchantController {
    private final merchantService merchantService;
    public merchantController(merchantService merchantService){
        this.merchantService=merchantService;
    }

    @GetMapping()
    public ResponseEntity getMerchant(){
        ArrayList<Merchant> merchants=merchantService.getMerchants();
        return ResponseEntity.status(200).body(merchants);
    }

    @PostMapping("/register")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if (errors.hasErrors()){
            String Message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(Message,400));}
        boolean isValid=merchantService.addMerchant(merchant);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("Merchant is add",201));}
        return ResponseEntity.status(400).body(new ApiResponces("you can't add Merchant that have seam id",400));
    }

    @PutMapping ("/update")
    public ResponseEntity updateMerchant(@RequestBody Merchant merchant,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(message,400));
        }
        boolean isValid=merchantService.updateMerchant(merchant);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("merchant updated ",201));}
        return ResponseEntity.status(400).body(new ApiResponces("there is nothing to update or wrong ID of merchant ",400));}

    @DeleteMapping("/delete")
    public ResponseEntity deleteMerchant(@RequestBody Merchant merchant,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(message,400));
        }
        boolean isValid=merchantService.deleteMerchant(merchant);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("Merchant deleted",201));}
        return ResponseEntity.status(400).body(new ApiResponces("there is nothing to delete or wrong ID Merchant ",400));}

    @PostMapping ("/addProduct")
    public ResponseEntity addProduct(@RequestParam String merchantId,
                                     @RequestParam String productId,
                                     @RequestParam int Stock,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(message,400));
        }
        boolean isValid=merchantService.addProduct(merchantId,productId,Stock);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("Product added to merchant stock  ",201));}
        return ResponseEntity.status(400).body(new ApiResponces("there is no product to add or wrong ID of product ",400));}

}
