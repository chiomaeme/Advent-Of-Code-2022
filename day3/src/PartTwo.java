import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) {
        String fileName = "./day3/src/input.txt";
        String test = "./day3/src/test.txt";
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<itemTypes> rucksack = new ArrayList<>();
        int totalPriorities = 0;
        String line1;
        String line2;
        String line3;

        try {
            File myFile = new File(fileName);
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                line1 = reader.nextLine();
                line2 = reader.nextLine();
                line3 = reader.nextLine();
                itemTypes current = new itemTypes(compareCompartments(line1, line2, line3));
                rucksack.add(current);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
        }

        for (itemTypes item: rucksack) {
            totalPriorities +=  item.getPriority();
        }
        System.out.println(totalPriorities);
    }

    public static char compareCompartments(String comp1, String comp2, String comp3){

        for (int i = 0; i < comp1.length(); i++) {
            for (int j = 0; j < comp2.length(); j++) {
                for (int l = 0; l < comp3.length(); l++) {
                    if (comp1.charAt(i) == comp2.charAt(j) && comp1.charAt(i) == comp3.charAt(l)) {
                        return comp1.charAt(i);
                    }
                }
            }
        }
        return 0;
    }
}
