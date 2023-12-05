package com.assignment.addressbook.dao;

import com.assignment.addressbook.entity.AddressBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AddressBookDao extends JpaRepository<AddressBookEntity, String> {

    Optional<AddressBookEntity> findByAddressBookName(String addressBookName);
}
