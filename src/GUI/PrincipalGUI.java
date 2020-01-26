package GUI;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Entidad.UsuarioEntidad;
import GUI.Archivo.*;
import GUI.Ayuda.*;
import GUI.Sistema.*;
import Servicio.AccesoServicio;
import Servicio.UsuarioServicio;

public class PrincipalGUI extends javax.swing.JFrame implements ActionListener
{  
    private UsuarioEntidad usuario;
    private final AccesoServicio acceso = new AccesoServicio();    
    private final UsuarioServicio servicio = new UsuarioServicio();
    private InicioGUI inicio = new InicioGUI();
    private PerfilGUI perfil = null;
    private SobreGUI sobre = new SobreGUI();
    private ModulosGUI modulos = new ModulosGUI();
    private OperacionesGUI operaciones = new OperacionesGUI();
    private PermisosGUI permisos = new PermisosGUI();
    private RolesGUI roles = new RolesGUI();
    private UsuariosGUI usuarios = new UsuariosGUI();
   
    public PrincipalGUI(UsuarioEntidad objUsuario) 
    {
        initComponents();
        this.usuario = objUsuario;
        this.setResizable(false);
        this.setTitle("Sistema Modular : Inicio");
        this.setLocationRelativeTo(null); //Centrar componente
        cargarComponentePanel(inicio);
        jMenuItemInicio.addActionListener(this);
        jMenuItemPerfilUsuario.addActionListener(this);
        jMenuItemSobrePrograma.addActionListener(this);
        jMenuItemCerrarPrograma.addActionListener(this);
        jMenuItemLogout.addActionListener(this);
        jMenuItemModulos.addActionListener(this);
        jMenuItemOperaciones.addActionListener(this);
        jMenuItemPermisos.addActionListener(this);
        jMenuItemRoles.addActionListener(this);
        jMenuItemUsuarios.addActionListener(this);
    }

    private UsuarioEntidad getEntidadUsuario() 
    {
        return this.usuario;
    }      
        
    private void cargarComponentePanel(Component componenteGUI)
    { 
        panelFondo.setVisible(false);
        panelFondo.removeAll();
        panelFondo.add(componenteGUI);
        panelFondo.setVisible(true);
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==jMenuItemInicio)
        {
            this.setTitle("Sistema Modular : Inicio");
            cargarComponentePanel(inicio); 
        }
        else if(e.getSource()==jMenuItemPerfilUsuario)
        {
            this.setTitle("Sistema Modular : Perfil");
            perfil = new GUI.Archivo.PerfilGUI(getEntidadUsuario());
            cargarComponentePanel(perfil);
        }
        else if(e.getSource()==jMenuItemSobrePrograma)
        {
            this.setTitle("Sistema Modular : Sobre el Programa");
            cargarComponentePanel(sobre);  
        }
        else if(e.getSource()==jMenuItemCerrarPrograma)
        {           
            acceso.Logout(getEntidadUsuario());
            System.exit(0);                      
        }
        else if(e.getSource()==jMenuItemLogout)
        {            
            acceso.Logout(getEntidadUsuario());             
            new GUI.AccesoGUI().setVisible(true);
            this.setVisible(false);            
        }
        else if(e.getSource()==jMenuItemModulos)
        {
            this.setTitle("Sistema Modular : Modulos");
            cargarComponentePanel(modulos);
        }
        else if(e.getSource()==jMenuItemOperaciones)
        {
            this.setTitle("Sistema Modular : Operaciones");
            cargarComponentePanel(operaciones);
        }
        else if(e.getSource()==jMenuItemPermisos)
        {
            this.setTitle("Sistema Modular : Permisos");
            cargarComponentePanel(permisos);
        }
        else if(e.getSource()==jMenuItemRoles)
        {
            this.setTitle("Sistema Modular : Roles");
            cargarComponentePanel(roles);
        }
        else if(e.getSource()==jMenuItemUsuarios)
        {
            this.setTitle("Sistema Modular : Usuarios");
            cargarComponentePanel(usuarios);
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemInicio = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemPerfilUsuario = new javax.swing.JMenuItem();
        jMenuItemLogout = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCerrarPrograma = new javax.swing.JMenuItem();
        jMenuSistema = new javax.swing.JMenu();
        jMenuItemModulos = new javax.swing.JMenuItem();
        jMenuItemSubModulos = new javax.swing.JMenu();
        jMenuItemOperaciones = new javax.swing.JMenuItem();
        jMenuItemRoles = new javax.swing.JMenuItem();
        jMenuItemPermisos = new javax.swing.JMenuItem();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemSobrePrograma = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new javax.swing.BoxLayout(panelFondo, javax.swing.BoxLayout.LINE_AXIS));

        jMenuArchivo.setText("Archivo");

        jMenuItemInicio.setText("Inicio");
        jMenuArchivo.add(jMenuItemInicio);
        jMenuArchivo.add(jSeparator3);

        jMenuItemPerfilUsuario.setText("Perfil de Usuario");
        jMenuArchivo.add(jMenuItemPerfilUsuario);

        jMenuItemLogout.setText("Cerrar Sesion");
        jMenuArchivo.add(jMenuItemLogout);
        jMenuArchivo.add(jSeparator2);

        jMenuItemCerrarPrograma.setText("Cerrar Programa");
        jMenuArchivo.add(jMenuItemCerrarPrograma);

        jMenuBar1.add(jMenuArchivo);

        jMenuSistema.setText("Sistema");

        jMenuItemModulos.setText("Modulos");
        jMenuSistema.add(jMenuItemModulos);

        jMenuItemSubModulos.setText("SubModulos");

        jMenuItemOperaciones.setText("Operaciones");
        jMenuItemSubModulos.add(jMenuItemOperaciones);

        jMenuItemRoles.setText("Roles");
        jMenuItemSubModulos.add(jMenuItemRoles);

        jMenuItemPermisos.setText("Permisos");
        jMenuItemSubModulos.add(jMenuItemPermisos);

        jMenuItemUsuarios.setText("Usuarios");
        jMenuItemSubModulos.add(jMenuItemUsuarios);

        jMenuSistema.add(jMenuItemSubModulos);

        jMenuBar1.add(jMenuSistema);

        jMenuAyuda.setText("Ayuda");

        jMenuItemSobrePrograma.setText("Sobre el programa");
        jMenuAyuda.add(jMenuItemSobrePrograma);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemCerrarPrograma;
    private javax.swing.JMenuItem jMenuItemInicio;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JMenuItem jMenuItemModulos;
    private javax.swing.JMenuItem jMenuItemOperaciones;
    private javax.swing.JMenuItem jMenuItemPerfilUsuario;
    private javax.swing.JMenuItem jMenuItemPermisos;
    private javax.swing.JMenuItem jMenuItemRoles;
    private javax.swing.JMenuItem jMenuItemSobrePrograma;
    private javax.swing.JMenu jMenuItemSubModulos;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenu jMenuSistema;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPanel panelFondo;
    // End of variables declaration//GEN-END:variables
    
}