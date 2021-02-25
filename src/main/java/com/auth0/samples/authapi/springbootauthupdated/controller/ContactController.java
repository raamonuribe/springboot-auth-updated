package com.auth0.samples.authapi.springbootauthupdated.controller;

import com.auth0.samples.authapi.springbootauthupdated.model.test.Contact;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contacts")
public class ContactController {
    private static final List<Contact> contacts = Lists.newArrayList(
            new Contact("Bruno Krebs","+5551987654321"),
            new Contact("John Doe","+5551888884444")
    );

    @GetMapping
    public List<Contact> getContacts() {
        return contacts;
    }

    @PostMapping
    public void addContact(@RequestBody Contact contact) {
        contacts.add(contact);
    }
}
