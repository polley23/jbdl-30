package com.gfg;

public class PowerByMul implements Power{
    @Override
    public long pow(int a, int b) {
        long ans = 1l;
        for(int i =1;i<=b;i++){
            ans = ans * (long) a;
        }
        return ans;
    }
}
