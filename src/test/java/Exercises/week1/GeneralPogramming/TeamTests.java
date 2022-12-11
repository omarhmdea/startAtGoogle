package Exercises.week1.GeneralPogramming;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamTests {

    private static Team team;
    private static List<String> names;
    private static String teamName;


    @BeforeAll
    static void setup() {
        Lineup lineup = new Lineup(1, 4, 3, 3);
        names = Arrays.asList("KDB", "Alexis", "Messi", "Hazard", "Benteke", "Mahrez", "Schmeichel", "Aguero", "Sane", "Pogba", "Dier");
        teamName = "NYRO";

        team = Team.createNewTeam(teamName, lineup, names);
    }


    @Test
    void get_teamName_EqualsNTRO() {
        assertEquals(teamName, team.getTeamName());
    }


    @Test
    void get_randomName_Test() {
        String randomName = team.getRandomName(names);
        assertTrue(names.contains(randomName));
    }

}





