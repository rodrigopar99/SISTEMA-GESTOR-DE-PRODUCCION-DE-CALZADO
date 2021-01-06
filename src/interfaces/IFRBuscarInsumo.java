/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import datos.ClienteService;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Michaell
 */
public class IFRBuscarInsumo extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFRBuscarInsumo
     */
    public IFRBuscarInsumo() {
        initComponents();
        mostrarInsumo();
        tabla.getTableHeader().setReorderingAllowed(false) ;
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        btnagregar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Buscar Insumos");

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
        jScrollPane1.setViewportView(tabla);

        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/agregar.png"))); // NOI18N
        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(btnagregar)
                .addGap(91, 375, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnagregar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        int fila=tabla.getSelectedRow();
        int contador=0;
        if(fila>=0){
            
            String datos[]= new String[2];
            String s;
            datos[0]=tabla.getValueAt(fila, 0).toString();
            datos[1]=tabla.getValueAt(fila, 1).toString();
            int stock = Integer.parseInt(tabla.getValueAt(fila, 2).toString());
            //arreglar problema
            
           //un dato                            3
           
          
            
           for (int i=0; i<interfaces.IFRProduccion.modelo2.getRowCount();i++){
                s = interfaces.IFRProduccion.modelo2.getValueAt(i, 0).toString().trim();
                
                if(s.equals(datos[0].trim())){
                    contador=contador+1;
                }
               
                
            }
           
           
       
              if (contador==0){
                interfaces.IFRProduccion.modelo2.addRow(datos);
                addCombo(interfaces.IFRProduccion.tabla.getColumnModel().getColumn(2),interfaces.IFRProduccion.tabla);
                interfaces.IFRProduccion.stockInsumo.add(stock);
                
                }else {
                JOptionPane.showMessageDialog(this, "Insumo ya incluido", "Seleccione Otro insumo", 0);
                }
           
           
        
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "Ninguna fila seleccionada", "Seleccione una fila", 0);
        }
    }//GEN-LAST:event_btnagregarActionPerformed

    
       public void mostrarInsumo() {
        DefaultTableModel modelo = ClienteService.mostrarInsumos();
        tabla.setModel(modelo);
    }
    
        public void addcheckbox(int columna,JTable tabla){
            TableColumn tc =  tabla.getColumnModel().getColumn(columna);
            tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
            tc.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
            
    }
        
       
        
        
        public void addCombo(TableColumn columna,JTable tabla){
            //TableColumn tc =  tabla.getColumnModel().getColumn(columna);
            //tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
            //tc.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
            JComboBox c= new JComboBox();
            c.addItem("2");
            c.addItem("4");
            c.addItem("6");
            c.addItem("8");
            c.addItem("10");
            c.addItem("12");
            c.addItem("14");
            c.addItem("16");
            c.addItem("18");
            c.addItem("20");
            
            columna.setCellEditor( new DefaultCellEditor(c));
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setToolTipText("seleccione");
            columna.setCellRenderer(render);
            
            
    }
       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
