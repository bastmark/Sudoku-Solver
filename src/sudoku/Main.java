package sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
       Sudoku sud = new Sudoku();
       sud.insert(2, 3, 4);
       sud.insert(3, 4, 5);
       sud.insert(4, 5, 6);
       sud.insert(5, 6, 7);
       sud.insert(6, 7, 8);
       if(sud.solve()) {
    	   System.out.println("lösning finns");
       }else {
    	   System.out.println("lösning saknas");
       }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
