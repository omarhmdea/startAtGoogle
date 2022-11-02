package Exercises.week3.DP.Vistor;

public class User implements Appliance{
    private int id;
    private String name;
    private String password;


    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }


    @Override
    public void accpet(Visitor visitor) {
        visitor.visit(this);
    }
}
