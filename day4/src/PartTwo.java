import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) {
        String fileName = "./day4/src/input.txt";
        String test = "./day4/src/test.txt";
        int overlappingPairs = 0;

        try {
            File myFile = new File(fileName);
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                int split = data.indexOf(',');
                String part1 = data.substring(0, split);
                String part2 = data.substring(split+1);

                int splitP1 =  part1.indexOf('-');
                int part1num1 = Integer.parseInt(part1.substring(0, splitP1));
                int part1num2 = Integer.parseInt(part1.substring(splitP1+1));

                int splitP2 = part2.indexOf('-');
                int part2num1 = Integer.parseInt(part2.substring(0, splitP2));
                int part2num2 = Integer.parseInt(part2.substring(splitP2+1));

                if ((part1num2 >= part2num1) && (part2num2 >= part1num1)) {
                    overlappingPairs++;
                    System.out.println("Part 1: " + part1 + " Part 2: " + part2);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        System.out.println("The amount of fully contained pairs is: " + overlappingPairs);
    }
}