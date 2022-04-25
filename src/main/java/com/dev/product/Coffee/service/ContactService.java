package com.dev.product.Coffee.service;


import com.dev.product.Coffee.entity.ContactEntity;

import java.util.List;

public interface ContactService {

    ContactEntity createContact(ContactEntity contact);
    boolean deleteContact(Long id);
    ContactEntity getContactById(Long id);
    List<ContactEntity> getAllContact();
}
