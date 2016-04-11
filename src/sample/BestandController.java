package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * Created by Nekkyou on 27-3-2016.
 */
public class BestandController
{

    @FXML public ImageView imageUitpakken;
    @FXML public ImageView imageWeergeven;
    @FXML public ImageView imageVerwijderen;
    @FXML public ImageView imageWijzigen;
    @FXML public ImageView imageBack;
    @FXML public AnchorPane anchorPane;

    private FileChooser fileChooser;

    private Image uitpakkenImage;
    private Image hoverUitpakkenImage;

    private Image weergevenImage;
    private Image hoverWeergevenImage;

    private Image verwijderenImage;
    private Image hoverVerwijderenImage;

    private Image wijzigenImage;
    private Image hoverWijzigenImage;

    private Image backImage;


    public BestandController() {
        //DO NOT USE ANY FXML HERE! in the constructor
        uitpakkenImage = new Image(String.valueOf(getClass().getResource("resource/uitpakkenNormaal.png")));
        hoverUitpakkenImage = new Image(String.valueOf(getClass().getResource("resource/uitpakkenHighlight.png")));

        weergevenImage = new Image(String.valueOf(getClass().getResource("resource/weergevenNormaal.png")));
        hoverWeergevenImage = new Image(String.valueOf(getClass().getResource("resource/weergevenHighlight.png")));

        verwijderenImage = new Image(String.valueOf(getClass().getResource("resource/verwijderenNormaal.png")));
        hoverVerwijderenImage = new Image(String.valueOf(getClass().getResource("resource/verwijderenHighlight.png")));

        wijzigenImage = new Image(String.valueOf(getClass().getResource("resource/wijzigenNormaal.png")));
        hoverWijzigenImage = new Image(String.valueOf(getClass().getResource("resource/wijzigenHighlight.png")));

        backImage = new Image(String.valueOf(getClass().getResource("resource/arrowBack.png")));

        setFilteredExplorer();
    }

    public void setStartImages() {
        imageUitpakken.setImage(uitpakkenImage);
        imageVerwijderen.setImage(verwijderenImage);
        imageWeergeven.setImage(weergevenImage);
        imageWijzigen.setImage(wijzigenImage);
        imageBack.setImage(backImage);

    }
    
    
    public void onImageUitpakkenClicked(Event event)
    {
        //Uitpakken clicked
        System.out.println("You clicked \"Uitpakken\"");
        openExplorer();
    }
    public void onImageWeergevenClicked(Event event)
    {
        //Weergeven Clicked
        System.out.println("You clicked \"Weergeven\"");
        openExplorer();
    }
    public void onImageVerwijderenClicked(Event event)
    {
        //Verwijderen clicked
        System.out.println("You clicked \"Verwijderen\"");
        openExplorer();
    }
    public void onImageWijzigenClicked(Event event)
    {
        //Wijzigen clicked
        System.out.println("You clicked \"Wijzigen\"");
        openExplorer();
    }

    private void openExplorer() {
        fileChooser.showOpenDialog(anchorPane.getScene().getWindow());
    }

    private void setFilteredExplorer() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open winrar file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Zip and RAR", "*.zip", "*.rar"));
    }

    //region Image setting
    public void onImageUitpakkenMouseEntered(Event event)
    {
        imageUitpakken.setImage(hoverUitpakkenImage);
    }

    public void onImageUitpakkenMouseExited(Event event)
    {
        imageUitpakken.setImage(uitpakkenImage);
    }
    

    

    public void onImageWeergevenMouseEntered(Event event)
    {
        imageWeergeven.setImage(hoverWeergevenImage);
    }

    public void onImageWeergevenMouseExited(Event event)
    {
        imageWeergeven.setImage(weergevenImage);
    }



    public void onImageVerwijderenMouseEntered(Event event)
    {
        imageVerwijderen.setImage(hoverVerwijderenImage);
    }

    public void onImageVerwijderenMouseExited(Event event)
    {
        imageVerwijderen.setImage(verwijderenImage);
    }



    public void onImageWijzigenMouseEntered(Event event)
    {
        imageWijzigen.setImage(hoverWijzigenImage);
    }

    public void onImageWijizigenMouseExited(Event event)
    {
        imageWijzigen.setImage(wijzigenImage);
    }
    //endregion

    public void onButtonBackClicked()
    {
        Stage stage = (Stage) imageBack.getScene().getWindow();
        stage.setTitle("WinRAR");

        FXMLLoader        loader      = new FXMLLoader(getClass().getResource("hoofdscherm.fxml"));
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
