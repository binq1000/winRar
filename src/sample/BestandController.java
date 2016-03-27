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
import javafx.stage.Stage;

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
    @FXML public Button buttonBack;

    private Image uitpakkenImage;
    private Image hoverUitpakkenImage;

    private Image weergevenImage;
    private Image hoverWeergevenImage;

    private Image verwijderenImage;
    private Image hoverVerwijderenImage;

    private Image wijzigenImage;
    private Image hoverWijzigenImage;


    public BestandController() {
        //DO NOT USE ANY FXML HERE! in the constructor
        uitpakkenImage = new Image(String.valueOf(getClass().getResource("resource/criminal1.jpg")));
        hoverUitpakkenImage = new Image(String.valueOf(getClass().getResource("resource/criminal2.jpg")));

        weergevenImage = new Image(String.valueOf(getClass().getResource("resource/criminal3.png")));
        hoverWeergevenImage = new Image(String.valueOf(getClass().getResource("resource/criminal4.jpg")));

        verwijderenImage = new Image(String.valueOf(getClass().getResource("resource/criminal2.jpg")));
        hoverVerwijderenImage = new Image(String.valueOf(getClass().getResource("resource/criminal3.png")));

        wijzigenImage = new Image(String.valueOf(getClass().getResource("resource/criminal4.jpg")));
        hoverWijzigenImage = new Image(String.valueOf(getClass().getResource("resource/criminal1.jpg")));
    }

    public void setStartImages() {
        imageUitpakken.setImage(uitpakkenImage);
        imageVerwijderen.setImage(verwijderenImage);
        imageWeergeven.setImage(weergevenImage);
        imageWijzigen.setImage(wijzigenImage);
    }
    
    
    public void onImageUitpakkenClicked(Event event)
    {
        //Uitpakken clicked
        System.out.println("You clicked \"Uitpakken\"");
    }
    public void onImageWeergevenClicked(Event event)
    {
        //Weergeven Clicked
        System.out.println("You clicked \"Weergeven\"");
    }
    public void onImageVerwijderenClicked(Event event)
    {
        //Verwijderen clicked
        System.out.println("You clicked \"Verwijderen\"");
    }
    public void onImageWijzigenClicked(Event event)
    {
        //Wijzigen clicked
        System.out.println("You clicked \"Wijzigen\"");
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

    public void onButtonBackClicked(ActionEvent actionEvent)
    {
        Stage stage = (Stage) buttonBack.getScene().getWindow();
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
