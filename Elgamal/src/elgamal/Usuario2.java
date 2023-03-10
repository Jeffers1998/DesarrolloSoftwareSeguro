/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elgamal;

/**
 *
 * @author LuisEduardoLeyvaHerrera
 */
public class Usuario2 extends javax.swing.JFrame {
    public String mensaje;
    /**
     * Creates new form Usuario2
     */
    public Usuario2() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        JTAMensajes = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTFMensaje = new javax.swing.JTextField();
        jBtnEnviarM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JTAMensajes.setEditable(false);
        JTAMensajes.setColumns(20);
        JTAMensajes.setRows(5);
        jScrollPane1.setViewportView(JTAMensajes);

        jLabel1.setText("Mensaje");

        jTFMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFMensajeActionPerformed(evt);
            }
        });

        jBtnEnviarM.setText("Enviar");
        jBtnEnviarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEnviarMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnEnviarM, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEnviarM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnEnviarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEnviarMActionPerformed
         // Se crea una instancia del objeto AlgoritmoElGamal
    AlgoritmoElGamal aeg = new AlgoritmoElGamal();
    // Se obtiene el mensaje a cifrar del campo de texto correspondiente
    mensaje = jTFMensaje.getText();
    // Se cifra el mensaje usando el algoritmo ElGamal
    mensaje = aeg.bigEncrypt(mensaje);
    // Se crea una instancia de la ventana del usuario 1
    Usuario1 u1 = new Usuario1();
    // Se hace visible la ventana del usuario 1
    u1.setVisible(true);
    // Se agrega el mensaje cifrado al campo de texto correspondiente de la ventana del usuario 1
    u1.jTAMensaje.append(mensaje);
   

    }//GEN-LAST:event_jBtnEnviarMActionPerformed

    private void jTFMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFMensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFMensajeActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea JTAMensajes;
    private javax.swing.JButton jBtnEnviarM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFMensaje;
    // End of variables declaration//GEN-END:variables
}
