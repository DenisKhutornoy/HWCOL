package participants;


import interfaces.Participant;

public class Director implements Participant {
    private String name;
    private int yaer;

    public Director(String name, int yaer) {
        this.name = name;
        this.yaer = yaer;
    }

    public String toString() {

        return name + " " + yaer + " г.р." ;
    }
}


