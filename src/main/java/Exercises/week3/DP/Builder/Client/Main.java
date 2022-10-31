package Exercises.week3.DP.Builder.Client;

import Exercises.Utils.Randoms;
import Exercises.week3.DP.Builder.JobPosition;

import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        LocalDate publishedDate = LocalDate.now().minusDays(Randoms.randomInt(0, 356));
        String title = "Chef";
        boolean isRemote = false;
        JobPosition chef = new JobPosition.Builder(publishedDate, title, isRemote).description("funny Job").Salary(7500).yearsOfExperience(1).build();
        System.out.println(chef);

    }
}
