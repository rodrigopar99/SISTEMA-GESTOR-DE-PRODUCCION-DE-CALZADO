/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
//import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteService {

     public static DefaultTableModel mostrarPedidos(){
        String []  nombresColumnas = {"Id","Cliente id", "Fecha pedido","Estado"};
        String [] registros = new String[4];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT *FROM pedido";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id_pedido");
                
                registros[1] = rs.getString("cliente_id");
                
                registros[2] = rs.getString("fecha");
           
                registros[3] = rs.getString("estado");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    } 
    
    
     
      public static DefaultTableModel mostrarPedidosSegunEstado( String estado){
        String []  nombresColumnas = {"Id","Fecha", "Estado","cliente id"};
        String [] registros = new String[4];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT *FROM pedido WHERE Estado='"+estado+ "'";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id_pedido");
                
                registros[1] = rs.getString("fecha");
                
                registros[2] = rs.getString("estado");
           
                registros[3] = rs.getString("cliente_id");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    } 
     
       public static DefaultTableModel mostrarClientesSegunEstado( String estado){
        String []  nombresColumnas = {"NOMBRE","AP.PATERNO", "NRO DOCUMENTO","TELEFONO","ESTADO","NRO.PEDIDOS"};
        String [] registros = new String[6];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT C.nombre,C.apellido_paterno,C.nro_documento,C.telefono,P.estado,COUNT(P.cliente_id) AS PEDIDOS FROM CLIENTE C INNER JOIN PEDIDO P ON C.id_cliente=P.cliente_id WHERE P.estado='"+estado+"' GROUP BY C.id_cliente";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("nombre");
                
                registros[1] = rs.getString("apellido_paterno");
                
                registros[2] = rs.getString("nro_documento");
           
                registros[3] = rs.getString("telefono");
                
                 registros[4] = rs.getString("estado");
                 
                  registros[5] = rs.getString("PEDIDOS");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
   public static DefaultTableModel mostrarPedidosConEstado( String estado){
        String []  nombresColumnas = {"ID PEDIDO","FECHA", "ESTADO","DNI CLIENTE","NRO DE DETALLES"};
        String [] registros = new String[5];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql ="SELECT\n" +
"     pedido.id_pedido,\n" +
"     pedido.fecha,\n" +
"     pedido.estado,\n" +
"     cliente.nro_documento,\n" +
"     count(detallepedido.pedido_id) as nro\n" +
"FROM\n" +
"     pedido INNER JOIN  detallepedido ON pedido.id_pedido = detallepedido.pedido_id\n" +
"     INNER JOIN  cliente ON pedido.cliente_id = cliente.id_cliente\n" +
"\n" +
"GROUP BY\n" +
"     pedido.id_pedido";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id_pedido");
                
                registros[1] = rs.getString("fecha");
                
                registros[2] = rs.getString("estado");
           
                registros[3] = rs.getString("nro_documento");
                
                 registros[4] = rs.getString("nro");
                 
                 
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }   
      
       public static DefaultTableModel mostrarInsumosConEstado( String estado){
        String []  nombresColumnas = {"INSUMO","CANTIDAD", "PRECIO","RAZON SOCIAL","TELEFONO","RUC"};
        String [] registros = new String[6];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql ="SELECT\n" +
"     insumo.nombre,\n" +
"     insumo.cantidad,\n" +
"     insumo.precio,\n" +
"     proveedor.razon_social,\n" +
"     proveedor.telefono,\n" +
"     proveedor.Ruc\n" +
"FROM\n" +
"      proveedor INNER JOIN  insumo ON proveedor.id_proveedor = insumo.proveedor_id";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("nombre");
                
                registros[1] = rs.getString("cantidad");
                
                registros[2] = rs.getString("precio");
           
                registros[3] = rs.getString("razon_social");
                
                 registros[4] = rs.getString("telefono");
                 
                 registros[5] = rs.getString("Ruc");
                 
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }   
       
       
    public static DefaultTableModel mostrarTrabajadoresConEstado( String estado){
        String []  nombresColumnas = {"NOMBRE","AP. PATERNO", "TELEFONO","DNI","CARGO","VECES EN PRODUCCION"};
        String [] registros = new String[6];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql ="SELECT\n" +
"     trabajador.nombre,\n" +
"     trabajador.apellido_paterno,\n" +
"     trabajador.telefono,\n" +
"     trabajador.nro_documento,\n" +
"     trabajador.cargo,\n" +
"     count(detalletrabajador.trabajador_id) as nro\n" +
"FROM\n" +
"      trabajador INNER JOIN detalletrabajador ON trabajador.id_trabajador = detalletrabajador.trabajador_id\n" +
"\n" +
"GROUP BY\n" +
"     trabajador.id_trabajador";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("nombre");
                
                registros[1] = rs.getString("apellido_paterno");
                
                registros[2] = rs.getString("telefono");
           
                registros[3] = rs.getString("nro_documento");
                
                 registros[4] = rs.getString("cargo");
                 
                 registros[5] = rs.getString("nro");
                 
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }       
       
public static DefaultTableModel mostrarDetallePedidoConEstado( String idpedido){
        String []  nombresColumnas = {"NOMBRE","TIPO", "COLOR","TALLA","NRO. TACO","CANTIDAD"};
        String [] registros = new String[6];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql ="SELECT\n" +
"	 modelo.nombre,\n" +
"     modelo.tipo, \n" +
"     detallepedido.color,\n" +
"     detallepedido.talla,\n" +
"     detallepedido.nroTaco,\n" +
"     detallepedido.cantidad\n" +
"        \n" +
"FROM\n" +
"      pedido INNER JOIN  detallepedido ON pedido.id_pedido = detallepedido.pedido_id\n" +
"     INNER JOIN  modelo ON detallepedido.modelo_id = modelo.id_modelo\n" +
"WHERE\n" +
"     detallepedido.pedido_id = " + idpedido;
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("nombre");
                
                registros[1] = rs.getString("tipo");
                
                registros[2] = rs.getString("color");
           
                registros[3] = rs.getString("talla");
                
                 registros[4] = rs.getString("nroTaco");
                 
                 registros[5] = rs.getString("cantidad");
                 
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }       
       
    public static int ultimoRegistro(String nombreId, String nombreTabla){
        int id=0;
        String sql = "SELECT MAX("+nombreId+") AS "+nombreId+" FROM "+nombreTabla;
    
         Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
              try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                //colocamos el registro en la columna adecuada
                 id= rs.getInt(1);
                   
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
            
    return id;
    }
    

   
    

   public static DefaultTableModel mostrarClientes(){
        String []  nombresColumnas = {"Id","Nombre","ApPaterno", "ApMaterno","Telefono", "Tipo documento","Nro documento","Direccion"};
        String [] registros = new String[8];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM cliente";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                //colocamos el registro en la columna adecuada
                registros[0] = rs.getString("id_cliente");
                
                registros[1] = rs.getString("nombre");
           
                registros[2] = rs.getString("apellido_paterno");
                
                registros[3] = rs.getString("apellido_materno");
                
                registros[4] = rs.getString("telefono");
                
                registros[5] = rs.getString("tipo_documento");
                
                registros[6] = rs.getString("nro_documento");
                
                registros[7] = rs.getString("direccion");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    } 
   
   
   
   public static DefaultTableModel mostrarDetallePedido(){
        String []  nombresColumnas = {"Id","Cantidad(docenas)","Color","Nro Taco","Talla","Modelo Id","Pedido Id"};
        String [] registros = new String[7];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM detallepedido";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                //colocamos el registro en la columna adecuada
                registros[0] = rs.getString("id_detallePedido");
                
                registros[1] = rs.getString("cantidad");
           
                registros[2] = rs.getString("color");
                
                registros[3] = rs.getString("nroTaco");
                
                registros[4] = rs.getString("talla");
                
                registros[5] = rs.getString("modelo_id");
                
                registros[6] = rs.getString("pedido_id");
               
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    } 
   
   
   //mostrar modelo 
    public static DefaultTableModel mostrarModelo(){
        String []  nombresColumnas = {"Id","Nombre","Tipo"};
        String [] registros = new String[3];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM modelo";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id_modelo");
                
                registros[1] = rs.getString("nombre");
           
                registros[2] = rs.getString("tipo");
            
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    } 
   
   
    //mostrar trabajador por filtro
    
     public static DefaultTableModel mostrarTrabajador2(String cargo){
        String []  nombresColumnas = {"Id","Nombre","ApMaterno", "ApPaterno","Telefono", "Tipo documento","Nro documento","Direccion","Cargo"};
        String [] registros = new String[9];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM trabajador WHERE cargo = '"+cargo+"'";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id_trabajador");
                
                registros[1] = rs.getString("nombre");
           
                registros[2] = rs.getString("apellido_paterno");
                
                registros[3] = rs.getString("apellido_materno");
                
                registros[4] = rs.getString("telefono");
                
                registros[5] = rs.getString("tipo_documento");
                
                registros[6] = rs.getString("nro_documento");
                
                registros[7] = rs.getString("direccion");
                
                 registros[8] = rs.getString("cargo");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    } 
    
    
    
    
    
   //mostrar trabajador
    public static DefaultTableModel mostrarTrabajador(){
        String []  nombresColumnas = {"Id","Nombre","ApMaterno", "ApPaterno","Telefono", "Tipo documento","Nro documento","Direccion","Cargo"};
        String [] registros = new String[9];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM trabajador";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id_trabajador");
                
                registros[1] = rs.getString("nombre");
           
                registros[2] = rs.getString("apellido_paterno");
                
                registros[3] = rs.getString("apellido_materno");
                
                registros[4] = rs.getString("telefono");
                
                registros[5] = rs.getString("tipo_documento");
                
                registros[6] = rs.getString("nro_documento");
                
                registros[7] = rs.getString("direccion");
                
                 registros[8] = rs.getString("cargo");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    } 
   
   
   //mostrar proveedores
      public static DefaultTableModel mostrarProveedor(){
        String []  nombresColumnas = {"Id","Razón Social","Ruc", "Telefono","Dirección"};
        String [] registros = new String[5];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM proveedor";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id_proveedor");
                
                registros[1] = rs.getString("razon_social");
                
                registros[2] = rs.getString("Ruc");
           
                registros[3] = rs.getString("telefono");
                
                registros[4] = rs.getString("direccion");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    } 
      
     
   //mostrar insumos
       public static DefaultTableModel mostrarInsumos(){
        String []  nombresColumnas = {"Id","nombre","Cantidad", "Precio","Proveedor id"};
        String [] registros = new String[5];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT *FROM insumo";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id_insumo");
                
                registros[1] = rs.getString("nombre");
                
                registros[2] = rs.getString("cantidad");
           
                registros[3] = rs.getString("precio");
                
                registros[4] = rs.getString("proveedor_id");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    } 
      
   
   
      public static DefaultTableModel buscarClientes( String buscar){
        String []  nombresColumnas = {"Id","Nombres","ApMaterno","Telefono", "ApPaterno", "Tipo documento","Nro documento","Direccion"};
        String [] registros = new String[8];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM cliente WHERE id_cliente LIKE '%"+buscar+"%' OR nombre LIKE '%"+buscar+ "%' OR nro_documento LIKE '%" +buscar+"%'";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id_cliente");
                
                registros[1] = rs.getString("nombre");
                
                registros[2] = rs.getString("apellido_paterno");
                
                registros[3] = rs.getString("apellido_materno");
                
                registros[4] = rs.getString("telefono");
                
                registros[5] = rs.getString("tipo_documento");
                
                registros[6] = rs.getString("nro_documento");
                
                registros[7] = rs.getString("direccion");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
      //buscar trabajador
     public static DefaultTableModel buscarTrabajador( String buscar){
        String []  nombresColumnas = {"Id","Nombre","ApMaterno", "ApPaterno","Telefono", "Tipo documento","Nro documento","Direccion","Cargo"};
        String [] registros = new String[9];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM trabajador WHERE id_trabajador LIKE '%"+buscar+"%' OR cargo LIKE '%"+buscar+ "%' OR nro_documento LIKE '%" +buscar+"%'";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                 registros[0] = rs.getString("id_trabajador");
                
                registros[1] = rs.getString("nombre");
           
                registros[2] = rs.getString("apellido_paterno");
                
                registros[3] = rs.getString("apellido_materno");
                
                registros[4] = rs.getString("telefono");
                
                registros[5] = rs.getString("tipo_documento");
                
                registros[6] = rs.getString("nro_documento");
                
                registros[7] = rs.getString("direccion");
                
                registros[8] = rs.getString("cargo");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
     
     //buscar modelo
      public static DefaultTableModel buscarModelo(String buscar){
        String []  nombresColumnas = {"Id","Nombre","Tipo"};
        String [] registros = new String[3];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM modelo WHERE nombre LIKE '%"+buscar+"%'";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id_modelo");
                
                registros[1] = rs.getString("nombre");
           
                registros[2] = rs.getString("tipo");
            
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    } 
     
     
      
      
      
      //////////////////////////////////////////////////////////////////////////////////////////////////////
      
     public static boolean registrarDetalleInsumo( int cantidad,int produccionId, int insumoId){
     String sql = "INSERT INTO detalleinsumo (cantidad,produccion_id,insumo_id) VALUES (?,?,?)";
     Connection conectar;
     PreparedStatement pst;  
        try {
            conectar = DBConexion.getConnection();
            pst = conectar.prepareStatement(sql);
            
            pst.setInt(1, cantidad);
            pst.setInt(2, produccionId);
            pst.setInt(3, insumoId);
            
            int i = pst.executeUpdate();
            
            if (i != 0){
                //JOptionPane.showMessageDialog(null,"Los datos se han guardado satisfactoriamente");
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
      
      
      public static boolean registrarDetalleTrabajador( int trabajadorId,int produccionId){
     String sql = "INSERT INTO detalletrabajador (trabajador_id,produccion_id) VALUES (?,?)";
     Connection conectar;
     PreparedStatement pst;  
        try {
            conectar = DBConexion.getConnection();
            pst = conectar.prepareStatement(sql);
            
            pst.setInt(1, trabajadorId);
            pst.setInt(2, produccionId);
            
            int i = pst.executeUpdate();
            
            if (i != 0){
                //JOptionPane.showMessageDialog(null,"Los datos se han guardado satisfactoriamente");
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
      
      
      
      

      
      
      
      
      
      /////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      
      
      
      
      
      
      
      //buscarProveedor
      public static DefaultTableModel buscarProveedor( String buscar){
        String []  nombresColumnas = {"Id","Razón Social","Ruc", "Telefono","Dirección"};
        String [] registros = new String[5];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM proveedor WHERE id_proveedor LIKE '%"+buscar+"%' OR razon_social LIKE '%"+buscar+ "%' OR Ruc LIKE '%" +buscar+"%'";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
               registros[0] = rs.getString("id_proveedor");
                
                registros[1] = rs.getString("razon_social");
                
                registros[2] = rs.getString("Ruc");
           
                registros[3] = rs.getString("telefono");
                
                registros[4] = rs.getString("direccion");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
      
      
    public static DefaultTableModel buscarDetallePedido( String buscar){
        String []  nombresColumnas = {"Id","Cantidad","Color", "Nro taco","Talla","Modelo id","Pedido id"};
        String [] registros = new String[7];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM detallepedido WHERE pedido_id LIKE '%"+buscar+"%'";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
               registros[0] = rs.getString("id_detallepedido");
                
                registros[1] = rs.getString("cantidad");
                
                registros[2] = rs.getString("color");
           
                registros[3] = rs.getString("nroTaco");
                
                registros[4] = rs.getString("talla");
                
                registros[5] = rs.getString("modelo_id");
                
                registros[6] = rs.getString("pedido_id");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }  
      
      
      
      
      
      //BUSCAR INSUMO
      public static DefaultTableModel buscarInsumo( String buscar){
        String []  nombresColumnas = {"Id","Nombre","Cantidad", "Precio","Proveedor id"};
        String [] registros = new String[5];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM insumo WHERE id_insumo LIKE '%"+buscar+"%' OR nombre LIKE '%"+buscar+"%'";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
               registros[0] = rs.getString("id_insumo");
                
                registros[1] = rs.getString("nombre");
                
                registros[2] = rs.getString("cantidad");
           
                registros[3] = rs.getString("precio");
                
                registros[4] = rs.getString("proveedor_id");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
      
      
       public static DefaultTableModel buscarPedido( String buscar, String estado){
        String []  nombresColumnas = {"Id","Fecha","Estado", "Cliente id"};
        String [] registros = new String[4];
        
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql ="SELECT * FROM pedido WHERE id_pedido LIKE '%"+buscar+"%' AND estado LIKE '%"+estado+"%'";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
               registros[0] = rs.getString("id_pedido");
                
                registros[1] = rs.getString("fecha");
                
                registros[2] = rs.getString("estado");
           
                registros[3] = rs.getString("cliente_id");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
      //ELIMINAR  "Delete from cliente where id_cliente= '"+id+"'";
      
   public static boolean eliminarRegistro(int id, String nombreTabla, String nombreId){
        String sql = "DELETE FROM "+nombreTabla+" WHERE " +nombreId+" = ?";
        Connection cn;
        PreparedStatement pst;
        try
        {
            cn = DBConexion.getConnection();
            
            pst = cn.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            int i = pst.executeUpdate();
            
            return i != 0;
            
        }
        catch(SQLException e )
        {
            System.out.println("Error al eliminar registro "+e.getMessage());
            
            return false;
        }
    }
   
   
      public static boolean validarNumeros (String datos){
      return datos.matches("[0-9]+");
      }
      
      public static boolean validarLetras (String datos){
      return datos.matches("[a-zA-Z]+");
      }
      
      public static boolean validarDecimales(String datos){
      
          return datos.matches("^[0-9]+([.][0-9]+)?$");
      }
      
       public static boolean validarNocetosAlinicio(String datos){
      
          return datos.matches("[1-9][0-9]*");
      }

}
