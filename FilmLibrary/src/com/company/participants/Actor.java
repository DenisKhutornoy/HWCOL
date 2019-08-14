package com.company.participants;

import com.company.interfaces.Participant;

public class Actor implements Participant {
    private String name;
    private int yaer;

    public Actor(String name, int yaer) {
        this.name = name;
        this.yaer = yaer;
    }

    public String toString() {

        return name + " " + yaer + " г.р." ;
    }
}
