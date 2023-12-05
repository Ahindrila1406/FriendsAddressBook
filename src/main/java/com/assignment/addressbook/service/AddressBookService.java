package com.assignment.addressbook.service;

import com.assignment.addressbook.entity.AddressBookEntity;
import com.assignment.addressbook.entity.ContactEntity;
import com.assignment.addressbook.model.AddressBook;
import com.assignment.addressbook.model.Contact;
import com.assignment.addressbook.model.ContactIdModel;
import com.assignment.addressbook.model.UniqueContactsModel;
import java.util.List;

public interface AddressBookService {
    public List<String> fetchAddressBookNames();

    public AddressBookEntity createAddressBook(AddressBook addressBookName);

    public ContactEntity createContact(Contact contactDetails);

    public ContactEntity fetchContact(ContactIdModel id);

    public List<ContactEntity> fetchContactsFromAddressBook(AddressBook addressBookModel);

    public List<UniqueContactsModel> fetchUniqueContacts();

}
