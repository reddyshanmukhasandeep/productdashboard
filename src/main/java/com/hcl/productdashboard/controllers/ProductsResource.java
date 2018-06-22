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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/products")
@Api(value = "Product Resource")

@CrossOrigin
public class ProductsResource {
  @Autowired
  ProductsService productsService;
	
  @ApiOperation(value="Returns List of Products")
	@GetMapping
	public ResponseEntity<List<Products>> getProductsDetails(){
		List<Products> Products = productsService.getProductsDetails();
		return new ResponseEntity<List<Products>>(Products,HttpStatus.OK);
	}
  @ApiOperation(value="Create a  Product")
	@PostMapping
	public ResponseEntity<Products> postProducts(@RequestBody Products product){
		
		Products ProductsDetail = productsService.addProduct(product);
		return new ResponseEntity<Products>(ProductsDetail,HttpStatus.OK);
	}
  @ApiOperation(value="Update the  Product")
	@PutMapping
	public ResponseEntity<Products> putProducts(@RequestBody Products product){
		
		Products ProductsDetail = productsService.updateProducts(product);
		return new ResponseEntity<Products>(ProductsDetail,HttpStatus.OK);
	}
  @ApiOperation(value="Delete product by Id")
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteProducts(@PathVariable Long id){
		
		productsService.deleteProduct(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
  
  @ApiOperation(value="Get product by Id")
	@GetMapping(value="{id}")
	public ResponseEntity<Products> getProductsByID(@PathVariable Long id){
		
		Products ProductsDetail =productsService.getProductsByID(id);
		return new ResponseEntity<Products>(ProductsDetail,HttpStatus.OK);
	}
	}

