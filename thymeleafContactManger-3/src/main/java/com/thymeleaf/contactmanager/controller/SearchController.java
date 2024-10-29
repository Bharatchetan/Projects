package com.thymeleaf.contactmanager.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.thymeleaf.contactmanager.dao.ContactRepository;
import com.thymeleaf.contactmanager.dao.UserRepository;
import com.thymeleaf.contactmanager.entities.CUser;
import com.thymeleaf.contactmanager.entities.Contact;

@RestController
public class SearchController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ContactRepository contactRepository;
	
//	Search Handler
	@GetMapping("/search/{q}")
	public ResponseEntity<?> search(@PathVariable("q") String q, Principal principal){
		System.out.println(q);
		CUser user = this.userRepository.getUserByUserName(principal.getName());
//		System.out.println(user);
		List<Contact> contacts = this.contactRepository.findByNameContainingAndUser(q, user);
		for(Contact c:contacts) 
		System.out.println(c);
		return ResponseEntity.ok(contacts);
	}
}
