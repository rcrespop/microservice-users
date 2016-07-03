package net.robertocrespo.microservices.users.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * User not found exception
 * @author Roberto Crespo
 */
public class UserNotFoundException extends NestedRuntimeException {
    public UserNotFoundException(String userId) {
        super(String.format("User with  Id '%s' not founded", userId));
    }

}
