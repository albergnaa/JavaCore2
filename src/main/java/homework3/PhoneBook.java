package homework3;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    HashMap<String, HashSet<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        HashSet<String> book = phoneBook.getOrDefault(name, new HashSet<>());
        book.add(phoneNumber);
        phoneBook.put(name, book);
    }

    public void get(String name) {
        System.out.println(name + ":");
        System.out.println(phoneBook.getOrDefault(name, new HashSet<>()));
    }
}