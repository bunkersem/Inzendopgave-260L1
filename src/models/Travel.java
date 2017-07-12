package models;

import java.util.ArrayList;

/**
 * Created by Sem on 09-Jul-17.
 */
public class Travel {
    int id;
    String htmlContent;
    String imageUrl;
    Hotel hotel;
    static ArrayList<Travel> travels = null;
    static ArrayList<Travel> reservationTravels = null;

    public static void setTravels(ArrayList<Travel> travels) {
        Travel.travels = travels;
    }

    public static ArrayList<Travel> getReservationTravels() {
        return reservationTravels;
    }

    public static void setReservationTravels(ArrayList<Travel> reservationTravels) {
        Travel.reservationTravels = reservationTravels;
    }

    public Travel(final int id, final String htmlContent, final String imageUrl, final Hotel hotel) {
        this.id = id;
        this.htmlContent = htmlContent;
        this.imageUrl = imageUrl;
        this.hotel = hotel;
    }

    public static ArrayList<Travel> getTravels() {
        return travels;
    }

    public int getId() {
        return id;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
