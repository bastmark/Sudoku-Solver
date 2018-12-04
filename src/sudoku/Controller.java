package sudoku;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class Controller {
    @FXML
    private GridPane grid;
    @FXML
    private HBox hbox;
    @FXML
    private Button solveButton;
    @FXML
    private Button clearButton;

    public Controller() {
    }

    public void initialize() {
        Sudoku game = new Sudoku();

        for (int i = 0; i < game.size(); i++) {
            for (int j = 0; j < game.size(); j++) {
                final int row = j;
                final int col = i;

                TextField field = new NumberTextField();
                field.setAlignment(Pos.CENTER);
                field.textProperty().addListener((observable, oldValue, newValue) -> {
                    game.insert(newValue.equals("") ? 0 : Integer.valueOf(newValue), row, col);
                });

                grid.add(field, row, col);
            }
        }
    }
}
