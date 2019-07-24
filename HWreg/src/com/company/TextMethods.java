package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextMethods {
    String text = "On a dark desert highway, cool wind in my hair\n" +
            "Warm smell of colitas, rising up through the air\n" +
            "Up ahead in the distance, I saw a shimmering light\n" +
            "My head grew heavy and my sight grew dim\n" +
            "I had to stop for the night.\n" +
            "There she stood in the doorway;\n" +
            "I heard the mission bell\n" +
            "And I was thinking to myself\n" +
            "'This could be heaven or this could be Hell'\n" +
            "Then she lit up a candle and she showed me the way\n" +
            "There were voices down the corridor,\n" +
            "I thought I heard them say\n" +
            "Welcome to the Hotel California\n" +
            "Such a lovely place (such a lovely place)\n" +
            "Such a lovely face.\n" +
            "Plenty of room at the Hotel California\n" +
            "Any time of year (any time of year) you can find it here\n" +
            "Her mind is Tiffany-twisted, she got the Mercedes bends\n" +
            "She got a lot of pretty, pretty boys, that she calls friends\n" +
            "How they dance in the courtyard, sweet summer sweat\n" +
            "Some dance to remember, some dance to forget\n" +
            "So I called up the Captain,\n" +
            "'Please bring me my wine'\n" +
            "He said, 'we haven't had that spirit here since nineteen sixty-nine'\n" +
            "And still those voices are calling from far away,\n" +
            "Wake you up in the middle of the night\n" +
            "Just to hear them say\"\n" +
            "Welcome to the Hotel California\n" +
            "Such a lovely place (such a lovely place)\n" +
            "Such a lovely face.\n" +
            "They livin' it up at the Hotel California\n" +
            "What a nice surprise (what a nice surprise), bring your alibis";

    String[] words = text.toLowerCase().replaceAll("[-.?!)(,:]", "").split("\\s");

    public void wordsCount(String[] words) {
        Map<String, Integer> wordscount = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                Integer count = wordscount.get(word);
                if (count == null) {
                    count = 0;
                }
                wordscount.put(word, ++count);
            }
        }
        for (String word : wordscount.keySet()) {
            System.out.println(word + ": " + wordscount.get(word));
        }
    }


    public void replaceSymbol(String text, int index, String symbol) {
        StringBuilder builder = new StringBuilder();
        if (text != null && text.length() > 0 && index > 0) {
            for (String word : text.split(" ")) {
                if (word.length() >= index) {
                    builder.append(word, 0, index - 1).append(symbol).append(word.substring(index));
                } else {
                    builder.append(word);
                }
                builder.append(" ");
            }
        }
        System.out.println(builder.toString());
    }


    public void selectwordsbychars(String[] words) {
        LinkedList<String> selectedwords = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 1 && words[i].charAt(0) == words[i].charAt(words[i].length() - 1)) {
                selectedwords.add(words[i]);
            }
        }
        Collections.sort(selectedwords);
        for (int j = 0; j < selectedwords.size() - 2; j++) {
            if (selectedwords.get(j).equals(selectedwords.get(j + 1))) {
                selectedwords.remove(j + 1);
            }
        }
        System.out.println(selectedwords);
    }

    public void markscount(String text) {
        Pattern pattern = Pattern.compile("[.,:;!?'\"-]");
        Matcher matcher = pattern.matcher(text);
        int count = 0;

        while (matcher.find()) {
            count++;
        }

        System.out.println(count);
    }

}

