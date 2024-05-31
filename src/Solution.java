import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String pathOfNeededFile = "D:\\03_Сережа\\Programming\\Learning_Programming\\src\\newFileNames.txt";
        String pathOfThisFile = "D:\\03_Сережа\\Programming\\Learning_Programming\\src\\fileNames.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(pathOfThisFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(pathOfNeededFile))) {
            while (reader.ready()) {
                String string = reader.readLine();
                String[] informationFromReadedString = string.split(" ");
                String finalString = "E_";
                for(int i = 1; i < informationFromReadedString.length; i++) {
                    finalString += toUpperFirstSymbol(informationFromReadedString[i]);
                }
                String number = informationFromReadedString[0];
                number = number.substring(0, number.length() - 1);
                finalString += "_" + number;
                writer.write(finalString + "\n");
            }
        } catch (Exception e) {}

    }

    private static String toUpperFirstSymbol(String word) {
        return (word.charAt(0) + "").toUpperCase() + word.substring(1, word.length());
    }
}
