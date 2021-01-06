/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datos.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Michaell
 */
public class OrdenProduccion {
    private Timestamp fecha;

    public OrdenProduccion() {
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
    
     public  boolean registrarProduccion( int pedidoId){
     String sql = "INSERT INTO produccion (fecha,pedido_id) VALUES (?,?)";
     Connection conectar;
     PreparedStatement pst;  
        try {
            conectar = DBConexion.getConnection();
            pst = conectar.prepareStatement(sql);
            
            pst.setTimestamp(1, fecha);
            pst.setInt(2, pedidoId);
            
            int i = pst.executeUpdate();
            
            if (i != 0){
                JOptionPane.showMessageDialog(null,"Los datos se han guardado satisfactoriamente");
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"Error en la transaccion");
                
                return false;
            }
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
    
             return false;
        }
          
    }
    
    
    
    
}
