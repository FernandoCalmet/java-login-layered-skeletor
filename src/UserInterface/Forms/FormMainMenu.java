package UserInterface.Forms;

import Support.Common.Cache.ActiveUser;
import Support.Common.Cache.Roles;
import UserInterface.Forms.Other.Welcome;

import javax.swing.*;
import java.awt.*;

public class FormMainMenu extends JFrame {
    private Welcome componentWelcome;

    private JPanel panelMenu;
    private JPanel panelBody;
    private JMenu fileMenu;
    private JMenu userMenu;
    private JMenu helpMenu;
    private JMenuItem profileMenuItem;
    private JMenuItem logoutMenuItem;
    private JMenuItem aboutMenuItem;
    private JMenuItem ExitMenuItem;
    private JMenuItem settingsMenuItem;
    private JMenuItem usersMenuItem;
    private JMenuItem notesMenuItem;
    private JMenuItem tasksMenuItem;
    public JPanel panelMain;
    private JMenuBar menuBar;

    public FormMainMenu()
    {
        ManagePermissions();
        SetComponents();
        LoadComponentPanel(componentWelcome);
    }

    private void ManagePermissions()
    {
        if (ActiveUser.c_role.equals(Roles.CUSTOMER)) {
            usersMenuItem.setEnabled(false);
            settingsMenuItem.setEnabled(false);
        }
    }

    private void SetComponents(){
        this.componentWelcome = new Welcome();
    }

    private void LoadComponentPanel(Component component) {
        panelBody.setVisible(false);
        panelBody.removeAll();
        panelBody.add(component);
        panelBody.setVisible(true);
    }
}
