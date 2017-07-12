package main.subviews;

import database.Credentials;
import database.Dataservice;
import internationalization.LanguageProvider;
import main.Helpers;
import main.Main;
import models.Hotel;
import models.Travel;
import models.User;

import javax.security.auth.login.CredentialException;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.HashMap;

import static internationalization.LanguageProvider.*;
import static main.Helpers.getLang;
import static main.Helpers.resourceTaskRunner;

/**
 * Created by Sem on 10-Jul-17.
 */
public class UserReservationsFrame extends JFrame {
    public UserReservationsFrame(){
        setSize(960, 720);
        setLocationRelativeTo(null);
        setTitle(welcomeFrameTitle(getLang()));
        setFont(Font.getFont("Arial"));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public void init(){
        setVisible(true);
        if (User.getCurrentUser() == null) try {
            throw new CredentialException("You are not logged in");
        } catch (CredentialException e) {
            UserReservationsFrame.this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            JOptionPane.showMessageDialog(null, notLoggedIn(getLang()));
            e.printStackTrace();
        }
        else
            setContentPane(new UserReservationContent());
    }

    class UserReservationContent extends JPanel {
            LayoutManager gridLayout = new GridLayout(0,1);
            HashMap<JPanel, Travel> travelPanels = new HashMap<>();

            public UserReservationContent(){
                setLayout(gridLayout);
                for (Travel travel : Travel.getReservationTravels()) {
                    JPanel travelPanel = new JPanel();
                    travelPanels.put(travelPanel, travel);
                    LayoutManager layout = new FlowLayout(FlowLayout.LEADING);
                    travelPanel.setLayout(layout);

                    resourceTaskRunner(travel.getImageUrl(), travelPanel);
                    JLabel content = new JLabel("<html>" + travel.getHtmlContent() + "</html>");
                    content.setMaximumSize(new Dimension(999999, 180));
                    travelPanel.add(content);
                    JButton removeBtn = new JButton(LanguageProvider.remove(getLang()));
                    removeBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            try {
                                if (User.getCurrentUser() == null)
                                    throw new CredentialException("User is not logged in");
                                Dataservice.removeReservationWithTravelId(travel);
                                Travel.setReservationTravels( Dataservice.getReservationsForUser(User.getCurrentUser(), Hotel.hotels));
                                travelPanel.setVisible(false);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } catch (CredentialException e) {
                                JOptionPane.showMessageDialog(null, notLoggedIn(getLang()));
                                e.printStackTrace();
                            }
                        }
                    });
                    travelPanel.add(removeBtn);

                    this.add(travelPanel);


            }
        }
    }
}
