package main;

import main.subviews.OffersListingFrame;
import main.subviews.RequestBrochureFrame;
import models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static internationalization.LanguageProvider.*;
import static main.Helpers.*;
import static main.Fonts.*;
import static main.FontType.*;

/**
 * Created by Sem on 09-Jul-17.
 */
public class WelcomePanel extends JPanel {
    LayoutManager layout = new BoxLayout(this, BoxLayout.Y_AXIS);
    ImageIcon logo;
    JLabel welcomeLabel = new JLabel(welcome(getLang()));


    JButton reservationsListBtn = new JButton(reservationsListBtn(getLang()));
    JButton offersListBtn = new JButton(offersListBtn(getLang()));
    JButton requestBrochureBtn = new JButton(requestBrochure(getLang()));


    public WelcomePanel(){
        logo = new ImageIcon(getResourceUrl("/resources/images/logo.png"), businessLogo(getLang()));

        setLayout(layout);

        welcomeLabel.setFont(createFont(TITLE));
        add(new JLabel(logo));
        add(welcomeLabel);

        add(reservationsListBtn);
        add(offersListBtn);
        add(requestBrochureBtn);

        reservationsListBtn.addActionListener(reservationsListBtnClick);
        offersListBtn.addActionListener(offersListBtnClick);
        requestBrochureBtn.addActionListener(requestBrochureBtnClick);
    }

    ActionListener reservationsListBtnClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Open reservations list window");
            if (User.getCurrentUser() != null)
                Main.userReservationsFrame.init();
            else {
                JOptionPane.showMessageDialog(null, unautheticatedFrameRequest(getLang()));
            }
        }

    };

    ActionListener offersListBtnClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Open offers List Window");
            Main.offersListingFrame.init();

        }
    };

    ActionListener requestBrochureBtnClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Open offers List Window");
            Main.requestBrochureFrame.init();
        }
    };
}
