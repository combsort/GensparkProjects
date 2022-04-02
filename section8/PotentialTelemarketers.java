package genspark.assignments.section8;

import genspark.assignments.Assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class PotentialTelemarketers implements Assignment {

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
//        // ↓↓↓↓ your code goes here ↓↓↓↓
//        String callsPath = "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\resources\\calls.csv";
//        String textsPath = "C:\\Genspark\\genspark-java-core\\genspark-java-core\\src\\main\\resources\\texts.csv";
//
//        String[] calls = fileToStringArray(callsPath).split("\n");
//        String[] texts = fileToStringArray(textsPath).split("\n");
//
//        //make outgoing calls but never send texts, receive texts, or receive icoming calls
//        HashMap<String, List<String>> sentTexts = new HashMap<>();
//        HashMap<String, List<String>> rcvTexts = new HashMap<>();
//        HashMap<String, List<String>> rcvCalls = new HashMap<>();
//        HashMap<String, List<String>> sentCalls = new HashMap<>();
//
//        for (String text : texts){
//            String[] txtArray = text.split(",");
//            String sendingNum = txtArray[0];
//            String rcvNum = txtArray[1];
//
//            if (!rcvTexts.containsKey(rcvNum)){
//                ArrayList<String> l = new ArrayList<>();
//                rcvTexts.put(rcvNum, l);
//            }
//            else{
//                rcvTexts.get(rcvNum).add(rcvNum);
//            }
//
//            if (!sentTexts.containsKey(sendingNum)){
//                ArrayList<String> l = new ArrayList<>();
//                sentTexts.put(sendingNum, l);
//            }
//            else{
//                sentTexts.get(sendingNum).add(sendingNum);
//            }
//
//        }
//
//        for (String call : calls){
//            String[] callArray = call.split(",");
//            String callingNum = callArray[0];
//            String rcvNum = callArray[1];
//
//            if (!rcvCalls.containsKey(rcvNum)){
//                ArrayList<String> l = new ArrayList<>();
//                rcvCalls.put(rcvNum, l);
//            }
//            else{
//                rcvCalls.get(rcvNum).add(rcvNum);
//            }
//
//            if (!sentCalls.containsKey(callingNum)){
//                ArrayList<String> l = new ArrayList<>();
//                sentCalls.put(callingNum, l);
//            }
//            else{
//                sentCalls.get(callingNum).add(callingNum);
//            }
//
//        }
//
//        HashSet<String> numbers = new HashSet<>();
//        numbers.addAll(rcvCalls.keySet());
//        numbers.addAll(sentTexts.keySet());
//        numbers.addAll(rcvTexts.keySet());
//        numbers.addAll(sentCalls.keySet());
//
//
//        ArrayList<String> marketerNums = new ArrayList<>();
//        for (String number : numbers){
//            if( rcvCalls.get(number) == null
//                    && sentTexts.get(number) == null
//                    && rcvTexts.get(number) == null
//            )
//            {
//                marketerNums.add(number);
//            }
//        }
//
//        String hi = marketerNums.stream().sorted().reduce("", (a,b) -> a+b);
        return null;
    }
}
