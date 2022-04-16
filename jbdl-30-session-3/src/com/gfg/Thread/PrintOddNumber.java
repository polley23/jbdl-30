package com.gfg.Thread;

import javax.sound.midi.SysexMessage;
import java.util.Random;

public class PrintOddNumber implements Task{
    @Override
    public void doSomething() {
        Random random = new Random();
        int i = random.nextInt();
        while (i%2==0){
            i = random.nextInt();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println(i);
    }
}
