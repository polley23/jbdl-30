package com.gfg.session6jbdl30;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrinterImpl implements Printer{
    @Override
    public void print() {
        log.info("Hello World "+ this.hashCode());
    }

}
