package main;

import internationalization.Language;
import models.User;

import javax.security.auth.login.CredentialException;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.Key;

import static internationalization.LanguageProvider.*;
import static main.Helpers.*;

/**
 * Created by Sem on 09-Jul-17.
 */
public class MenuBar extends JMenuBar {
    JMenu userMenu, helpMenu, languageMenu;
    JMenuItem menuLoginItem, menuLogoutItem, adminLogin, englishItem, dutchItem;

    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;

    public MenuBar(){
        // User menu
        userMenu = new JMenu(toolbarUserMenu(getLang()));
        userMenu.setMnemonic(KeyEvent.VK_U);
        userMenu.getAccessibleContext().setAccessibleDescription(toolbarUserMenuDecription(getLang()));

        // User menu login.
        menuLoginItem = new JMenuItem(loginBtn(getLang()), KeyEvent.VK_L);
        menuLoginItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuLoginItem.addActionListener(loginBtnClick);
        userMenu.add(menuLoginItem);

        userMenu.addSeparator();

        // User menu logout.
        menuLogoutItem = new JMenuItem(logOutBtn(getLang()), KeyEvent.VK_O);
        menuLogoutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuLogoutItem.addActionListener(logoutBtnClick);
        userMenu.add(menuLogoutItem);



        add(userMenu);

        // Add language menu.
        languageMenu = new JMenu(language(getLang()));
        languageMenu.setMnemonic(KeyEvent.VK_L);

        // Add English
        englishItem = new JMenuItem("English");
        englishItem.addActionListener(englishBtnClick);
        languageMenu.add(englishItem);

        dutchItem = new JMenuItem("Nederlands");
        dutchItem.addActionListener(dutchBtnClick);
        languageMenu.add(dutchItem);

        add(languageMenu);

        // Help menu
        helpMenu = new JMenu(helpMenu(getLang()));
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.getAccessibleContext().setAccessibleDescription(helpMenuDescription(getLang()));

        // Add admin login
        adminLogin = new JMenuItem(adminLogin(getLang()), KeyEvent.VK_A);
        adminLogin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        adminLogin.addActionListener(adminLoginBtnClick);
        helpMenu.add(adminLogin);

        add(helpMenu);


    }

    ActionListener adminLoginBtnClick = new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            try {
            if (User.getCurrentUser() == null || User.isAdmin() == false) {
                throw new CredentialException("Incorrect Credentials");
            }
            Main.adminFrame.init();
            } catch (CredentialException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, unauthorized(getLang()));
            }

        }
    };

    ActionListener loginBtnClick = new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent actionEvent){
            if (User.getCurrentUser() == null){
                Main.loginFrame.init();
            }
            else {
                JOptionPane.showMessageDialog(null, alreadyLoggedIn(getLang()));
            }
        }
    };

    ActionListener logoutBtnClick = new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            if (User.getCurrentUser() != null){
                User.setCurrentUser( null );
            } else {
                JOptionPane.showMessageDialog(null, logoutFailedNoUserLoggedIn(getLang()));
            }
        }
    };

    ActionListener englishBtnClick = new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            if (getLang() != Language.EN) {
                setLang(Language.EN);
                JOptionPane.showMessageDialog(null, restartFirstBeforeLanguageChange(Language.EN));
            }
        }
    };

    ActionListener dutchBtnClick = new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            if (getLang() != Language.NL) {
                setLang(Language.NL);
                JOptionPane.showMessageDialog(null, restartFirstBeforeLanguageChange(Language.NL));
            }
        }
    };
}
