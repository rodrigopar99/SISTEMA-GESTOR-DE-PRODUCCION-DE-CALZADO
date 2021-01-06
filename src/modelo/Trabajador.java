
package modelo;

import datos.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class Trabajador {
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String telefono;
    private String tipoDoc;
    private String nrodocumento;
    private String direccion;
   
    private String cargo;

    public Trabajador(String nombre, String apPaterno, String apMaterno, String nrodocumento, String tipoDoc, String direccion, String cargo) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.nrodocumento = nrodocumento;
        this.tipoDoc = tipoDoc;
        this.direccion = direccion;
        this.cargo = cargo;
    }
    
    
    public Trabajador(){
    
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNrodocumento() {
        return nrodocumento;
    }

    public void setNrodocumento(String nrodocumento) {
        this.nrodocumento = nrodocumento;
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



    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    public boolean registrarTrabajador( ){
     String sql = "INSERT INTO trabajador (nombre,apellido_paterno,apellido_materno,telefono,tipo_documento,nro_documento,direccion,cargo) VALUES (?,?,?,?,?,?,?,?)";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
            //pst.setInt(1,id);
            
            pst.setString(1, nombre);
            
            pst.setString(2, apPaterno);
            
            pst.setString(3, apMaterno);
            
            pst.setString(4, telefono);
            
             pst.setString(5, tipoDoc);
             
             pst.setString(6, nrodocumento);
             
             pst.setString(7, direccion);
             
              pst.setString(8, cargo);
            
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
    
     public boolean actualizarTrabajador(int id){
     String sql = "UPDATE trabajador SET nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, tipo_documento=?, nro_documento=?, direccion=?, cargo=? WHERE id_trabajador = ?";
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
             
             pst.setString(6, nrodocumento);
             
             pst.setString(7, direccion);
             
             pst.setString(8, cargo);
              
             pst.setInt(9, id);
            
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
    
    
    
}
