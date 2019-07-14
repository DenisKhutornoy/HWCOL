package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> list = listFromFile();
        printResult(toMap(list));
        TextReverser textReverser = new TextReverser();
        textReverser.printList(textReverser.sort(textReverser.list));
    }


    private static List<String> listFromFile() {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("WordsToFind.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    private static Map<String, Integer> toMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        list.forEach(line -> {
            String words[] = line.split(" ");

            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                    continue;
                }
                map.put(word, 1);
            }

        });

        return map;
    }


    public static void printResult(Map<String, Integer> map) {

        try (FileWriter writer = new FileWriter("ResultofSerching.txt", false)) {
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                writer.write((pair) + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

