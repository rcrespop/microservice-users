package net.robertocrespo.microservices.users.controller;

import net.robertocrespo.microservices.users.exception.UserNotFoundException;
import net.robertocrespo.microservices.users.model.User;
import net.robertocrespo.microservices.users.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import javax.validation.Valid;



/**
 * This  is the controller class with the endpoints of a CRUD for users.
 * @author Roberto Crespo
 * @since 1.0.0
 */

@RestController
@RequestMapping("users")
@Api(value = "Users microservice", description = "This API has a CRUD for users")
public class UsersController {

		
    private static final Log log = LogFactory.getLog(UsersController.class);

    private final UserService usersService;
    private User user;
   
    @Autowired
    public UsersController(UserService usersService) {
        this.usersService = usersService;
    }

    /**
     * Get a User by userId
     * @param userId
     * @return a controller
     */
    @RequestMapping(value="/{userId}",method = RequestMethod.GET)
    @ApiOperation(value = "Find an user", notes = "Return a user by Id" )
    public ResponseEntity<User> userById(@PathVariable String userId)  throws  UserNotFoundException{
        log.info("Get userById");
        try{
        	user = usersService.findByUserId(userId);
        }catch(UserNotFoundException e){
        	user = null;              			
        }     
        return ResponseEntity.ok(user);
        
    }
    
    /**
     * Get all Users
     * @return a controller
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Find all user", notes = "Return all users" )
    public ResponseEntity<List<User>> userById(){
        log.info("Get allUsers");
        return ResponseEntity.ok(usersService.findAll());
    }


    /**
     * Delete an user by Id
     * @param userId
     * @return empty response
     */
    @RequestMapping(value="/{userId}",method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete an user", notes = "Delete a user by Id")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
    	log.info("Delete user " + userId);
        usersService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Save a new user
     * @param user
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    @ApiOperation(value = "Create an user", notes = "Create a new user")
    public  ResponseEntity<User> saveUser(@RequestBody @Valid User user){
    	log.info("Save new user");
         return ResponseEntity.ok(usersService.saveUser(user));
    }

    /**
     * Update an user
     * @param user
     * @return empty response
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Update an user", notes = "Update an user by Id")
    public ResponseEntity<Void> updateUser(@RequestBody @Valid User user){
    	log.info("update user " + user.getUserId());
        usersService.updateUser(user);
        return ResponseEntity.noContent().build();
    }   

}
