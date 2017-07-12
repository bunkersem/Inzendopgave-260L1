package database;

import models.BrochureRequest;
import models.Hotel;
import models.Travel;
import models.User;

import javax.xml.transform.Result;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

import static main.Core.*;

/**
 * Created by Sem on 09-Jul-17.
 */
public class Dataservice {

    public static String sendHttpRequest(String targetUrl, String urlParameters) {
        HttpURLConnection connection = null;
        System.out.println("sending: ");
        System.out.print(urlParameters);

        if (true) return "Example response";
        try {
            URL url = new URL(targetUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User getUser(final String email, final String pwd) throws SQLException {
        String pwdHash = createHash(pwd);
        ResultSet rs = Repository.executeQuery("SELECT id, name FROM users WHERE pwd = '"+pwd+"' AND email = '"+email+"'");

        if (rs.next()) {
            String name = rs.getString("name");
            int id = rs.getInt("id");
            return new User(id, name);
        } else {
            return null;
        }
    }


    public static ArrayList<Hotel> getHotels() throws SQLException {
        ResultSet rs = Repository.executeQuery("SELECT * FROM hotels");
        ArrayList<Hotel> hotels = new ArrayList<>();
        while(rs.next()){
            hotels.add(new Hotel(
                    rs.getInt("id"),
                    rs.getString("name")));
        }
        return hotels;
    }

    public static ArrayList<Travel> getTravels(final ArrayList<Hotel> hotels) throws SQLException {
        ResultSet rs = Repository.executeQuery("SELECT * FROM travels");
        return getTravelsFromResultSet(rs, hotels);
    }

    public static void putBrochureRequest(final BrochureRequest br) throws SQLException {
        Object[] ovalues = {br.getType(), br.getDestination(),
        br.getContactName(), br.getContactAdress(), br.getContactPostalCode(), br.getContactPlaceofResidence(),
        br.getContactPhone(), br.getContactMobilePhone(), br.getEmail(), br.getRemarks(), br.isContactCanCallback()};
        for (int i = 0; i < ovalues.length; i++) {
            if (ovalues[i].getClass() == String.class)
                ovalues[i] = "'" + ovalues[i] + "'";
        }
        String[] values = new String[ovalues.length];
        for (int i = 0; i < ovalues.length; i++) {
            values[i] = ovalues[i].toString();
        }
        String joinedValues = String.join(", ", values);
        Repository.executeUpdate("INSERT INTO brochures (type, destination, contactName, contactAdress,"
                + "contactPostalCode, contactPlaceofResidence, contactPhone, contactMobilePhone, email, remarks,"
                + "contactCanCallback) VALUES("+joinedValues+")");

    }

    public static void putReservation(Travel travel, User usr) throws SQLException {
        Repository.executeUpdate("INSERT INTO reservations (userId, travelId) VALUES ("
                +usr.getId()+", "+ travel.getId() +")");
    }

    public static void removeReservation(int reservationId) throws SQLException {
        Repository.executeUpdate("DELETE FROM reservations WHERE id = "
                + reservationId);
    }

    public static void removeReservationWithTravelId(Travel travel) throws SQLException {
        Repository.executeUpdate("DELETE FROM reservations WHERE travelId = "
                + travel.getId());
    }

    public static ArrayList<Travel> getReservationsForUser(User usr, final ArrayList<Hotel> hotels) throws SQLException {
        ResultSet rs =
                Repository.executeQuery("SELECT * FROM travels WHERE id IN\n" +
                        "(SELECT travelId FROM reservations WHERE userId = " + usr.getId() + ")");
        return getTravelsFromResultSet(rs, hotels);
    }

    static ArrayList<Travel> getTravelsFromResultSet(final ResultSet resultSet, final ArrayList<Hotel> hotels) throws SQLException {
        ArrayList<Travel> travelReservations = new ArrayList<>();
        while(resultSet.next()){
            int htlId = resultSet.getInt("hotelId");
            int id = resultSet.getInt("id");
            Hotel hotel = first(hotels, htl -> htl.id == htlId);
            travelReservations.add(new Travel(
                    id,
                    resultSet.getString("htmlContent"),
                    resultSet.getString("imageUrl"),
                    hotel));
        }
        return travelReservations;
    }


    public static String createHash(final String source) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new Error("Something when wrong");
        }
        md.update(source.getBytes());
        byte[] digest = md.digest();
        return String.format("%064x", new java.math.BigInteger(1, digest));
    }
}
