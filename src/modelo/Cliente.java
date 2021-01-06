
package modelo;

import datos.ClienteService;
import datos.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Cliente {
   
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String telefono;
    private String tipoDoc;
    private String nroDoc;
    private String direccion;

    public Cliente() {

    }

    public Cliente(String nombre, String apPaterno, String apMaterno,String telefono, String nroDoc, String tipoDoc, String direccion) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.telefono=telefono;
        this.nroDoc = nroDoc;
        this.tipoDoc = tipoDoc;
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean actualizarCliente(int id ){
     String sql = "UPDATE cliente SET nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, tipo_documento=?, nro_documento=?, direccion=? WHERE id_cliente = ?";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
            
            
            pst.setString(1, nombre);
            
            pst.setString(2, apPaterno);
            
            pst.setString(3, apMaterno);
            
            pst.setString(4, telefono);
            
             pst.setString(5, tipoDoc);
             
             pst.setString(6, nroDoc);
             
             pst.setString(7, direccion);
             
             pst.setInt(8, id);
            
            int i = pst.executeUpdate();
            
            if (i != 0)
            {
                JOptionPane.showMessageDialog(null,"Los datos se han guardado satisfactoriamente");
                
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error en la transaccion");
                
                return false;
            }
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
    
             return false;
        }
          
    }
    
    
    //registramos un cliente
    //lo declaramos booleano para que retorne verdadero o falso segun el proceso 
    public boolean registrarCliente( ){
        //hacemos nuestra instruccion sql e insertamos dentro de la tabla cliente 
     String sql = "INSERT INTO cliente (nombre,apellido_paterno,apellido_materno,telefono,tipo_documento,nro_documento,direccion) VALUES (?,?,?,?,?,?,?)";
     
     //declaramos una variable de tipo conexion
     Connection conectar;
     
     //un PreparedStatement que lo llamamos pst
     PreparedStatement pst;  
     
        try {
            
            //a esta variable le asignamos el metodo getConnection que creamos CON la clase DBconexion
            //como es estatico la usamos usando la clase
            conectar = DBConexion.getConnection();
            
            //CREAMOS NUESTRO PreparedStatement
            pst = conectar.prepareStatement(sql);
            
            
              //     1 2 3 4 5
             //value(?,?,?,?,?)
            // (posicion del argumento, que se le envia )
            pst.setString(1, nombre);
            
            pst.setString(2, apPaterno);
            
            pst.setString(3, apMaterno);
            
            pst.setString(4, telefono);
            
             pst.setString(5, tipoDoc);
             
             pst.setString(6, nroDoc);
             
             pst.setString(7, direccion);
            
            int i = pst.executeUpdate();
            
            if (i != 0)
            {
                JOptionPane.showMessageDialog(null,"Los datos se han guardado satisfactoriamente");
                
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error en la transaccion");
                
                return false;
            }
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
    
             return false;
        }
          
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getNrodoc() {
        return nroDoc;
    }

    public void setDocIdentidad(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
