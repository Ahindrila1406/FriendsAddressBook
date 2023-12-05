package com.project.AddressBook.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.project.AddressBook.model.Friend;

@Repository
public class PersistenceImpl implements Persistence {
	
	private static final Logger log = LoggerFactory.getLogger(PersistenceImpl.class);

	
	@Override
    public void saveToFile(String fileName,List<Friend> friends) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            outputStream.writeObject(friends);
        } catch (IOException e){
            log.error("Unable to save file " + e.getMessage(), e);
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchceked")
    public List<Friend> loadFromFile(String fileName) {
    	List<Friend> friends = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))){
            friends = (List<Friend>) inputStream.readObject();
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return friends; 
       		
    }

}
