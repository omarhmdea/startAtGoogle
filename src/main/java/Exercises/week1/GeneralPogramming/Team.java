package Exercises.week1.GeneralPogramming;


import Exercises.Utils.Randoms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class Team {

    private final Player[] players;
    private final List<String> playersName;
    private List<Position> playersPosition;
    private final List<Integer> playersJersey;
    private final static int TEAM_SIZE = 11;
    private String teamName;


    public Team() {
        this.players = new Player[TEAM_SIZE];
        this.playersName = new ArrayList<>();
        this.playersJersey = new ArrayList<>();
        this.playersPosition = new ArrayList<>();

    }


    public static Team createNewTeam(String teamName, Lineup lineup, List<String> playersName) {
        Team team = new Team();
        team.setPlayersPosition(lineup.getPositions());


        for(int i = 0; i < team.getPlayersPosition().size(); i++) {

            String name = team.getRandomName(playersName);
            int jerseyNum = team.getRandomJerseyNumber(1, 12);
            int grade = team.getRandomGrade(1, 11);

            switch(team.getPlayersPosition().get(i)) {
                case GOAL_KEEPER -> team.getPlayers()[i] = Player.createNewGolKeeper(name, jerseyNum, grade);
                case DEFENDER -> team.getPlayers()[i] = Player.createNewDefender(name, jerseyNum, grade);
                case MIDFIELDER -> team.getPlayers()[i] = Player.createNewMidfielder(name, jerseyNum, grade);
                case ATTACKER -> team.getPlayers()[i] = Player.createNewAttacker(name, jerseyNum, grade);
            }

        }

        team.setTeamName(teamName);
        return team;
    }


    public String getTeamName() {
        return teamName;
    }


    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public String getRandomName(List<String> names) {

        List<String> availableNames = new ArrayList<>(names);
        //availableNames.removeAll(this.playersName);

        String playerName = availableNames.get(Randoms.randomInt(availableNames.size()));
        //this.playersName.add(playerName);

        return playerName;
    }


    public int getRandomJerseyNumber(int min, int max) {
        int jerseyNumber = Randoms.randomInt(min, max);

        while(this.playersJersey.contains(jerseyNumber)) {
            jerseyNumber = Randoms.randomInt(min, max);
        }

        this.playersJersey.add(jerseyNumber);

        return jerseyNumber;

    }


    public int getRandomGrade(int min, int max) {
        return Randoms.randomInt(min, max);
    }


    public Player[] getPlayers() {
        return players;
    }


    public void setPlayersPosition(List<Position> playersPosition) {
        this.playersPosition = playersPosition;
    }


    public List<Position> getPlayersPosition() {
        return playersPosition;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Team name: " + this.teamName + "\n");
        str.append("Players: " + "\n");

        for(Player player : this.players) {
            str.append(player.toString());
        }

        return str.toString();
    }


    public void writeToFile(String fileName) {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));) {
            writer.write(this.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
