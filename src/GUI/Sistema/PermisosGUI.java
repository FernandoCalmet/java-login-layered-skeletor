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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class PermisosGUI extends javax.swing.JPanel implements IGUIBase
{    
    private PermisoEntidad permiso = new PermisoEntidad();
    private PermisoServicio servicio = new PermisoServicio();
    private String [] columnas = {"Id Permiso", "Id Rol", "Rol", "Id Operación", "Operación"};
    private ArrayList<Object[]> listaDatos = new ArrayList<>();
    private DefaultTableModel tablaDatos = new DefaultTableModel(columnas, 0);
    private TableRowSorter filtroDatos;
    private ButtonGroup buttonGroupFiltro = new ButtonGroup();

    public PermisosGUI() 
    {
        initComponents();
        cargarDatos();
        bloquearBotones();
        cargarGrupoRadioBotones();        
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
        this.jTextFieldId.enable(false);
        this.txtNombreRol.enable(false);
        this.txtNombreOperacion.enable(false);
    }
    
    public void seleccionarDatos()
    {
        this.jTextFieldId.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 0)));
        this.txtIdRol.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 1)));
        this.txtNombreRol.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 2)));
        this.txtIdOperacion.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 3)));
        this.txtNombreOperacion.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 4)));
        this.btnCrear.setEnabled(false);
    }
    
    public void limpiarSeleccion()
    {
        this.jTextFieldId.setText(null);
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
    
    @Override
    public void filtroBusqueda()
    {
        String filtro = jTextFieldBuscar.getText();
        if(jRadioButtonId.isSelected())
        {
            int columna = 0;
            filtroDatos.setRowFilter(RowFilter.regexFilter(filtro, columna));
        }
        else if(jRadioButtonIdRol.isSelected())
        {
            int columna = 1;
            filtroDatos.setRowFilter(RowFilter.regexFilter(filtro, columna));
        }  
        else if(jRadioButtonIdOperacion.isSelected())
        {
            int columna = 3;
            filtroDatos.setRowFilter(RowFilter.regexFilter(filtro, columna));
        }  
    }
    
    @Override
    public void cargarFiltro()
    {
        filtroDatos = new TableRowSorter(tablaDatos);
        tblDatos.setRowSorter(filtroDatos);
    }
    
    @Override
    public void cargarGrupoRadioBotones()
    {
        buttonGroupFiltro.add(jRadioButtonId);
        buttonGroupFiltro.add(jRadioButtonIdRol);
        buttonGroupFiltro.add(jRadioButtonIdOperacion);
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
        jLabelId = new javax.swing.JLabel();
        jLabelRol = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        txtIdRol = new javax.swing.JTextField();
        lblIdOperacion = new javax.swing.JLabel();
        txtIdOperacion = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNombreRol = new javax.swing.JTextField();
        txtNombreOperacion = new javax.swing.JTextField();
        jLabelFiltro = new javax.swing.JLabel();
        jRadioButtonId = new javax.swing.JRadioButton();
        jRadioButtonIdRol = new javax.swing.JRadioButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabelBuscar = new javax.swing.JLabel();
        jRadioButtonIdOperacion = new javax.swing.JRadioButton();

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

        jLabelId.setText("ID");

        jLabelRol.setText("Rol");

        lblIdOperacion.setText("Operación");

        jLabelTitulo.setText("Permisos");

        jLabelFiltro.setText("Filtrar resultados por:");

        jRadioButtonId.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonId.setText("Id");

        jRadioButtonIdRol.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonIdRol.setText("Id Rol");

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });

        jLabelBuscar.setText("Buscar");

        jRadioButtonIdOperacion.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonIdOperacion.setText("Id Operación");

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
                        .addComponent(jLabelId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldId))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreRol))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIdOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreOperacion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelFiltro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonIdRol)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonIdOperacion)))
                        .addGap(0, 2, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelId)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRol)
                    .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdOperacion)
                    .addComponent(txtIdOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonId)
                    .addComponent(jRadioButtonIdRol)
                    .addComponent(jRadioButtonIdOperacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        permiso.setId(Integer.parseInt(this.jTextFieldId.getText()));
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
        permiso.setId(Integer.parseInt(this.jTextFieldId.getText()));
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

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        if(buttonGroupFiltro.getSelection() == null)
        {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Debes seleccionar una opcion de filtro");
        }
        else
        {
            jTextFieldBuscar.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(final KeyEvent e){
                    filtroBusqueda();
                }
            });
            cargarFiltro();
        }
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelRol;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JRadioButton jRadioButtonId;
    private javax.swing.JRadioButton jRadioButtonIdOperacion;
    private javax.swing.JRadioButton jRadioButtonIdRol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JLabel lblIdOperacion;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtIdOperacion;
    private javax.swing.JTextField txtIdRol;
    private javax.swing.JTextField txtNombreOperacion;
    private javax.swing.JTextField txtNombreRol;
    // End of variables declaration//GEN-END:variables
}