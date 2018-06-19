package com.hcl.productdashboard.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.productdashboard.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

	
  public User findByUserNameAndPassword(String userName,String password);

@Query("SELECT US.uid FROM User US WHERE US.userName= :userName AND US.password =:password")
public Long findByUserName(@Param("userName") String userName,@Param("password") String password);


}
