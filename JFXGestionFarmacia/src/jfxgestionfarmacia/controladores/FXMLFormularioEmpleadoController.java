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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import jfxgestionfarmacia.modelo.pojo.Empleado;

public class FXMLFormularioEmpleadoController implements Initializable {

    @FXML
    private ImageView ivImagenEmpleado;
    @FXML
    private Label lbTitulo;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidoPaterno;
    @FXML
    private TextField tfApellidoMaterno;
    @FXML
    private TextField tfCorreoElectronico;
    @FXML
    private ComboBox<Empleado> cbTipoEmpleado;
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfPassword;
    @FXML
    private ComboBox<?> cbSede;
    
    private File archivoFoto;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void clicSeleccionarImagen(ActionEvent event) {
        FileChooser dialogoSeleccionImg = new FileChooser();
        dialogoSeleccionImg.setTitle("Selecciona una imagen");
        FileChooser.ExtensionFilter filtroDialogo = new FileChooser.ExtensionFilter("Archivos PNG (*.png)", "*.PNG","Archivo JPG (*.jpg)","*.JPG");
        dialogoSeleccionImg.getExtensionFilters().add(filtroDialogo);
        Stage escenarioBase = (Stage) lbTitulo.getScene().getWindow();
        archivoFoto =  dialogoSeleccionImg.showOpenDialog(escenarioBase);
        
        if(archivoFoto != null){
            try{
                BufferedImage bufferImg = ImageIO.read(archivoFoto);
                Image imagenFoto = SwingFXUtils.toFXImage(bufferImg, null);
                ivImagenEmpleado.setImage(imagenFoto);
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }
    }

    @FXML
    private void clicBtnRegistrarEmpleado(ActionEvent event) {
    }

    @FXML
    private void clicBtnCancelarRegistro(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Cancelar registro");
            alert.setHeaderText("¿Desea cancelar el registro del Empleado?");
            
            ButtonType btnSi = new ButtonType("Sí");
            ButtonType btnNo = new ButtonType("No");
            alert.getButtonTypes().setAll(btnSi, btnNo);
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == btnSi) {
                Stage escearioPrincipal = (Stage) tfNombre.getScene().getWindow();
                escearioPrincipal.close();
            }
    }
    
}
