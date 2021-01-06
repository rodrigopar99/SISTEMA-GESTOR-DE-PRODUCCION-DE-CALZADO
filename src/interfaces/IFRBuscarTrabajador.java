/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import datos.ClienteService;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author Michaell
 */
public class IFRBuscarTrabajador extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFRBuscarTrabajador
     */
    
    
    
   
    public IFRBuscarTrabajador() {
        initComponents();
        mostrarTrabajador();
        tabla.getTableHeader().setReorderingAllowed(false) ;
        
       
    //mostrarTrabajador2("ssk");
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
        btnagregar = new javax.swing.JButton();

        setClosable(true);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(btnagregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnagregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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
        if(fila>=0){
            //falta eliminar  un armador, perfilador,alistador, cortador.
            if (getTitle().equals("Cortador")){
            interfaces.IFRProduccion.agregarDatosLista(interfaces.IFRProduccion.modeloListaCortador,String.valueOf(tabla.getValueAt(fila, 0)),interfaces.IFRProduccion.jcortador, "cortador");
            dispose();
            }else if (getTitle().equals("Perfilador")){
            interfaces.IFRProduccion.agregarDatosLista(interfaces.IFRProduccion.modeloListaPerfilador,String.valueOf(tabla.getValueAt(fila, 0)),interfaces.IFRProduccion.jperfilador,"perfilador");
            dispose();
            } else if (getTitle().equals("Alistador")){
           interfaces.IFRProduccion.agregarDatosLista(interfaces.IFRProduccion.modeloListaAlistador,String.valueOf(tabla.getValueAt(fila, 0)),interfaces.IFRProduccion.jalistador,"alistador");
            dispose();
            }else if(getTitle().equals("Armador")){
            interfaces.IFRProduccion.agregarDatosLista(interfaces.IFRProduccion.modeloListaArmador,String.valueOf(tabla.getValueAt(fila, 0)),interfaces.IFRProduccion.jarmador,"armador");
            dispose();
            }
            
            
            
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Ninguna fila seleccionada", "Seleccione una fila", 0);
        }
    }//GEN-LAST:event_btnagregarActionPerformed

    
      public void mostrarTrabajador() {
        
                System.out.println(IFRProduccion.verificar);
          
              if(IFRProduccion.verificar==1){
               DefaultTableModel modelo = ClienteService.mostrarTrabajador2("Cortador");
                tabla.setModel(modelo);
              }
              if (IFRProduccion.verificar==2){
              
              DefaultTableModel modelo = ClienteService.mostrarTrabajador2("Perfilador");
                tabla.setModel(modelo);
              } 
              if(IFRProduccion.verificar==3){
               DefaultTableModel modelo = ClienteService.mostrarTrabajador2("Armador");
                tabla.setModel(modelo);
              } 
               if(IFRProduccion.verificar==4){
               DefaultTableModel modelo = ClienteService.mostrarTrabajador2("Alistador");
                tabla.setModel(modelo);
              }
        
       
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    public static javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}