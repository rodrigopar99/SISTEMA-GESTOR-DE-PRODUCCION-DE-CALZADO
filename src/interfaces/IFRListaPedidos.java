/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import datos.ClienteService;
import static datos.ClienteService.eliminarRegistro;
import datos.DBConexion;
import static interfaces.IUPrincipal.desktopPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Michaell
 */
public class IFRListaPedidos extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFRListaPedidos
     */
    
    String estado;
    ButtonGroup gupoRadioButton;
    DefaultTableModel modelo2;
    
    public IFRListaPedidos() {
        initComponents();
        modelo2 = new  DefaultTableModel();
        tabla2.setModel(modelo2);
        estado="Sin produccion";
        habilitarEstadoDePedido=0;
        gupoRadioButton= new  ButtonGroup();
        gupoRadioButton.add(rsinproduccion);
        gupoRadioButton.add(rproduccion);
       
        
        mostrarPedido(estado);
        tabla.getTableHeader().setReorderingAllowed(false) ;
        tabla2.getTableHeader().setReorderingAllowed(false) ;
        
        rsinproduccion.setSelected(true);
        

       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        btneliminarpedido = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtidcliente = new javax.swing.JTextField();
        btnvercliente = new javax.swing.JButton();
        btnactualizarpedido = new javax.swing.JButton();
        rproduccion = new javax.swing.JRadioButton();
        rsinproduccion = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnactualizardetallepedido = new javax.swing.JButton();
        btneliminarestadopedido = new javax.swing.JButton();

        setClosable(true);
        setTitle("Listar Pedidos");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                switch (colIndex) {
                    case 0:
                    return false;
                    case 1:
                    return false;
                    case 2:
                    return true;
                    case 3:
                    return false;
                    default:
                    return false;
                }
            }
        };
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.setFocusable(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        txtbuscar.setForeground(new java.awt.Color(153, 153, 153));
        txtbuscar.setText("Buscar");
        txtbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtbuscarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtbuscarMouseReleased(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        btneliminarpedido.setText("Anular");
        btneliminarpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarpedidoActionPerformed(evt);
            }
        });

        jLabel1.setText("Cliente");

        txtidcliente.setEnabled(false);

        btnvercliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Buscar.gif"))); // NOI18N
        btnvercliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverclienteActionPerformed(evt);
            }
        });

        btnactualizarpedido.setText("Actualizar");
        btnactualizarpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarpedidoActionPerformed(evt);
            }
        });

        rproduccion.setText("En produccion");
        rproduccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rproduccionMouseClicked(evt);
            }
        });
        rproduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rproduccionActionPerformed(evt);
            }
        });

        rsinproduccion.setText("Sin produccion");
        rsinproduccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rsinproduccionMouseClicked(evt);
            }
        });
        rsinproduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsinproduccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnvercliente)
                        .addGap(44, 44, 44)
                        .addComponent(rproduccion)
                        .addGap(18, 18, 18)
                        .addComponent(rsinproduccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(btnactualizarpedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminarpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnvercliente)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rproduccion)
                        .addComponent(rsinproduccion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnactualizarpedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminarpedido))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                switch (colIndex) {
                    case 0:
                    return false;
                    case 1:
                    return true;
                    case 2:
                    return true;
                    case 3:
                    return true;
                    case 4:
                    return true;
                    default:
                    return false;
                }
            }
        };
        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Cantidad", "Color", "Nro Taco", "Talla", "Modelo id", "Pedido id"
            }
        ));
        tabla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnactualizardetallepedido.setText("Actualizar");
        btnactualizardetallepedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizardetallepedidoActionPerformed(evt);
            }
        });

        btneliminarestadopedido.setText("Anular");
        btneliminarestadopedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarestadopedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnactualizardetallepedido)
                .addGap(18, 18, 18)
                .addComponent(btneliminarestadopedido, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnactualizardetallepedido)
                    .addComponent(btneliminarestadopedido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactualizardetallepedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizardetallepedidoActionPerformed
         int fila=tabla2.getSelectedRow();
         if(fila>=0){
               
                 actualizarDetallePedido(Integer.parseInt(tabla2.getValueAt(fila, 0).toString()),String.valueOf(tabla2.getValueAt(fila, 1)),String.valueOf(tabla2.getValueAt(fila, 2)),String.valueOf(tabla2.getValueAt(fila, 3)),String.valueOf(tabla2.getValueAt(fila, 4)));
                 
         }else{
         JOptionPane.showMessageDialog(null,"Ninguna fila seleccionada");
         }
    }//GEN-LAST:event_btnactualizardetallepedidoActionPerformed

    String a;
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int fila=tabla.getSelectedRow();
         if(fila>=0){
                
                 a =String.valueOf(tabla.getValueAt(fila, 0));
                 txtidcliente.setText(tabla.getValueAt(fila,3).toString());
                 buscarDetallePedido(String.valueOf(tabla.getValueAt(fila, 0)));
                 addComboColor(tabla2.getColumnModel().getColumn(2),tabla2);
                 addComboTaco(tabla2.getColumnModel().getColumn(3),tabla2);
                 addComboTalla(tabla2.getColumnModel().getColumn(4),tabla2);
                 
              
                 addComboEstadoPedido(tabla.getColumnModel().getColumn(2),tabla);
                
                 
         }
    }//GEN-LAST:event_tablaMouseClicked

    private void tabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla2MouseClicked

    }//GEN-LAST:event_tabla2MouseClicked

    
    public void limpiarTabla(){
    modelo2.getDataVector().removeAllElements();
    tabla2.updateUI();
    }
    
    
    
    
    
    private void btneliminarestadopedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarestadopedidoActionPerformed
       
         int fila=tabla2.getSelectedRow();
         if(fila>=0){
               
                 if (eliminarRegistro(Integer.parseInt(tabla2.getValueAt(fila, 0).toString()),"detallepedido","id_detallePedido")){
                 buscarDetallePedido(a);
                 }
                 
         }else {
         JOptionPane.showMessageDialog(null,"Ninguna fila seleccionada");
         }
        
        
        
    }//GEN-LAST:event_btneliminarestadopedidoActionPerformed

    private void btneliminarpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarpedidoActionPerformed
            int fila = tabla.getSelectedRow();
            if(fila>=0){

                if (ClienteService.eliminarRegistro(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(),0).toString()),"pedido","id_pedido")){
                   mostrarPedido(estado);
                   buscarDetallePedido(a);
                   txtidcliente.setText("");
                    
                }
            }else{
                JOptionPane.showMessageDialog(this, "Ninguna fila seleccionada", "Seleccione una fila en la tabla pedidos", 0);
            }  
    }//GEN-LAST:event_btneliminarpedidoActionPerformed

    private void btnactualizarpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarpedidoActionPerformed
    
     int fila=tabla.getSelectedRow();
    if (fila>=0){
    actualizarClientePedido(Integer.parseInt(tabla.getValueAt(fila,0).toString()),(txtidcliente.getText()), tabla.getValueAt(fila,2).toString());
    mostrarPedido(estado);
    txtidcliente.setText("");
      }else {
    JOptionPane.showMessageDialog(null,"Ninguna fila seleccionada");
    
    }         
              
    }//GEN-LAST:event_btnactualizarpedidoActionPerformed

    
       
    
//    public void stateChanged(ChangeEvent e) {
//    if(rproduccion.isSelected()==true){
//    System.out.println("PEDIDO EN PRUDCCION");
//    }else if (rsinproduccion.isSelected()==true){
//    System.out.println("PEDIDO EN SIN PRUDCCION");
//    }
//        
//    }
    
    
    
    
    private void btnverclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverclienteActionPerformed
    IFRBuscarCliente buscarcliente = new IFRBuscarCliente();
    buscarcliente.setTitle("Buscar Cliente");
   desktopPane.add(buscarcliente);
   
   int x = (desktopPane.getWidth() / 2) - (buscarcliente.getWidth() / 2);
   int y = (desktopPane.getHeight() / 2) - (buscarcliente.getHeight() / 2);
   buscarcliente.setLocation(x, y);
   
   buscarcliente.setVisible(true);
    }//GEN-LAST:event_btnverclienteActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
       buscarPedidos(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbuscarMouseExited
          if (txtbuscar.getText().equals("")){
          txtbuscar.setText("Buscar");
          txtbuscar.setForeground(new Color(153,153,153));
        
        }
    }//GEN-LAST:event_txtbuscarMouseExited

    private void txtbuscarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbuscarMouseReleased
        if (txtbuscar.getText().equals("Buscar")){
        txtbuscar.setText("");
        txtbuscar.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtbuscarMouseReleased
int habilitarEstadoDePedido;
    private void rproduccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rproduccionMouseClicked

    }//GEN-LAST:event_rproduccionMouseClicked

    private void rsinproduccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rsinproduccionMouseClicked

    }//GEN-LAST:event_rsinproduccionMouseClicked

    private void rproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rproduccionActionPerformed
         if (rproduccion.isSelected()==true){
       estado="EN PRODUCCION";
        habilitarEstadoDePedido=1;
        mostrarPedido(estado);
        btneliminarpedido.setEnabled(false);
        btneliminarestadopedido.setEnabled(false);
        btnactualizardetallepedido.setEnabled(false);
        btnvercliente.setEnabled(false);
       limpiarTabla();
        
    
   }
    }//GEN-LAST:event_rproduccionActionPerformed

    private void rsinproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsinproduccionActionPerformed
            if (rsinproduccion.isSelected()==true){
    estado="Sin produccion" ;
    habilitarEstadoDePedido=0;    
    mostrarPedido(estado);
    tabla.updateUI();
    btneliminarpedido.setEnabled(true);
    btneliminarestadopedido.setEnabled(true);
    btnactualizardetallepedido.setEnabled(true);
     btnvercliente.setEnabled(true);
     limpiarTabla();
    
   }
    }//GEN-LAST:event_rsinproduccionActionPerformed
     
 

    
    public void buscarPedidos(String buscar){
        DefaultTableModel modelo = ClienteService.buscarPedido(buscar,estado);
        tabla.setModel(modelo);   
    }
    
    public boolean actualizarClientePedido(int idPedido, String clienteid, String estado ){
     String sql = "UPDATE pedido SET estado=?, cliente_id=? WHERE id_pedido= ?";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
          
            pst.setString(1,estado);
             
            pst.setString(2,clienteid);
            
            pst.setInt(3, idPedido);
            
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
    
    
    

     public boolean actualizarDetallePedido(int id, String cantidad, String color, String nroTaco, String talla ){
     String sql =  "UPDATE detallepedido SET cantidad=?, color=?, nroTaco=?, talla=? WHERE id_detallePedido = ?";
     Connection conectar;
     PreparedStatement pst;  
     
        try {
            conectar = DBConexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
            pst.setString(1, cantidad);
            pst.setString(2, color);
            pst.setString(3, nroTaco);
            pst.setString(4, talla);
            
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
    
    
    
    
    
    
    
    
    
    
    
    public void addComboColor(TableColumn columna,JTable tabla){
            //TableColumn tc =  tabla.getColumnModel().getColumn(columna);
            //tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
            //tc.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
            JComboBox c= new JComboBox();
            c.addItem("Azul");
            c.addItem("Negro");
            c.addItem("Blanco");
            columna.setCellEditor( new DefaultCellEditor(c));
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setToolTipText("seleccione");
            columna.setCellRenderer(render);
            
    }
     
    
         public void addComboTaco(TableColumn columna,JTable tabla){
            //TableColumn tc =  tabla.getColumnModel().getColumn(columna);
            //tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
            //tc.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
            JComboBox c= new JComboBox();
            c.addItem("5");
            c.addItem("7");
            c.addItem("9");
            c.addItem("10");
            c.addItem("11");
         
            columna.setCellEditor( new DefaultCellEditor(c));
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setToolTipText("seleccione");
            columna.setCellRenderer(render);
            
    }
    
    
         
         
    public void addComboEstadoPedido(TableColumn columna,JTable tabla){
            //TableColumn tc =  tabla.getColumnModel().getColumn(columna);
            //tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
            //tc.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
            JComboBox c= new JComboBox();
        if (habilitarEstadoDePedido==1){
            c.addItem("EN PRODUCCION");
            c.addItem("TERMINADO"); 
            c.addItem("ENTREGADO");
            
    }else {
        c.addItem("Sin produccion");
        }
         
            columna.setCellEditor( new DefaultCellEditor(c));
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setToolTipText("seleccione");
            columna.setCellRenderer(render);
            
    }
         
         
    
          public void addComboTalla(TableColumn columna,JTable tabla){
            //TableColumn tc =  tabla.getColumnModel().getColumn(columna);
            //tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
            //tc.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
            JComboBox c= new JComboBox();
            c.addItem("36");
            c.addItem("37");
            c.addItem("38");
            c.addItem("39");
            c.addItem("40");
            c.addItem("42");
            c.addItem("43");
            columna.setCellEditor( new DefaultCellEditor(c));
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setToolTipText("seleccione");
            columna.setCellRenderer(render);
            
    }
    
    
    
    
    
       public void mostrarPedido(String est) {
        DefaultTableModel modelo = ClienteService.mostrarPedidosSegunEstado(est);
        tabla.setModel(modelo);
    }
       
    
        public void buscarDetallePedido(String buscar){
         modelo2 = ClienteService.buscarDetallePedido(buscar);
        tabla2.setModel(modelo2);   
    }
        
  
  
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizardetallepedido;
    private javax.swing.JButton btnactualizarpedido;
    private javax.swing.JButton btneliminarestadopedido;
    private javax.swing.JButton btneliminarpedido;
    private javax.swing.JButton btnvercliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rproduccion;
    private javax.swing.JRadioButton rsinproduccion;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla2;
    private javax.swing.JTextField txtbuscar;
    public static javax.swing.JTextField txtidcliente;
    // End of variables declaration//GEN-END:variables
}
