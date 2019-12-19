package com.checkoutcounter.handler;

import com.checkoutcounter.controller.request.CategoryConfigureRequest;
import com.checkoutcounter.model.Category;
import com.checkoutcounter.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sanket Bhsukat on 11/12/2019.
 */
@Component
public class CategoryConfigurationHandler implements Handler<Category,CategoryConfigureRequest> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @Override
    public Category handle(CategoryConfigureRequest input) {

        Category categoryByName = categoryRepository.findCategoryByName(input.getName());
        if(categoryByName!=null){
            categoryByName.setSalestax(Double.valueOf(input.getSalesTaxPercentage()));
        }else {
            categoryByName=new Category(input.getName(),Double.valueOf(input.getSalesTaxPercentage()));
        }
        return categoryRepository.save(categoryByName);
    }

    @Override
    public Category handle(int id) {
        Category one = categoryRepository.findOne(id);
        if (one == null) {
            throw new RuntimeException("Invalid Category Id");
        }
        return one;
    }

    @Override
    public List<Category> handle() {
        return categoryRepository.findAll();
    }
}
