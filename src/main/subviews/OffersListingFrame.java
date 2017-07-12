package main.subviews;

import database.Dataservice;
import main.Helpers;
import main.Main;
import models.Hotel;
import models.Travel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static internationalization.LanguageProvider.more;
import static internationalization.LanguageProvider.welcomeFrameTitle;
import static main.Helpers.*;
import static main.Helpers.GetImageFromUrl;
import static main.Helpers.getLang;
import static main.Helpers.setLang;

/**
 * Created by Sem on 09-Jul-17.
 */
public class OffersListingFrame extends JFrame {
    OffersListingPanel content = new OffersListingPanel();

    public OffersListingFrame(){
        setSize(960, 720);
        setLocationRelativeTo(null);
        setTitle(welcomeFrameTitle(getLang()));
        setFont(Font.getFont("Arial"));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setContentPane(content);
    }

    public void init() {
        setVisible(true);
    }

    class OffersListingPanel extends JPanel{
        LayoutManager gridLayout = new GridLayout(0,1);
        HashMap<JPanel, Travel> travelPanels = new HashMap<>();

        public OffersListingPanel(){
            setLayout(gridLayout);
            for (Travel travel : Travel.getTravels()) {
                JPanel travelPanel = new JPanel();
                travelPanels.put(travelPanel, travel);
                LayoutManager layout = new FlowLayout(FlowLayout.LEADING);
                travelPanel.setLayout(layout);

                resourceTaskRunner(travel.getImageUrl(), travelPanel);
                JLabel content = new JLabel("<html>" + travel.getHtmlContent() + "</html>");
                content.setMaximumSize(new Dimension(999999, 180));
                travelPanel.add(content);
                JButton moreInfoBtn = new JButton(more(getLang()));
                moreInfoBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Main.travelFrame.init(travel);
                    }
                });

                travelPanel.add(moreInfoBtn);

                OffersListingPanel.this.add(travelPanel);

            }
        }
    }
}
