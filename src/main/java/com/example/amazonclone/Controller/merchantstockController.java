package com.example.amazonclone.Controller;

import com.example.amazonclone.model.ApiResponces;
import com.example.amazonclone.model.MerchantStock;
import com.example.amazonclone.service.merchantService;
import com.example.amazonclone.service.merchantstockService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchantstock")
public class merchantstockController {
    private final merchantstockService merchantstockService;
    public merchantstockController( merchantstockService merchantstockService){
        this.merchantstockService= merchantstockService;
    }

    @GetMapping()
    public ResponseEntity getMerchantStock(){
        ArrayList<MerchantStock> merchantStocks=merchantstockService.getMerchantStocks();
        return ResponseEntity.status(200).body(merchantStocks);
    }

    @PostMapping("/register")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()){
            String Message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(Message,400));}
        boolean isValid=merchantstockService.addMerchantStock(merchantStock);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("Merchant stock is add",201));}
        return ResponseEntity.status(400).body(new ApiResponces("you can't add Merchant stock that have seam id",400));
    }

    @PutMapping ("/update")
    public ResponseEntity updateMerchantStock(@RequestBody MerchantStock merchantStock,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(message,400));
        }
        boolean isValid=merchantstockService.updateMerchantStock(merchantStock);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("merchantstock updated ",201));}
        return ResponseEntity.status(400).body(new ApiResponces("there is nothing to update or wrong ID of merchant stock ",400));}

    @DeleteMapping("/delete")
    public ResponseEntity deleteMerchantStock(@RequestBody MerchantStock merchantStock,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponces(message,400));
        }
        boolean isValid=merchantstockService.deleteMerchantStock(merchantStock);
        if (isValid){
            return ResponseEntity.status(201).body(new ApiResponces("Merchant stock deleted",201));}
        return ResponseEntity.status(400).body(new ApiResponces("there is nothing to delete or wrong ID Merchant stock ",400));}


}
