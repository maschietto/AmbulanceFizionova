package com.lexsoft.fizionova.propertyBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    private final String systemPathRoot;


    @Autowired
    public MyBean(@Value("${filesistem.root}") String systemPathRoot) {
        this.systemPathRoot = systemPathRoot;

    }

    public String getSystemPathRoot() {
        return systemPathRoot;
    }
}