package GUI.Sistema;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Entidad.PermisoEntidad;
import Servicio.PermisoServicio;
import Interface.IGUIBase;

public class PermisosGUI extends javax.swing.JPanel implements IGUIBase
{    
    private PermisoEntidad permiso = new PermisoEntidad();
    private PermisoServicio servicio = new PermisoServicio();
    private String [] columnas = {"Id Permiso", "Id Rol", "Rol", "Id Operación", "Operación"};
    private ArrayList<Object[]> listaDatos = new ArrayList<>();
    private DefaultTableModel tablaDatos = new DefaultTableModel(columnas, 0);

    public PermisosGUI() 
    {
        initComponents();
        cargarDatos();
        bloquearBotones();
    }
    
    public void cargarDatos()
    {
        tablaDatos.setRowCount(0);
        listaDatos = servicio.ListarTodos();
        for(Object[] obj : listaDatos)
        {
            tablaDatos.addRow(obj);
        }
        this.tblDatos.setModel(tablaDatos);
        this.txtId.enable(false);
        this.txtNombreRol.enable(false);
        this.txtNombreOperacion.enable(false);
    }
    
    public void seleccionarDatos()
    {
        this.txtId.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 0)));
        this.txtIdRol.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 1)));
        this.txtNombreRol.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 2)));
        this.txtIdOperacion.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 3)));
        this.txtNombreOperacion.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 4)));
        this.btnCrear.setEnabled(false);
    }
    
    public void limpiarSeleccion()
    {
        this.txtId.setText(null);
        this.txtIdRol.setText(null);
        this.txtNombreRol.setText(null);
        this.txtIdOperacion.setText(null);
        this.txtNombreOperacion.setText(null);
        this.btnCrear.setEnabled(true);
    }
    
    public void bloquearCampos()
    {
        this.txtIdRol.enable(false);
        this.txtIdOperacion.enable(false);
    }
    
    public void desbloquearCampos()
    {
        this.txtIdRol.enable(true);
        this.txtIdOperacion.enable(true);
    }
    
    public void bloquearBotones()
    {
        this.btnModificar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnLimpiar.setEnabled(false);
    }
    
    public void desbloquearBotones()
    {
        this.btnModificar.setEnabled(true);
        this.btnEliminar.setEnabled(true);
        this.btnLimpiar.setEnabled(true);
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
        lblIdRol = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtIdRol = new javax.swing.JTextField();
        lblIdOperacion = new javax.swing.JLabel();
        txtIdOperacion = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNombreRol = new javax.swing.JTextField();
        txtNombreOperacion = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        btnCrear.setText("Agregar");
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        lblId.setText("ID");

        lblIdRol.setText("ID Rol");

        lblIdOperacion.setText("ID Operacion");

        jLabelTitulo.setText("Permisos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addGap(0, 338, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreRol, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIdRol)
                            .addComponent(txtId)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIdOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreOperacion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIdOperacion)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdRol)
                    .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdOperacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseClicked
        permiso.setId_rol(Integer.parseInt(this.txtIdRol.getText()));
        permiso.setId_operacion(Integer.parseInt(this.txtIdOperacion.getText()));
        if(servicio.Crear(permiso) == true)
        {
            cargarDatos();
            limpiarSeleccion();
        } 
    }//GEN-LAST:event_btnCrearMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        permiso.setId(Integer.parseInt(this.txtId.getText()));
        permiso.setId_rol(Integer.parseInt(this.txtIdRol.getText()));
        permiso.setId_operacion(Integer.parseInt(this.txtIdOperacion.getText()));
        if(servicio.Modificar(permiso) == true)
        {
            cargarDatos();
            limpiarSeleccion();
            bloquearCampos();
            bloquearBotones();
        } 
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        permiso.setId(Integer.parseInt(this.txtId.getText()));
        if(servicio.Eliminar(permiso) == true)
        {
            cargarDatos();
            limpiarSeleccion();
            bloquearCampos();
            bloquearBotones();
        } 
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiarSeleccion();
        desbloquearCampos();
        bloquearBotones();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        seleccionarDatos();
        desbloquearCampos();
        desbloquearBotones();
    }//GEN-LAST:event_tblDatosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdOperacion;
    private javax.swing.JLabel lblIdRol;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdOperacion;
    private javax.swing.JTextField txtIdRol;
    private javax.swing.JTextField txtNombreOperacion;
    private javax.swing.JTextField txtNombreRol;
    // End of variables declaration//GEN-END:variables
}