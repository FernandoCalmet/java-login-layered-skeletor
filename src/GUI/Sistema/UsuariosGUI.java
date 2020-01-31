package GUI.Sistema;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Entidad.UsuarioEntidad;
import Servicio.UsuarioServicio;
import Interface.IGUIBase;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class UsuariosGUI extends javax.swing.JPanel implements IGUIBase
{    
    private UsuarioEntidad usuario;
    private UsuarioServicio servicio;   
    private String [] columnas = {"Id", "Correo", "Clave", "Nombre", "Id Rol", "Rol"};
    private ArrayList<Object[]> listaDatos;   
    private DefaultTableModel tablaDatos;   
    private TableRowSorter filtroDatos;
    private ButtonGroup buttonGroupFiltro;

    public UsuariosGUI() 
    {
        this.usuario = new UsuarioEntidad();
        this.servicio = new UsuarioServicio(); 
        this.listaDatos = new ArrayList<>(); 
        this.tablaDatos = new DefaultTableModel(columnas, 0);
        this.buttonGroupFiltro = new ButtonGroup();
        initComponents();
        cargarDatos();  
        bloquearBotones();
        cargarGrupoRadioBotones();
    }
      
    @Override
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
    }
    
    @Override
    public void seleccionarDatos()
    {
        this.txtId.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 0)));
        this.txtCorreo.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 1)));
        this.txtClave.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 2)));
        this.txtNombre.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 3)));
        this.txtIdRol.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 4)));
        this.txtNombreRol.setText(String.valueOf(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 5)));
        this.btnCrear.setEnabled(false);
    }
    
    @Override
    public void limpiarSeleccion()
    {
        this.txtId.setText(null);
        this.txtCorreo.setText(null);
        this.txtClave.setText(null);
        this.txtNombre.setText(null);        
        this.txtIdRol.setText(null);
        this.txtNombreRol.setText(null);
        this.btnCrear.setEnabled(true);
    }
    
    @Override
    public void bloquearCampos()
    {
        this.txtNombre.enable(false);
        this.txtCorreo.enable(false);
        this.txtClave.enable(false);
        this.txtNombre.enable(false);
        this.txtIdRol.enable(false);
    }
    
    @Override
    public void desbloquearCampos()
    {
        this.txtNombre.enable(true);
        this.txtCorreo.enable(true);
        this.txtClave.enable(true);
        this.txtNombre.enable(true);
        this.txtIdRol.enable(true);
    }
    
    @Override
    public void bloquearBotones()
    {
        this.btnModificar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnLimpiar.setEnabled(false);
    }
    
    @Override
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
        else if(jRadioButtonCorreo.isSelected())
        {
            int columna = 1;
            filtroDatos.setRowFilter(RowFilter.regexFilter(filtro, columna));
        }
        else if(jRadioButtonNombre.isSelected())
        {
            int columna = 3;
            filtroDatos.setRowFilter(RowFilter.regexFilter(filtro, columna));
        }  
        else if(jRadioButtonIdRol.isSelected())
        {
            int columna = 4;
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
        buttonGroupFiltro.add(jRadioButtonCorreo);
        buttonGroupFiltro.add(jRadioButtonNombre);
        buttonGroupFiltro.add(jRadioButtonIdRol);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        lblClave = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblIdRol = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        jLabelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtIdRol = new javax.swing.JTextField();
        txtNombreRol = new javax.swing.JTextField();
        jLabelFiltro = new javax.swing.JLabel();
        jRadioButtonId = new javax.swing.JRadioButton();
        jRadioButtonNombre = new javax.swing.JRadioButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabelBuscar = new javax.swing.JLabel();
        jRadioButtonIdRol = new javax.swing.JRadioButton();
        jRadioButtonCorreo = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblId.setText("ID");

        lblCorreo.setText("Correo");

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

        lblClave.setText("Contraseña");

        lblNombre.setText("Nombre");

        lblIdRol.setText("Rol");

        jLabelTitulo.setText("Usuarios");

        jLabelFiltro.setText("Filtrar resultados por:");

        jRadioButtonId.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonId.setText("Id");

        jRadioButtonNombre.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonNombre.setText("Nombre");

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });

        jLabelBuscar.setText("Buscar");

        jRadioButtonIdRol.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonIdRol.setText("Id Rol");

        jRadioButtonCorreo.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonCorreo.setText("Correo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(lblCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdRol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId)
                            .addComponent(txtCorreo)
                            .addComponent(txtClave)
                            .addComponent(txtNombre)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreRol))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                                .addComponent(jRadioButtonNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonCorreo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonIdRol)))
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
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClave)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdRol)
                    .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonId)
                    .addComponent(jRadioButtonNombre)
                    .addComponent(jRadioButtonIdRol)
                    .addComponent(jRadioButtonCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseClicked
        usuario.setCorreo(this.txtCorreo.getText());
        usuario.setClave(this.txtClave.getText());
        usuario.setNombre(this.txtNombre.getText());
        usuario.setId_rol(Integer.parseInt(this.txtIdRol.getText()));
        if(servicio.Crear(usuario) == true)
        {
            cargarDatos();
            limpiarSeleccion();
        } 
    }//GEN-LAST:event_btnCrearMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        usuario.setId(Integer.parseInt(this.txtId.getText()));
        usuario.setCorreo(this.txtCorreo.getText());
        usuario.setClave(this.txtClave.getText());
        usuario.setNombre(this.txtNombre.getText());
        usuario.setId_rol(Integer.parseInt(this.txtIdRol.getText()));
        if(servicio.Modificar(usuario) == true)
        {
            cargarDatos();
            limpiarSeleccion();
            bloquearCampos();
            bloquearBotones();
        } 
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        usuario.setId(Integer.parseInt(this.txtId.getText()));
        if(servicio.Eliminar(usuario) == true)
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
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JRadioButton jRadioButtonCorreo;
    private javax.swing.JRadioButton jRadioButtonId;
    private javax.swing.JRadioButton jRadioButtonIdRol;
    private javax.swing.JRadioButton jRadioButtonNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdRol;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblDatos;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdRol;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreRol;
    // End of variables declaration//GEN-END:variables
}