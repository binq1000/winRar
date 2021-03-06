package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller c;

    @Override
    public void start(Stage primaryStage) throws Exception{

        c = new Controller();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hoofdscherm.fxml"));
        loader.setController(c);

        Parent root = loader.load();
        primaryStage.setTitle("WinRAR");
        primaryStage.setScene(new Scene(root, 640, 480, Color.rgb(101, 109, 208)));
        primaryStage.show();

        c.setStartImages();

        Image icon = new Image(String.valueOf(getClass().getResource("resource/winrarIcon.png")));
        primaryStage.getIcons().add(icon);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
