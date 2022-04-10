package com.gfg;

public class AgeFinder {
    Lifeform lifeform;

    public AgeFinder(Lifeform lifeform) {
        this.lifeform = lifeform;
    }

    public int getAge(){
        return lifeform.getAge();

    }
}
