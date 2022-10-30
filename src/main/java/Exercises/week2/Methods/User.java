package Exercises.week2.Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private final String name;
    private final List<Coupon> couponList;


    public User(String name, List<Coupon> couponList) {
        this.name = name;
        this.couponList = new ArrayList<>();

        for(Coupon coupon : Objects.requireNonNull(couponList)) {
            this.couponList.add(Coupon.newCouponInstance(coupon));
        }
    }


    public void addCoupon(Coupon coupon) {
        couponList.add(Objects.requireNonNull(coupon));
    }


    public void removeCoupon(Coupon coupon) {
        couponList.remove(Objects.requireNonNull(coupon));
    }


    public List<Coupon> getCoupons() {
        return couponList;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Username: ").append(name).append(" \n");
        str.append("Coupons: \n");

        for(Coupon coupon : couponList) {
            str.append(coupon.toString());
        }
        return str.toString();
    }
}
