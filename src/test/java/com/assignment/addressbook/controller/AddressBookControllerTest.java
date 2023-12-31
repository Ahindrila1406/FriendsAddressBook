package com.assignment.addressbook.controller;

import com.assignment.addressbook.model.AddressBook;
import com.assignment.addressbook.model.Contact;
import com.assignment.addressbook.model.ContactIdModel;
import com.assignment.addressbook.model.CustomResponseModel;
import com.assignment.addressbook.service.AddressBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class AddressBookControllerTest {

    @InjectMocks
    private AddressBookController addressBookController;

    @Mock
    private AddressBookService addressBookService;

    @Test
    void fetchAllAddressBooks() {
        CustomResponseModel<Object> customResponseModel = new CustomResponseModel<>(addressBookService.fetchAddressBookNames());
        ResponseEntity responseEntity = new ResponseEntity(customResponseModel, HttpStatus.OK);
        assertEquals(responseEntity.toString(),addressBookController.fetchAllAddressBooks().toString());
    }

    @Test
    void createAddressBook() {
        AddressBook addressBookModel = new AddressBook("ADDRESS_BOOK_1");
        CustomResponseModel<Object> customResponseModel = new CustomResponseModel<>(addressBookService.createAddressBook(addressBookModel));
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(customResponseModel, HttpStatus.OK);
        assertEquals(responseEntity.toString(),addressBookController.createAddressBook(addressBookModel).toString());
    }


    @Test
    void createContact() {
        Contact model = new Contact(1,"John","9463829204","ADDRESS_BOOK_1");
        CustomResponseModel<Object> customResponseModel = new CustomResponseModel<>(addressBookService.createContact(model));
        ResponseEntity responseEntity = new ResponseEntity(customResponseModel, HttpStatus.OK);
        assertEquals(responseEntity.toString(),addressBookController.createContact(model).toString());
    }

    @Test
    void fetchContact() {
        ContactIdModel id = new ContactIdModel(1);
        CustomResponseModel<Object> customResponseModel = new CustomResponseModel<>(addressBookService.fetchContact(id));
        ResponseEntity responseEntity = new ResponseEntity(customResponseModel, HttpStatus.OK);
        assertEquals(responseEntity.toString(),addressBookController.fetchContact(id).toString());
    }

    @Test
    void fetchContactsFromAddressBook() {
        AddressBook addressBookModel = new AddressBook("ADDRESS_BOOK_1");
        CustomResponseModel<Object> customResponseModel = new CustomResponseModel<>(addressBookService.fetchContactsFromAddressBook(addressBookModel));
        ResponseEntity responseEntity = new ResponseEntity(customResponseModel, HttpStatus.OK);
        assertEquals(responseEntity.toString(),addressBookController.fetchContactsFromAddressBook(addressBookModel).toString());
    }

    @Test
    void fetchUniqueContacts() {
        CustomResponseModel<Object> customResponseModel = new CustomResponseModel<>(addressBookService.fetchUniqueContacts());
        ResponseEntity responseEntity = new ResponseEntity(customResponseModel, HttpStatus.OK);
        assertEquals(responseEntity.toString(),addressBookController.fetchUniqueContacts().toString());

    }
}