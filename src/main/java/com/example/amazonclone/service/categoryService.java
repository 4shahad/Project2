package com.example.amazonclone.service;

import com.example.amazonclone.model.Category;
import com.example.amazonclone.model.Product;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class categoryService {
   private ArrayList<Category>categories=new ArrayList<>();
 private productService productService;
    public categoryService(@Lazy productService productService) {
        this.productService = productService;}

    public ArrayList<Category> getCategory(){
        return categories;
    }

    public boolean addCategory(Category category){
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getID().equals(category.getID())){
                return false;
            }
        }
        categories.add(category);
        return true;}

    public boolean deleteCategory(Category category){
        ArrayList<Product>products=productService.getProducts();
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getID().equals(category.getID())){
                for (int j = 0; j <products.size() ; j++) {
                    if (products.get(j).getCategoryID().equals(category.getID())){
                        products.remove(j);}}
                categories.remove(i)  ;
                return true;
            }}
        return false;
    }

    public boolean updateCategory(Category category ){
        ArrayList<Product>products=productService.getProducts();
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getID().equals(category.getID())){
                for (int j = 0; j < products.size(); j++) {
                    if (products.get(j).getCategoryID().equals(category.getID())){
                        products.get(j).setCategoryID(category.getID());}}
                categories.set(i,category) ;
                return true;}}
        return false; }
}
