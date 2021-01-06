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
public class DetallePedido {
    
    private Modelo modelo;
    private int cantidadEnDocenas;
    private String color;
    private int nroTaco;
    private int talla;

    public DetallePedido() {
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getCantidadEnDocenas() {
        return cantidadEnDocenas;
    }

    public void setCantidadEnDocenas(int cantidadEnDocenas) {
        this.cantidadEnDocenas = cantidadEnDocenas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNroTaco() {
        return nroTaco;
    }

    public void setNroTaco(int nroTaco) {
        this.nroTaco = nroTaco;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }
    
    
    
    public boolean registrarDetallePedido(int idPedido,int idModelo ){
     String sql = "INSERT INTO detallepedido (cantidad, color, nroTaco, talla, modelo_id, pedido_id) VALUES (?,?,?,?,?,?)";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
            pst.setInt(1, cantidadEnDocenas);
            pst.setString(2, color);
            pst.setInt(3, nroTaco);
            pst.setInt(4, talla);
            pst.setInt(5, idModelo);
             pst.setInt(6, idPedido);
            
                     
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
