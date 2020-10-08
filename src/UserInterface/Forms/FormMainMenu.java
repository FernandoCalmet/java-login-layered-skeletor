package UserInterface.Forms;

import Support.Common.Cache.ActiveUser;
import Support.Common.Cache.Roles;

import javax.swing.*;

public class FormMainMenu extends JFrame {

    private JPanel panelMenu;
    private JPanel panelBody;
    private JMenu fileMenu;
    private JMenu userMenu;
    private JMenu helpMenu;
    private JMenuItem profileMenuItem;
    private JMenuItem logoutMenuItem;
    private JMenuItem notesMenuItem;
    private JMenuItem tasksMenuItem;
    private JMenuItem aboutMenuItem;

    public FormMainMenu()
    {

    }

    private void ManagePermissions()
    {
        if (ActiveUser.c_role.equals(Roles.ADMINISTRATOR)) {
            //Administrator Rules
        }
        if (ActiveUser.c_role.equals(Roles.CUSTOMER)) {
            //Customer Rules
        }
    }
}
