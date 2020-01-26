package GUI;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.UsuarioEntidad;
import Servicio.AccesoServicio;

public class AccesoGUI extends javax.swing.JFrame 
{    
    private UsuarioEntidad usuario = new UsuarioEntidad();  
    private AccesoServicio acceso = new AccesoServicio();

    public AccesoGUI() 
    {       
        initComponents();
        this.setResizable(false);
        this.setTitle("Acceso de Usuario");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        JLabelCorreo = new javax.swing.JLabel();
        JTextCorreo = new javax.swing.JTextField();
        JLabelClave = new javax.swing.JLabel();
        JTextClave = new javax.swing.JPasswordField();
        JButtonLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));

        JLabelCorreo.setText("Correo");

        JLabelClave.setText("Contraseña");

        JButtonLogin.setText("Iniciar Sesión");
        JButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonLoginActionPerformed(evt);
            }
        });

        jLabel1.setText("Autenticacion de datos");

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLabelClave, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(JLabelCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTextCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(JTextClave)))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(0, 185, Short.MAX_VALUE)
                        .addComponent(JButtonLogin))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFondoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabelCorreo)
                    .addComponent(JTextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabelClave)
                    .addComponent(JTextClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JButtonLogin)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonLoginActionPerformed
        usuario.setCorreo(this.JTextCorreo.getText());
        usuario.setClave(this.JTextClave.getText());        
        if(acceso.Login(usuario).getId() > 0)
        {
            new GUI.PrincipalGUI(usuario).setVisible(true);
            this.setVisible(false);            
        }        
    }//GEN-LAST:event_JButtonLoginActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonLogin;
    private javax.swing.JLabel JLabelClave;
    private javax.swing.JLabel JLabelCorreo;
    private javax.swing.JPasswordField JTextClave;
    private javax.swing.JTextField JTextCorreo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}