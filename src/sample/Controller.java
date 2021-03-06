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
import javafx.scene.paint.*;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Color;
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

    private int screenHeight;
    private int screenWidth;

    private Image icon;

    private javafx.scene.paint.Color color;

    public Controller() {
        bestandImage = new Image(String.valueOf(getClass().getResource("resource/bestandNormaal.png")));
        hoverBestandImage = new Image(String.valueOf(getClass().getResource("resource/bestandHighlight.png")));

        controleImage = new Image(String.valueOf(getClass().getResource("resource/controleNormaal.png")));
        hoverControleImage = new Image(String.valueOf(getClass().getResource("resource/controleHighlight.png")));

        zoekImage = new Image(String.valueOf(getClass().getResource("resource/zoekenNormaal.png")));
        hoverZoekImage = new Image(String.valueOf(getClass().getResource("resource/zoekenHighlight.png")));

        icon = new Image(String.valueOf(getClass().getResource("resource/winrarIcon.png")));

        color = javafx.scene.paint.Color.rgb(101, 109, 208);

        screenWidth = 640;
        screenHeight = 480;
    }


    public void setStartImages() {
        imageBestand.setImage(bestandImage);
        imageControle.setImage(controleImage);
        imageZoek.setImage(zoekImage);


    }

    public void onInputZoekMouseClicked(Event event)
    {
        //Zoeken clicked
        System.out.println("You clicked \"Zoeken\"");
        Stage stage = (Stage) imageBestand.getScene().getWindow();
        stage.setTitle("WinRAR - Zoeken");


        stage.getIcons().add(icon);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("zoeken.fxml"));
        ZoekenController zController = new ZoekenController();
        loader.setController(zController);

        Parent root = null;
        try
        {
            root = loader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root, screenWidth, screenHeight, javafx.scene.paint.Color.rgb(101, 109, 208)));

        zController.setData();
    }

    public void onImageBestandMouseClicked(Event event)
    {
        System.out.println("You clicked \"Bestand\"");
        Stage stage = (Stage) imageBestand.getScene().getWindow();
        stage.setTitle("WinRAR - Bestand");

        stage.getIcons().add(icon);

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

        stage.setScene(new Scene(root, screenWidth, screenHeight, javafx.scene.paint.Color.rgb(101, 109, 208)));

        bController.setStartImages();
    }

    public void onImageControleMouseClicked(Event event)
    {
        //Controle clicked
        System.out.println("You clicked \"Controle\"");
        Stage stage = (Stage) imageBestand.getScene().getWindow();
        stage.setTitle("WinRAR - Controle");

        stage.getIcons().add(icon);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("controle.fxml"));
        ControleController cController = new ControleController();
        loader.setController(cController);

        Parent root = null;
        try
        {
            root = loader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root, screenWidth, 240, javafx.scene.paint.Color.rgb(101, 109, 208)));

        cController.setStartImages();
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
