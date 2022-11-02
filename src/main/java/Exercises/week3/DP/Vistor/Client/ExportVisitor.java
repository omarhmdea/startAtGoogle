package Exercises.week3.DP.Vistor.Client;

import Exercises.week3.DP.Vistor.Asset;
import Exercises.week3.DP.Vistor.Group;
import Exercises.week3.DP.Vistor.User;
import Exercises.week3.DP.Vistor.Visitor;

public class ExportVisitor implements Visitor {


    @Override
    public void visit(User user) {
        String str = "{\n";
        str += "    id: " + user.getId() + "\n";
        str += "    name: " + user.getName() + "\n";
        str += "    password: " + user.getPassword() + "\n";
        str += "}\n";
        System.out.println(str);
    }


    @Override
    public void visit(Group group) {
        String str = "{\n";
        str += "    id: " + group.getId() + "\n";
        str += "    size: " + group.getSize() + "\n";
        str += "}\n";
        System.out.println(str);
    }


    @Override
    public void visit(Asset asset) {
        String str = "{\n";
        str += "    serial: " + asset.getSerial() + "\n";
        str += "    owner: " + asset.getOwner() + "\n";
        str += "    rating: " + asset.getRating() + "\n";
        str += "}\n";
        System.out.println(str);
    }
}
