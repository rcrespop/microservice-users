
package net.robertocrespo.microservices.users.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * Model class of controller
 * @author Roberto Crespo
 *
 */
@Document(collection = "users")
@JsonPropertyOrder({"userId", "name"})
public class User implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;

    @Id
    @NotNull  
    private String userId;
    @NotNull    
    private String name;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}   
}
