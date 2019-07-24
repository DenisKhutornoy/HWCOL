package com.company;

public class Main {

    public static void main(String[] args) {
	TextMethods tm = new TextMethods();
	tm.wordsCount(tm.words);
	tm.replaceSymbol(tm.text,3,"h");
	tm.selectwordsbychars(tm.words);
	tm.markscount(tm.text);
    }
}
