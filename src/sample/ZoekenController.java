package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Nekkyou on 27-3-2016.
 */
public class ZoekenController
{

    @FXML private Button buttonBack;
    @FXML private TextField txtInput;
    @FXML private TableView tableData;

    public ZoekenController() {
        //Do not use FXML in the constructor
    }
    
    public void onButtonBackClicked(ActionEvent actionEvent)
    {
        Stage stage = (Stage) buttonBack.getScene().getWindow();
        stage.setTitle("WinRAR");

        FXMLLoader loader     = new FXMLLoader(getClass().getResource("hoofdscherm.fxml"));
        Controller controller = new Controller();
        loader.setController(controller);

        Parent root = null;
        try
        {
            root = loader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root, 640, 480));

        controller.setStartImages();
    }
}
