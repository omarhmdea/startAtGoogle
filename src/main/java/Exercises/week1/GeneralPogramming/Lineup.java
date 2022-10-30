package Exercises.week1.GeneralPogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lineup {

    private final int goolKeepersNumber;
    private final int defendersNumber;
    private final int midfieldersNumber;
    private final int attackersNumber;

    private List<Position> positions;

    public Lineup(int goolKeepersNumber, int defendersNumber, int midfieldersNumber, int attackersNumber) {
        this.goolKeepersNumber = goolKeepersNumber;
        this.defendersNumber = defendersNumber;
        this.midfieldersNumber = midfieldersNumber;
        this.attackersNumber = attackersNumber;
        positions = new ArrayList<>(goolKeepersNumber + defendersNumber + midfieldersNumber + attackersNumber);
    }

    public List<Position> getPositions() {

        for (int i = 0; i < this.goolKeepersNumber; i++)
            positions.add(Position.GOAL_KEEPER);

        for (int i = 0; i < this.defendersNumber; i++)
            positions.add(Position.DEFENDER);

        for (int i = 0; i < this.midfieldersNumber; i++)
            positions.add(Position.MIDFIELDER);

        for (int i = 0; i < this.attackersNumber; i++)
            positions.add(Position.ATTACKER);

        Collections.shuffle(positions);
        return positions;
    }
}
