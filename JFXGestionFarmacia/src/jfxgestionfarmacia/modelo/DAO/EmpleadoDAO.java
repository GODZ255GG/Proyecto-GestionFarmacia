package jfxgestionfarmacia.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jfxgestionfarmacia.modelo.ConexionBD;
import jfxgestionfarmacia.modelo.pojo.Empleado;
import jfxgestionfarmacia.utils.Constantes;

public class EmpleadoDAO {
    public static Empleado obtenerInformacionEmpleado(){
        Empleado respuesta = new Empleado();
        respuesta.setCodigoRespuesta(Constantes.OPERACION_EXITOSA);
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String consulta = "select  idEmpleado, Empleado.nombre, apellidoPaterno, apellidoMaterno, correoElectronico, username, password, " +
                            "tipoEmpleado, Empleado.Sede_idSede, Sede.nombre AS nombreSede from Empleado " +
                            "inner join Sede on Empleado.Sede_idSede = Sede.idSede;";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(consulta);
                ResultSet resultado = prepararSentencia.executeQuery();
                ArrayList<Empleado> empleadoConsulta = new ArrayList();
                while(resultado.next()){
                    Empleado empleado = new Empleado();
                    empleado.setIdEmpleado(resultado.getInt("idEmpleado"));
                    empleado.setNombre(resultado.getString("nombre"));
                    empleado.setApellidoPaterno(resultado.getString("apellidoPaterno"));
                    empleado.setApellidoMaterno(resultado.getString("apellidoMaterno"));
                    empleado.setCorreoElectronico(resultado.getString("correoElectronico"));
                    empleado.setUsername(resultado.getString("username"));
                    empleado.setPassword(resultado.getString("password"));
                    empleado.setTipoEmpleado(resultado.getString("tipoEmpleado"));
                    empleado.setIdSede(resultado.getInt("Sede_idSede"));
                    empleado.setNombreSede(resultado.getString("nombreSede"));
                    empleadoConsulta.add(empleado);
                }
                respuesta.setEmpleados(empleadoConsulta);
                conexionBD.close();
            }catch (SQLException e){
                respuesta.setCodigoRespuesta(Constantes.ERROR_CONSULTA);
            }
        }else{
            respuesta.setCodigoRespuesta(Constantes.ERROR_CONEXION);
        }
        return respuesta;
    }
}
