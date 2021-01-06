
package modelo;

import datos.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Proveedor {
    
    private String razonSocial;
    private String ruc;
    private String telefono;
    private String direccion;
    


    public Proveedor(String razonSocial, String ruc, String telefono, String direccion) {
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    
    public Proveedor(){
    
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
     public boolean registrarProveedor( ){
     String sql = "INSERT INTO proveedor (razon_social,ruc,telefono,direccion) VALUES (?,?,?,?)";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
            //pst.setInt(1,id);
            
            pst.setString(1, razonSocial);
            
            pst.setString(2, ruc);
            
            pst.setString(3, telefono);
            
            pst.setString(4, direccion);
            
             
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
     
     
     public boolean actualizarProveedor(int id ){
     String sql = "UPDATE proveedor SET razon_social=?, Ruc=?, telefono=?, direccion=? WHERE id_proveedor = ?";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
            //pst.setInt(1,id);
            
            pst.setString(1, razonSocial);
            
            pst.setString(2, ruc);
            
            pst.setString(3, telefono);
            
            pst.setString(4, direccion);
            
             pst.setInt(5, id);
            
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
