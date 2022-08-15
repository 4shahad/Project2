package com.example.amazonclone.service;

import com.example.amazonclone.model.Merchant;
import com.example.amazonclone.model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class merchantService {
    ArrayList<Merchant> merchants=new ArrayList<>();
  private merchantstockService merchantstockService;

    public merchantService(merchantstockService merchantstockService) {
        this.merchantstockService = merchantstockService;
    }

    public ArrayList<Merchant> getMerchants(){
        return merchants;
    }

    public boolean addMerchant(Merchant merchant){
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getID().equals(merchant.getID())){
                return false;
            }
        }
        merchants.add(merchant);
        return true;}

    public boolean deleteMerchant(Merchant merchant){

        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getID().equals(merchant.getID())){
                merchants.remove(i)  ;
                return true;
            }}
        return false;
    }

    public boolean updateMerchant(Merchant merchant ){
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getID().equals(merchant.getID())){
                merchants.set(i,merchant) ;
                return true;
            }}

        return false; }

    public boolean addProduct(String productId,String merchantId,int stock ){
        ArrayList<MerchantStock>merchantStocks=merchantstockService.getMerchantStocks();
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getProductId().equals(productId)){
                merchantStocks.get(i).setMerchantId(merchantId);
                merchantStocks.get(i).setStock(stock);
                merchantStocks.get(i).setProductId(productId);
                return true;
            }

        }
   return false; }


}

