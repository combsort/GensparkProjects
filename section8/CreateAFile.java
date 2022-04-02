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

public class CreateAFile implements Assignment {

    public void createAFile(){
        String pathname = "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\java\\genspark\\assignments\\section8/sample_data.txt";
        try {
            File myObj = new File(pathname);
            if (!myObj.createNewFile()) {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToAFile(){
        String pathname = "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\java\\genspark\\assignments\\section8/sample_data.txt";
        Path p = Paths.get(pathname);
        try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write("test");
        } catch (IOException ioe) {
            System.err.format("IOException: %s%n", ioe);
        }
    }

    public ArrayList<Character> readAFile(){
        String pathname = "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\java\\genspark\\assignments\\section8/sample_data.txt";
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

        ret.remove(4);
        return ret;
    }
//
//    public String fileToStringArray(String str){
//        ArrayList<Character> result = readAFile(str);
//        return result.stream().map(Object::toString)
//                .reduce("",(a,b) -> a+b);
//    }

}
