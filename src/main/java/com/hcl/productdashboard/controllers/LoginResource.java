package com.hcl.productdashboard.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hcl.productdashboard.model.User;
import com.hcl.productdashboard.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Api(value = "Login Resource")

public class LoginResource {
	
	@Autowired
	UserService userService;
	
	  @ApiOperation(value="Create the User")

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public ResponseEntity<String> createUser(@RequestBody User userObj) {
		Map<String, Object> message = new HashMap<String, Object>();
		Long userExists = userService.findByUserName(userObj);
		ResponseEntity<String> response = null;
		if (null != userExists && 0 != userExists) {
			message.put("message", "There is already a user registered with the username and password provided!");
			message.put("Status", "Error");
			response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.FORBIDDEN);
		} else {
			
			userService.createUser(userObj);
			message.put("message", "User has been registered successfully!");
			message.put("Status", "Success");
			response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.OK);
		}
		return response;
	}
	
	  @ApiOperation(value="Autheticate the user")

	 @RequestMapping(method = RequestMethod.GET, value = "/login")
	    public ResponseEntity<String> authenticateUser(@RequestHeader("userName") String user_name,
	                                                   @RequestHeader("password") String password) {

	        ResponseEntity<String> response = null;
	        Long userId = userService.authenticateUser(user_name, password);
	        Map<String, Object> message = new HashMap<String, Object>();
	        if (userId != null) {
	            message.put("message", "User Authenticated Successfully.");
	            message.put("Status", "Sucess");
	            message.put("UserId", userId);
	            response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.OK);
	        } else {
	            message.put("message", "Invalid User Credentails.");
	            message.put("Status", "Error");
	            response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.FORBIDDEN);
	        }

	        return response;
	    }

}
