import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "./day3/src/input.txt";
        String test = "./day3/src/test.txt";
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<itemTypes> rucksack = new ArrayList<>();
        int totalPriorities = 0;


        try {
            File myFile = new File(test);
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                int parts = data.length() / 2;
                String compartment1 = data.substring(0, parts);
                String compartment2 = data.substring(parts);
                itemTypes current = new itemTypes(compareCompartments(compartment1, compartment2));
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

    public static char compareCompartments(String comp1, String comp2){

        for (int i = 0; i < comp1.length(); i++) {
            for (int j = 0; j < comp2.length(); j++) {
                if (comp1.charAt(i) == comp2.charAt(j)) {
                    System.out.println(comp1.charAt(i));
                    return comp1.charAt(i);
                }
            }
        }
        return 0;
    }
}

class itemTypes {
    protected char letter;
    protected int priority;

    protected itemTypes(char letter){
        this.letter = letter;
        if (Character.isLowerCase(letter)) {
            this.priority = letter - 96;
        } else {
            this.priority = letter - 38;
        }
    }

    protected char getLetter() {
        return this.letter;
    }

    protected int getPriority() {
        return this.priority;
    }

    protected void printTypes(){
        System.out.println(this.letter + "priority: "
                + this.priority);
    }
}