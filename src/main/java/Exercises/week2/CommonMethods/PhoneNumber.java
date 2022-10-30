package Exercises.week2.CommonMethods;

import java.util.Objects;

public class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {

    private final String areaCode;
    private final String number;


    @Override
    public String toString() {
        return "PhoneNumber: " + areaCode + number + "\n";
    }


    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(! (o instanceof PhoneNumber that)) return false;
        return Objects.equals(areaCode, that.areaCode) && Objects.equals(number, that.number);
    }


    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }


    public PhoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }


    @Override
    protected Object clone() {

        try {
            PhoneNumber clone = (PhoneNumber) super.clone();
            return clone;

        } catch(CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int compareTo(PhoneNumber o) {

        int compareAreaCode = areaCode.compareTo(o.areaCode);

        if(compareAreaCode == 0) {
            return number.compareTo(o.number);
        }
        else {
            return compareAreaCode;
        }
    }
}
