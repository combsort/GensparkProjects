package genspark.assignments.section8;

import genspark.assignments.Assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class PotentialTelemarketers implements Assignment {

    public String solution() throws IOException {
//        // ↓↓↓↓ your code goes here ↓↓↓↓
        String callsPath = "C:\\GenSpark\\genspark-java-core\\genspark-java-core\\genspark-java-core\\src\\main\\resources\\calls.csv";
        String textsPath = "C:\\GenSpark\\genspark-java-core\\genspark-java-core\\genspark-java-core\\src\\main\\resources\\texts.csv";

        String[] calls = Files.readString(Paths.get(callsPath), StandardCharsets.US_ASCII).split("\n");
        String[] texts = Files.readString(Paths.get(textsPath), StandardCharsets.US_ASCII).split("\n");

        //make outgoing calls but never send texts, receive texts, or receive icoming calls
        HashMap<String, List<String>> sentTexts = new HashMap<>();
        HashMap<String, List<String>> rcvTexts = new HashMap<>();
        HashMap<String, List<String>> rcvCalls = new HashMap<>();
        HashMap<String, List<String>> sentCalls = new HashMap<>();

        for (String text : texts){
            String[] txtArray = text.split(",");
            String sendingNum = txtArray[0];
            String rcvNum = txtArray[1];

            if (!rcvTexts.containsKey(rcvNum)){
                ArrayList<String> l = new ArrayList<>();
                rcvTexts.put(rcvNum, l);
            }
            else{
                rcvTexts.get(rcvNum).add(rcvNum);
            }

            if (!sentTexts.containsKey(sendingNum)){
                ArrayList<String> l = new ArrayList<>();
                sentTexts.put(sendingNum, l);
            }
            else{
                sentTexts.get(sendingNum).add(sendingNum);
            }
        }

        for (String call : calls){
            String[] callArray = call.split(",");
            String callingNum = callArray[0];
            String rcvNum = callArray[1];

            if (!rcvCalls.containsKey(rcvNum)){
                ArrayList<String> l = new ArrayList<>();
                rcvCalls.put(rcvNum, l);
            }
            else{
                rcvCalls.get(rcvNum).add(rcvNum);
            }

            if (!sentCalls.containsKey(callingNum)){
                ArrayList<String> l = new ArrayList<>();
                sentCalls.put(callingNum, l);
            }
            else{
                sentCalls.get(callingNum).add(callingNum);
            }
        }

        HashSet<String> numbers = new HashSet<>();
        numbers.addAll(rcvCalls.keySet());
        numbers.addAll(sentTexts.keySet());
        numbers.addAll(rcvTexts.keySet());
        numbers.addAll(sentCalls.keySet());

        ArrayList<String> marketerNums = new ArrayList<>();
        for (String number : numbers){
            if( rcvCalls.get(number) == null
                    && sentTexts.get(number) == null
                    && rcvTexts.get(number) == null
            )
            {
                marketerNums.add(number);
            }
        }

        Collections.sort(marketerNums);
        String hi = "";
        String postFix = "";
        for (String num : marketerNums){
            hi = hi+postFix+num;
            postFix = ",";
        }

        return hi;
    }
}
