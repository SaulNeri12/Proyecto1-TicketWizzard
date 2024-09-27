/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.equipo7.proyecto1.ticketwizzard.dtos.BoletoDTO;
import com.equipo7.proyecto1.ticketwizzard.dtos.EventoDTO;
import com.equipo7.proyecto1.ticketwizzard.dtos.TransaccionDTO;
import com.equipo7.proyecto1.ticketwizzard.dtos.UsuarioDTO;
import com.equipo7.proyecto1.ticketwizzard.excepciones.GestorException;
import com.equipo7.proyecto1.ticketwizzard.gestores.GestorEventos;
import com.equipo7.proyecto1.ticketwizzard.gestores.GestorTransacciones;
import com.equipo7.proyecto1.ticketwizzard.gestores.GestorUsuarios;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorEventos;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorTransacciones;
import com.equipo7.proyecto1.ticketwizzard.interfaces.gestores.IGestorUsuarios;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author neri
 */
public class frmMiHistorial extends javax.swing.JFrame {

    private IGestorEventos gestorEventos;
    private IGestorTransacciones transacciones;
    private IGestorUsuarios usuarios;
    private UsuarioDTO usuario;

    public frmMiHistorial(UsuarioDTO usuario) {
        this.usuario = usuario;
        this.transacciones = GestorTransacciones.getInstance();
        this.gestorEventos = GestorEventos.getInstance();
        this.usuarios = GestorUsuarios.getInstance();
        initComponents();
        this.setLocationRelativeTo(null);

        inicializarComponentes();
        cargarTransacciones();
    }

    private void inicializarComponentes() {
        lblUsuarioName.setText(usuario.getNombreCompleto());

        String[] columnNames = {"ID", "Fecha", "Vendedor", "Comprador", "Boleto", "Evento", "Monto", "Estado", "Tipo"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblTransacciones.setModel(model);

        btnPagar.setEnabled(false);

        tblTransacciones.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblTransacciones.getSelectedRow();
                if (selectedRow != -1) {
                    String estado = tblTransacciones.getValueAt(selectedRow, 7).toString();
                    if ("en espera".equalsIgnoreCase(estado)) {
                        btnPagar.setEnabled(true);
                    } else {
                        btnPagar.setEnabled(false);
                    }
                }
            }
        });

        btnPagar.addActionListener(evt -> realizarCompra());
    }

    private void cargarTransacciones() {
        try {
            List<TransaccionDTO> listaTransacciones = transacciones.obtenerTransaccionesUsuario(usuario.getId());
            DefaultTableModel model = (DefaultTableModel) tblTransacciones.getModel();
            model.setRowCount(0);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (TransaccionDTO transaccion : listaTransacciones) {
                String nombreEvento = "N/A";
                String idBoleto = "N/A";

                if (transaccion.getBoleto() != null) {
                    idBoleto = transaccion.getBoleto().getId().toString();

                    Integer idEvento = transaccion.getBoleto().getIdEvento();
                    if (idEvento != null) {
                        try {
                            EventoDTO evento = gestorEventos.obtenerEvento(idEvento);
                            if (evento != null) {
                                nombreEvento = evento.getNombre();
                            }
                        } catch (GestorException ex) {
                            System.err.println("Error al obtener el evento: " + ex.getMessage());
                        }
                    }
                }

                model.addRow(new Object[]{
                    transaccion.getId().toString(),
                    dateFormat.format(transaccion.getFechaHora()),
                    transaccion.getVendedor() != null ? transaccion.getVendedor().getNombreCompleto() : "N/A",
                    transaccion.getComprador() != null ? transaccion.getComprador().getNombreCompleto() : "N/A",
                    idBoleto,
                    nombreEvento,
                    transaccion.getMonto(),
                    transaccion.getEstado(),
                    transaccion.getTipoTransaccion()
                });
            }
        } catch (GestorException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar las transacciones: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void realizarCompra() {
        
        try {
            int selectedRow = tblTransacciones.getSelectedRow();
            if (selectedRow != -1) {

                Integer idTransaccion = Integer.valueOf(tblTransacciones.getValueAt(selectedRow, 0).toString());
                
                if (idTransaccion == null) {
                    throw new GestorException("Selecciona una fila correcta");
                }
                
                TransaccionDTO pago = this.transacciones.obtenerTransaccion(idTransaccion);
                
                this.transacciones.actualizarTransaccion(pago);
            }
        } catch (GestorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        lblUsuarioName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransacciones = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblUsuarioName.setFont(new java.awt.Font("Segoe UI Historic", 3, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(lblUsuarioName, "Nombre"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 3, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "Tu historial de Movimientos"); // NOI18N

        tblTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "fecha", "vendedor", "comprador", "boleto", "evento", "monto", "Estado", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(tblTransacciones);
        if (tblTransacciones.getColumnModel().getColumnCount() > 0) {
            tblTransacciones.getColumnModel().getColumn(0).setHeaderValue("Fecha"); // NOI18N
            tblTransacciones.getColumnModel().getColumn(1).setHeaderValue("Vendedor"); // NOI18N
            tblTransacciones.getColumnModel().getColumn(2).setHeaderValue("Comprador"); // NOI18N
            tblTransacciones.getColumnModel().getColumn(3).setHeaderValue("Boleto"); // NOI18N
            tblTransacciones.getColumnModel().getColumn(4).setHeaderValue("Evento"); // NOI18N
            tblTransacciones.getColumnModel().getColumn(5).setHeaderValue("Monto"); // NOI18N
            tblTransacciones.getColumnModel().getColumn(6).setHeaderValue("Estado"); // NOI18N
            tblTransacciones.getColumnModel().getColumn(7).setHeaderValue("Tipo"); // NOI18N
        }

        org.openide.awt.Mnemonics.setLocalizedText(btnAtras, "Volver"); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnPagar, "Pagar"); // NOI18N
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsuarioName)
                        .addGap(256, 256, 256))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAtras)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(160, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(141, 141, 141)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuarioName)
                    .addComponent(btnPagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel2)
                    .addContainerGap(297, Short.MAX_VALUE)))
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

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // Creamos el nuevo frame
        frmTusBoletos reg = new frmTusBoletos(usuario);

        // Mostramos el nuevo frame
        reg.setVisible(true);

        // Ocultamos la ventana actual en lugar de cerrarla
        this.setVisible(false);
        
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnPagar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuarioName;
    private javax.swing.JTable tblTransacciones;
    // End of variables declaration//GEN-END:variables
}
