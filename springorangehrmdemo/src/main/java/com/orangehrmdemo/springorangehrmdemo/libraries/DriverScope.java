package com.orangehrmdemo.springorangehrmdemo.libraries;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

public class DriverScope extends SimpleThreadScope {

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return super.get(name, objectFactory);
    }
}
