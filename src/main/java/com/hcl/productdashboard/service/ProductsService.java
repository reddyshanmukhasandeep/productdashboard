package com.hcl.productdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productdashboard.model.Products;
import com.hcl.productdashboard.repo.ProductsRepo;

@Service
public class ProductsService {
@Autowired
ProductsRepo productsRepo;
	public List<Products> getProductsDetails() {
		// TODO Auto-generated method stub
		return productsRepo.findAll();
	}

	public Products addProduct(Products product) {
		// TODO Auto-generated method stub
		return productsRepo.save(product);
	}

	public Products updateProducts(Products product) {
		// TODO Auto-generated method stub
		return productsRepo.save(product);
	}

	public void deleteProduct(Long id) {
		productsRepo.deleteById(id);		
	}

	public Products getProductsByID(Long id) {
		// TODO Auto-generated method stub
		return productsRepo.findByPid(id);
	}

	

}
