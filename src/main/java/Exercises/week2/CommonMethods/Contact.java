package Exercises.week2.CommonMethods;

public class Contact implements Cloneable, Comparable<Contact> {

    private Name name;
    private PhoneNumber phoneNumber;


    public Contact(Name name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public Name getName() {
        return name;
    }


    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(! (o instanceof Contact contact)) return false;
        return name.equals(contact.name) && phoneNumber.equals(contact.phoneNumber);
    }


    @Override
    public int hashCode() {
        return name.hashCode() * phoneNumber.hashCode();
    }


    @Override
    public String toString() {
        return "\n" + "Name: " + name.toString() + phoneNumber.toString();
    }


    @Override
    protected Object clone() {
        try {
            Contact clone = (Contact) super.clone();
            clone.name = (Name) name.clone();
            clone.phoneNumber = (PhoneNumber) phoneNumber.clone();

            return clone;
        } catch(CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int compareTo(Contact o) {
        int res = name.compareTo(o.name);

        if(res == 0) {
            return phoneNumber.compareTo(o.phoneNumber);
        }
        else {
            return res;
        }
    }

}
