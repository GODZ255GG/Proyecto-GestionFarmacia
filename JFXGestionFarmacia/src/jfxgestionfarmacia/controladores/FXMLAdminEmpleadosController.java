package jfxgestionfarmacia.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxgestionfarmacia.modelo.DAO.EmpleadoDAO;
import jfxgestionfarmacia.modelo.pojo.Empleado;
import jfxgestionfarmacia.utils.Constantes;
import jfxgestionfarmacia.utils.Utilidades;

public class FXMLAdminEmpleadosController implements Initializable {

    @FXML
    private TextField tfBuscar;
    @FXML
    private TableColumn tcNombre;
    @FXML
    private TableColumn tcApellidoPaterno;
    @FXML
    private TableColumn tcApellidoMaterno;
    @FXML
    private TableColumn tcCorreoElectronico;
    @FXML
    private TableColumn tcUsername;
    @FXML
    private TableColumn tcPassword;
    @FXML
    private TableColumn tcTipoEmpleado;
    @FXML
    private TableColumn tcSede;
    
    private ObservableList<Empleado> empleados;
    @FXML
    private TableView<Empleado> tvEmpleados;

   @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTable();
        cargarInformacionTabla();
    }

    private void configurarTable(){
        tcNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        tcApellidoPaterno.setCellValueFactory(new PropertyValueFactory("apellidoPaterno"));
        tcApellidoMaterno.setCellValueFactory(new PropertyValueFactory("apellidoMaterno"));
        tcCorreoElectronico.setCellValueFactory(new PropertyValueFactory("correoElectronico"));
        tcUsername.setCellValueFactory(new PropertyValueFactory("username"));
        tcPassword.setCellValueFactory(new PropertyValueFactory("password"));
        tcTipoEmpleado.setCellValueFactory(new PropertyValueFactory("tipoEmpleado"));
        tcSede.setCellValueFactory(new PropertyValueFactory("nombreSede"));
    }
    
    private void cargarInformacionTabla(){
        empleados = FXCollections.observableArrayList();
        Empleado respuestaBD = EmpleadoDAO.obtenerInformacionEmpleado();
        switch(respuestaBD.getCodigoRespuesta()){
            case Constantes.ERROR_CONEXION:
                Utilidades.mostrarDialogoSimple("Sin conexion", 
                        "Los sentimos por el momento no hay conexión para poder cargar la información", Alert.AlertType.ERROR);
                break;
            case Constantes.ERROR_CONSULTA:
                Utilidades.mostrarDialogoSimple("Error al cargar los datos", 
                        "Hubo un error al cargar la información por favor inténtelo más tarde", Alert.AlertType.WARNING);
                break;
            case Constantes.OPERACION_EXITOSA:
                    empleados.addAll(respuestaBD.getEmpleados());
                    tvEmpleados.setItems(empleados);
                break;
        }
    }

    @FXML
    private void clicBtnRegistrar(ActionEvent event) {
        Stage escenarioFormulario = new Stage();
        escenarioFormulario.setScene(Utilidades.inicializarEscena("vistas/FXMLFormularioEmpleado.fxml"));
        escenarioFormulario.setTitle("Registro");
        escenarioFormulario.initModality(Modality.APPLICATION_MODAL);
        escenarioFormulario.showAndWait();
    }

    @FXML
    private void clicBtnModificar(ActionEvent event) {
    }

    @FXML
    private void clicBtnDarBaja(ActionEvent event) {
    }

    @FXML
    private void clicRegresar(MouseEvent event) {
        Stage escearioPrincipal = (Stage) tfBuscar.getScene().getWindow();
        escearioPrincipal.close();
    }
    
}
