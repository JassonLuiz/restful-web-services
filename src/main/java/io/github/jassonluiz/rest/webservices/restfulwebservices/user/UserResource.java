package io.github.jassonluiz.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	public UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping(path = "/users")
	public List<User> retrievelAllUsers(){
		return service.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User retrievelUser(@PathVariable int id){
		return service.findUser(id);
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser)
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
