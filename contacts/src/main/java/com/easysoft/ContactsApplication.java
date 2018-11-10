package com.easysoft;

import com.easysoft.dao.repository.ContactRepository;
import com.easysoft.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner {

	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("Hassani", "Mohamed", df.parse("23/05/1986"), "hassan@gmail.com", 0605040302, "has.jpg"));
		contactRepository.save(new Contact("Ibrahimi", "Khaled", df.parse("11/07/2000"), "khalid@gmail.com", 0605040302, "has.jpg"));
		contactRepository.save(new Contact("Lairaichi", "kawtar", df.parse("04/03/1956"), "kawtar@gmail.com", 0605040302, "has.jpg"));

		contactRepository.findAll().forEach(c -> System.out.println(c.getNom()));
	}
}
