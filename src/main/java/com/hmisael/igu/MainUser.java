package com.hmisael.igu;

import com.hmisael.logica.Controladora;
import com.hmisael.logica.Usuario;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hernán Misael
 */
public class MainUser extends javax.swing.JFrame {

    Controladora control;
    Usuario usuario;
    
    public MainUser(Controladora control, Usuario usuario) {
        initComponents();
        this.control = control;
        this.usuario = usuario;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        btnRecargarTablaUser = new javax.swing.JButton();
        btnSalirUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbUsuarios);

        btnRecargarTablaUser.setText("Recargar Tabla");
        btnRecargarTablaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarTablaUserActionPerformed(evt);
            }
        });

        btnSalirUser.setText("Salir");
        btnSalirUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirUserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("BIENVENIDO AL SISTEMA");

        jLabel2.setText("Usuario:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnRecargarTablaUser)
                    .addComponent(btnSalirUser, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRecargarTablaUser)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalirUser))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jLabel2.setText("Usuario: "+usuario.getNombre());
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnSalirUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirUserActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirUserActionPerformed

    private void btnRecargarTablaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarTablaUserActionPerformed
         cargarTabla();
    }//GEN-LAST:event_btnRecargarTablaUserActionPerformed

    private void cargarTabla() {
        
        //Crear modelo
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        //Declarar columnas
        String titulos[] = {"Id", "Usuario", "Rol"};
        modelo.setColumnIdentifiers(titulos);
        
        
        //Cargar usuarios de la BD a una lista Usuario
        List<Usuario> listaUsuarios = control.traerUsuarios();
        
        if(listaUsuarios != null){
            //recorrer usuarios
            for (Usuario usu : listaUsuarios){
                Object[] objeto = {usu.getId(), usu.getNombre(), usu.getUnRol().getNombre()};
                modelo.addRow(objeto);
            }
        }
        
        //Asignar modelo a tabla
        tbUsuarios.setModel(modelo);
    }
    
     public void mostrarMensaje (String mensaje, String tipo, String titulo){
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("INFO")){
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        else if(tipo.equals("ERROR")){
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRecargarTablaUser;
    private javax.swing.JButton btnSalirUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbUsuarios;
    // End of variables declaration//GEN-END:variables
}
