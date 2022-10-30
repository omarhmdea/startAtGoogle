package Exercises.week1.GeneralPogramming;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main (String[] args) {

        Lineup lineup = new Lineup(1, 4, 3, 3);
        List<String> names = Arrays.asList("KDB", "Alexis", "Messi", "Hazard", "Benteke", "Mahrez", "Schmeichel", "Aguero", "Sane", "Pogba", "Dier");
        String teamName = "NYRO";

        Team team = Team.createNewTeam(teamName, lineup, names);

        System.out.println(team.toString());
        team.writeToFile(teamName + "-Team.txt");

    }
}
