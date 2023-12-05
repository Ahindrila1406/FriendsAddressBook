package com.assignment.addressbook.service;

import com.assignment.addressbook.dao.AddressBookDao;
import com.assignment.addressbook.dao.ContactDao;
import com.assignment.addressbook.entity.AddressBookEntity;
import com.assignment.addressbook.entity.ContactEntity;
import com.assignment.addressbook.model.AddressBook;
import com.assignment.addressbook.model.Contact;
import com.assignment.addressbook.model.ContactIdModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AddressBookServiceImplTest {

    @Autowired
    private AddressBookService addressBookService;

    @MockBean
    private AddressBookDao addressBookDao;

    @MockBean
    private ContactDao contactDetailsDao;


    @Test
    void fetchAddressBookNames() {
        AddressBookEntity addressBook1 = new AddressBookEntity("ADDRESS_BOOK_1");
        AddressBookEntity addressBook2 = new AddressBookEntity("ADDRESS_BOOK_2");
        AddressBookEntity addressBook3 = new AddressBookEntity("ADDRESS_BOOK_3");
        when(addressBookDao.findAll()).thenReturn(List.of(addressBook1,addressBook2,addressBook3));
        assertEquals(3,addressBookService.fetchAddressBookNames().size());

    }

    @Test
    void createAddressBook() {
        AddressBook addressBookModel = new AddressBook("ADDRESS_BOOK_4");
        AddressBookEntity addressBookEntity = new AddressBookEntity("ADDRESS_BOOK_4");
        when(addressBookDao.save(addressBookEntity)).thenReturn(addressBookEntity);
        assertEquals(addressBookEntity,addressBookService.createAddressBook(addressBookModel));
    }

    @Test
    @Disabled
    void createContact() {
        ContactEntity contactDetails = new ContactEntity(1, "John", "9463829204", "ADDRESS_BOOK_1");
        Contact model = new Contact(1,"John","9463829204","ADDRESS_BOOK_1");
        when(contactDetailsDao.save(Mockito.any())).thenReturn(model);
        assertEquals(contactDetails,addressBookService.createContact(model));
    }

    @Test
    void fetchContact() {
        ContactEntity contactDetails = new ContactEntity(1, "John", "9463829204", "ADDRESS_BOOK_1");
        when(contactDetailsDao.findById(Mockito.any())).thenReturn(Optional.of(contactDetails));
        ContactIdModel id = new ContactIdModel(1);
        assertEquals(contactDetails,addressBookService.fetchContact(id));
    }

    @Test
    void fetchContactsFromAddressBook() {
        ContactEntity contactDetails = new ContactEntity(1, "John", "9463829204", "ADDRESS_BOOK_1");
        AddressBook addressBookModel = new AddressBook("ADDRESS_BOOK_4");
        when(contactDetailsDao.findByAddressBookName(Mockito.any())).thenReturn(List.of(contactDetails));
        assertEquals(1,addressBookService.fetchContactsFromAddressBook(addressBookModel).size());
    }

    @Test
    void fetchUniqueContacts() {

    }

}