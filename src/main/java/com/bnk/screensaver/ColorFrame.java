package com.bnk.screensaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component
//@Scope("prototype") НЕ НУЖНО!!
public abstract class ColorFrame extends JFrame {
//    @Autowired
//    private Color color;

    //ТАК ВООБЩЕ НЕЛЬЗЯ
//    @Autowired
//    private ApplicationContext applicationContext;

    public ColorFrame() {
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        getContentPane().setBackground(getColor());
        repaint();
    }
    protected abstract Color getColor();
}
