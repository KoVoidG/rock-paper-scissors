package view;

import controller.RPSController;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class SetupPanel extends JPanel {

    private RPSController controller;

    private JTextField nameTextField;
    private JTextField roundsTextField;
    private final JButton startGameButton;

    public SetupPanel(RPSController controller) {

        this.controller = controller;
        setLayout(new GridBagLayout());
        setBackground(new Color(230, 240, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Welcome to Rock Paper Scissors!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 36));
        titleLabel.setForeground(new Color(50, 50, 150));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setFont(new Font("MV Boli", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(nameLabel, gbc);

        nameTextField = new JTextField(20);
        nameTextField.setFont(new Font("MV Boli", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(nameTextField, gbc);

        JLabel roundsLabel = new JLabel("Number of rounds:");
        roundsLabel.setFont(new Font("MV Boli", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(roundsLabel, gbc);

        roundsTextField = new JTextField("3", 5);
        roundsTextField.setFont(new Font("MV Boli", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(roundsTextField, gbc);

        startGameButton = new JButton("Start Game");
        startGameButton.setFont(new Font("MV Boli", Font.BOLD, 24));
        startGameButton.setBackground(new Color(60, 179, 113));
        startGameButton.setForeground(Color.WHITE);
        startGameButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(startGameButton, gbc);

        startGameButton.addActionListener((ActionEvent e) -> {
            String name = nameTextField.getText().trim();
            int rounds = 0;

            if (name.isEmpty()) {
                name = "Player1";
            }

            try {
                rounds = Integer.parseInt(roundsTextField.getText().trim());
                if (rounds <= 0) {
                    JOptionPane.showMessageDialog(SetupPanel.this,
                            "Number of rounds must be a postive integer.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(SetupPanel.this,
                        "Invalid number of rounds. Please enter a whole number.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            if (SetupPanel.this.controller != null) {
                SetupPanel.this.controller.startGame(name, rounds); // Send the data to the Controller
            } else {
                System.err.println("Error: Controller is null in SetupPanel. Cannot start game.");
                JOptionPane.showMessageDialog(SetupPanel.this,
                        "An internal error occurred. Please restart the application.",
                        "Application Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void setController(RPSController controller) {
        this.controller = controller;
        System.out.println("SetupPanel: Controller has been set successfully!");
    }

    public void resetFields() {
        nameTextField.setText("");
        roundsTextField.setText("3");
    }
}
