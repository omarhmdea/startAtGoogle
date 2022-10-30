package Exercises.week2.CommonMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook {

    private List<Contact> contacts;
    private String name;


    public PhoneBook(List<Contact> contacts, String name) {
        this.contacts = contacts;
        this.name = name;
    }


    public PhoneBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }


    public void addContact(Contact c) {
        contacts.add(c);
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Phone Book Name: " + name + "\n");

        for(Contact contact : contacts) {
            str.append(contact.toString());
        }
        return str.toString();
    }


    public void sortPhoneBook() {
        Collections.sort(contacts);
    }


    public List<Contact> findEqualContact(PhoneBook other) {
        List<Contact> equalContact = new ArrayList<>();

        for(Contact contact : contacts) {
            for(Contact otherContact : other.contacts) {
                if(otherContact.equals(contact)) {
                    equalContact.add(contact);
                }

            }
        }
        return equalContact;
    }


    public PhoneBook clonePhoneBookWithNewName(String name) {
        PhoneBook clone = new PhoneBook(name);
        List<Contact> cloneContacts = new ArrayList<>();

        for(Contact contact : contacts) {
            cloneContacts.add((Contact) contact.clone());
        }

        clone.contacts = cloneContacts;

        return clone;
    }


}
