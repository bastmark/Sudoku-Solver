package sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class containing main method for starting application.
 *
 * @author Johannes Bastmark
 * @author Szymon Stypa
 * @author Axel Domell
 *
 * @version 1.0
 * @see <a href="https://github.com/bastmark/Sudoku-solver">Github repository</a>
 */
public class Main extends Application {

    /**
     * Starts a JavaFX application and loads the controller from sudoku.fxml.
     * @param primaryStage primaryStage
     * @throws Exception exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sudoku.fxml"));
        primaryStage.setTitle("Sudoku Solver");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    /**
     * Main method.
     * @param args main
     */
    public static void main(String[] args) {
        launch(args);
    }
}
