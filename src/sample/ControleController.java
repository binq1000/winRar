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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * Created by Nekkyou on 27-3-2016.
 */
public class ControleController
{
    @FXML public ImageView imageVirus;
    @FXML public ImageView imageRapport;
    @FXML public ImageView imageTesten;
    @FXML public ImageView imageLogboek;
    @FXML public ImageView imageBack;
    @FXML public AnchorPane anchorPane;

    private Image virusImage;
    private Image hoverVirusImage;
    private Image rapportImage;
    private Image hoverRapportImage;
    private Image testenImage;
    private Image hoverTestenImage;
    private Image logboekImage;
    private Image hoverLogboekImage;
    private Image backImage;
    private Color color;

    private FileChooser fileChooser;

    public ControleController() {
        //Do not use any FXML here

        virusImage = new Image(String.valueOf(getClass().getResource("resource/virusNormaal.png")));
        hoverVirusImage = new Image(String.valueOf(getClass().getResource("resource/virusHighlight.png")));

        rapportImage = new Image(String.valueOf(getClass().getResource("resource/rapportNormaal.png")));
        hoverRapportImage = new Image(String.valueOf(getClass().getResource("resource/rapportHighlight.png")));

        testenImage = new Image(String.valueOf(getClass().getResource("resource/testenNormaal.png")));
        hoverTestenImage = new Image(String.valueOf(getClass().getResource("resource/testenHighlight.png")));

        logboekImage = new Image(String.valueOf(getClass().getResource("resource/logboekNormaal.png")));
        hoverLogboekImage = new Image(String.valueOf(getClass().getResource("resource/logboekHighlight.png")));

        backImage = new Image(String.valueOf(getClass().getResource("resource/arrowBack.png")));

        color = javafx.scene.paint.Color.rgb(101, 109, 208);
        setFilteredExplorer();
    }

    public void onImageVirusClicked(Event event)
    {

        System.out.println("You clicked \"Virus Controlle\"");
        File f = getFile();
        createDialog("You just scanned" + System.lineSeparator() + f.getName() + " for virusses");
    }

    public void createDialog(String s) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text(s));
        Scene dialogScene = new Scene(dialogVbox, 200 , 100);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public void onImageRapportClicked(Event event)
    {
        System.out.println("You clicked \"Rapport genereren\"");
        createDialog("Look at this awesome Rapport \n ow wait where did it go?");
    }

    private void setFilteredExplorer() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open winrar file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Zip and RAR", "*.zip", "*.rar"));
    }

    public File getFile() {
        File f = null;
        while (f == null) {
            f = fileChooser.showOpenDialog(anchorPane.getScene().getWindow());
        }
        return f;
    }

    public void onImageTestenClicked(Event event)
    {
        System.out.println("You clicked \"Testen\"");
        File f = getFile();
        createDialog("You tested: " + f.getName());
    }

    public void onImageLogboekClicked(Event event)
    {
        System.out.println("You clicked \"Logboek weergeven\"");
        createDialog("Showing an invisible log at the moment!");
    }

    public void onButtonBackClicked()
    {
        Stage stage = (Stage) imageBack.getScene().getWindow();
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

        stage.setScene(new Scene(root, 640, 480, color));

        controller.setStartImages();
    }

    //region Image setting
    public void setStartImages() {
        imageLogboek.setImage(logboekImage);
        imageRapport.setImage(rapportImage);
        imageTesten.setImage(testenImage);
        imageVirus.setImage(virusImage);
        imageBack.setImage(backImage);
    }

    public void onImageVirusMouseEntered(Event event)
    {
        imageVirus.setImage(hoverVirusImage);
    }

    public void onImageVirusMouseExited(Event event)
    {
        imageVirus.setImage(virusImage);
    }

    public void onImageRapportMouseEntered(Event event)
    {
        imageRapport.setImage(hoverRapportImage);
    }

    public void onImageRapportMouseExited(Event event)
    {
        imageRapport.setImage(rapportImage);
    }

    public void onImageTestenMouseEntered(Event event)
    {
        imageTesten.setImage(hoverTestenImage);
    }

    public void onImageLogobkeMouseExited(Event event)
    {
        imageLogboek.setImage(logboekImage);
    }

    public void onImageTestenMouseExited(Event event)
    {
        imageTesten.setImage(testenImage);
    }

    public void onImageLogboekMouseEntered(Event event)
    {
        imageLogboek.setImage(hoverLogboekImage);
    }
    //endregion
}
