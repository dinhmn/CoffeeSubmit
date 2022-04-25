package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.entity.ContactEntity;
import com.dev.product.Coffee.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/c1")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public ResponseEntity<ContactEntity> createContact(@RequestBody ContactEntity contact) {
        return ResponseEntity.ok(contactService.createContact(contact));
    }
    @GetMapping("/contact")
    public ResponseEntity<List<ContactEntity>> getAllContact(){
        return ResponseEntity.ok(contactService.getAllContact());
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteContact(@PathVariable Long id){
        boolean deteted = false;
        deteted = contactService.deleteContact(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", deteted);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/contact/{id}")
    public ResponseEntity<ContactEntity> getContactById(@PathVariable Long id){
        ContactEntity contact = contactService.getContactById(id);
        return ResponseEntity.ok(contact);
    }
}
