package Exercises.week2.CommonMethods;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Name omarName = new Name("Omar", "Hmdea", "Mr.");
        Name mostafaName = new Name("Mustafa", "Mosa", "Mr.");
        Name khaledName = new Name("Khaled", "aa", "Ms.");

        PhoneNumber omarPhone = new PhoneNumber("050", "1234567");
        PhoneNumber mostafaPhone = new PhoneNumber("052", "1234567");
        PhoneNumber khaledPhone = new PhoneNumber("053", "1234567");

        Contact omarContact = new Contact(omarName, omarPhone);
        Contact mustafaContact = new Contact(mostafaName, mostafaPhone);
        Contact khaledContact = new Contact(khaledName, khaledPhone);

        PhoneBook phoneBook = new PhoneBook("Stam");

        phoneBook.addContact(omarContact);
        phoneBook.addContact(mustafaContact);
        phoneBook.addContact(khaledContact);

        // to String
        System.out.println(phoneBook);


        // ComperTo
        System.out.println("After Sorting");
        phoneBook.sortPhoneBook();
        System.out.println(phoneBook);


        Name anaName = new Name("Ana", "fi", "Ms.");
        PhoneNumber anaPhone = new PhoneNumber("056", "1234567");
        Contact anaContact = new Contact(anaName, anaPhone);

        PhoneBook phoneBook2 = new PhoneBook("Stam2");

        phoneBook2.addContact(omarContact);
        phoneBook2.addContact(anaContact);
        phoneBook2.addContact(khaledContact);

        // equal
        List<Contact> equalContact = phoneBook.findEqualContact(phoneBook2);
        System.out.println(equalContact);

        // Clone
        PhoneBook phoneBook3 = phoneBook2.clonePhoneBookWithNewName("NYRO");
        System.out.println(phoneBook3);

    }
}
