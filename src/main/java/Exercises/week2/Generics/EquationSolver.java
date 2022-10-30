package Exercises.week2.Generics;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class EquationSolver implements Callable<Integer> {

    private final String sol;
    private final List<Integer> sols;


    public EquationSolver(String sol, List<Integer> sols) {
        this.sol = sol;
        this.sols = sols;
    }


    @Override
    public Integer call() throws Exception {
        return sols.get(ThreadLocalRandom.current().nextInt(sols.size()));
    }
}
