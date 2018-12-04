package sudoku;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class Controller {
    private Sudoku game;

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
        game = new Sudoku();

        // Initialise all the TextField inputs and set on change listener to update game instance
        for (int i = 0; i < game.size(); i++) {
            for (int j = 0; j < game.size(); j++) {
                final int row = i;
                final int col = j;

                TextField field = new NumberTextField();
                field.setAlignment(Pos.CENTER);
                field.textProperty().addListener((observable, oldValue, newValue) -> {
                    game.insert(newValue.equals("") ? 0 : Integer.valueOf(newValue), row, col);
                });

                grid.add(field, col, row);
            }
        }
        // Clear all the fields. Note that the Sudoku instance will be updated because of the connection above.
        clearButton.setOnAction(x -> {
            grid.getChildren().forEach(child -> {
                if (child instanceof  NumberTextField) ((NumberTextField) child).setText("");
            });
        });

        // Solve the game and update all the TextFields in grid with corresponding values
        solveButton.setOnAction(x -> {
            if (game.solve()) {
                for (int i = 0; i < game.size(); i++) {
                    for (int j = 0; j < game.size(); j++) {
                        int value = game.get(i, j);
                        getTextField(i, j, grid).setText(value != 0 ? String.valueOf(value) : "");
                    }
                }
            }
        });
    }

    private TextField getTextField(final int row, final int column, GridPane gp) {
        for (Node node : gp.getChildren()) {
            if (gp.getRowIndex(node) == row && gp.getColumnIndex(node) == column && node instanceof TextField) {
                return (TextField) node;
            }
        }

        return null;
    }
}
