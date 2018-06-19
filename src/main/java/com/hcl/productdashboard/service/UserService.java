package com.hcl.productdashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productdashboard.model.User;
import com.hcl.productdashboard.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	

	public Long authenticateUser(String user_name, String password) {
User user =userRepo.findByUserNameAndPassword( user_name, password);

 if(user!=null) {
  if(user.getUid()!=null)
	  return user.getUid();}
    return null;
	}



	public Long findByUserName(User userObj) {
		// public Long findByUserName(User user) {
		Long  userid =userRepo.findByUserName( userObj.getUserName(),userObj.getPassword());
		
		  if(userid!=null)
		  {  
			 return userid;
			  
			  }
		  else 
		    return null;
			}



	public void createUser(User userObj) {
		userRepo.save(userObj);
		
	}
	}

