package com.microservice.demo.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	@Autowired
	private RestTemplate restTemplate;

	List<User> list = Arrays.asList(new User(123L, "Abhay", "1232323"), new User(456L, "Beer", "189874342323"),
			new User(789L, "Chintu", "197878232323"));
	
	//TODO Handle Type safety
	@SuppressWarnings("unchecked")
	public User getUser(Long userId) {
		User user = list.stream().filter(usr -> usr.getUserId().equals(userId)).findAny().orElse(null);
		List<Contact> contacts = restTemplate.getForObject("http://contact-service/contact/user/" + userId, List.class);
		user.setContacts(contacts);
		return user;
	}

}
