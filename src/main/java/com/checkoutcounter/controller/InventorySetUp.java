package com.checkoutcounter.controller;

import com.checkoutcounter.controller.request.BillingRequest;
import com.checkoutcounter.controller.request.CategoryConfigureRequest;
import com.checkoutcounter.controller.request.ProductConfigureRequest;
import com.checkoutcounter.handler.Handler;
import com.checkoutcounter.model.Bill;
import com.checkoutcounter.model.Category;
import com.checkoutcounter.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sanket Bhsukat on 11/12/2019.
 */
@Controller
public class InventorySetUp {

    private static final Logger logger = LoggerFactory.getLogger(InventorySetUp.class);

    @Autowired
    private Handler<Product,ProductConfigureRequest> productConfigureRequestHandler;

    @Autowired
    private Handler<Category,CategoryConfigureRequest> categoryConfigureRequestHandler;

    @RequestMapping(value = "/checkoutcounter/category",method =  RequestMethod.POST,consumes = { "application/json" })
    public ResponseEntity createCategory(@RequestBody CategoryConfigureRequest request)
    {
        return new ResponseEntity(categoryConfigureRequestHandler.handle(request).getId(), HttpStatus.OK);
    }

    @RequestMapping (value = "/checkoutcounter/category/{id}",method =  RequestMethod.GET,produces = { "application/json" })
    @ResponseBody
    public ResponseEntity getCategory(@PathVariable("id") int id)
    {
        return new ResponseEntity(categoryConfigureRequestHandler.handle(id), HttpStatus.OK);
    }

    @RequestMapping (value = "/checkoutcounter/category/all",method =  RequestMethod.GET,produces = { "application/json" })
    @ResponseBody
    public ResponseEntity getCategory()
    {
        return new ResponseEntity(categoryConfigureRequestHandler.handle(), HttpStatus.OK);
    }

    @RequestMapping(value = "/checkoutcounter/product",method =  RequestMethod.POST,consumes = { "application/json" })
    public ResponseEntity createProduct(@RequestBody ProductConfigureRequest request)
    {
        return new ResponseEntity(productConfigureRequestHandler.handle(request).getId(), HttpStatus.OK);
    }

    @RequestMapping (value = "/checkoutcounter/product/{id}",method =  RequestMethod.GET,produces = { "application/json" })
    @ResponseBody
    public ResponseEntity getProduct(@PathVariable("id") int id)
    {
        return new ResponseEntity(productConfigureRequestHandler.handle(id), HttpStatus.OK);
    }

    @RequestMapping (value = "/checkoutcounter/product/all",method =  RequestMethod.GET,produces = { "application/json" })
    @ResponseBody
    public ResponseEntity getProduct()
    {
        return new ResponseEntity(productConfigureRequestHandler.handle(), HttpStatus.OK);
    }

}
