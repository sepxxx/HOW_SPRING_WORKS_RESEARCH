package com.bnk;

import com.bnk.quoters.Quoter;
import com.bnk.quoters.TerminatorQuoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Hello world!");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
//        while(true) {
//            Thread.sleep(100);
////            applicationContext.getBean(TerminatorQuoter.class).sayQuote();
//            applicationContext.getBean(Quoter.class).sayQuote();
//        }
    }
}