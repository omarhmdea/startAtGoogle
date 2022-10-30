package Exercises.week2.CommonMethods;

import java.util.Objects;

public class Name implements Cloneable, Comparable<Name> {

    private final String firstName;
    private final String lastName;
    private final String prefex;


    public Name(String firstName, String lastName, String prefex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.prefex = prefex;
    }


    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(! (o instanceof Name name)) return false;
        return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName) && Objects.equals(prefex, name.prefex);
    }


    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, prefex);
    }


    @Override
    public String toString() {
        return prefex + " " + firstName + " " + lastName + "\n";
    }


    @Override
    protected Object clone() {
        try {
            Name clone = (Name) super.clone();
            return clone;
        } catch(CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getPrefex() {
        return prefex;
    }


    @Override
    public int compareTo(Name o) {

        int compareFirstName = firstName.compareTo(o.firstName);

        if(compareFirstName == 0) {
            return lastName.compareTo(o.lastName);
        }
        else {
            return compareFirstName;
        }

    }
}
