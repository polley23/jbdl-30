package com.gfg;

import com.sun.org.apache.xpath.internal.operations.Div;

import java.io.IOException;
import java.rmi.AccessException;

public class Calculator {
    int a;
    int b;
    Power power; // composition has a relationship
    public Calculator(int a , int b, Power power){
        this.a = a;
        this.b = b;
        this.power = power;
    }

    public Calculator(int a , int b){
        this.a = a;
        this.b = b;
    }
    public int getSum(){
        return this.a+this.b;
    }

    public long getPower(){
        return power.pow(this.a,this.b);
    }
    public double getDivision() throws DivideByZeroException , AccessException {
        return this.a/this.b;
    }
}
