import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "./day2/src/input.txt";
        String test = "./day2/src/test.txt";
        int score = 0;
        char cpuChoice;
        char playerChoice;

        try {
            File myFile = new File(fileName);
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                cpuChoice = data.charAt(0);
                playerChoice = data.charAt(2);
                score += compareChoices(cpuChoice, playerChoice);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File could not be found.");

        }
        System.out.println("Player total score is: " + score);

    }

    private static int compareChoices(char cpu, char player) {
        int playerScore = 0;

        if (cpu == 'A' && player == 'X') {
            playerScore = 1 + 3;
        } else if (cpu == 'A' && player == 'Y') {
            playerScore = 2 + 6;
        } else if (cpu == 'A' && player == 'Z') {
            playerScore = 3;
        } else if (cpu == 'B' && player == 'X') {
            playerScore = 1;
        } else if (cpu == 'B' && player == 'Y'){
            playerScore = 2 + 3;
        } else if (cpu == 'B' && player == 'Z') {
            playerScore = 3 + 6;
        } else if (cpu == 'C' && player == 'X') {
            playerScore = 1 + 6;
        } else if (cpu == 'C' && player == 'Y') {
            playerScore = 2;
        } else if (cpu == 'C' && player == 'Z') {
            playerScore = 3 + 3;
        } else {
            System.out.println("An error was detected");
        }

        return playerScore;
    }
}