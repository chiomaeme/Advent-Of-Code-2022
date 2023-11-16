import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args){

        String fileName = "./day1/src/input.txt";
        String test = "./day1/src/test.txt";
        long currentTotal = 0;
        long[] allElves = new long[3];

        try {
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.isBlank()) {
                    compareElves(currentTotal, allElves);
                    currentTotal = 0;
                } else {
                    currentTotal += Long.parseLong(data);
                }
            }
            myReader.close();
            compareElves(currentTotal, allElves);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        System.out.println(Arrays.toString(allElves));
        System.out.println(allElves[0] + allElves[1] + allElves[2]);
    }

    private static void compareElves(long currentTotal, long[] allElves) {

        if (currentTotal >= allElves[0]) {
            allElves[2] = allElves[1];
            allElves[1] = allElves[0];
            allElves[0] = currentTotal;
        } else if (currentTotal >= allElves[1]) {
            allElves[2] = allElves[1];
            allElves[1] = currentTotal;
        } else if (currentTotal >= allElves[2]) {
            allElves[2] = currentTotal;
        }
    }
}
