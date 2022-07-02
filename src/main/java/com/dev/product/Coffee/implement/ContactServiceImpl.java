package com.dev.product.Coffee.implement;


import com.dev.product.Coffee.entity.ContactEntity;
import com.dev.product.Coffee.repository.ContactRepository;
import com.dev.product.Coffee.service.ContactService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactEntity createContact(ContactEntity contact) {
        contact.setCreatedDate(new Date());
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public List<ContactEntity> getAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public boolean deleteContact(Long id) {
        Optional<ContactEntity> contactEntityOptional = contactRepository.findById(id);
        if (contactEntityOptional.isPresent()) {
            ContactEntity contactEntity = contactEntityOptional.get();
            contactRepository.delete(contactEntity);
            return true;
        }
        return false;
    }

    @Override
    public ContactEntity getContactById(Long id) {
        Optional<ContactEntity> contactEntityOptional = contactRepository.findById(id);
        ContactEntity contactEntity = null;
        if (contactEntityOptional.isPresent()) {
            contactEntity = contactEntityOptional.get();
        }
        return contactEntity;
    }

}
