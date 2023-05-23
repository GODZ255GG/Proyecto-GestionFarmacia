package jfxgestionfarmacia.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import jfxgestionfarmacia.utils.Utilidades;

public class FXMLPromocionesController implements Initializable {

    @FXML
    private TableView<?> tvPromociones;
    @FXML
    private TableColumn colNombrePromo;
    @FXML
    private TableColumn colNombreProdu;
    @FXML
    private TableColumn colFechaIni;
    @FXML
    private TableColumn colFechaFin;
    @FXML
    private TableColumn colDescripcion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicCerrarVentana(MouseEvent event) {
        Stage escearioPrincipal = (Stage) tvPromociones.getScene().getWindow();
        escearioPrincipal.close();
    }

    @FXML
    private void clicBtnRegistrar(ActionEvent event) {
        Stage escenarioFormularioPromo = new Stage();
        escenarioFormularioPromo.setScene(Utilidades.inicializarEscena("vistas/FXMLPromocionFormulario.fxml"));
        escenarioFormularioPromo.setTitle("Formulario de Promociones");
        escenarioFormularioPromo.initModality(Modality.APPLICATION_MODAL);
        escenarioFormularioPromo.showAndWait();
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        escenarioFormularioPromo.setX((screenBounds.getWidth() - escenarioFormularioPromo.getWidth()) / 2);
        escenarioFormularioPromo.setY((screenBounds.getHeight() - escenarioFormularioPromo.getHeight()) / 2);
    }

    @FXML
    private void clicBtnModificar(ActionEvent event) {
    }

    @FXML
    private void clicBtnBaja(ActionEvent event) {
    }

    @FXML
    private void clicBtnConsultar(ActionEvent event) {
        Stage escenarioDetallesPromo = new Stage();
        escenarioDetallesPromo.setScene(Utilidades.inicializarEscena("vistas/FXMLDetallesPromocion.fxml"));
        escenarioDetallesPromo.setTitle("Detalles de las Promociones");
        escenarioDetallesPromo.initModality(Modality.APPLICATION_MODAL);
        escenarioDetallesPromo.showAndWait();
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        escenarioDetallesPromo.setX((screenBounds.getWidth() - escenarioDetallesPromo.getWidth()) / 2);
        escenarioDetallesPromo.setY((screenBounds.getHeight() - escenarioDetallesPromo.getHeight()) / 2);
    }
    
}