package main;

import main.subviews.*;
import models.Hotel;
import models.Travel;
import models.User;

import javax.swing.*;
import java.sql.SQLException;

import static tests.Tests.*;

public class Main {

    public static OffersListingFrame offersListingFrame;
    public static RequestBrochureFrame requestBrochureFrame;
    public static UserReservationsFrame userReservationsFrame;
    public static AdminFrame adminFrame;
    public static LoginFrame loginFrame;
    public static TravelFrame travelFrame;


    public static void main(final String[] args) {
        try {
            database.Repository.connectToDatabase();
            // In devlopment do thesse tests.
            test();


            // Get Content
            Hotel.hotels = database.Dataservice.getHotels();
            Travel.setTravels( database.Dataservice.getTravels(Hotel.hotels));


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Could not connect to remote server");
            e.printStackTrace();
            return;
        }

        offersListingFrame = new OffersListingFrame();
        requestBrochureFrame = new RequestBrochureFrame();
        adminFrame = new AdminFrame();
        loginFrame = new LoginFrame();
        travelFrame = new TravelFrame();
        userReservationsFrame = new UserReservationsFrame();

        System.out.println("Hello World!");
        MainFrame mf = new MainFrame();
    }
}
