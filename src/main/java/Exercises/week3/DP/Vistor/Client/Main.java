package Exercises.week3.DP.Vistor.Client;

import Exercises.week3.DP.Vistor.Appliance;
import Exercises.week3.DP.Vistor.Asset;
import Exercises.week3.DP.Vistor.Group;
import Exercises.week3.DP.Vistor.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Appliance> appliances = new ArrayList<>();

        appliances.add(new User(1,"omar","123"));
        appliances.add(new Group(99, 20));
        appliances.add(new Asset("Khaled", 12345, 7.8));

        ExportVisitor exportVisitor = new ExportVisitor();

        for( Appliance app : appliances) {
            app.accpet(exportVisitor);
        }
    }
}
