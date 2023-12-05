package com.project.AddressBook.persistence;

import java.util.List;
import com.project.AddressBook.model.Friend;

public interface Persistence {
    void saveToFile(String fileName, List<Friend> friends);
    List<Friend> loadFromFile(String fileName);
}

