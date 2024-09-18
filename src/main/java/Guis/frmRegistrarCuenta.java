/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Guis;

import com.equipo7.proyecto1.ticketwizzard.conexion.Conexion;
import com.equipo7.proyecto1.ticketwizzard.dao.UsuariosDAO;
import com.equipo7.proyecto1.ticketwizzard.dtos.UsuarioDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.DAOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author caarl
 */
public class frmRegistrarCuenta extends javax.swing.JFrame {

    /**
     * Creates new form frmRegistrarCuenta
     */
    
    public frmRegistrarCuenta( ) {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PasswordFieldConfirmarContra = new javax.swing.JPasswordField();
        PasswordFieldContra = new javax.swing.JPasswordField();
        chbxTerminosYCondiciones = new javax.swing.JCheckBox();
        btnRegistrarUsu = new javax.swing.JButton();
        btnVolverInicioSesion = new javax.swing.JButton();

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicketWizzard - Registrarse");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Registrar Cuenta");

        jLabel2.setText("Nombre Completo:");

        txtNombre.setBackground(new java.awt.Color(204, 204, 204));

        txtCorreo.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setText("Correo Electronico:");

        jLabel3.setText("Fecha de nacimiento:");

        txtFechaNac.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setText("Domicilio:");

        txtDomicilio.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setText("Contraseña:");

        jLabel8.setText("Confirmar Contraseña:");

        PasswordFieldConfirmarContra.setBackground(new java.awt.Color(204, 204, 204));

        PasswordFieldContra.setBackground(new java.awt.Color(204, 204, 204));

        chbxTerminosYCondiciones.setText("Acepto los terminos y condiciones");
        chbxTerminosYCondiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxTerminosYCondicionesActionPerformed(evt);
            }
        });

        btnRegistrarUsu.setText("Registrarme");
        btnRegistrarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuActionPerformed(evt);
            }
        });

        btnVolverInicioSesion.setText("Atras");
        btnVolverInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverInicioSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnVolverInicioSesion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(PasswordFieldContra)
                                            .addComponent(PasswordFieldConfirmarContra, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(11, 11, 11)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(chbxTerminosYCondiciones)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(btnRegistrarUsu)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordFieldContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordFieldConfirmarContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chbxTerminosYCondiciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarUsu)
                    .addComponent(btnVolverInicioSesion))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chbxTerminosYCondicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxTerminosYCondicionesActionPerformed
        btnRegistrarUsu.setEnabled(chbxTerminosYCondiciones.isSelected());
    }//GEN-LAST:event_chbxTerminosYCondicionesActionPerformed

    private void btnRegistrarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuActionPerformed
     // Verificar que todos los campos estén llenos
    if (txtNombre.getText().isEmpty() || txtCorreo.getText().isEmpty() || 
        txtDomicilio.getText().isEmpty() || txtFechaNac.getText().isEmpty() || 
        PasswordFieldContra.getPassword().length == 0 || 
        PasswordFieldConfirmarContra.getPassword().length == 0) {
        
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Verificar que las contraseñas coincidan
    if (!Arrays.equals(PasswordFieldContra.getPassword(), PasswordFieldConfirmarContra.getPassword())) {
        JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Verificar que se hayan aceptado los términos y condiciones
    if (!chbxTerminosYCondiciones.isSelected()) {
        JOptionPane.showMessageDialog(this, "Debe aceptar los términos y condiciones", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

     try {
        // Crear un nuevo UsuarioDTO con los datos del formulario
        UsuarioDTO nuevoUsuario = new UsuarioDTO();
        nuevoUsuario.setNombreCompleto(txtNombre.getText());
        nuevoUsuario.setEmail(txtCorreo.getText());
        nuevoUsuario.setDomicilio(txtDomicilio.getText());
        nuevoUsuario.setFechaNacimiento(Date.valueOf(txtFechaNac.getText()));

        // Encriptar la contraseña
        String contraseñaPlana = new String(PasswordFieldContra.getPassword());
        String contraseñaEncriptada = BCrypt.hashpw(contraseñaPlana, BCrypt.gensalt());
        nuevoUsuario.setContrasena(contraseñaEncriptada);
        
        // Calcular la edad
        LocalDate fechaNac = nuevoUsuario.getFechaNacimiento().toLocalDate();
        LocalDate ahora = LocalDate.now();
        int edad = Period.between(fechaNac, ahora).getYears();
        nuevoUsuario.setEdad(edad);

        // Establecer un saldo inicial
        nuevoUsuario.setSaldo(0.0f);

        // Crear una instancia de UsuariosDAO y agregar el usuario
        Conexion conexion = new Conexion();
        UsuariosDAO usuariosDAO = new UsuariosDAO(conexion);
        usuariosDAO.agregarUsuario(nuevoUsuario);

        JOptionPane.showMessageDialog(this, "Usuario registrado con éxito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

        // Abrir la ventana de inicio de sesión y cerrar la actual
        frmInicioSesion inicioSesion = new frmInicioSesion();
        inicioSesion.setVisible(true);
        this.dispose();

    } catch (DAOException e) {
        JOptionPane.showMessageDialog(this, "Error al registrar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Use YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnRegistrarUsuActionPerformed

    private void btnVolverInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverInicioSesionActionPerformed
       // Creamos el nuevo frame
        frmInicioSesion reg = new frmInicioSesion();

        // Mostramos el nuevo frame
        reg.setVisible(true);

        // Ocultamos la ventana actual en lugar de cerrarla
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverInicioSesionActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordFieldConfirmarContra;
    private javax.swing.JPasswordField PasswordFieldContra;
    private javax.swing.JButton btnRegistrarUsu;
    private javax.swing.JButton btnVolverInicioSesion;
    private javax.swing.JCheckBox chbxTerminosYCondiciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
