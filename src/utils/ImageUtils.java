package utils;

import java.awt.*;
import javax.swing.*;

public class ImageUtils {

    private static ImageIcon rockIcon;
    private static ImageIcon paperIcon;
    private static ImageIcon scissorsIcon;
    private static ImageIcon defaultIcon;

    public static void loadImages() {
        try {
            rockIcon = new ImageIcon(ImageUtils.class.getResource("/images/rock.jpg"));
            paperIcon = new ImageIcon(ImageUtils.class.getResource("/images/paper.jpg"));
            scissorsIcon = new ImageIcon(ImageUtils.class.getResource("/images/scissors.jpg"));
            defaultIcon = new ImageIcon(ImageUtils.class.getResource("/images/default.jpg"));

            rockIcon = scaleImage(rockIcon, 150, 150);
            paperIcon = scaleImage(paperIcon, 150, 150);
            scissorsIcon = scaleImage(scissorsIcon, 150, 150);
            defaultIcon = scaleImage(defaultIcon, 150, 150);

        } catch (Exception e) {
            System.err.println("Error loading images: " + e.getMessage());
            System.err.println("Ensure 'rock.jpg', 'paper.jpg', scissors.jpg, and 'default.png' are in 'images' folder accessible by the classpath.");

            rockIcon = null;
            paperIcon = null;
            scissorsIcon = null;
            defaultIcon = null;

        }

    }

    private static ImageIcon scaleImage(ImageIcon icon, int width, int height) {
        if (icon == null || icon.getImage() == null) {
            return null;
        }
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);

    }

    public static ImageIcon getRockIcon() {
        return rockIcon;
    }

    public static ImageIcon getPaperIcon() {
        return paperIcon;
    }

    public static ImageIcon getScissorsIcon() {
        return scissorsIcon;
    }

    public static ImageIcon getDefaultIcon() {
        return defaultIcon;
    }

    public static ImageIcon getIconForChoice(String choice) {
        if (choice == null || choice.isEmpty()) {
            return defaultIcon;
        }
        return switch (choice.toLowerCase()) {
            case "rock" ->
                rockIcon;
            case "paper" ->
                paperIcon;
            case "scissors" ->
                scissorsIcon;
            default ->
                defaultIcon;
        };
    }
}
