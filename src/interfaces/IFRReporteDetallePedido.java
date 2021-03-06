/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import datos.ClienteService;
import static interfaces.IFRReporteCliente.crearConexion;
import static interfaces.IFRReporteCliente.impirmirReporte;
import java.security.Principal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Michaell
 */
public class IFRReporteDetallePedido extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFRReporteDetallePedido
     */
    
    private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("Dapp202020PU");
    private static EntityManager em;
    HashMap parametros;
    Connection conn;
    
    public IFRReporteDetallePedido() {
        initComponents();
        
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
        txtidpedido = new javax.swing.JTextField();
        txtfechapedido = new javax.swing.JTextField();
        txtestadopedido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnreportedellatepedido = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        txtidpedido.setEnabled(false);

        txtfechapedido.setEnabled(false);

        txtestadopedido.setEnabled(false);
        txtestadopedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtestadopedidoActionPerformed(evt);
            }
        });

        jLabel1.setText("PEDIDO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtidpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfechapedido, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtestadopedido, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidpedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfechapedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtestadopedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnreportedellatepedido.setText("Report");
        btnreportedellatepedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreportedellatepedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(btnreportedellatepedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnreportedellatepedido, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnreportedellatepedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreportedellatepedidoActionPerformed
   int fila=tabla.getRowCount();
   if (fila>0){
        parametros= new HashMap();
        try {
            crearConexion();
            em.getTransaction().begin();
            parametros.put("IDPEDIDO", txtidpedido.getText());
            conn=em.unwrap(java.sql.Connection.class);
            impirmirReporte("ReporteDetallePedido.jasper",parametros,conn);
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            
             Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }else {
        JOptionPane.showMessageDialog(null,"No hay datos");
   
   }
    }//GEN-LAST:event_btnreportedellatepedidoActionPerformed

    private void txtestadopedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtestadopedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtestadopedidoActionPerformed
        public static  void mostrarDetallePedido(String idPedido) {
        DefaultTableModel modelo = ClienteService. mostrarDetallePedidoConEstado(idPedido);
        tabla.setModel(modelo);
       }

             public static EntityManager crearConexion(){
        return em=emf.createEntityManager();
       }  
          
        
        public static void impirmirReporte(String reporte, Map parametros, Connection conn){
            try {
                JasperReport jr= (JasperReport)JRLoader.loadObject(Principal.class.getResource("/reportes/" + reporte));
                JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conn);
                
                
                JasperViewer jv= new JasperViewer(jp, false);
                jv.setVisible(true);
            } catch (JRException ex ) {
                Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnreportedellatepedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabla;
    public static javax.swing.JTextField txtestadopedido;
    public static javax.swing.JTextField txtfechapedido;
    public static javax.swing.JTextField txtidpedido;
    // End of variables declaration//GEN-END:variables
}
