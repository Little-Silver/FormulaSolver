import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent mainRoot = FXMLLoader.load(getClass().getResource("/resources/Home.fxml"));

        //Scene - Panel
        Scene scene = new Scene(mainRoot, 300, 275);
        scene.getStylesheets().add("/resources/DefaultStyles.css");

        //Stage - Window
        primaryStage.setTitle("Formula Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
