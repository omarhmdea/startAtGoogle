package Exercises.week3.DP.Vistor;

public interface Visitor {

    void visit(User user);
    void visit(Group group);
    void visit(Asset asset);

}
