package controller;

import common.Library;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import view.Menu;

public class CountProgramming extends Menu<String> {

    static String[] mc = {"Letter and Charator Count", "Convert base number", "Exit"};
    String str;
    Library l;

    public CountProgramming() {
        super("PROGRAMMING", mc);
        l = new Library();
        str = l.getString("Input string: ");
    }

    public void execute(int n) {
        switch (n) {
            case 1:
                countLetter(str);
                break;
            case 2:
                str = str.replaceAll("\\s+", "");
                countCharater(str);
                break;
            case 3:
                System.exit(0);
        }
    }

    public void countLetter(String str) {
    LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
    StringTokenizer tokenizer = new StringTokenizer(str, " \t\n\r\f.,;:?![]{}()\"'");
    
    while (tokenizer.hasMoreTokens()) {
        String word = tokenizer.nextToken();
        
        
        if (word.matches("[a-zA-Z]+")) {
            int count = lhm.getOrDefault(word, 0);
            lhm.put(word, count + 1);
        }
    }
    
    lhm.forEach((key, value) -> {
        System.out.println(key + " -> " + value);
    });
}

    public void countCharater(String str) {
        LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(str, " \t\n\r\f.,;:?![]{}()\"'");

        Pattern pattern = Pattern.compile("[a-zA-Z]+");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            Matcher matcher = pattern.matcher(token);

            while (matcher.find()) {
                String alphanumericToken = matcher.group();

                for (int i = 0; i < alphanumericToken.length(); i++) {
                    char ch = alphanumericToken.charAt(i);
                    int count = lhm.getOrDefault(ch, 0);
                    lhm.put(ch, count + 1);
                }
            }
        }

        lhm.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }
}
