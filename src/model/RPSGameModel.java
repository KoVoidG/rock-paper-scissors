package model;

import java.util.Random;

public final class RPSGameModel {

    private String playerName;
    private int totalRounds;
    private int currentRound;
    private int playerScore;
    private int computerScore;
    private int ties;
    private String playerChoice;
    private String computerChoice;
    private String roundResult;
    private boolean gameEnded;

    private final Random random = new Random();
    private final String[] choices = {"rock", "paper", "scissors"};

    public RPSGameModel() {
        resetGame();
    }

    public void resetGame() {
        this.playerName = "Player";
        this.totalRounds = 0;
        this.currentRound = 0;
        this.playerScore = 0;
        this.computerScore = 0;
        this.ties = 0;
        this.playerChoice = "";
        this.computerChoice = "";
        this.roundResult = "";
        this.gameEnded = false;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setTotalRounds(int totalRounds) {
        this.totalRounds = totalRounds;
    }

    public void playRound(String playerChoice) {
        if (gameEnded) {
            return;
        }

        this.playerChoice = playerChoice.toLowerCase();
        this.computerChoice = choices[random.nextInt(choices.length)];
        this.currentRound++;

        if (this.playerChoice.equals(this.computerChoice)) {
            roundResult = "tie";
            ties++;
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors"))
                || (playerChoice.equals("paper") && computerChoice.equals("rock"))
                || (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            roundResult = "win";
            playerScore++;
        } else {
            roundResult = "lose";
            computerScore++;
        }

        if (currentRound >= totalRounds) {
            gameEnded = true;
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getTies() {
        return ties;
    }

    public String getPlayerChoice() {
        return playerChoice;
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    public String getRoundResult() {
        return roundResult;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public int getLosses() {
        return totalRounds - playerScore - ties;
    }

}
