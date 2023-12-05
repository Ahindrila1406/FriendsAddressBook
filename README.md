# FriendsAddressBook

# Project Title:
Address Book Backend
This project has 2 address books by default. The user can  add new contact and display contact details from the two address books Book1 and Book2. Additionally can find the unique contacts from both the address books.

# Project Description:
This is a project to develop an address book that allows a user to store (between successive runs of the program) the name and phone numbers of their friends, with the
following functionality:
• To be able to display the list of friends and their corresponding phone numbers sorted
by their name.
• Given another address book that may or may not contain the same friends, display the
list of friends that are unique to each address book (the union of all the relative
complements). For example given:
Example:
Book1 = { “Bob”, “Mary”, “Jane” }
Book2 = { “Mary”, “John”, “Jane” }
Displays
The contacts that are unique to each address book are:
Book1 \ Book2 = { “Bob”, “John” }

# Run Locally:
1. Clone the project -- git clone https://github.com/Ahindrila1406/FriendsAddressBook
2. Go to the project directory : FriendsAddressBook
3. Import project in an editor : Import the project in any java editor and run the project (This project is created using Java 11 so please ensure compatibility). The API's should be accessible via localhost:8080
4. Run the application in Postman :
   a) For adding new contacts in the Book1 run the following POST method in Postman : http://localhost:8080/addressbook/addFriend/Book1
   JSON body format for adding friend : 
   {
     "name" : "Bob",
     "phoneNumber" : "9674393352"
   }
   {
     "name" : "Mary",
     "phoneNumber" : "9474393352"
   }
   {
     "name" : "Jane",
     "phoneNumber" : "9374393352"
   }
   
   b) For adding new contacts in the Book2 run the following POST method in Postman : http://localhost:8080/addressbook/addFriend/Book2
   {
     "name" : "Mary",
     "phoneNumber" : "9674393352"
   }
   {
     "name" : "John",
     "phoneNumber" : "9074393352"
   }
   {
     "name" : "Jane",
     "phoneNumber" : "9974393352"
   }
   
   c) For displaying sorted contact list in Book1 run the following GET method in Postman : http://localhost:8080/addressbook/displayFriends/Book1
   d) For displaying sorted contact list in Book2 run the following GET method in Postman : http://localhost:8080/addressbook/displayFriends/Book2
   e) For displaying unique contacts to each address book run the following GET method in Postman : http://localhost:8080/addressbook/findUniqueFriends
   
   

