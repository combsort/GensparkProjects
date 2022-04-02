package genspark.assignments.section8;

import genspark.assignments.Assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;


public class RecordOfTextsAndCalls implements Assignment {

    public ArrayList<Character> readAFile(String str){
        String pathname = str.equals("") ? "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\java\\genspark\\assignments\\section8/sample_data.txt" : str;
        File file = new File(pathname);
        ArrayList<String> contents = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String next = scanner.nextLine() + '\n';
                contents.add(next);
            }
        } catch (IOException e) {
            System.out.println("Failure opening file: " + e.getMessage());
        }

        ArrayList<Character> ret = (ArrayList<Character>) contents.stream()
                .map(s -> s.chars().mapToObj(i->(char)i).collect(Collectors.toList()))
                .reduce(new ArrayList<>(),(prevString,newString) ->{
                    ArrayList<Character> a = new ArrayList<>(prevString);
                    a.addAll(newString);
                    return a;
                });

        return ret;
    }

    public String fileToStringArray(String str){
        ArrayList<Character> result = readAFile(str);
        return result.stream().map(Object::toString)
                .reduce("",(a,b) -> a+b);
    }

    public String[] solution() throws IOException {
        // ↓↓↓↓ your code goes here ↓↓↓↓
//        First record of texts, <inc> texts <ans> at time <time>
//        Last record of calls, <inc num> calls <ans num> at time <time>, lasting <duration> seconds

        String callsPath = "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\resources\\calls.csv";
        String textsPath = "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\resources\\texts.csv";

        String[] calls = fileToStringArray(callsPath).split("\n");
        String[] texts = fileToStringArray(textsPath).split("\n");
        String[] firstText = texts[0].split(",");
        String[] lastCall = calls[calls.length-1].split(",");

        String[] myAnswer = new String[]{
                String.format("First record of texts, %s texts %s at time %s", firstText[0], firstText[1], firstText[2].split(" ")[1]),
                String.format("Last record of calls, %s calls %s at time %s, lasting %s seconds", lastCall[0], lastCall[1], lastCall[2].split(" ")[1],lastCall[3])
        };

        return myAnswer;
    }
}
