package UserInterface.Forms.User;

import Domain.Models.UserModel;
import UserInterface.Forms.FormMainMenu;

import javax.swing.*;

public class FormLogin extends JFrame {
    public JPanel panelLogin;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JLabel lblErrorMessage;
    private JButton btnLogin;

    public FormLogin() {
        initListeners();
        lblErrorMessage.setVisible(false);
    }

    private void login() {
        try {
            if (!"Username or Email".equals(txtUser.getText()) && txtUser.getText().length() > 2) {
                if (!"Password".equals(txtPassword.getText())) {
                    UserModel user = new UserModel();
                    boolean validLogin = user.LogIn(txtUser.getText(), txtPassword.getText());
                    if (validLogin) {
                        JFrame formMainMenu = new JFrame("Main Menu");
                        formMainMenu.setContentPane(new FormMainMenu().panelMain);
                        formMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        formMainMenu.pack();
                        formMainMenu.setLocationRelativeTo(null);
                        formMainMenu.setVisible(true);
                        this.panelLogin.setVisible(false);
                        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    } else {
                        msgError("The wrong username or password was entered. Try again.");
                        txtPassword.setText("Password");
                    }
                } else {
                    msgError("Please enter a password.");
                }
            } else {
                msgError("Enter username or email.");
            }
        } catch (Exception ex) {
            msgError(ex.getMessage());
        }
    }

    private void msgError(String msg) {
        lblErrorMessage.setText(" " + msg);
        lblErrorMessage.setVisible(true);
    }

    private void initListeners() {
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                login();
            }
        });

        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                super.focusGained(e);
                if ("Username or Email".equals(txtUser.getText())) {
                    txtUser.setText("");
                }
            }
        });

        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                super.focusLost(e);
                if ("".equals(txtUser.getText())) {
                    txtUser.setText("Username or Email");
                }
            }
        });

        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                super.focusGained(e);
                if ("Password".equals(txtPassword.getText())) {
                    txtPassword.setText("");
                }
            }
        });

        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                super.focusLost(e);
                if ("".equals(txtPassword.getText())) {
                    txtPassword.setText("Password");
                }
            }
        });
    }
}
