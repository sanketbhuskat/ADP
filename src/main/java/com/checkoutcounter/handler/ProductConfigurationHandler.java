package com.checkoutcounter.handler;

import com.checkoutcounter.controller.request.ProductConfigureRequest;
import com.checkoutcounter.model.Category;
import com.checkoutcounter.model.Product;
import com.checkoutcounter.repository.CategoryRepository;
import com.checkoutcounter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Created by Sanket Bhsukat on 11/12/2019.
 */
@Component
public class ProductConfigurationHandler implements Handler<Product,ProductConfigureRequest> {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product handle(ProductConfigureRequest input) {
        Product productByName = productRepository.findProductByName(input.getName());

        if(productByName!=null){
            Category category = productByName.getCategory();
            //update Category
            if(!category.equals(input.getCategory())){
                productByName.setCategory(categoryRepository.findCategoryByName(input.getCategory()));
            }
            if(productByName.getCost()!=Double.valueOf(input.getCost())){
                productByName.setCost(Double.valueOf(input.getCost()));
            }

        }else {
          productByName=new Product(input.getName(),Double.valueOf(input.getCost()),categoryRepository.findCategoryByName(input.getCategory()));
        }
        return productRepository.save(productByName);
    }

    @Override
    public Product handle(int id) {

        Product one = productRepository.findOne(id);
        if (one == null) {
            throw new RuntimeException("Invalid produce Id");
        }
        return one;
    }

    @Override
    public List<Product> handle() {
        return productRepository.findAll();
    }
}
