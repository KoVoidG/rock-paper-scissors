package view;

import controller.RPSController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import utils.ImageUtils;

public class GamePanel extends JPanel {

    private RPSController controller;

    private final JLabel gameInfoLabel;
    private final JLabel playerChoiceLabel;
    private final JLabel computerChoiceLabel;
    private final JLabel resultLabel;
    private final JLabel playerImageLabel;
    private final JLabel computerImageLabel;
    private final JButton rockButton, paperButton, scissorsButton;

    public GamePanel(RPSController controller) {
        this.controller = controller;
        setLayout(new BorderLayout(20, 20));
        setBackground(new Color(255, 255, 220));

        // top panel - score, round
        JPanel topInfoPanel = new JPanel(new GridLayout(1, 1));
        topInfoPanel.setBackground(new Color(240, 240, 190));
        topInfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gameInfoLabel = new JLabel("Player: N/A Score: 0 - 0 Round: 0/0", SwingConstants.CENTER);
        gameInfoLabel.setFont(new Font("MV Boli", Font.BOLD, 22));
        topInfoPanel.add(gameInfoLabel);
        add(topInfoPanel, BorderLayout.NORTH);

        // center panel - choices, images, results
        JPanel centerGameContentPanel = new JPanel(new GridBagLayout());
        centerGameContentPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Player's choice image and text
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        playerImageLabel = new JLabel(ImageUtils.getDefaultIcon());
        centerGameContentPanel.add(playerImageLabel, gbc);

        gbc.gridy = 1;
        playerChoiceLabel = new JLabel();
        playerChoiceLabel.setFont(new Font("MV Boli", Font.BOLD, 18));
        centerGameContentPanel.add(playerChoiceLabel, gbc);

        // VS Label
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        JLabel vsLabel = new JLabel("VS");
        vsLabel.setFont(new Font("Arial", Font.BOLD, 48));
        centerGameContentPanel.add(vsLabel, gbc);

        // Computer's Choice Image and Text
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        computerImageLabel = new JLabel(ImageUtils.getDefaultIcon());
        centerGameContentPanel.add(computerImageLabel, gbc);

        gbc.gridy = 1;
        computerChoiceLabel = new JLabel();
        computerChoiceLabel.setFont(new Font("MV Boli", Font.BOLD, 18));
        centerGameContentPanel.add(computerChoiceLabel, gbc);

        // Result Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        resultLabel = new JLabel();
        resultLabel.setFont(new Font("MV Boli", Font.BOLD, 36));
        resultLabel.setForeground(Color.BLUE);
        centerGameContentPanel.add(resultLabel, gbc);

        add(centerGameContentPanel, BorderLayout.CENTER);

        // Bottom Panel - Player action buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        buttonPanel.setOpaque(false);

        Font buttonFont = new Font("MV Boli", Font.BOLD, 20);
        Color buttonBgColor = new Color(150, 200, 255);
        Color buttonFgColor = Color.black;

        rockButton = new JButton("Rock", ImageUtils.getRockIcon());
        paperButton = new JButton("Paper", ImageUtils.getPaperIcon());
        scissorsButton = new JButton("Scissors", ImageUtils.getScissorsIcon());

        JButton[] choiceButtons = {rockButton, paperButton, scissorsButton};
        for (JButton button : choiceButtons) {
            button.setFont(buttonFont);
            button.setBackground(buttonBgColor);
            button.setForeground(buttonFgColor);
            button.setFocusPainted(false);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.addActionListener(new ChoiceButtonListener()); // Use a single listener
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private class ChoiceButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String playerChoice = ((JButton) e.getSource()).getText().toLowerCase();
            controller.playerMadeChoice(playerChoice);
        }
    }

    public void setController(RPSController controller) {
        this.controller = controller;
    }

    public void updateInfo(String playerName,
            int playerScore,
            int computerScore,
            int ties,
            int currentRound,
            int totalRounds) {
        gameInfoLabel.setText(String.format("%s: %d | Computer: %d | Ties: %d | Round: %d/%d",
                playerName,
                playerScore,
                computerScore,
                ties,
                currentRound,
                totalRounds));
    }

    public void updateChoices(String playerChoice, String computerChoice) {
        playerChoiceLabel.setText("You chose: " + playerChoice);
        computerChoiceLabel.setText("Computer chose: " + computerChoice);

        playerImageLabel.setIcon(ImageUtils.getIconForChoice(playerChoice));
        computerImageLabel.setIcon(ImageUtils.getIconForChoice(computerChoice));
    }

    public void updateResult(String roundResult) {

        String resultText;
        Color resultColor;

        switch (roundResult) {
            case "win" -> {
                resultText = "YOU WIN!";
                resultColor = new Color(0, 150, 0);
            }

            case "lose" -> {
                resultText = "YOU LOSE!";
                resultColor = Color.red;
            }

            case "tie" -> {
                resultText = "IT'S A TIE!";
                resultColor = Color.orange;
            }

            default -> {
                resultColor = Color.blue;
                resultText = "";
            }
        }
        resultLabel.setText(resultText);
        resultLabel.setForeground(resultColor);

    }

    public void resetGamePanelVisuals() {
        playerImageLabel.setIcon(ImageUtils.getDefaultIcon());
        computerImageLabel.setIcon(ImageUtils.getDefaultIcon());
        playerChoiceLabel.setText("Your Choice");
        computerChoiceLabel.setText("Computer Choice");
        resultLabel.setText("Make your move!");
        resultLabel.setForeground(Color.BLUE);
    }
}
