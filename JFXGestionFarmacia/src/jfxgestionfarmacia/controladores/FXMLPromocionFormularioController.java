package jfxgestionfarmacia.controladores;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class FXMLPromocionFormularioController implements Initializable {

    @FXML
    private TextField tfNombrePromo;
    @FXML
    private DatePicker dpInicio;
    @FXML
    private DatePicker dpFin;
    @FXML
    private ComboBox<?> cbProducto;
    @FXML
    private TextArea tfDescripcion;
    @FXML
    private ImageView ivPromocion;
    @FXML
    private Label lbImagen;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void visualizarImagen(File imgSeleccionada){
        if(imgSeleccionada != null){
            try {
                BufferedImage bufferImg = ImageIO.read(imgSeleccionada);
                Image imagenDecodificada =SwingFXUtils.toFXImage(bufferImg, null);
                ivPromocion.setImage(imagenDecodificada);
            } catch (IOException ex) {
                lbImagen.setText("Error al visualizar la imagen seleccionada...");
            }
        }
    }
    
    @FXML
    private void clicBtnSeleccionFoto(ActionEvent event) {
        FileChooser dialogoSeleccionImg = new FileChooser();
        dialogoSeleccionImg.setTitle("Selecciona una imagen");
        FileChooser.ExtensionFilter filtroDialogo = new FileChooser.ExtensionFilter("Archivos PNG (*.png)", "*.PNG");
        dialogoSeleccionImg.getExtensionFilters().add(filtroDialogo);
        Stage escenarioBase = (Stage) lbImagen.getScene().getWindow();
        File archivoSeleccionado = dialogoSeleccionImg.showOpenDialog(escenarioBase);
        visualizarImagen(archivoSeleccionado);
    }

    @FXML
    private void clicBtnRegistrar(ActionEvent event) {
    }

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cancelar registro");
            alert.setHeaderText("¿Desea cancelar el registro de la Promoción?");
            
            ButtonType btnSi = new ButtonType("Sí");
            ButtonType btnNo = new ButtonType("No");
            alert.getButtonTypes().setAll(btnSi, btnNo);
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == btnSi) {
                Stage escearioPrincipal = (Stage) dpFin.getScene().getWindow();
                escearioPrincipal.close();
            }
    }
    
}
