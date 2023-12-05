package com.project.AddressBook.controller;

import com.project.AddressBook.Response.CustomResponse;
import com.project.AddressBook.exception.AddressBookException;
import com.project.AddressBook.model.Friend;
import com.project.AddressBook.service.AddressBookServiceImpl;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookServiceImpl addressBookService;

    private static final Logger log = LoggerFactory.getLogger(AddressBookController.class);

    @PostMapping("/addFriend/{addressBookName}")
    public ResponseEntity<CustomResponse<Friend>> addFriend(@RequestBody Friend friend, @PathVariable String addressBookName) throws Exception {
        validateAddressBookName(addressBookName);

        addressBookService.addFriend(friend, addressBookName);
        log.info("Friend added successfully");

        return createSuccessResponse(friend, "Friend added successfully");
    }
   

    @GetMapping("/displayFriends/{addressBookName}")
    public ResponseEntity<CustomResponse<List<Friend>>> displayFriends(@PathVariable String addressBookName) throws Exception {
        validateAddressBookName(addressBookName);

        log.info("Displaying friends of: {} in sorted order", addressBookName);
        Optional<List<Friend>> sortedFriendsList = addressBookService.displayFriends(addressBookName);

        return sortedFriendsList.map(list ->
                createSuccessResponse(list, "Friends displayed successfully")
        ).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/findUniqueFriends")
    public ResponseEntity<CustomResponse<Set<String>>> findUniqueFriends() throws Exception {
        log.info("Displaying unique list of friends");
        Optional<Set<String>> uniqueFriendsList = addressBookService.findUniqueFriends();

        return uniqueFriendsList.map(list ->
                createSuccessResponse(list, "Unique friends displayed successfully")
        ).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    private void validateAddressBookName(String addressBookName) {
        if ("invalid".equals(addressBookName)) {
            throw new AddressBookException("Invalid address book name");
        }
    }

    private <T> ResponseEntity<CustomResponse<T>> createSuccessResponse(T data, String message) {
        CustomResponse<T> response = new CustomResponse<>(data, message, HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
}
