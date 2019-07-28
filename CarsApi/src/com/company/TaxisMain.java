package com.company;

import com.company.mathClasses.Taxis;

public class TaxisMain {
    public static void main(String[] args) {
        Taxis taxis = new Taxis();
        taxis.streamStart(taxis.park);
    }
}
