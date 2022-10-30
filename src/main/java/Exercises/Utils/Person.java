package Exercises.Utils;

public abstract class Person {

    private String name;
    private int id;


    public Person() {
        this.name = "";
        this.id = 0;
    }


    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public boolean equals(Object other) {
        if(other == this) return true;
        if(other == null) return false;
        if(other.getClass() != this.getClass()) return false;
        Person that = (Person) other;
        return (this.name.equals(that.name)) && (this.id == that.id);
    }


    public String toString() {
        return "Name: " + name;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
}