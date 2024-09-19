/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.equipo7.proyecto1.ticketwizzard.objetos.Usuario;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author caarl
 */
public class frmTicket extends javax.swing.JFrame {

    /**
     * Creates new form frmTicket
     */
    private final Usuario usuarioActual;  // Esta variable debe almacenar el usuario que inició sesión.

    public frmTicket(Usuario usuario) {
        this.usuarioActual = usuario;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void generarPDF() {
        String vendedor = txtVendedor.getText();
        String comprador = txtComprador.getText();
        String evento = txtEvento.getText();
        String cantidad = txtCantidad.getText();
        String total = txtTotal.getText();

        // Archivo PDF a generar
        Document document = new Document();
        String fileName = "TicketVenta.pdf";

        try {
            // Configuración para generar el PDF
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            // Título del ticket
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
            Paragraph title = new Paragraph("TICKET", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Separación con línea
            document.add(new Paragraph("\n"));
            document.add(new LineSeparator());

            // Información del vendedor y comprador
            Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            document.add(new Paragraph("Vendedor: " + vendedor, boldFont));
            document.add(new Paragraph("Comprador: " + comprador, boldFont));

            document.add(new Paragraph("\n"));  // Espaciado

            // Línea de separación
            document.add(new LineSeparator());

            // Información del evento
            document.add(new Paragraph("Evento: " + evento, boldFont));
            document.add(new Paragraph("Cantidad: " + cantidad, boldFont));
            document.add(new Paragraph("Total a Pagar: $" + total, boldFont));

            document.add(new Paragraph("\n"));  // Espaciado

            // Línea de separación
            document.add(new LineSeparator());

            // Mensaje de agradecimiento
            Font footerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC);
            Paragraph footer = new Paragraph("Gracias por su compra", footerFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(footer);

            // Agregar la fecha de emisión del ticket
            Paragraph fecha = new Paragraph("Fecha: " + LocalDate.now().toString(), footerFont);
            fecha.setAlignment(Element.ALIGN_CENTER);
            document.add(fecha);

            // Cierre del documento
            document.close();

            JOptionPane.showMessageDialog(this, "PDF generado con éxito. Ubicación: " + new File(fileName).getAbsolutePath(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
            abrirPDF(fileName);
        } catch (DocumentException de) {
            JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + de.getMessage(), "Error de Documento", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(this, "No se pudo encontrar el archivo para guardar el PDF: " + fnfe.getMessage(), "Error de Archivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirPDF(String fileName) {
        try {
            File pdfFile = new File(fileName);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "La apertura automática no está soportada en este sistema.\n"
                            + "Por favor, abra el archivo manualmente: " + pdfFile.getAbsolutePath(),
                            "No se puede abrir automáticamente",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "El archivo PDF generado no existe en la ubicación esperada.",
                        "Archivo No Encontrado",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al abrir el archivo PDF: " + ex.getMessage(),
                    "Error de IO",
                    JOptionPane.ERROR_MESSAGE);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEvento = new javax.swing.JTextField();
        txtComprador = new javax.swing.JTextField();
        txtVendedor = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        btnImCom = new javax.swing.JButton();
        btnVolverTusBoletos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicketWizzard - Ticket");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Ticket");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("Comprador");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("Vendedor");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setText("Evento");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setText("Cantidad");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setText("Total");

        txtEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEventoActionPerformed(evt);
            }
        });

        txtComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompradorActionPerformed(evt);
            }
        });

        txtVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendedorActionPerformed(evt);
            }
        });

        btnImCom.setText("Imprimir Comprobante");
        btnImCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImComActionPerformed(evt);
            }
        });

        btnVolverTusBoletos.setText("Salir");
        btnVolverTusBoletos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverTusBoletosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(txtEvento)
                                .addComponent(txtComprador)
                                .addComponent(txtVendedor)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnVolverTusBoletos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImCom)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(txtComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImCom)
                    .addComponent(btnVolverTusBoletos))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendedorActionPerformed

    private void txtCompradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompradorActionPerformed
    }//GEN-LAST:event_txtCompradorActionPerformed

    private void txtEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEventoActionPerformed

    private void btnVolverTusBoletosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverTusBoletosActionPerformed
        // Creamos el nuevo frame
        frmTusBoletos reg = new frmTusBoletos(usuarioActual);

        // Mostramos el nuevo frame
        reg.setVisible(true);

        // Ocultamos la ventana actual en lugar de cerrarla
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverTusBoletosActionPerformed

    private void btnImComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImComActionPerformed
        generarPDF();
    }//GEN-LAST:event_btnImComActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImCom;
    private javax.swing.JButton btnVolverTusBoletos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtComprador;
    private javax.swing.JTextField txtEvento;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
