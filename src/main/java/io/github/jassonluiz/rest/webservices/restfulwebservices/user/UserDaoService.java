package io.github.jassonluiz.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Jasson", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Katia", LocalDate.now().minusYears(54)));
		users.add(new User(3, "Anne", LocalDate.now().minusYears(21)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findUser(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}
}
