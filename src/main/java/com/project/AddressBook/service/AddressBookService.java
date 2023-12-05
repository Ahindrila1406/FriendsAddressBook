package com.project.AddressBook.service;
import com.project.AddressBook.model.Friend;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AddressBookService  {
    void addFriend(Friend friend,String addressBookName) throws Exception;
    Optional<List<Friend>> displayFriends(String addressBookName) throws Exception;
    Optional<Set<String>> findUniqueFriends() throws Exception;
}
