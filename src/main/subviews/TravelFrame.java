package main.subviews;

import com.google.gson.Gson;
import database.Dataservice;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import main.Helpers;
import models.Hotel;
import models.Travel;
import models.User;

import javax.security.auth.login.CredentialException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import static internationalization.LanguageProvider.*;
import static main.Helpers.*;
import static main.Helpers.GetImageFromUrl;
import static main.Helpers.getLang;
import static main.Helpers.setLang;

/**
 * Created by Sem on 10-Jul-17.
 */
public class TravelFrame extends JFrame {

    public TravelFrame(){
        setSize(720, 620);
        setLocationRelativeTo(null);
        setTitle(welcomeFrameTitle(getLang()));
        setFont(Font.getFont("Arial"));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public void init(Travel travel){
        setVisible(true);
        System.out.println("Displaying content for hotelId: " + travel.getId());
        System.out.println("TODO");
        setContentPane(new TravelPanel(travel));
    }

    class TravelPanel extends JPanel {
        JButton orderTravelBtn = new JButton(orderReservation(getLang()));
        JLabel content = new JLabel();
        Travel travel;

        LayoutManager layout = new BorderLayout();
        public TravelPanel(final Travel travel) {
            this.travel = travel;
            setBorder(new EmptyBorder(10,10,10,10));
            setLayout(layout);
            JPanel imageContainer = new JPanel();
            JPanel centerPanel = new JPanel();
            resourceTaskRunner(travel.getImageUrl(), imageContainer);
            content.setText("<html>"+ travel.getHtmlContent() +"</html>");
            orderTravelBtn.addActionListener(orderTravelBtnClick);
            imageContainer.setBackground(Color.WHITE);

            centerPanel.add(content);
            centerPanel.setBackground(Color.WHITE);
            centerPanel.add(orderTravelBtn);

            add(imageContainer, BorderLayout.WEST);
            add(centerPanel, BorderLayout.CENTER);
        }

        ActionListener orderTravelBtnClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (User.getCurrentUser() == null) throw new CredentialException("You are not logged in");
                    Dataservice.putReservation(travel, User.getCurrentUser());
                    Travel.setReservationTravels(Dataservice.getReservationsForUser(User.getCurrentUser(), Hotel.hotels));

                    //Send http request to the hotel server.
                    Gson gson = new Gson();
                    String json = gson.toJson(travel);

                    Dataservice.sendHttpRequest("example.remotehotelserver.com/api/reservations", json);
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, internalError(getLang()));
                } catch (CredentialException e) {
                    JOptionPane.showMessageDialog(null, notLoggedIn(getLang()));
                    e.printStackTrace();
                }
            }
        };


    }
}
