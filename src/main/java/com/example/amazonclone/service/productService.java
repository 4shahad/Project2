package com.example.amazonclone.service;


import com.example.amazonclone.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class productService {
    private ArrayList<Product> products=new ArrayList<>();
   private categoryService categoryService;

    public productService(categoryService categoryService) {
        this.categoryService = categoryService;
    }

    //First method
public ArrayList<Product> getProducts(){
    return products;
}
//2 method
    public boolean addProduct(Product product){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID().equals(product.getID())){
                return false;
            }
        }
        for (int i = 0; i < categoryService.getCategory().size(); i++) {
            if (categoryService.getCategory().get(i).getID().equals(product.getCategoryID())){
                products.add(product);
                return true;}}

   return false;}

    //3 method
    public boolean deleteProduct(Product product){

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID().equals(product.getID())){
             products.remove(i)  ;
            return true;
            }}
        return false;
         }

    //4 method
    public boolean updateProduct(Product product ){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID().equals(product.getID())){
                if (categoryService.getCategory().get(i).getID().equals(product.getCategoryID())) {
                    products.set(i, product);
                    return true;
                }}}

   return false; }

    private merchantstockService merchantstockService;
    private userService userService;

    public void userService(userService userService) {
        this.userService = userService;}
    public void merchantstockService(merchantstockService merchantstockService) {
        this.merchantstockService = merchantstockService;}

    public Integer buyProduct(String userId , String productId, String merchantId ){
        ArrayList<MerchantStock>merchantStocks=merchantstockService.getMerchantStocks();
        ArrayList<User>users=userService.getUsers();
if (merchantStocks==null||users==null){
    return -1;}

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID().equals(userId)){
                if (users.get(i).getBalance()>=products.get(i).getPrice())
                for (int j = 0; j < merchantStocks.size(); j++) {
                    if (merchantStocks.get(j).getProductId().equals(productId)){
                        if (merchantStocks.get(j).getMerchantId().equals(merchantId)){
                            if (merchantStocks.get(j).getStock()!=0){
                          int newStock=  merchantStocks.get(j).getStock()-1;
                            merchantStocks.get(j).setStock(newStock);
                            double newBalance=users.get(i).getBalance()-products.get(i).getPrice();
                            users.get(i).setBalance((int) newBalance);
                            return 1;}
                        }
                    }

                }
            }

        }

 return 0;   }
}
