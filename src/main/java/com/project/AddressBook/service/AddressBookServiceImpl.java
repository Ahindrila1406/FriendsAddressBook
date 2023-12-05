package com.project.AddressBook.service;

import com.project.AddressBook.model.Friend;
import com.project.AddressBook.persistence.PersistenceImpl;
import com.project.AddressBook.service.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Data
@Service
public class AddressBookServiceImpl implements AddressBookService {
	private List<Friend> currentAddressBookFriends;
	private List<Friend> otherAddressBookFriends;
	@Autowired
	private PersistenceImpl persistence;
	private static final Logger log = LoggerFactory.getLogger(AddressBookServiceImpl.class);
	private static final String CURRENT_ADDRESSBOOK_FILEPATH = "src/main/resources/AddressBook1.txt";
	private static final String OTHER_ADDRESSBOOK_FILEPATH = "src/main/resources/AddressBook2.txt";

	public AddressBookServiceImpl() {
		this.currentAddressBookFriends = new ArrayList<>();
		this.otherAddressBookFriends = new ArrayList<>();
	}

	public void saveToFile(String fileName, List<Friend> friends) {
		persistence.saveToFile(fileName, friends);

	}

	public List<Friend> loadFromFile(String fileName) {
		return persistence.loadFromFile(fileName);

	}

	@Override
	public void addFriend(Friend friend, String addressBookName) throws Exception {

		switch (addressBookName) {
		case "Book1":
			currentAddressBookFriends.add(friend);
			saveToFile("src/main/resources/AddressBook1.txt", currentAddressBookFriends);
			log.info("Friend added to: " + addressBookName);
			break;

		case "Book2":
			otherAddressBookFriends.add(friend);
			saveToFile("src/main/resources/AddressBook2.txt", otherAddressBookFriends);
			log.info("Friend added to: " + addressBookName);
			break;

		default:
			System.out.println("Invalid AddressBook ");
			log.warn("Unexpected address book name: " + addressBookName);
			break;
		}

	}

	@Override
	public Optional<List<Friend>> displayFriends(String addressBookName) throws Exception {
		List<Friend> friendsList = null;
		List<Friend> sortedFriendsList = null;

		switch (addressBookName) {
		case "Book1":
			friendsList = loadFromFile(CURRENT_ADDRESSBOOK_FILEPATH);
			log.info("Friends list fetched from" + addressBookName);
			break;

		case "Book2":
			friendsList = loadFromFile(OTHER_ADDRESSBOOK_FILEPATH);
			log.info("Friends list fetched from" + addressBookName);
			break;

		default:
			System.out.println("Invalid AddressBook ");
			log.warn("Unexpected address book name: " + addressBookName);
			break;

		}

		if (friendsList != null) {
	        sortedFriendsList = friendsList.stream().distinct().sorted(Comparator.comparing(Friend::getName))
	                .collect(Collectors.toList());
	        log.info("Sorted list of friends from: " + addressBookName + " is " + sortedFriendsList.toString());
	        return Optional.of(sortedFriendsList);
	    } else {
	        log.warn("Friends list is null for address book: " + addressBookName);
	        return Optional.empty();
	    }

	}
	
	@Override
	public Optional<Set<String>> findUniqueFriends() throws Exception {
	    currentAddressBookFriends = loadFromFile(CURRENT_ADDRESSBOOK_FILEPATH);
	    otherAddressBookFriends = loadFromFile(OTHER_ADDRESSBOOK_FILEPATH);

	    Set<String> currentAddressBookNameSet = currentAddressBookFriends.stream()
	            .map(Friend::getName).distinct()
	            .collect(Collectors.toSet());

	    Set<String> otherAddressBookNameSet = otherAddressBookFriends.stream()
	            .map(Friend::getName).distinct()
	            .collect(Collectors.toSet());

	    Set<String> duplicateNames = new HashSet<>(currentAddressBookNameSet);
	    duplicateNames.retainAll(otherAddressBookNameSet);

	    currentAddressBookNameSet.removeAll(duplicateNames);
	    otherAddressBookNameSet.removeAll(duplicateNames);

	    Set<String> uniqueFriends = new TreeSet<>(Comparator.naturalOrder());
	    uniqueFriends.addAll(currentAddressBookNameSet);
	    uniqueFriends.addAll(otherAddressBookNameSet);

	    log.info("Unique elements of two address books: {}", uniqueFriends);

	    return Optional.of(uniqueFriends);
	}


}
