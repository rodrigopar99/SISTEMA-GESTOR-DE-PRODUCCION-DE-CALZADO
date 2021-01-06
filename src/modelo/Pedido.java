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
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Pedido {
    private Cliente cliente;
    private Timestamp fecha;
    private String estado;
    private ArrayList <DetallePedido> orden; //lista

    public Pedido() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<DetallePedido> getOrden() {
        return orden;
    }

    public void setOrden(ArrayList<DetallePedido> orden) {
        this.orden = orden;
    }
    
    public boolean registrarPedido(int idCliente ){
     String sql = "INSERT INTO pedido (fecha, estado, cliente_id) VALUES (?,?,?)";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
            pst.setTimestamp(1, fecha);
            pst.setString(2, estado);
            pst.setInt(3, idCliente);
            
                     
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
    
    
    public boolean actualizarEstadoPedido(int idPedido ){
     String sql = "UPDATE pedido SET estado=? WHERE id_pedido= ?";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
          
            pst.setString(1, estado);
            pst.setInt(2, idPedido);
            
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
