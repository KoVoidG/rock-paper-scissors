
import controller.RPSController;
import javax.swing.*;
import model.RPSGameModel;
import view.RPSView;

public class App {

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(() -> {
            RPSGameModel model = new RPSGameModel();
            RPSView view = new RPSView();
            RPSController controller = new RPSController(model, view);

            view.setController(controller);
        });
    }
}
