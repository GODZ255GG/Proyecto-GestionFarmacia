
package jfxgestionfarmacia.interfaz;

public interface INotificacionOperacion {
    public void notificarOperacionGuardar(String nombre);
    
    public void notificarOperacionActualizar(String nombrePromo);
   
    public void notificarOperacionGuardar(String nombreEmpleado);
    
    public void notificarOperacionActualizar(String nombreEmpleado);
}
