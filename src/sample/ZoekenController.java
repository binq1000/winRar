package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
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

    public void setData() {


        for (File f : File.listRoots()) {
            System.out.println(f.toString());
            fileStuff(f);
        }
    }

    public void fileStuff(File f) {
        if (f.isDirectory()) {
            f.canRead();
        }
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

    public void ontxtInputComplete(ActionEvent actionEvent)
    {
        System.out.println("Hit this one");
        searchFile(txtInput.getText());
    }

    public void searchFile(String s) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text("You searched for: " + s));
        Scene dialogScene = new Scene(dialogVbox, 200 , 100);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
