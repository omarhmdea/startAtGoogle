package Exercises.week1.GeneralPogramming;

import Exercises.Utils.Person;

public class Player extends Person {

    private int grade;
    private Position position;


    public Player() {
        super();
    }


    public static Player createNewGolKeeper(String name, int jerseyNumber, int grade) {
        Player player = new Player();
        player.setName(name);
        player.setId(jerseyNumber);
        player.setGrade(grade);
        player.setPosition(Position.GOAL_KEEPER);
        return player;
    }


    public static Player createNewDefender(String name, int jerseyNumber, int grade) {
        Player player = new Player();
        player.setName(name);
        player.setId(jerseyNumber);
        player.setGrade(grade);
        player.setPosition(Position.DEFENDER);
        return player;
    }


    public static Player createNewMidfielder(String name, int jerseyNumber, int grade) {
        Player player = new Player();
        player.setName(name);
        player.setId(jerseyNumber);
        player.setGrade(grade);
        player.setPosition(Position.MIDFIELDER);
        return player;
    }


    public static Player createNewAttacker(String name, int jerseyNumber, int grade) {
        Player player = new Player();
        player.setName(name);
        player.setId(jerseyNumber);
        player.setGrade(grade);
        player.setPosition(Position.ATTACKER);
        return player;
    }


    @Override
    public String toString() {
        String str = "\n";
        str += "\t" + super.toString() + "\n";
        str += "\t" + "Jersey Number: " + this.getId() + "\n";
        str += "\t" + "Grade: " + this.grade + "\n";
        str += "\t" + "Position: " + this.position + "\n";
        str += "\n";

        return str;
    }


    public int getGrade() {
        return grade;
    }


    public void setGrade(int grade) {
        this.grade = grade;
    }


    public Position getPosition() {
        return position;
    }


    public void setPosition(Position position) {
        this.position = position;
    }
}
