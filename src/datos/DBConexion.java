/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;


import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConexion 
{
    //creamos un metido estatico de tipo conexion (paquete.clase)
    public static com.mysql.jdbc.Connection getConnection()
    {
        //declaramos una variable de tipo conexion llamada con
        com.mysql.jdbc.Connection con = null;
        
        String bd = "zapaton2"; //nombre de la base de datos
        String url = "jdbc:mysql://localhost:3306/"+bd+"?useServerPrepStmts=true"; //local host ya que estamos usando una conexion local
        String user = "root";// el usuario 
        String pass = "";// la clave
        
        try
        {
            //cargamos la clase Driver 
            Class.forName("org.gjt.mm.mysql.Driver");
            
            //acá hacemos la conexion y le pasamos los 3 parametros
            con = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, user, pass);
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        //retorno la conexion
        return con;
    }
}
