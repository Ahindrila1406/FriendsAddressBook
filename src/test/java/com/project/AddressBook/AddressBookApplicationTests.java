package com.project.AddressBook;

import com.project.AddressBook.model.Friend;
import com.project.AddressBook.service.AddressBookService;

import com.project.AddressBook.service.AddressBookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class AddressBookApplicationTests {

	@Autowired
	private AddressBookServiceImpl addressBookService;

	@Test
	void testAddFriend() throws Exception {
		addressBookService.addFriend(new Friend("Joe","923456789"), "Book1");
		addressBookService.addFriend(new Friend("Charlie","956890123"), "Book1");
		addressBookService.addFriend(new Friend("Harry","987654321"), "Book1");
		assertEquals(3, addressBookService.displayFriends("Book1").get().size());
	}

	@Test
	void testFindUniqueFriends() throws Exception {

		addressBookService.addFriend(new Friend("Alex","923456789"), "Book1");
		addressBookService.addFriend(new Friend("Mary","963456789"), "Book1");
		addressBookService.addFriend(new Friend("Jane","123456789"), "Book1");

		addressBookService.addFriend(new Friend("Mary","923456789"), "Book2");
		addressBookService.addFriend(new Friend("John","823456789"), "Book2");
		addressBookService.addFriend(new Friend("Jane","923456789"), "Book2");

		Optional<Set<String>> uniqueFriendsBook = addressBookService.findUniqueFriends();
		assertNotNull(uniqueFriendsBook.get());
	}
	
	@Test
	void testDisplayFriendsInSortedOrder() throws Exception {
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    PrintStream mockPrintStream = new PrintStream(outputStream);

	    Optional<List<Friend>> friends = addressBookService.displayFriends("Book1");

	    System.setOut(mockPrintStream);

	    List<String> expectedOutput = Arrays.asList(
	            "Joe: 923456789",
	            "Charlie: 956890123",
	            "Harry: 987654321"
	    );

	    List<String> actualOutput = friends.orElseThrow().stream()
	            .map(friend -> friend.getName() + ": " + friend.getPhoneNumber())
	            .collect(Collectors.toList());

	    Collections.sort(expectedOutput);
	    Collections.sort(actualOutput);

	    assertEquals(expectedOutput, actualOutput);
	}



//	@Test
//	void testDisplayFriendsInSortedOrder() throws Exception {
//		
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//		PrintStream mockPrintStream = new PrintStream(outputStream);
//
//		Friend friend1 = new Friend("Alice","123456789");
//		Friend friend2 = new Friend("Charlie","987654321");
//		Friend friend3 = new Friend("Bob","567890123");
//
//		addressBookService.addFriend(friend1, "Book1");
//      	addressBookService.addFriend(friend2, "Book1");
//		addressBookService.addFriend(friend3, "Book1");
//
//		Optional<List<Friend>> friends=addressBookService.displayFriends("Book1");
//
//		System.setOut(System.out);
//
//		List<String> expectedOutput = Arrays.asList(
//				"Alice: 123456789",
//				"Bob: 567890123",
//				"Charlie: 987654321"
//		);
//
//		List<String> actualOutput = Arrays.asList(outputStream.toString().trim().split("\r\n"));
//		assertEquals(expectedOutput, friends);
//
////		Friend friend1 = new Friend("Bob","123456789");
////		Friend friend2 = new Friend("Mary","987654321");
////		Friend friend3 = new Friend("Jane","567890123");
////
////		addressBookService.addFriend(friend1, "Book1");
////		addressBookService.addFriend(friend2, "Book1");
////		addressBookService.addFriend(friend3, "Book1");
////
////		Optional<List<Friend>> friends=addressBookService.displayFriends("Book1");
////		assertEquals(3, friends.get().size());
//	}
}
