package net.robertocrespo.microservices.users.service;

import net.robertocrespo.microservices.users.model.User;
import java.util.List;


/**
 * This class has the neccesary methods to implement a CRUD
 * @author Roberto Crespo
 * @since 1.0.0
 */
public interface UserService {

	/**
    * Find all users
    * @return controller
    */
   List<User> findAll();
	
	/**
     * Find a controller
     * @param userId
     * @return controller
     */
    User findByUserId(String userId);

  
    /**
     * Save a new user
     * @param user
     * @return controller saved
     */
    User saveUser(User user);

    /**
     * Update a user
     * @param user
     */
    void updateUser(User user);

    /**
     * Delete a user
     * @param userId
     */
    void deleteUser(String userId);
}
