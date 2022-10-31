package Exercises.week3.DP.Builder;

import java.time.LocalDate;

public class JobPosition {

    private final LocalDate publishedDate;
    private final String title;
    private final boolean isRemote;
    private String description;
    private int salary;
    private int yearsOfExperience;


    public static class Builder {

        private final LocalDate publishedDate;
        private final String title;
        private final boolean isRemote;

        private String description = "";
        private int salary = 0;
        private int yearsOfExperience = 0;


        public Builder(LocalDate publishedDate, String title, boolean isRemote) {
            this.publishedDate = publishedDate;
            this.title = title;
            this.isRemote = isRemote;
        }


        public Builder description(String description) {
            this.description = description;
            return this;
        }


        public Builder Salary(int salary) {
            this.salary = salary;
            return this;
        }


        public Builder yearsOfExperience(int yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
            return this;
        }


        public JobPosition build() {
            return new JobPosition(this);
        }

    }


    public JobPosition(Builder builder) {
        this.publishedDate = builder.publishedDate;
        this.title = builder.title;
        this.isRemote = builder.isRemote;
        this.description = builder.description;
        this.salary = builder.salary;
        this.yearsOfExperience = builder.yearsOfExperience;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nJobPosition {\n");
        sb.append("   publishedDate = ").append(publishedDate);
        sb.append("\n   title = '").append(title).append('\'');
        sb.append("\n   isRemote = ").append(isRemote);
        sb.append("\n   description = '").append(description).append('\'');
        sb.append("\n   salary = ").append(salary);
        sb.append("\n   yearsOfExperience = ").append(yearsOfExperience);
        sb.append("\n}");
        return sb.toString();
    }
}
