package com.gfg;

public class Review implements Comparable<Review>{
    int criticReview;
    int userReview;
    Review( int criticReview,int userReview ){
        this.criticReview =criticReview;
        this.userReview = userReview;
    }

    @Override
    public int compareTo(Review o) {
        return this.criticReview-o.criticReview;
    }
}
