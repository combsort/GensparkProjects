package genspark.assignments.section8;

import genspark.assignments.Assignment;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class LongestCall implements Assignment {

//    public ArrayList<Character> readAFile(String str){
//        String pathname = str.equals("") ? "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\java\\genspark\\assignments\\section8/sample_data.txt" : str;
//        File file = new File(pathname);
//        ArrayList<String> contents = new ArrayList<>();
//        try (Scanner scanner = new Scanner(file)) {
//            while (scanner.hasNext()) {
//                String next = scanner.nextLine() + '\n';
//                contents.add(next);
//            }
//        } catch (IOException e) {
//            System.out.println("Failure opening file: " + e.getMessage());
//        }
//
//        ArrayList<Character> ret = (ArrayList<Character>) contents.stream()
//                .map(s -> s.chars().mapToObj(i->(char)i).collect(Collectors.toList()))
//                .reduce(new ArrayList<>(),(prevString,newString) ->{
//                    ArrayList<Character> a = new ArrayList<>(prevString);
//                    a.addAll(newString);
//                    return a;
//                });
//
//        return ret;
//    }
//
//    public String fileToStringArray(String str){
//        ArrayList<Character> result = readAFile(str);
//        return result.stream().map(Object::toString)
//                .reduce("",(a,b) -> a+b);
//    }

    class SortByDuration implements Comparator<String> {

        // Method
        // Sorting in ascending order of roll number
        public int compare(String a, String b)
        {
            String[] aDetails = a.split(",");
            String[] bDetails = b.split(",");
            return Integer.parseInt(bDetails[3]) - Integer.parseInt(aDetails[3]);
        }
    }

    public String solution() {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        String callsPath = "C:\\GenSpark\\genspark-java-core\\genspark-java-core\\genspark-java-core\\src\\main\\resources\\calls.csv";

        try{
            String[] calls = Files.readString(Paths.get(callsPath), StandardCharsets.US_ASCII).split("\n");
            Object[] sortedRecords = Arrays.stream(calls).sorted(new SortByDuration()).toArray();
            String answerRecord = (String) sortedRecords[0];
            String answer = answerRecord.split(",")[0];
            return answer;
        }
        catch (IOException e ){
            e.printStackTrace();
            return "0";
        }
    }
}

