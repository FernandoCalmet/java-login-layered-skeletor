package UserInterface;

import UserInterface.Forms.User.FormLogin;

import javax.swing.*;

public class Program {
    public static void main(String[] args) {
        JFrame formLogin = new JFrame("Login");
        formLogin.setContentPane(new FormLogin().panelLogin);
        formLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formLogin.pack();
        formLogin.setLocationRelativeTo(null);
        formLogin.setSize(450,250);
        formLogin.setVisible(true);
    }
}
