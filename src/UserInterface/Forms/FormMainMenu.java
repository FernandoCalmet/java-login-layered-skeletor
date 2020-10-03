package UserInterface.Forms;

import Infrastructure.Common.Cache.ActiveUser;
import Infrastructure.Common.Cache.Roles;

import javax.swing.*;

public class FormMainMenu extends JFrame {
    private JPanel panelMain;
    private JMenuBar mainMenu;
    private JMenu menuFile;
    private JMenu menuUser;
    private JMenu menuNote;
    private JMenu menuTask;
    private JMenuItem itemInfo;
    private JMenuItem itemLogout;

    public FormMainMenu()
    {
        initComponents();
    }

    private void ManagePermissions()
    {
        if (ActiveUser.c_role == Roles.ADMINISTRATOR) {
            //Administrator Rules
        }
        if (ActiveUser.c_role == Roles.CUSTOMER) {
            //Customer Rules
        }
    }

    private void initComponents() {
        menuFile = new JMenu();
        itemInfo = new JMenuItem();
        itemLogout = new JMenuItem();
        menuFile.setText("File");
        menuFile.add(itemInfo);
        menuFile.add(itemLogout);

        mainMenu.add(menuFile);
    }
}
