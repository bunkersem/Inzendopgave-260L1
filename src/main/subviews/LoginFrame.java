package main.subviews;

import database.Dataservice;
import internationalization.LanguageProvider;
import main.FontType;
import main.Fonts;
import models.Hotel;
import models.Travel;
import models.User;

import javax.security.auth.login.CredentialException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import static internationalization.LanguageProvider.*;
import static internationalization.LanguageProvider.welcomeFrameTitle;
import static main.Helpers.getLang;

/**
 * Created by Sem on 10-Jul-17.
 */
public class LoginFrame extends JFrame {
    LoginContentPanel content = new LoginContentPanel();

    public LoginFrame (){
        setSize(360, 220);
        setLocationRelativeTo(null);
        setTitle(loginFrameTitle(getLang()));
        setFont(Fonts.createFont(FontType.NORMAL));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setContentPane(content);
    }

    public void init() {
        setVisible(true);
    }


    class LoginContentPanel extends JPanel {
        JTextField emailField = new JTextField();
        JPasswordField pwdField = new JPasswordField();
        JButton loginBtn = new JButton(loginBtn(getLang()));
        LayoutManager layout = new GridLayout(3,2,40,10);

        public LoginContentPanel(){
            setLayout(layout);
            setBorder(new EmptyBorder(40,40,40,40));

            add(new JLabel(email(getLang())));
            add(emailField);
            add(new JLabel(password(getLang())));
            add(pwdField);
            add(loginBtn);
            loginBtn.addActionListener(loginBtnClick);

            pack();
            setResizable(false);
        }

        ActionListener loginBtnClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Check if user is already logged in.
                if (User.getCurrentUser() != null){
                    JOptionPane.showMessageDialog(null, alreadyLoggedIn(getLang()));
                    return;
                } // else


                 String password = pwdField.getText();
                 String email = emailField.getText();

                try {
                    User loggedInUser = Dataservice.getUser(email, password);
                    if (loggedInUser == null)
                        throw new CredentialException("Incorrect login credentials.");
                    pwdField.setForeground(Color.BLACK);
                    User.setCurrentUser( loggedInUser );
                    Travel.setReservationTravels(Dataservice.getReservationsForUser(User.getCurrentUser(), Hotel.hotels));

                    // Everything worked.
                    LoginFrame.this.dispatchEvent(new WindowEvent(LoginFrame.this, WindowEvent.WINDOW_CLOSING));

                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, logginFailed(getLang()));
                } catch (CredentialException e) {
                    pwdField.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, incorrectCredentials(getLang()));
                    e.printStackTrace();
                }
            }
        };
    }
}
