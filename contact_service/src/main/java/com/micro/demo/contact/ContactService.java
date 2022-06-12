package com.micro.demo.contact;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ContactService {

	List<Contact> list = Arrays.asList(new Contact(1L, "Abhay@g.com", "Abh", 123L),
			new Contact(2L, "Beer@g.com", "Bee", 456L), new Contact(3L, "Chintu@g.com", "Chintu", 789L),
			new Contact(4L, "Beer22@g.com", "Bee", 456L));

	public List<Contact> getUserContact(Long userId) {
		return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
