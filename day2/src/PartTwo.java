import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartTwo {

    public static void main(String[] args){
         String fileName = "./day2/src/input.txt";
         String test = "./day2/src/test.txt";
         int score = 0;

         try {
             File myFile = new File(fileName);
             Scanner reader = new Scanner(myFile);

             while (reader.hasNextLine()) {
                 String data = reader.nextLine();
                 char cpuChoice = data.charAt(0);
                 char endGoal = data.charAt(2);
                 score += compareStrategy(cpuChoice, endGoal);
             }
         }
         catch (FileNotFoundException e) {
             System.out.println("File could not be found.");
         }

         System.out.println("The player score is: " + score);
    }

    private static int compareStrategy(char cpu, char ending) {
        int endingScore = 0;

        if (cpu == 'A' && ending == 'X') { // lose
            endingScore = 3;
        } else if (cpu == 'A' && ending == 'Y') { // draw
            endingScore = 1 + 3;
        } else if (cpu == 'A' && ending == 'Z') { // win
            endingScore = 2 + 6;
        } else if (cpu == 'B' && ending == 'X') {
            endingScore = 1;
        } else if (cpu == 'B' && ending == 'Y'){
            endingScore = 2 + 3;
        } else if (cpu == 'B' && ending == 'Z') {
            endingScore = 3 + 6;
        } else if (cpu == 'C' && ending == 'X') {
            endingScore = 2;
        } else if (cpu == 'C' && ending == 'Y') {
            endingScore = 3 + 3;
        } else if (cpu == 'C' && ending == 'Z') {
            endingScore = 1 + 6;
        } else {
            System.out.println("An error was detected");
        }

        return endingScore;
    }

}
