package com.cg.hsm.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hsm.domain.User;
import com.cg.hsm.service.MapValidationErrorService;
import com.cg.hsm.service.UserService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController 
{
   @Autowired
   private UserService userService;
   
   @Autowired
   private MapValidationErrorService mapValidationErrorService;
   
   @ApiOperation(value = "Adding a user")
   @PostMapping("/add")
   public ResponseEntity<?> createUser(@Valid @RequestBody User user,BindingResult result)
   {
	   ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
	   if(errorMap != null)
		   return errorMap;
	   User us= userService.saveUser(user);
//	   System.out.println(user.getUserName());
	   return new ResponseEntity<User>(us,HttpStatus.OK);
   }
   
   @ApiOperation(value = "display a user using userName")
   @GetMapping("/{userName}")
   public ResponseEntity<?> getUserByUserName(@PathVariable String userName)
   {
	  User user = userService.findByUserName(userName);
	  return new ResponseEntity<User>(user,HttpStatus.OK);
   }
   
   @ApiOperation(value = "display all the users")
   @GetMapping("/all")
   public Iterable<User> getAllUsers()
   {
	   return userService.getAllUsers();
   }
   
   @ApiOperation(value = "Deleting a user using userName")
   @DeleteMapping("/{userName}")
   public ResponseEntity<?> deleteUser(@PathVariable String userName)
   {
	   userService.deleteByUserName(userName);
	   return new ResponseEntity<String>("User having : "+userName+" got deleted",HttpStatus.OK);
   }
   
   @ApiOperation(value = "Updating user password using userName")
   @PutMapping("/forgetpassword/{userName}")
   public void updateUser(@Valid @RequestBody User user , @PathVariable String userName)
   {
	   userService.updateUserPassword(user,userName);
   }
   
   @ApiOperation(value = "Authenticating the user")
   @PostMapping("/authenticateUser")
   public String authenticate(@Valid @RequestBody User user)
   {
	  String result = userService.authenticateUser(user);
	  return result;
   }
   
   
   @ApiOperation(value = "Authenticating the admin")
   @PostMapping("/authenticateAdmin")
   public String authenticateAdmin(@Valid @RequestBody User user)
   {   
	  String result = userService.authenticateAdmin(user);
	  return result;
   }
}