package com.easysoft.web.services;

import com.easysoft.dao.repository.ContactRepository;
import com.easysoft.model.Contact;

import net.bytebuddy.implementation.bytecode.constant.DefaultValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactRestService {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @GetMapping("/contacts/{id}")
    public Contact getContact(@PathVariable("id") Long id) {
        return contactRepository.findById(id).get();
    }

    @GetMapping("/chercherContacts")
    public Page<Contact> chercher(
            @RequestParam(value = "motCle", defaultValue = "") String motCle,
            @RequestParam(value = "page", defaultValue = "0")int page,
            @RequestParam(value = "size", defaultValue = "5")int size) {

        return contactRepository.chercher("%"+motCle+"%", new PageRequest(page, size));
    }

    @PostMapping("/contacts")
    public Contact saveContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @DeleteMapping("/contacts/{id}")
    public boolean deleteContact(@PathVariable("id") Long id) {
        contactRepository.delete(contactRepository.findById(id).get());
        return true;
    }

    @PutMapping("/contacts/{id}")
    public Contact updateContact(@PathVariable("id") Long id, @RequestBody Contact contact) {
        contact.setId(id);
        return contactRepository.save(contact);
    }

}
