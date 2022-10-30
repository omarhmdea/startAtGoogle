package Exercises.week2.Methods;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Store {

    public void assignCoupon(User user, Coupon coupon) {
        Objects.requireNonNull(user).addCoupon(coupon);
    }


    public Optional<Coupon> useCouponById(User user, String couponId) {

        for(Coupon coupon : user.getCoupons()) {
            if(coupon.getId().equals(couponId)) {
                user.removeCoupon(coupon);
                return Optional.of(coupon);
            }
        }
        return Optional.empty();
    }


    public int useCouponByHighestValue(User user) {

        assert user != null;
        int max = 0;


        for(Coupon coupon : user.getCoupons()) {
            if(max < coupon.getValue()) {
                max = coupon.getValue();
            }
        }
        return max;
    }


    public Date useCouponByClosestExpiryDate(User user) {

        assert user != null;
        long closestExpiryDate = user.getCoupons().get(0).getExpiryDate().getTime();

        for(Coupon coupon : user.getCoupons()) {
            long nextDateTime = coupon.getExpiryDate().getTime();
            if(closestExpiryDate > nextDateTime) {
                closestExpiryDate = nextDateTime;
            }
        }
        return new Date(closestExpiryDate);
    }


    public Coupon useRandomCoupon(User user) {

        assert user != null;
        int randInt = ThreadLocalRandom.current().nextInt(user.getCoupons().size());
        return user.getCoupons().get(randInt);
    }

}
