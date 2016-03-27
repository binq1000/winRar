package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Controller {

    @FXML
    public ImageView imageZoek;

    @FXML
    public ImageView imageBestand;

    @FXML
    public ImageView imageControle;

    private Image bestandImage;
    private Image hoverBestandImage;

    private Image controleImage;
    private Image hoverControleImage;

    private Image zoekImage;
    private Image hoverZoekImage;

    public Controller() {
        bestandImage = new Image(String.valueOf(getClass().getResource("resource/criminal1.jpg")));
        hoverBestandImage = new Image(String.valueOf(getClass().getResource("resource/criminal2.jpg")));

        controleImage = new Image(String.valueOf(getClass().getResource("resource/criminal3.png")));
        hoverControleImage = new Image(String.valueOf(getClass().getResource("resource/criminal4.jpg")));

        zoekImage = new Image(String.valueOf(getClass().getResource("resource/criminal2.jpg")));
        hoverZoekImage = new Image(String.valueOf(getClass().getResource("resource/criminal3.png")));
    }


    public void setStartImages() {
        imageBestand.setImage(bestandImage);
        imageControle.setImage(controleImage);
        imageZoek.setImage(zoekImage);
//        imageControle.setImage(new Image("file:/E:/School/JCF41/winRar/out/production/winRar/sample/resource/criminal2.jpg"));
    }

    public void onInputZoekMouseClicked(Event event)
    {
        //Zoeken clicked
        System.out.println("You clicked \"Zoeken\"");
    }

    public void onImageBestandMouseClicked(Event event)
    {
        System.out.println("You clicked \"Bestand\"");
        Stage stage = (Stage) imageBestand.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("bestand.fxml"));
        BestandController bController = new BestandController();
        loader.setController(bController);

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

        bController.setStartImages();
    }

    public void onImageControleMouseClicked(Event event)
    {
        //Controle clicked
        System.out.println("You clicked \"Controle\"");
    }

    //region image setting
    public void onImageBestandMouseEntered(Event event)
    {
        //Change picture of imageBestand to hover one
        imageBestand.setImage(hoverBestandImage);
    }

    public void onImageControleMouseEntered(Event event)
    {
        //Change picture of imageControle to hover one
        imageControle.setImage(hoverControleImage);
    }

    public void onImageBestandMouseExited(Event event)
    {
        //Change picture of imageBestand to normal one
        imageBestand.setImage(bestandImage);
    }

    public void onImageControleMouseExited(Event event)
    {
        //Change picture of imageControle to normal one
        imageControle.setImage(controleImage);
    }

    public void onImageZoekMouseEntered(Event event)
    {
        imageZoek.setImage(hoverZoekImage);
    }

    public void onImageZoekMouseExited(Event event)
    {
        imageZoek.setImage(zoekImage);
    }
    //endregion


}
