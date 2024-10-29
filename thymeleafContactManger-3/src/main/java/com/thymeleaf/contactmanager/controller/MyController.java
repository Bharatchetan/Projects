package com.thymeleaf.contactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thymeleaf.contactmanager.dao.UserRepository;
import com.thymeleaf.contactmanager.entities.CUser;
import com.thymeleaf.contactmanager.entities.Contact;

@Controller
public class MyController {
	@Autowired
	private UserRepository userRepository;
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		CUser user=new CUser();
		user.setName("Chetan");
		user.setEmail("Chetan@enterprise.com");
		Contact contact=new Contact();
		user.getContacts().add(contact);
		userRepository.save(user);
		return "working";
	}
}
