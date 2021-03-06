package com.hcl.productdashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.productdashboard.model.Products;
import com.hcl.productdashboard.service.ProductsService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
  @Autowired
  ProductsService productsService;
	
	@GetMapping
	public ResponseEntity<List<Products>> getProductsDetails(){
		List<Products> Products = productsService.getProductsDetails();
		return new ResponseEntity<List<Products>>(Products,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Products> postProducts(@RequestBody Products product){
		
		Products ProductsDetail = productsService.addProduct(product);
		return new ResponseEntity<Products>(ProductsDetail,HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Products> putProducts(@RequestBody Products product){
		
		Products ProductsDetail = productsService.updateProducts(product);
		return new ResponseEntity<Products>(ProductsDetail,HttpStatus.OK);
	}
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteProducts(@PathVariable Long id){
		
		productsService.deleteProduct(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping(value="{id}")
	public ResponseEntity<Products> getProductsByID(@PathVariable Long id){
		
		Products ProductsDetail =productsService.getProductsByID(id);
		return new ResponseEntity<Products>(ProductsDetail,HttpStatus.OK);
	}
	}

