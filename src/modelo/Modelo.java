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
public class Modelo {
    private String nombre;
    private String tipoModelo;

    public Modelo(String nombre,String tipoModelo) {
        this.tipoModelo = tipoModelo;
        this.nombre=nombre;
    }
    
    
    public Modelo(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoModelo() {
        return tipoModelo;
    }

    public void setTipoModelo(String tipoModelo) {
        this.tipoModelo = tipoModelo;
    }
    
    
     public boolean registrarModelo( ){
     String sql = "INSERT INTO modelo (nombre,tipo) VALUES (?,?)";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
            //pst.setInt(1,id);
            
            pst.setString(1, nombre);
            
            pst.setString(2, tipoModelo);
            
         
            
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
    
     public boolean actualizarModelo(int id ){
     String sql =  "UPDATE modelo SET nombre=?, tipo=? WHERE id_modelo = ?";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
           
            
            pst.setString(1, nombre);
            
            pst.setString(2, tipoModelo);
            
            pst.setInt(3, id);
         
            
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
