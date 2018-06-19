package com.hcl.productdashboard.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.productdashboard.model.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Long>{

	Products findByPid(Long id);

}
