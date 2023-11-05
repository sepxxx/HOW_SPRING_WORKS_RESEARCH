package com.bnk.screensaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalTime.*;

public class PeriodicalScopeConfigurer implements Scope {

    //имя бина против объекта с бином и временем его существования
    Map<String, Pair<LocalTime, Object>> map = new HashMap<>();


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if(map.containsKey(name)) {
            Pair<LocalTime, Object> localTimeObjectPair = map.get(name);
            int secondsSinceLastRequest = now().getSecond() - localTimeObjectPair.getKey().getSecond();
            if(secondsSinceLastRequest>3)
                map.put(name, new Pair<>(now(), objectFactory.getObject()));
        } else {
            map.put(name, new Pair<>(now(), objectFactory.getObject()));
        }

        return map.get(name).getValue();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
