import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    public static final String SCORE_PATH = "C:\\GensparkProjects\\GensparkProjects\\Hangman\\src\\main\\resources\\scores.txt";
    public static final String MAN_PATH = "C:\\GensparkProjects\\GensparkProjects\\Hangman\\src\\main\\resources\\hangman_ascii.txt";

    public ArrayList<String> getFileLines(String path){
        File file = new File(path);
        ArrayList<String> contents = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String next = scanner.nextLine();
                contents.add(next);
            }
        } catch (IOException e) {
            System.out.println("Failure opening file: " + e.getMessage());
        }
        return contents;
    }

    public void appendLineToFile(String path, String line){
        Path p = Paths.get(path);
        try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
            writer.write(line+'\n');
        } catch (IOException ioe) {
            System.err.format("IOException: %s%n", ioe);
        }
    }

    public void recordScore(String name, int score){
        appendLineToFile(SCORE_PATH, String.format("%s,%s",name,score));
    }

}
