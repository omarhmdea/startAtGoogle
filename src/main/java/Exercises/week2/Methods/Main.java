package Exercises.week2.Methods;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Coupon coupon1 = new Coupon("1", new Date(2023 - 1900, Calendar.APRIL, 3), 250);
        Coupon coupon2 = new Coupon("2", new Date(2025 - 1900, Calendar.APRIL, 3), 300);
        Coupon coupon3 = new Coupon("3", new Date(2029 - 1900, Calendar.NOVEMBER, 13), 50);


        List<Coupon> coupons = new ArrayList<>();
        coupons.add(coupon1);
        coupons.add(coupon2);

        User omar = new User("Omar Hmdea", coupons);
        System.out.println(omar);

        Store store = new Store();


        // assign coupon to user
        store.assignCoupon(omar, coupon3);
        System.out.println(omar);

        //methods to use coupons
        System.out.println(store.useCouponById(omar, "3").orElseThrow(() -> new RuntimeException("Id not found")));
        System.out.println(store.useCouponByHighestValue(omar));
        System.out.println(store.useCouponByClosestExpiryDate(omar));
        System.out.println(store.useRandomCoupon(omar));


    }
}
