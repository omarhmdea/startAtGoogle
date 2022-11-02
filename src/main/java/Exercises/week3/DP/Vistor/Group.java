package Exercises.week3.DP.Vistor;

public class Group implements Appliance{
    private int id;
    private int size;


    public Group(int id, int size) {
        this.id = id;
        this.size = size;
    }


    public int getId() {
        return id;
    }


    public int getSize() {
        return size;
    }


    @Override
    public void accpet(Visitor visitor) {
        visitor.visit(this);
    }
}
