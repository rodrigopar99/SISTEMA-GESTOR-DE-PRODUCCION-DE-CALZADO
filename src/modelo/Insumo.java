/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datos.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Michaell
 */
public class Insumo {
    private String nombre;
    private int cantidad;
    private float precio;
    private Proveedor proveedor;

    public Insumo(String nombre, int cantidad, float precio, Proveedor proveedor) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.proveedor = proveedor;
    }
    
    
    

     public Insumo(){
     
     }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
     


       public boolean registrarInsumo(int idProveedor ){
     String sql = "INSERT INTO insumo (nombre, cantidad, precio, proveedor_id) VALUES (?,?,?,?)";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
            //pst.setInt(1,id);
            
            pst.setString(1, nombre);
            pst.setInt(2, cantidad);
            pst.setFloat(3, precio);
            pst.setInt(4, idProveedor);
            
                     
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

     public boolean actualizarInsumo(int id, String proveedor_idfk ){
     String sql = "UPDATE insumo SET nombre=?, cantidad=?, precio=?, proveedor_id=? WHERE id_insumo = ?";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
            //pst.setInt(1,id);
            
            pst.setString(1, nombre);
            
            pst.setInt(2, cantidad);
            
            pst.setFloat(3, precio);
            
            pst.setString(4, proveedor_idfk);
           
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
     
     
     
     public boolean actualizarStock(int id ){
     String sql = "UPDATE insumo SET cantidad=? WHERE id_insumo = ?";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
             
            pst.setInt(1, cantidad);
  
            pst.setInt(2, id);
            
            int i = pst.executeUpdate();
            
            if (i != 0)
            {
                //JOptionPane.showMessageDialog(null,"Los datos se han guardado satisfactoriamente");
                
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
