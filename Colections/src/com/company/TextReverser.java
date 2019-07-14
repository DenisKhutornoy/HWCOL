package com.company;

import java.io.*;

import java.util.Collections;
import java.util.LinkedList;


public class TextReverser {


    LinkedList<String> list = readFile();


    public LinkedList<String> readFile() {
        LinkedList<String> list = new LinkedList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("WordsToReverse.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] readBytes = new byte[0];
        try {
            readBytes = new byte[fis.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fis.read(readBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String file = new String(readBytes);

        String[] stringCars = separator(file, " ");

        for (int i = 0; i < stringCars.length; i++) {


            list.add(stringCars[i]);
        }
        return list;
    }

    public String[] separator(String text, String symbol) {
        String[] lines = text.split(symbol);
        return lines;
    }

    public LinkedList<String> sort(LinkedList<String> list) {
        Collections.reverse(list);
        return list;
    }

    public void printList(LinkedList<String> list) {
        int size = list.size();
        try (FileWriter writer = new FileWriter("ReversedText.txt", false)) {
            for (int i = 0; i < size; i++) {
                writer.write(list.get(i) + " ");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
