package com.bnk.quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)//мы будем считывать эту аннотацию с reflection
public @interface InjectRandomInt {
    int min();
    int max();

}
