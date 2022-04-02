package genspark.assignments.section8;

import genspark.assignments.Assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TotalNumberOfCalls implements Assignment {

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

    public int solution() throws IOException {
//        String callsPath = "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\resources\\calls.csv";
//        String textsPath = "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\resources\\texts.csv";
//
//        String[] calls = fileToStringArray(callsPath).split("\n");
//        String[] texts = fileToStringArray(textsPath).split("\n");
//
//        HashSet<String> numbers = new HashSet<>();
//
//        for (String call : calls){
//            String[] data = call.split(",");
//            String calling = data[0];
//            String rcv = data[1];
//            numbers.add(calling);
//            numbers.add(rcv);
//        }
//        for (String text : texts){
//            String[] data = text.split(",");
//            String sender = data[0];
//            String rcv = data[1];
//            numbers.add(sender);
//            numbers.add(rcv);
//        }

        return 0;//numbers.size();
    }
}

