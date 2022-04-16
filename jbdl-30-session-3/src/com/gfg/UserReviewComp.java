package com.gfg;

import java.util.Comparator;

public class UserReviewComp implements Comparator<Review> {
    @Override
    public int compare(Review o1, Review o2) {
        return o1.userReview-o2.userReview;
    }
}
