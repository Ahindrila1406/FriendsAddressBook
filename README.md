# Project Title

Address Book Backend
This project has 3 address books by default with 3 contacts each. 
1) The user can add new contact.
2) The user can add new AddressBook.
3) Find unique contacts from each address book. 

## Project Description
This project develops an address book that allows a user to store (between
successive runs of the program) the name and phone numbers of their friends, with the
following functionality:
• To be able to display the list of friends and their corresponding phone numbers sorted
by their name.
• Given another address book that may or may not contain the same friends, display the
list of friends that are unique to each address book (the union of all the relative
complements). For example given:

Book1 = { “Bob”, “Mary”, “Jane” }
Book2 = { “Mary”, “John”, “Jane” }
The friends that are unique to each address book are:
Book1 \ Book2 = { “Bob”, “John” }

## Run Locally

Clone the project -- git clone https://github.com/Ahindrila1406/FriendsAddressBook.git


Go to the project directory

  cd FriendsAddressBook


Import project in an editor
  Import the project in any java editor and run the project (This project is created using Java 11 so please ensure compatibility). The API's should be accessible via localhost:8080

## Run from Postman

1) API for creating new Address book : http://localhost:8080/contactAddressBook/createAddressBook (POST method)
   JSON Request Body :
   {
    "addressBookName": "ADDRESSBOOK_1"
   }
2) API for creating new contact : http://localhost:8080/contactAddressBook/createContact (POST method)
   JSON Request Body :
   {
    "fullName": "Bob",
    "phoneNumber": "57575",
    "addressBookName": "ADDRESSBOOK_1"
   }
3) API for displaying contacts with respect to id: http://localhost:8080/contactAddressBook/displayContact (POST method)
    JSON Request Body :
   {
    "id": 10
   }
   
4) API for displaying existing Address Books: http://localhost:8080/contactAddressBook/displayAllAddressBooks (GET method)   
  
5) API for displaying unique contacts in the address books : http://localhost:8080/contactAddressBook/displayUniqueContacts (GET method)



