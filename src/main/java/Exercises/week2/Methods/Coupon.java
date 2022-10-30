package Exercises.week2.Methods;

import java.util.Date;

public class Coupon {

    private final String id;
    private final Date expiryDate;
    private final int value;


    public Coupon(String id, Date expiryDate, int value) {
        this.id = id;
        this.expiryDate = new Date(expiryDate.getTime());

        if(value < 0 ) throw new IllegalArgumentException("Value is not positive");
        this.value = value;
    }


    public static Coupon newCouponInstance(Coupon other) {
        if(other == null) {
            throw new IllegalArgumentException("null coupon");
        }

        return new Coupon(other.id, other.expiryDate, other.value);
    }


    public String getId() {
        return id;
    }


    public int getValue() {
        return value;
    }


    public Date getExpiryDate() {
        return new Date(expiryDate.getTime());
    }


    @Override
    public String toString() {
        String str = "";
        str += "[ id = " + id + ", ";
        str += "expiry date = " + expiryDate.toString() + ", ";
        str += "value = " + value + " ]\n";
        return str;
    }
}
