import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String fileName = "./day1/src/input.txt";
        String test = "./day1/src/test.txt";
        int counter = 0;
        int currentCounter = 0;
        int calorieTotal = 0;
        int currentTotal = 0;

        try {
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.isBlank()) {
                    counter++;
                    if (currentTotal > calorieTotal) {
                        calorieTotal = currentTotal;
                        currentCounter = counter;
                    }
                    currentTotal = 0;
                } else {
                    currentTotal += Integer.parseInt(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        System.out.println("The elf with the most calories if Elf " + currentCounter);
        System.out.println("The amount of calories that the elf has is " + calorieTotal);

    }
}

