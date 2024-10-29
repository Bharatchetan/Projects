package com.thymeleaf.contactmanager.dao;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thymeleaf.contactmanager.entities.CUser;
import com.thymeleaf.contactmanager.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{
//Pagination
//	currentPage-page
//	Contact per Page-5
	@Query("from Contact as c where c.user.id=:userId")
	public Page<Contact> findContactByCUser(@Param("userId") int userId, Pageable pePageable);
	
//	public List<Contact> findContactByCUser(@Param("userId") int userId);
	
	public List<Contact> findByNameContainingAndUser(String keyword,CUser user);
}
