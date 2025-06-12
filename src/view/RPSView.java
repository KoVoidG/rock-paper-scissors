package view;

import controller.RPSController;
import java.awt.*;
import javax.swing.*;
import utils.ImageUtils;

public class RPSView extends JFrame {

    private final JPanel cardPanel;
    private final CardLayout cardLayout;

    private final SetupPanel setupPanel;
    private final GamePanel gamePanel;
    private final EndPanel endPanel;

    public RPSView() {

        setTitle("ROCK-PAPER-SCISSORS GAME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(750, 600));
        setResizable(false);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        setupPanel = new SetupPanel(null);
        gamePanel = new GamePanel(null);
        endPanel = new EndPanel(null);

        cardPanel.add(setupPanel, "Setup");
        cardPanel.add(gamePanel, "Game");
        cardPanel.add(endPanel, "End");

        add(cardPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        ImageUtils.loadImages();

    }

    public void setController(RPSController controller) {
        if (setupPanel != null) {
            setupPanel.setController(controller);
        }
        if (gamePanel != null) {
            gamePanel.setController(controller);
        }
        if (endPanel != null) {
            endPanel.setController(controller);
        }

    }

    public void showSetupPanel() {
        cardLayout.show(cardPanel, "Setup");
        setupPanel.resetFields();
    }

    public void showGamePanel() {
        cardLayout.show(cardPanel, "Game");
    }

    public void showEndPanel() {
        cardLayout.show(cardPanel, "End");
    }

    public void updateGamePanel(String playerName,
            int playerScore,
            int computerScore,
            int ties,
            int currentRound,
            int totalRounds,
            String playerChoice,
            String computerChoice,
            String roundResult) {
        gamePanel.updateInfo(playerName, playerScore, computerScore, ties, currentRound, totalRounds);
        gamePanel.updateChoices(playerChoice, computerChoice);
        gamePanel.updateResult(roundResult);
    }

    public void updateEndPanel(String playerName, int wins, int ties, int losses, int totalRounds) {
        endPanel.updateFinalScore(playerName, wins, ties, losses, totalRounds);
    }

    public void resetGamePanelVisuals() {
        gamePanel.resetGamePanelVisuals();
    }
}
