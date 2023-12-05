package com.assignment.addressbook.service;

import com.assignment.addressbook.dao.AddressBookDao;
import com.assignment.addressbook.dao.ContactDao;
import com.assignment.addressbook.entity.AddressBookEntity;
import com.assignment.addressbook.entity.ContactEntity;
import com.assignment.addressbook.exception.CustomException;
import com.assignment.addressbook.model.AddressBook;
import com.assignment.addressbook.model.Contact;
import com.assignment.addressbook.model.ContactIdModel;
import com.assignment.addressbook.model.UniqueContactsModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Objects;

@Service
public class AddressBookServiceImpl implements AddressBookService{

    @Autowired
    private AddressBookDao addressBookDao;

    @Autowired
    private ContactDao contactDetailsDao;
    private static final Logger logger = Logger.getLogger(AddressBookServiceImpl.class.getName());


    @Override
    public List<String> fetchAddressBookNames() {
        List<AddressBookEntity> addressBookList = this.addressBookDao.findAll();
        List<String> addressBookNamesList = new ArrayList<>();
        addressBookList.forEach(addressBook -> addressBookNamesList.add(addressBook.getAddressBookName()));
        return addressBookNamesList;
    }

    @Override
    public AddressBookEntity createAddressBook(AddressBook addressBookReq) {
        Optional<AddressBookEntity> addressBook = this.addressBookDao.findByAddressBookName(addressBookReq.getAddressBookName());
        if(addressBook.isPresent()) {
            throw new CustomException("Invalid input, resource already exists");
        }
        AddressBookEntity addressBookEntity = new AddressBookEntity(addressBookReq.getAddressBookName());
        this.addressBookDao.save(addressBookEntity);
        logger.info("New Address Book : " + addressBookReq.getAddressBookName() + " created");
        
        return addressBookEntity;
    }


    @Override
    public ContactEntity createContact(Contact contactDetails) {
        AddressBookEntity addressBook = this.addressBookDao.findByAddressBookName(contactDetails.getAddressBookName()).orElseThrow(() -> new CustomException("No such address book exists"));
        ContactEntity contactEntity = new ContactEntity(contactDetails.getFullName(),contactDetails.getPhoneNumber(),addressBook.getAddressBookName());
        this.contactDetailsDao.save(contactEntity);
        logger.info("New Contact : " + contactDetails.getFullName()+ " created");
        return contactEntity;
    }

    @Override
    public ContactEntity fetchContact(ContactIdModel id) {
        ContactEntity contactEntity = this.contactDetailsDao.findById(id.getId()).orElseThrow(() -> new CustomException("No such contact exists"));
        logger.info("Displaying contact of Contact Id : " + id.getId());
        return contactEntity;
    }

    @Override
    public List<ContactEntity> fetchContactsFromAddressBook(AddressBook addressBookModel) {
        List<ContactEntity> listContacts = this.contactDetailsDao.findByAddressBookName(addressBookModel.getAddressBookName());
        logger.info("Displaying contacts from : " + addressBookModel.getAddressBookName());
        return listContacts.stream().sorted(Comparator.comparing(ContactEntity::getFullName))
                .collect(Collectors.toList());

    }

    @Override
    public List<UniqueContactsModel> fetchUniqueContacts() {
        List<ContactEntity> contactDetailsList = contactDetailsDao.findAll();
        HashMap<String,UniqueContactsModel> unqiueMap = new HashMap<>();
        contactDetailsList.forEach(contactDetail -> {
            if(!unqiueMap.containsKey(contactDetail.getFullName().toLowerCase())) {
                unqiueMap.put(contactDetail.getFullName().toLowerCase(),new UniqueContactsModel(contactDetail.getFullName(),contactDetail.getPhoneNumber()));
            }
            else {
                unqiueMap.put(contactDetail.getFullName().toLowerCase(),null);
            }
        });
        logger.info("Displaying unique contacts from");
        return (unqiueMap.values().stream().filter(Objects::nonNull)
                .sorted(Comparator.comparing(UniqueContactsModel::getFullName)).collect(Collectors.toList()));
    }


}
