package org.example;

public class Main {
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();

        game.printGreeting();

        while (game.isGameRunning()) {
            game.generateRandomNumber();
            game.startGame();
            int guess = game.getGuess();
            int randomNumber = game.getRandomNumber();

            while (guess != randomNumber) {
                guess = game.handleGuess(guess);
            }
            game.handleGameOver();

        }
    }


}