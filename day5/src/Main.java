import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "./day5/src/input.txt";
        String test = "./day5/src/test.txt";
        int counter = 0;
        int location;
        int maxLocation = 0;
        ArrayList<Crate> tempCargo = new ArrayList<>();
        ArrayList<Crate> cargo = new ArrayList<>();
        ArrayList<Integer> movements = new ArrayList<>();

        // Process the list
        try {
            File myFile = new File(test);
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                // Stop when next line is empty.
                if (data.isBlank()) {
                    counter++;
                    continue;
                }
                if (counter == 0) {
                    for (int i = 0; i < data.length(); i++) {
                        if (Character.isLetter(data.charAt(i))) {
                            location = ((i - 1) / 4) + 1;
                            Crate currentCrate = new Crate(data.charAt(i), location);
                            tempCargo.add(currentCrate);
                            if (location > maxLocation) {
                                maxLocation = location;
                            }
                        }
                    }
                } else {
                    String ndata = data.replaceAll("(s|move)", "");
                    ndata = ndata.replaceAll("(s|from)", "");
                    ndata = ndata.replaceAll("(s|to)", "");
                    String[] complete = ndata.split("  ");
                    for (String value: complete) {
                        movements.add(Integer.parseInt(value.trim()));
                    }
                }
            }

        } catch(FileNotFoundException e) {
            System.out.println("File could not be found");
        }

        // Sort the cargo
        int crateLocation = 1;
        while (crateLocation <= maxLocation) {
            for (Crate crate : tempCargo) {
                if (crate.getCrateNumber() == crateLocation) {
                    cargo.add(crate);
                }
            }
            crateLocation++;
        }

        movements.get(0);
        movements.get(1);
        movements.get(2);

        cargo.remove(1);
        //cargo.add();

        int i = 0;
        int count = 0;
        while (i < movements.size()) {
            int move = movements.get(i);
            i++;
            int from = movements.get(i);
            i++;
            int to = movements.get(i);
            System.out.println(movements.get(i));
            i++;

            if (from == cargo.get(0/*last crate location, work backwards*/).getCrateNumber()) {
                cargo.add(to, cargo.get(0));
                //cargo.remove(0+1);
            }
            for (int j = 0; j < move; j++) {
                // cargo.lastIndexOf(//crate with crateNumber from)
                while (count < cargo.size()) {
                    cargo.get(count).getCrateNumber();
                }
                Crate newLoc = cargo.get(from);
                cargo.add(to, newLoc);
            }
        }

    }
}

class Crate {
    protected char letter;
    protected int crateNumber;

    public Crate(char letter, int number) {
        this.letter = letter;
        this.crateNumber = number;
    }

    protected int getCrateNumber() {
        return this.crateNumber;
    }

    protected char getLetter() {
        return this.letter;
    }

}