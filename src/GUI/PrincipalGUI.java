package GUI;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.Acceso.AccesoLogoutControlador;
import GUI.Archivo.*;
import GUI.Ayuda.*;
import GUI.Sistema.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class PrincipalGUI extends JFrame implements ActionListener
{  
    private Object objModelo;
    private InicioGUI inicio;
    private PerfilGUI perfil;
    private SobreGUI sobre;
    private ModulosGUI modulos;
    private OperacionesGUI operaciones;
    private PermisosGUI permisos;
    private RolesGUI roles;
    private UsuariosGUI usuarios;
   
    public PrincipalGUI(Object objEntidad) 
    {
        this.objModelo = objEntidad;
        this.inicio = new InicioGUI();
        this.perfil = null;
        this.sobre = null;
        this.modulos = null;
        this.operaciones = null;
        this.permisos = null;
        this.roles = null;
        this.usuarios = null;
        initComponents();               
        cargarComponentePanel(inicio);
        configInicial();        
    }
    
    private void setObjModelo(Object obj){ objModelo = obj; }
    private Object getObjModelo(){ return objModelo;}
    
    private void configInicial()
    {
        this.setResizable(false);
        this.setTitle("Sistema Modular : Inicio");
        this.setLocationRelativeTo(null);
        cargarAccionesMenu();
    }
            
    private void cargarComponentePanel(Component componenteGUI)
    { 
        panelFondo.setVisible(false);
        panelFondo.removeAll();
        panelFondo.add(componenteGUI);
        panelFondo.setVisible(true);        
    }   
    
    private void cargarAccionesMenu()
    {
        jMenuItemInicio.addActionListener(this);
        jMenuItemPerfilUsuario.addActionListener(this);
        jMenuItemSobrePrograma.addActionListener(this);
        jMenuItemCerrarPrograma.addActionListener(this);
        jMenuItemLogout.addActionListener(this);
        jMenuItemBase.addActionListener(this);
        jMenuItemOperaciones.addActionListener(this);
        jMenuItemPermisos.addActionListener(this);
        jMenuItemRoles.addActionListener(this);
        jMenuItemUsuarios.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    { 
        if(e.getSource()==jMenuItemInicio)
        {
            inicio = new InicioGUI();
            this.setTitle("Sistema Modular : Inicio");
            cargarComponentePanel(inicio); 
        }
        else if(e.getSource()==jMenuItemPerfilUsuario)
        {
            perfil = new PerfilGUI(this.objModelo);
            this.setTitle("Sistema Modular : Perfil");           
            cargarComponentePanel(perfil);
        }
        else if(e.getSource()==jMenuItemSobrePrograma)
        {
            sobre = new SobreGUI();
            this.setTitle("Sistema Modular : Sobre el Programa");
            cargarComponentePanel(sobre);  
        }
        else if(e.getSource()==jMenuItemCerrarPrograma)
        {           
            setObjModelo(new AccesoLogoutControlador().AccesoLogout(getObjModelo()));
            System.exit(0);                      
        }
        else if(e.getSource()==jMenuItemLogout)
        {            
            setObjModelo(new AccesoLogoutControlador().AccesoLogout(getObjModelo()));        
            new GUI.AccesoGUI().setVisible(true);
            this.setVisible(false);            
        }
        else if(e.getSource()==jMenuItemBase)
        {
            modulos = new ModulosGUI();
            this.setTitle("Sistema Modular : Módulos");          
            cargarComponentePanel(modulos);
        }
        else if(e.getSource()==jMenuItemOperaciones)
        {
            operaciones = new OperacionesGUI();
            this.setTitle("Sistema Modular : Operaciones");
            cargarComponentePanel(operaciones);
        }
        else if(e.getSource()==jMenuItemPermisos)
        {
            permisos = new PermisosGUI();
            this.setTitle("Sistema Modular : Permisos");
            cargarComponentePanel(permisos);
        }
        else if(e.getSource()==jMenuItemRoles)
        {
            roles = new RolesGUI();
            this.setTitle("Sistema Modular : Roles");
            cargarComponentePanel(roles);
        }
        else if(e.getSource()==jMenuItemUsuarios)
        {
            usuarios = new UsuariosGUI();
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
        jMenuItemModulos = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemOperaciones = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuItemRoles = new javax.swing.JMenuItem();
        jMenuItemPermisos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemBase = new javax.swing.JMenuItem();
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

        jMenu1.setText("Operaciones");

        jMenuItemOperaciones.setText("Configuración");
        jMenu1.add(jMenuItemOperaciones);
        jMenu1.add(jSeparator4);

        jMenuItemUsuarios.setText("Usuarios");
        jMenu1.add(jMenuItemUsuarios);

        jMenuItemRoles.setText("Roles");
        jMenu1.add(jMenuItemRoles);

        jMenuItemPermisos.setText("Permisos");
        jMenu1.add(jMenuItemPermisos);

        jMenuItemModulos.add(jMenu1);

        jMenuSistema.add(jMenuItemModulos);
        jMenuSistema.add(jSeparator1);

        jMenuItemBase.setText("Configuración");
        jMenuSistema.add(jMenuItemBase);

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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemBase;
    private javax.swing.JMenuItem jMenuItemCerrarPrograma;
    private javax.swing.JMenuItem jMenuItemInicio;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JMenu jMenuItemModulos;
    private javax.swing.JMenuItem jMenuItemOperaciones;
    private javax.swing.JMenuItem jMenuItemPerfilUsuario;
    private javax.swing.JMenuItem jMenuItemPermisos;
    private javax.swing.JMenuItem jMenuItemRoles;
    private javax.swing.JMenuItem jMenuItemSobrePrograma;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenu jMenuSistema;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPanel panelFondo;
    // End of variables declaration//GEN-END:variables
    
}