package com.bnk.quoters;

import javax.annotation.PostConstruct;


@Profiling
public class TerminatorQuoter implements Quoter{
    private String message;

    @InjectRandomInt(min=4, max=7)
    private int repeat;
    @Override
    @PostProxy
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("message: " + message);
        }
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public TerminatorQuoter() {
        System.out.println("Phase 1 - CONSTRUCTOR - START");
        System.out.println("Repeat value: " + repeat);
        System.out.println("Message "+ message);
        System.out.println("PHASE 1 END");
    }

    @PostConstruct //должна обрабатываться каким-либо BeanPostProcessor
    public void init(){
        System.out.println("Phase 2 - INIT METHOD - START");
        System.out.println("Repeat value: " + repeat);
        System.out.println("Message: " + message);
        System.out.println("Phase 2 END");
    }

}
