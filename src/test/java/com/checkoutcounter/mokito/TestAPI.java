package com.checkoutcounter.mokito;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.WebApplicationContext;

import com.checkoutcounter.controller.CheckoutCounter;
import com.checkoutcounter.controller.InventorySetUp;
import com.checkoutcounter.controller.request.BillingRequest;
import com.checkoutcounter.controller.request.CategoryConfigureRequest;
import com.checkoutcounter.controller.request.ProductConfigureRequest;
import com.checkoutcounter.controller.request.PurchaseRequest;

//test
public class TestAPI {
	
	@Autowired
	CheckoutCounter checkoutCouter;
	
	@Autowired
	InventorySetUp inventorySetUp;
	
	@Test
	public  void test() {
		assertTrue(true);
	}
	
	
	@Test
	public void TestCreateBillStatusCode() {
		
	
		checkoutCouter =Mockito.mock(CheckoutCounter.class);
		
		ResponseEntity mockMesponse =  new ResponseEntity(1, HttpStatus.OK);
	 
		
		Mockito.when(checkoutCouter.getBill(0)).thenReturn(mockMesponse);
	 
	    
	    Assert.assertEquals(HttpStatus.OK,checkoutCouter.getBill(0).getStatusCode());
		
	}
	
	@Test
	public void TestGetBill() {
		
	
		checkoutCouter =Mockito.mock(CheckoutCounter.class);
		
		ResponseEntity mockMesponse =  new ResponseEntity(1, HttpStatus.OK);
	 
		
		Mockito.when(checkoutCouter.getBill(0)).thenReturn(mockMesponse);
	 
	    
	    Assert.assertEquals(1,checkoutCouter.getBill(0).getBody());
		
	}
	
	@Test
	public void TestCreateBill() {
		
	
		checkoutCouter =Mockito.mock(CheckoutCounter.class);
		
		ResponseEntity mockMesponse =  new ResponseEntity(1, HttpStatus.OK);
	 
		
		BillingRequest request = new BillingRequest();
	    List<PurchaseRequest> purchase = new ArrayList<>();
	    
	    PurchaseRequest purchaseRequest = new PurchaseRequest();
	    purchaseRequest.setProductName("XYZ");
	    purchaseRequest.setQuantity("10");
	    
	    purchase.add(purchaseRequest);
	   
	    request.setPurchase(purchase);
	    
		Mockito.when(checkoutCouter.createBill(request)).thenReturn(mockMesponse);
	 
	    
	    Assert.assertEquals(1,checkoutCouter.createBill(request).getBody());
		
	}
	
	
	@Test
	public void TestgetBills() {
		
	
		checkoutCouter =Mockito.mock(CheckoutCounter.class);
		
		BillingRequest request = new BillingRequest();
	    List<PurchaseRequest> purchase = new ArrayList<>();
	    
	    PurchaseRequest purchaseRequest = new PurchaseRequest();
	    purchaseRequest.setProductName("XYZ");
	    purchaseRequest.setQuantity("10");
	    
	    purchase.add(purchaseRequest);
	   
	    request.setPurchase(purchase);
	    
	    ResponseEntity mockMesponse =  new ResponseEntity(request, HttpStatus.OK);
	    
		Mockito.when(checkoutCouter.getBills()).thenReturn(mockMesponse);
	 
	    Assert.assertNotNull(checkoutCouter.getBills());
	    Assert.assertEquals(mockMesponse.getBody(),checkoutCouter.getBills().getBody());
		
	}
	
	
	@Test
	public void TestcreateCategory() {
		
		inventorySetUp =Mockito.mock(InventorySetUp.class);
		
		CategoryConfigureRequest request = new CategoryConfigureRequest();
	    
		request.setName("ABC");
		request.setSalesTaxPercentage("10");
		
		ResponseEntity mockMesponse =  new ResponseEntity(request, HttpStatus.OK);
		
		Mockito.when(inventorySetUp.createCategory(request)).thenReturn(mockMesponse);
	 
	    
	    Assert.assertEquals(request,inventorySetUp.createCategory(request).getBody());
	}
	
	@Test
	public void TestgetCategory() {
		
		inventorySetUp =Mockito.mock(InventorySetUp.class);
		
		CategoryConfigureRequest request = new CategoryConfigureRequest();
	    
		request.setName("ABC");
		request.setSalesTaxPercentage("10");
		
		ResponseEntity mockMesponse =  new ResponseEntity(request, HttpStatus.OK);
		
		Mockito.when(inventorySetUp.getCategory(1)).thenReturn(mockMesponse);
	 
	    
	    Assert.assertEquals(request,inventorySetUp.getCategory(1).getBody());
		
	}
	
	
	@Test
	public void TestgetAllCategory() {
		
		inventorySetUp =Mockito.mock(InventorySetUp.class);
		
		CategoryConfigureRequest request = new CategoryConfigureRequest();
	    
		request.setName("ABC");
		request.setSalesTaxPercentage("10");
		
		ResponseEntity mockMesponse =  new ResponseEntity(request, HttpStatus.OK);
		
		Mockito.when(inventorySetUp.getCategory()).thenReturn(mockMesponse);
	 
	    
	    Assert.assertEquals(request,inventorySetUp.getCategory().getBody());
		
	}

	@Test
	public void TestCreateProduct() {
		
		inventorySetUp =Mockito.mock(InventorySetUp.class);
		
		ProductConfigureRequest request = new ProductConfigureRequest();
	    
		request.setName("ABC");
		request.setCategory("Z");
		request.setCost("1000");
		
		ResponseEntity mockMesponse =  new ResponseEntity(request, HttpStatus.OK);
		
		Mockito.when(inventorySetUp.createProduct(request)).thenReturn(mockMesponse);
	 
		Assert.assertNotNull(inventorySetUp.createProduct(request).getBody());
	    Assert.assertEquals(request,inventorySetUp.createProduct(request).getBody());
		
	}
	
	@Test
	public void TestgetProduct() {
		
		inventorySetUp =Mockito.mock(InventorySetUp.class);
		
		ProductConfigureRequest request = new ProductConfigureRequest();
	    
		request.setName("ABC");
		request.setCategory("Z");
		request.setCost("1000");
		
		ResponseEntity mockMesponse =  new ResponseEntity(request, HttpStatus.OK);
		
		Mockito.when(inventorySetUp.getProduct()).thenReturn(mockMesponse);
	 
		Assert.assertNotNull(inventorySetUp.getProduct().getBody());
	    Assert.assertEquals(request,inventorySetUp.getProduct().getBody());
		
	}
	
	
}
