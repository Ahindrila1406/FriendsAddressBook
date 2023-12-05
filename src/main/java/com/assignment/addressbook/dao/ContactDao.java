package com.assignment.addressbook.dao;

import com.assignment.addressbook.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ContactDao extends JpaRepository<ContactEntity, Integer> {

    Optional<ContactEntity> findById(Integer id);

    List<ContactEntity> findByAddressBookName(String addressBook);

    @Modifying
    @Transactional
    @Query("DELETE FROM contactDetails u WHERE u.addressBookName=:addressBook")
    void deleteByAddressBookName(String addressBook);

}
