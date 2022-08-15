package com.example.amazonclone.service;

import com.example.amazonclone.model.MerchantStock;
import com.example.amazonclone.model.Product;
import com.example.amazonclone.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class userService {
    private ArrayList<User> users=new ArrayList<>();
    //First method
    public ArrayList<User> getUsers(){
        return users;
    }
    //2 method
    public boolean addUser(User user){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID().equals(user.getID())){
                return false;
            }
        }

        users.add(user);
        return true;}

    //3 method
    public boolean deleteUser(User user){

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID().equals(user.getID())){
                users.remove(i)  ;
                return true;
            }}
        return false;
    }

    //4 method
    public boolean updateUser(User user ){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID().equals(user.getID())){
                users.set(i,user) ;
                return true;
            }}

        return false; }





}
