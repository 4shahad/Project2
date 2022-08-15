package com.example.amazonclone.service;

import com.example.amazonclone.model.Merchant;
import com.example.amazonclone.model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class merchantstockService {
    ArrayList<MerchantStock> merchantStocks=new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks(){
        return merchantStocks;
    }

    public boolean addMerchantStock(MerchantStock merchantStock){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getID().equals(merchantStock.getID())){
                return false;
            }
        }
        merchantStocks.add(merchantStock);
        return true;}

    public boolean deleteMerchantStock(MerchantStock merchantStock){

        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getID().equals(merchantStock.getID())){
                merchantStocks.remove(i)  ;
                return true;
            }}
        return false;
    }

    public boolean updateMerchantStock(MerchantStock merchantStock ){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getID().equals(merchantStock.getID())){
                merchantStocks.set(i,merchantStock) ;
                return true;
            }}

        return false; }
}
