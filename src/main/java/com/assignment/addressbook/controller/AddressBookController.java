package com.assignment.addressbook.controller;

import com.assignment.addressbook.entity.AddressBookEntity;
import com.assignment.addressbook.entity.ContactEntity;
import com.assignment.addressbook.model.UniqueContactsModel;
import com.assignment.addressbook.model.AddressBook;
import com.assignment.addressbook.model.Contact;
import com.assignment.addressbook.model.ContactIdModel;
import com.assignment.addressbook.model.CustomResponseModel;
import com.assignment.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactAddressBook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;
    
    @PostMapping(value="/createAddressBook")
    public ResponseEntity<CustomResponseModel> createAddressBook(@RequestBody AddressBook addressBookModel){
        AddressBookEntity addressBook = this.addressBookService.createAddressBook(addressBookModel);
        return new ResponseEntity<>(new CustomResponseModel(addressBook),HttpStatus.OK);
    }

    @PostMapping(value="/createContact")
    public ResponseEntity<CustomResponseModel> createContact(@RequestBody Contact contactDetails){
        ContactEntity contact = this.addressBookService.createContact(contactDetails);
        return new ResponseEntity<>(new CustomResponseModel(contact),HttpStatus.OK);
    }
    
    @PostMapping(value="/displayContact")
    public ResponseEntity<CustomResponseModel> fetchContact(@RequestBody ContactIdModel contactIdModel){
        ContactEntity contactDetails = this.addressBookService.fetchContact(contactIdModel);
        return new ResponseEntity<>(new CustomResponseModel(contactDetails),HttpStatus.OK);
    }
    
    @GetMapping(value="/displayAllAddressBooks")
    public ResponseEntity<CustomResponseModel> fetchAllAddressBooks(){
        List<String> listAddress = this.addressBookService.fetchAddressBookNames();
        return new ResponseEntity<>(new CustomResponseModel(listAddress),HttpStatus.OK);
    }

    @PostMapping(value="/displayContactsFromAddressBook")
    public ResponseEntity<CustomResponseModel> fetchContactsFromAddressBook(@RequestBody AddressBook addressBookModel){
        List<ContactEntity> contacts = this.addressBookService.fetchContactsFromAddressBook(addressBookModel);
        return new ResponseEntity<>(new CustomResponseModel(contacts),HttpStatus.OK);
    }

    @GetMapping(value="/displayUniqueContacts")
    public ResponseEntity<CustomResponseModel> fetchUniqueContacts(){
        List<UniqueContactsModel> uniqueContacts = this.addressBookService.fetchUniqueContacts();
        return new ResponseEntity<>(new CustomResponseModel(uniqueContacts),HttpStatus.OK);
    }

}
