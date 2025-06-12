package view;

import controller.RPSController;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class EndPanel extends JPanel {

    private RPSController controller;

    private final JLabel thankYouLabel;
    private final JLabel finalScoreLabel;
    private final JButton playAgainButton;
    private final JButton exitButton;

    public EndPanel(RPSController controller) {

        this.controller = controller;
        setLayout(new GridBagLayout());
        setBackground(new Color(220, 225, 220));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 15, 0);
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        // thank you message
        thankYouLabel = new JLabel("Thanks for playing!", SwingConstants.CENTER);
        thankYouLabel.setFont(new Font("MV Boli", Font.BOLD, 36));
        thankYouLabel.setForeground(new Color(0, 100, 0));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(thankYouLabel, gbc);

        // final score display
        finalScoreLabel = new JLabel("Final Score: Calculating...", SwingConstants.CENTER);
        finalScoreLabel.setFont(new Font("MV Boli", Font.PLAIN, 28));
        finalScoreLabel.setForeground(Color.DARK_GRAY);
        gbc.gridy = 1;
        add(finalScoreLabel, gbc);

        // button playagain
        playAgainButton = new JButton("Play Again");
        playAgainButton.setFont(new Font("MV Boli", Font.BOLD, 22));
        playAgainButton.setBackground(new Color(150, 200, 255));
        playAgainButton.setForeground(Color.BLACK);
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(playAgainButton, gbc);

        // button exit
        exitButton = new JButton("Exit Game");
        exitButton.setFont(new Font("MV Boli", Font.BOLD, 22));
        exitButton.setBackground(new Color(255, 150, 150));
        exitButton.setForeground(Color.BLACK);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(exitButton, gbc);

        playAgainButton.addActionListener((ActionEvent e) -> {
            if (EndPanel.this.controller != null) {
                EndPanel.this.controller.playAgain();

            } else {
                System.err.println("Error: Controller is null in EndPanel (Play Again).");
            }
        });

        exitButton.addActionListener((ActionEvent e) -> {
            if (EndPanel.this.controller != null) {
                EndPanel.this.controller.exitGame();

            } else {
                System.err.println("Error: Controller is null in EndPanel (Exit).");
            }
        });

    }

    public void setController(RPSController controller) {
        this.controller = controller;
    }

    public void updateFinalScore(String playerName,
            int wins,
            int ties,
            int losses,
            int totalRounds) {
        thankYouLabel.setText("Thanks for playing, " + playerName + "!");
        finalScoreLabel.setText(String.format("You won %d, tied %d, and lost %d out of %d rounds",
                wins, ties, losses, totalRounds));

    }

}
