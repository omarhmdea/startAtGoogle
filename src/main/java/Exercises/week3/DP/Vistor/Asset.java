package Exercises.week3.DP.Vistor;

public class Asset implements Appliance{

    private String owner;
    public int serial;
    public double rating;


    public Asset(String owner, int serial, double rating) {
        this.owner = owner;
        this.serial = serial;
        this.rating = rating;
    }


    public String getOwner() {
        return owner;
    }


    public int getSerial() {
        return serial;
    }


    public double getRating() {
        return rating;
    }


    @Override
    public void accpet(Visitor visitor) {
        visitor.visit(this);
    }
}
