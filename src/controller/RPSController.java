package controller;

import javax.swing.SwingUtilities;
import model.RPSGameModel;
import view.RPSView;

public class RPSController {

    private final RPSGameModel model;
    private final RPSView view;

    public RPSController(RPSGameModel model, RPSView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame(String playerName, int totalRounds) {
        model.resetGame();
        model.setPlayerName(playerName);
        model.setTotalRounds(totalRounds);

        view.resetGamePanelVisuals();
        view.showGamePanel();
    }

    public void playerMadeChoice(String playerChoice) {
        model.playRound(playerChoice);

        updategameView();

        if (model.isGameEnded()) {
            SwingUtilities.invokeLater(() -> {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                view.updateEndPanel(model.getPlayerName(),
                        model.getPlayerScore(),
                        model.getTies(),
                        model.getLosses(),
                        model.getTotalRounds());

                view.showEndPanel();
            });
        }
    }

    public void playAgain() {
        model.resetGame();
        view.showSetupPanel();
    }

    public void exitGame() {
        System.exit(0);
    }

    public void updategameView() {
        view.updateGamePanel(
                model.getPlayerName(),
                model.getPlayerScore(),
                model.getComputerScore(),
                model.getTies(),
                model.getCurrentRound(),
                model.getTotalRounds(),
                model.getPlayerChoice(),
                model.getComputerChoice(),
                model.getRoundResult());
    }
}
