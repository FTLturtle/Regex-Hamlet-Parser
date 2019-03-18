package HamletParser;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser() {
        this.hamletData = loadFile();
    }

    /**
     * For testing purposes
     */
    HamletParser(String input) {
        this.hamletData = input;
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public void replaceHoratioWithTariq() {
        findAndReplace("Horatio", "Tariq");
    }

    public void replaceHamletWithLeon() {
        findAndReplace("Hamlet", "Leon");
    }

    public Integer findHoratio() {
        return find("Horatio");
    }

    public Integer findHamlet() {
        return find("Hamlet");
    }

    private Integer find(String find) {
        Integer result = null;
        Pattern pattern = Pattern.compile(find);
        Matcher matcher = pattern.matcher(hamletData);
        if (matcher.find()) {
            result = matcher.start();
        }
        return result;
    }

    private void findAndReplace(String find, String replace) {
        Pattern pattern = Pattern.compile(find);
        Matcher matcher = pattern.matcher(hamletData);
        hamletData = matcher.replaceAll(replace);
    }

    public String getHamletData() {
        return hamletData;
    }

}
