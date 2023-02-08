package org.example;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    Scanner scan = new Scanner(System.in);
    private int guess;
    private int randomNumber;
    private int numOfGuesses = 1;
    private int totalGames = 1;
    private int totalGuesses;
    private int bestGame;
    private boolean gameRunning = true;

    public int getGuess() {
        return guess;
    }
    public int getRandomNumber() {
        return randomNumber;
    }
    public boolean isGameRunning() {
        return gameRunning;
    }
    public void printGreeting() {
        System.out.println("Guessing Game!");
        System.out.println("This program allows you to play a guessing game.\n" +
                "I will think of a number between 1 and" +
                "100 and will allow you to guess until" +
                "you get it. For each guess, I will tell you" +
                "whether the right answer is higher or lower" +
                "than your guess.");
        System.out.println();
    }

    public void generateRandomNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;
    }
    public void resetGame() {
        generateRandomNumber();
        numOfGuesses = 1;
        totalGames++;
    }

    public void startGame() {
        generateRandomNumber();
        System.out.print("I'm thinking of a number between 1 and 100...\nYour guess? ");
        guess = scan.nextInt();
    }

    public int handleGuess(int guess) {
        numOfGuesses++;
        if (guess > randomNumber) {
            System.out.print("It's lower.\nYour guess? ");
        } else {
            System.out.print("It's higher.\nYour guess? ");
        }
        return scan.nextInt();
    }

    public void handleGameOver() {
        if (bestGame == 0) {
            bestGame = numOfGuesses;
        } else if (numOfGuesses < bestGame) {
            bestGame = numOfGuesses;
        }
        totalGuesses += numOfGuesses;
        System.out.printf("You got it right in %s guesses!\nDo you want to play again? ", numOfGuesses);
        if (Character.toString(scan.next().charAt(0)).equalsIgnoreCase("n")) {
            gameRunning = false;
            printResults();
        } else {
            resetGame();
        }
    }

    private void printResults() {
        double guessesPerGame = totalGuesses / totalGames;
        System.out.printf("\nOverall results:\n" +
                "\ttotal games\t\t= %s\n" +
                "\ttotal guesses\t= %s\n" +
                "\tguesses/game\t= %s\n" +
                "\tbest game\t\t= %s\n", totalGames, totalGuesses, guessesPerGame, bestGame);
    }
}
