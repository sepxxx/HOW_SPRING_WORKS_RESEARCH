package com.bnk.quoters;

public class T1000 extends TerminatorQuoter implements Quoter{
    //getInterfaces возвращает лишь интерфейсы класа, но не super классов
    //поэтому имплементим Quoter
    @Override
    public void sayQuote() {
        System.out.println("I'm liquid");
    }

    public T1000() {
    }
}
