package com.checkoutcounter.handler;


import com.checkoutcounter.controller.request.BillingRequest;
import com.checkoutcounter.controller.request.PurchaseRequest;
import com.checkoutcounter.model.Bill;
import com.checkoutcounter.model.Product;
import com.checkoutcounter.repository.ProductRepository;
import com.checkoutcounter.repository.PurchaseRepository;
import com.checkoutcounter.model.Purchase;
import com.checkoutcounter.repository.BillRepository;
import com.checkoutcounter.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Created by Sanket Bhsukat on 11/12/2019.
 */
@Component
public class BillingRequestHandler implements Handler<Bill,BillingRequest> {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BillRepository billRepository;
    @Transactional
    public Bill handle(BillingRequest input) {

        Set<Purchase> purchases=new HashSet<>();
        for (PurchaseRequest purchase:input.getPurchase()) {
            Product productByName = productRepository.findProductByName(purchase.getProductName().toLowerCase());
            if(productByName!=null){
                Purchase temp = new Purchase(productByName, Integer.valueOf(purchase.getQuantity()));
                purchaseRepository.save(temp);
                purchases.add(temp);
            }else {
                throw new RuntimeException(purchase.getProductName() +" is not yet configured in the inventory");
            }

        }
        Bill bill=new Bill(purchases);

        return billRepository.save(bill);
    }

    public Bill handle(int input) {

        Bill one = billRepository.findOne(input);
        if(one!=null){
            return one;
        }else {
            throw new RuntimeException("Unable to find a Bill with Id "+input);
        }
    }

    @Override
    public List<Bill> handle() {
        return billRepository.findAll();
    }
}
