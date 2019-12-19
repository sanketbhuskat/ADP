package com.checkoutcounter.controller;

import com.checkoutcounter.controller.request.BillingRequest;
import com.checkoutcounter.handler.Handler;
import com.checkoutcounter.model.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CheckoutCounter {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutCounter.class);

    @Autowired
    private Handler<Bill,BillingRequest> billingRequestHandler;

    @RequestMapping (value = "/checkoutcounter/bill",method =  RequestMethod.POST,consumes = { "application/json" })
    public ResponseEntity createBill(@RequestBody BillingRequest request)
    {
        return new ResponseEntity(billingRequestHandler.handle(request).getId(), HttpStatus.OK);
    }

    @RequestMapping (value = "/checkoutcounter/bill/{id}",method =  RequestMethod.GET,produces = { "application/json" })
    @ResponseBody
    public ResponseEntity getBill(@PathVariable("id") int id)
    {
        return new ResponseEntity(billingRequestHandler.handle(id), HttpStatus.OK);
    }

    @RequestMapping (value = "/checkoutcounter/bill/all",method =  RequestMethod.GET,produces = { "application/json" })
    @ResponseBody
    public ResponseEntity getBills()
    {
        return new ResponseEntity(billingRequestHandler.handle(), HttpStatus.OK);
    }
}
