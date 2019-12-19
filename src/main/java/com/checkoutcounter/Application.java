package com.checkoutcounter;

import com.checkoutcounter.model.Category;
import com.checkoutcounter.model.Product;
import com.checkoutcounter.repository.BillRepository;
import com.checkoutcounter.repository.CategoryRepository;
import com.checkoutcounter.repository.ProductRepository;
import com.checkoutcounter.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BillRepository billRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {

        Category categoryA=new Category("A",10.00);
        Category categoryB=new Category("B",20.00);
        Category categoryC=new Category("C",0.00);
        List<Category> categoryList=new ArrayList<>();
        categoryList.add(categoryA);
        categoryList.add(categoryB);
        categoryList.add(categoryC);
        categoryRepository.save(categoryList);
        Product productA=new Product("apple",10.00,categoryA);
        Product productB=new Product("banana",20.00,categoryB);
        Product productC=new Product("cherry",30.00,categoryC);
        List<Product> productList=new ArrayList<>();
        productList.add(productA);
        productList.add(productB);
        productList.add(productC);
        productRepository.save(productList);
        /*Purchase purchase=new Purchase(productA,2);
        purchaseRepository.save(purchase);
        Set<Purchase> purchases=new HashSet<>();
        purchases.add(purchase);
        Bill bill=new Bill(purchases);

        Bill generatedBill = billRepository.save(bill);
        generatedBill.getId();


        for (Bill bill1 : billRepository.findAll()) {
            logger.info(bill1.toString());
        }*/
    }
}
