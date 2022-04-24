package com.gfg.session6jbdl30;

import org.springframework.stereotype.Component;
public class ClassB {
    Printer printer;

    public ClassB(Printer printer) {
        this.printer = printer;
    }

    public void print(){
        printer.print();
    }
}
