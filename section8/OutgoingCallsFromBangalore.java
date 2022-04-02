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
import java.util.Scanner;
import java.util.stream.Collectors;

public class OutgoingCallsFromBangalore implements Assignment {

    public void createAFile(String str){
        String pathname = str.equals("") ? "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\java\\genspark\\assignments\\section8/sample_data.txt" : str;
        try {
            File myObj = new File(pathname);
            if (!myObj.createNewFile()) {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToAFile(String str){
        String pathname = str.equals("") ? "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\java\\genspark\\assignments\\section8/sample_data.txt" : str;
        Path p = Paths.get(pathname);
        try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
            writer.write("test");
        } catch (IOException ioe) {
            System.err.format("IOException: %s%n", ioe);
        }
    }

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

    public String solution() throws IOException {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        // find all of the area codes and mobile prefixes called by people in bangalore.
        // Fixed lines start with an area code enclosed in parenthesis.
        // The area codes vary in length but always begin with 0.
        // MObile numbers have no parentheses, but have aspace in the middle of the number to help readability.
        // The prefix of a mobile number is its first four digits, and they always start with 7, 8 or 9
        // Telemarketers' numbers have no parentheses or space, but they start with the area code 140.
        // The return string should be all the area codes in lexicographic order with no duplicates.

//        String callsPath = "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\resources\\calls.csv";
//        String textsPath = "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\resources\\texts.csv";
//
//        String[] calls = fileToStringArray(callsPath).split("\n");
//        String[] texts = fileToStringArray(textsPath).split("\n");

        return null;
    }
}
