package tests;

import database.Dataservice;
import database.Repository;
import models.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sem on 09-Jul-17.
 */
public class Tests {
    public static void test(){
        doDbTests();
    }
    public static void doDbTests(){
        try {
            User usr = Dataservice.getUser("test@test.nl", "test");
            ArrayList<Hotel> hotels = Dataservice.getHotels();
            ArrayList<Travel> travels = Dataservice.getTravels(hotels);

            Repository.executeUpdate("DELETE FROM brochures WHERE contactMobilePhone = '064295492842424242'");
            Dataservice.putBrochureRequest(new BrochureRequest(0, "hote type", "trip destination",
                    "contact_name", "contactAress", "contactPostalCode",
                    "placeOfResidence", "01628239183", "064295492842424242",
                    "fake@fakeprovider.fake", "my extra remarks", true));


            System.out.print("Users: ");
            System.out.println(usr);

            System.out.print("Hotels: ");
            System.out.println(hotels);

            System.out.print("Travels: ");
            System.out.println(travels);

            System.out.print("Data: ");
            System.out.println(Repository.executeQuery("SELECT * FROM hotels"));

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
